package com.school.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order
public class CrosFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response=(HttpServletResponse)res;
		HttpServletRequest request=(HttpServletRequest)req;
		
		Map<String, String> map=new HashMap<>();
		String string = request.getHeader("origin");
		response.setHeader("Access-Control-Allow-Origin", string);
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE,OPTIONS");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "*");
		if("OPTIONS".equalsIgnoreCase(request.getMethod()))
		{
			response.setStatus(HttpServletResponse.SC_OK);
		}else {
			chain.doFilter(req, res);
		}
	}

}
