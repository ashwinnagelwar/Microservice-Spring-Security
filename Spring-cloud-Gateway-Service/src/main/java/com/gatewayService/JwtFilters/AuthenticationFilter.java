package com.gatewayService.JwtFilters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>{

	
	public static class Config{
		
	}
	
	public AuthenticationFilter() {
		super(Config.class);
		// TODO Auto-generated constructor stub
	}


	@Override
	public GatewayFilter apply(Config config) {
		return((exchange,chain)->{
			return chain.filter(exchange);
		});
	}

}
