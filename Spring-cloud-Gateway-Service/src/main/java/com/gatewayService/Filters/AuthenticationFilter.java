package com.gatewayService.Filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import com.gatewayService.utils.JwtUtil;

import jakarta.ws.rs.core.HttpHeaders;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>{

	@Autowired
	private RouteValidator routeValidator;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public static class Config{
		
	}
	
	public AuthenticationFilter() {
		super(Config.class);
		// TODO Auto-generated constructor stub
	}


	@Override
	public GatewayFilter apply(Config config) {
		return((exchange,chain)->{
			if(routeValidator.isSecured.test(exchange.getRequest()))
			{
				if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
				{
					throw new RuntimeException("Missing autherization header");
				}
				
				String authHeader=exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if(authHeader!=null && authHeader.startsWith("Bearer "))
				{
					authHeader=authHeader.substring(7);
				}
				try
				{
					jwtUtil.validateToken(authHeader);
				}catch(Exception ex)
				{
					throw new RuntimeException("Un-Authorized access request");
				}
			}
			return chain.filter(exchange);
		});
	}

}
