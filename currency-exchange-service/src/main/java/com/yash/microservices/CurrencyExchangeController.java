package com.yash.microservices;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Environment environment;
	
	@Autowired
	ExchangeValueRepository exchange;
	
	@RequestMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExanchangeValue(@PathVariable String from,@PathVariable String to) {
		ExchangeValue ev= exchange.findByFromAndTo(from, to); 
		ev.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("{}",ev);
		return ev;
	}
	
}
