package com.yash.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	Configuration configuration;
	
	@RequestMapping("/limits/")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
	
	@GetMapping("/limits/fault-tolerance")
	@HystrixCommand(fallbackMethod = "faultTolerantretrieveInfo")
	public LimitConfiguration retrieveInfo() {
		throw new RuntimeException();
	}
	
	public LimitConfiguration faultTolerantretrieveInfo() {
		return new LimitConfiguration(999, 99);
	}
}
