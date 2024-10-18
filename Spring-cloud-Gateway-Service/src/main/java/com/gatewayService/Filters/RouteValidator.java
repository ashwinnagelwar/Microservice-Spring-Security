package com.gatewayService.Filters;

import java.util.List;
import java.util.function.Predicate;
import java.util.*;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;


@Component
public class RouteValidator {

	
	public static final List<String> openApiEndpoints=List.of(
			"/auth-server/signUpUser",
			"/auth-server/generate-token"
			);
	
	public Predicate<ServerHttpRequest> isSecured=
			request-> openApiEndpoints
						.stream()
						.noneMatch(uri-> request.getURI().getPath().contains(uri));
}
