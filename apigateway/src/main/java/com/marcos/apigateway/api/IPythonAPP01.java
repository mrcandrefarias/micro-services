package com.marcos.apigateway.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="app1")
public interface IPythonAPP01 {
	
	@GetMapping(value = "/app")
	public String hello();
}
