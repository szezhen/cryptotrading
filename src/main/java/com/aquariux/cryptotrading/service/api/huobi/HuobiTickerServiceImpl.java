package com.aquariux.cryptotrading.service.api.huobi;

import java.util.Collections;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aquariux.cryptotrading.service.dto.huobi.HuobiTicker;
import com.aquariux.cryptotrading.service.dto.huobi.HuobiTickerResponse;

@Service
public class HuobiTickerServiceImpl implements HuobiTickerService {

	private final Environment env;
	private final RestTemplate restTemplate;
	
	public HuobiTickerServiceImpl(Environment env, RestTemplate restTemplate) {
		this.env = env;
		this.restTemplate = restTemplate;
	}

	@Override
	public List<HuobiTicker> getTickers() {
		ResponseEntity<HuobiTickerResponse> response = restTemplate
				.exchange(env.getProperty("application.endpoints.huobi.tickers"), HttpMethod.GET, null, new ParameterizedTypeReference<HuobiTickerResponse>() {});
		
		if (response.getStatusCode().is2xxSuccessful()) {
			return response.getBody().getTickers();
		}
		
		return Collections.emptyList();
	}

}
