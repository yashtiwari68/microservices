package com.yash.microservices;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConvertorController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CurrencyExchangeServiceProxy proxy;

	@RequestMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertorBean convertCurrency(@PathVariable String from,@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		Map<String,String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConvertorBean> responseEntity= new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyConvertorBean.class, uriVariables);
		CurrencyConvertorBean response=responseEntity.getBody();
		return new CurrencyConvertorBean(response.getId(),from,to,response.getConversionMultiple(),quantity.multiply(response.getConversionMultiple()),quantity,response.getPort());
	}
	
	@RequestMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConvertorBean convertCurrencyFeign(@PathVariable String from,@PathVariable String to, @PathVariable BigDecimal quantity) {
		CurrencyConvertorBean response=proxy.retrieveExanchangeValue(from, to);
		logger.info("{}",response);
		return new CurrencyConvertorBean(response.getId(),from,to,response.getConversionMultiple(),quantity.multiply(response.getConversionMultiple()),quantity,response.getPort());
	}
	
}
