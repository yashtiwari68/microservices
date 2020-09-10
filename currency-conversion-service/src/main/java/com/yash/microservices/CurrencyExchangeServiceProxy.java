package com.yash.microservices;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	@RequestMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConvertorBean retrieveExanchangeValue(@PathVariable("from") String from,@PathVariable("to") String to);
}