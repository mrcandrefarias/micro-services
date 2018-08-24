package com.marcos.apigateway.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="app2")
public interface IPythonAPP02 {
	
	@GetMapping(value = "/app")
	public String hello();
}
