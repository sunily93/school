package com.school.jwt;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.school.entity.User;
import com.school.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional=repo.findByEmail(username);
		if(!optional.isPresent()) throw new UsernameNotFoundException("User is not found",null);
		return new org.springframework.security.core.userdetails.User(optional.get().getEmail(),optional.get().getPassword(),new ArrayList<>());
	}

}
