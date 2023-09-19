package com.school.controller;

import java.io.IOException;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.school.dto.JwtRequest;
import com.school.dto.JwtRespone;
import com.school.entity.User;
import com.school.repository.UserRepository;
import com.school.util.JwtUtil;
@RestController
public class LoginController {

	public static final String TOKEN_PREFIX="Bearer ";
	public static final String HEADER_STRING="Authorization";
	
	@Autowired
	private AuthenticationManager manager;
	@Autowired
	private UserDetailsService service;
	@Autowired
	private JwtUtil util;
	@Autowired
	private UserRepository repo;
	
	@PostMapping("/authenticate")	
	public void createToken(@RequestBody JwtRequest request,HttpServletResponse response) throws IOException, JSONException
	{
		try {
			manager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
		}catch (BadCredentialsException e) {
			throw new BadCredentialsException("Invalid username or password");
		}catch(DisabledException e){
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not created");
			return;
		}
		UserDetails userDetails= service.loadUserByUsername(request.getEmail());
		Optional<User> optional = repo.findByEmail(userDetails.getUsername());
		
		String token = util.generateToken(userDetails);
		if(optional.isPresent())
		{
			response.getWriter().write(new JSONObject()
					.put("userId", optional.get().getId())
					.put("role", optional.get().getRole())
					.toString());
		}
		response.setHeader("Access-Control-Expose-Headers","Authorization");
		response.setHeader("Access-Control-Allow-Headers","Authorization ,X-Pingoyher,Origin,X-Requested-With,Content-Type,Accept,X-Custom-header");
		response.setHeader(HEADER_STRING, TOKEN_PREFIX +token); 
		//return new JwtRespone(token);
	}
	
	
}
