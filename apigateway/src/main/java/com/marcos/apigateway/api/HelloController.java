package com.marcos.apigateway.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@Autowired
	private IPythonAPP01 iPythonAPP01;
	
	@Autowired
	private IPythonAPP02 iPythonAPP02;
    
	public  ResponseEntity<String> defaultFallback(){
	    return new ResponseEntity<>("ERRO", HttpStatus.BAD_GATEWAY);
	}
	
    @HystrixCommand(defaultFallback = "defaultFallback")
    @GetMapping("/python01")
    public ResponseEntity<String> helloPython(){
    	return new ResponseEntity<>(
    			    iPythonAPP01.hello(),
				    HttpStatus.OK
				);
    } 
    
    @HystrixCommand(defaultFallback = "defaultFallback")
    @GetMapping("/python02")
    public ResponseEntity<String> helloPhp(){
    	return new ResponseEntity<>(
    			    iPythonAPP02.hello(),
				    HttpStatus.OK
				);
    }
}
