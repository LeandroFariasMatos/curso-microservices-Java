package com.bookservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Foo bar")
@RestController
@RequestMapping("book-service")
public class FooBarController {
	
	private Logger logger = LoggerFactory.getLogger(FooBarController.class);
	
	@GetMapping("/foo-bar")
	@Operation(summary = "Foo Bar")
	//@Retry(name="foo-bar",fallbackMethod = "fallbackMethod")
	//@CircuitBreaker(name="default",fallbackMethod = "fallbackMethod")
	//@RateLimiter(name="default")
	//@Bulkhead(name = "default")
	public String fooBar() {
		logger.info("Request to fooBar is received!!");
		/*
		 * var response = new
		 * RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
		 * return response.getBody();
		 */
		return "Foo-Bar!!";
	}
	
	public String fallbackMethod(Exception ex) {
		return "fallbackMethod foo-bar!!!";
	}

}
