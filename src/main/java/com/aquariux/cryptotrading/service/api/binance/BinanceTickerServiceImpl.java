package com.aquariux.cryptotrading.service.api.binance;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aquariux.cryptotrading.service.dto.binance.BinanceTicker;

@Service
public class BinanceTickerServiceImpl implements BinanceTickerService {

	private final Logger log = LoggerFactory.getLogger(BinanceTickerServiceImpl.class);
	
	private final Environment env;
	private final RestTemplate restTemplate;
	
	public BinanceTickerServiceImpl(Environment env, RestTemplate restTemplate) {
		this.env = env;
		this.restTemplate = restTemplate;
	}

	@Override
	public List<BinanceTicker> getTickers() {
		ResponseEntity<List<BinanceTicker>> response = restTemplate
				.exchange(env.getProperty("application.endpoints.binance.tickers"), HttpMethod.GET, null, new ParameterizedTypeReference<List<BinanceTicker>>() {});
		
		if (response.getStatusCode().is2xxSuccessful()) {
			return response.getBody();
		}
		
		return Collections.emptyList();
	}

}
