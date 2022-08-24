package com.aquariux.cryptotrading.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.aquariux.cryptotrading.domain.account.Order;
import com.aquariux.cryptotrading.domain.account.Ticker;
import com.aquariux.cryptotrading.domain.market.OrderBook;
import com.aquariux.cryptotrading.enumeration.OrderSide;
import com.aquariux.cryptotrading.enumeration.OrderStatus;
import com.aquariux.cryptotrading.enumeration.OrderType;
import com.aquariux.cryptotrading.service.api.binance.BinanceTickerService;
import com.aquariux.cryptotrading.service.api.huobi.HuobiTickerService;
import com.aquariux.cryptotrading.service.dto.binance.BinanceTicker;
import com.aquariux.cryptotrading.service.dto.huobi.HuobiTicker;

@Service
public class PriceAggregationServiceImpl implements PriceAggregationService {
	
	private final Logger log = LoggerFactory.getLogger(PriceAggregationServiceImpl.class);
	
	private static final int INTERVAL_IN_SECONDS = 10 * 1000; // 10 seconds
	
	private static final Set<String> SUPPORTED_PAIRS = Stream.of("BTCUSDT", "ETHUSDT")
			.collect(Collectors.toCollection(HashSet::new)); 
	
	private final BinanceTickerService binanceTickerService;
	private final HuobiTickerService huobiTickerService;
	private final OrderService orderService;
//	private final OrderBookService orderBookService
	
	public PriceAggregationServiceImpl(
			BinanceTickerService binanceTickerService,
			HuobiTickerService huobiTickerService,
			OrderService orderService
//			OrderBookService orderBookService
			) {
		this.binanceTickerService = binanceTickerService;
		this.huobiTickerService = huobiTickerService;
		this.orderService = orderService;
//		this.orderBookService = orderBookService;
	}

	@Scheduled(fixedRate = INTERVAL_IN_SECONDS)
	@Override
	public void retrievePricing() {
		
		Map<String, BinanceTicker> binanceTickerMap = new HashMap<>();
		Map<String, HuobiTicker> huobiTickerMap = new HashMap<>();
		
		CompletableFuture<Void> binanceTickerFuture = CompletableFuture.supplyAsync(() -> {
			return binanceTickerService.getTickers();
		}).thenAcceptAsync(tickers -> {
			tickers.parallelStream()
				.forEach(ticker -> {
					if (SUPPORTED_PAIRS.contains(ticker.getSymbol())) {
						binanceTickerMap.put(ticker.getSymbol(), ticker);
					}
				});
		});
		
		CompletableFuture<Void> huobiTickerFuture = CompletableFuture.supplyAsync(() -> {
			return huobiTickerService.getTickers();
		}).thenAcceptAsync(tickers -> {
			tickers.parallelStream()
				.forEach(ticker -> {
					if (SUPPORTED_PAIRS.contains(ticker.getSymbol())) {
						huobiTickerMap.put(ticker.getSymbol(), ticker);
					}
				});
		});
		
		CompletableFuture.allOf(binanceTickerFuture, huobiTickerFuture).join();
		
		SUPPORTED_PAIRS.parallelStream()
			.forEach(pair -> {
				Ticker ticker = new Ticker();
				ticker.setSymbol(pair);
				
				
				BigDecimal binanceBidPrice = new BigDecimal(binanceTickerMap.get(pair).getBidPrice());
				BigDecimal binanceBidSize = new BigDecimal(binanceTickerMap.get(pair).getBidSize());
				BigDecimal huobiBidPrice = new BigDecimal(String.valueOf(huobiTickerMap.get(pair).getBidPrice()));
				BigDecimal huobiBidSize = new BigDecimal(String.valueOf(huobiTickerMap.get(pair).getBidSize()));
				
				// Take max bid price
				if (binanceBidPrice.compareTo(huobiBidPrice) > 0) {
					ticker.setBidPrice(binanceBidPrice);
					ticker.setBidSize(binanceBidSize);
				} else {
					ticker.setBidPrice(huobiBidPrice);
					ticker.setBidSize(huobiBidSize);
				}
				
				BigDecimal binanceAskPrice = new BigDecimal(binanceTickerMap.get(pair).getAskPrice());
				BigDecimal binanceAskSize = new BigDecimal(binanceTickerMap.get(pair).getAskSize());
				BigDecimal huobiAskPrice = new BigDecimal(String.valueOf(huobiTickerMap.get(pair).getAskPrice()));
				BigDecimal huobiAskSize = new BigDecimal(String.valueOf(huobiTickerMap.get(pair).getAskSize()));
				
				// Take min ask price
				if (binanceAskPrice.compareTo(huobiAskPrice) <= 0) {
					ticker.setAskPrice(binanceAskPrice);
					ticker.setAskSize(binanceAskSize);
				} else {
					ticker.setAskPrice(huobiAskPrice);
					ticker.setAskSize(huobiAskSize);
				}
				
//				OrderBook orderBook = orderBookService.getOrderBookInstance(ticker.getSymbol());
				
				Order buyOrder = new Order();
				buyOrder.setSymbol(ticker.getSymbol());
				buyOrder.setPrice(ticker.getBidPrice());
				buyOrder.setSize(ticker.getBidSize());
				buyOrder.setType(OrderType.LIMIT);
				buyOrder.setSide(OrderSide.BUY);
				buyOrder.setStatus(OrderStatus.OPEN);
				
//				orderBookService.addBid(orderBook, ticker.getBidPrice(), ticker.getBidSize());
				
				orderService.save(buyOrder);
				
				Order sellOrder = new Order();
				sellOrder.setSymbol(ticker.getSymbol());
				sellOrder.setPrice(ticker.getAskPrice());
				sellOrder.setSize(ticker.getAskSize());
				sellOrder.setType(OrderType.LIMIT);
				sellOrder.setSide(OrderSide.SELL);
				sellOrder.setStatus(OrderStatus.OPEN);
				
//				orderBookService.addBid(orderBook, ticker.getAskPrice(), ticker.getAskSize());
				
				orderService.save(sellOrder);
			});
	}

}
