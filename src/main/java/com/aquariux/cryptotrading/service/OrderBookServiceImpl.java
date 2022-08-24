package com.aquariux.cryptotrading.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aquariux.cryptotrading.domain.account.Order;
import com.aquariux.cryptotrading.domain.market.OrderBook;
import com.aquariux.cryptotrading.enumeration.OrderSide;
import com.aquariux.cryptotrading.enumeration.OrderStatus;
import com.aquariux.cryptotrading.enumeration.OrderType;

@Service
public class OrderBookServiceImpl implements OrderBookService {

	@Override
	public void addBid(OrderBook orderBook, BigDecimal price, BigDecimal size) {
		List<Order> bucket = getBucket(orderBook.getBids(), price);
		
		Order buyOrder = new Order();
		buyOrder.setSymbol(orderBook.getSymbol());
		buyOrder.setPrice(price);
		buyOrder.setSize(size);
		buyOrder.setType(OrderType.LIMIT);
		buyOrder.setSide(OrderSide.BUY);
		buyOrder.setStatus(OrderStatus.OPEN);
		
		bucket.add(buyOrder);
		orderBook.getBids().put(buyOrder.getPrice(), bucket);
		orderBook.getBestBidPrices().add(price);
		this.matchOrders(orderBook);
	}

	@Override
	public void addAsk(OrderBook orderBook, BigDecimal price, BigDecimal size) {
		List<Order> bucket = getBucket(orderBook.getAsks(), price);
		
		Order sellOrder = new Order();
		sellOrder.setSymbol(orderBook.getSymbol());
		sellOrder.setPrice(price);
		sellOrder.setSize(size);
		sellOrder.setType(OrderType.LIMIT);
		sellOrder.setSide(OrderSide.SELL);
		sellOrder.setStatus(OrderStatus.OPEN);
		
		bucket.add(sellOrder);
		orderBook.getAsks().put(sellOrder.getPrice(), bucket);
		orderBook.getBestAskPrices().add(price);
		this.matchOrders(orderBook);
	}

	@Override
	public List<Order> getBucket(Map<BigDecimal, List<Order>> map, BigDecimal price) {
		List<Order> bucket;
		
		if (map.containsKey(price)) {
			bucket = map.get(price);
		} else {
			bucket = new LinkedList<Order>();
		}
		
		return bucket;
	}

	@Override
	public void matchOrders(OrderBook orderBook) {
		List<Order> bidBucket = null;
        List<Order> askBucket = null;
        BigDecimal lowestAsk = null;
        BigDecimal highestBid = null;
        boolean finished = false;
        
        while(!finished)
        {
            highestBid = orderBook.getBestBidPrices().peek();
            lowestAsk = orderBook.getBestAskPrices().peek();

            if(lowestAsk == null || highestBid == null || lowestAsk.compareTo(highestBid) > 0)
            {
                finished = true;
            }
            else
            {
                bidBucket = orderBook.getBids().get(orderBook.getBestBidPrices().peek());
                askBucket = orderBook.getAsks().get(orderBook.getBestAskPrices().peek());

                BigDecimal bidSize = bidBucket.get(0).getSize();
                BigDecimal askSize = askBucket.get(0).getSize();

                if(bidSize.compareTo(askSize) > 0) {

                    bidSize = bidSize.subtract(askSize);
                    bidBucket.get(0).setSize(bidSize);

                    askBucket.remove(0);
                    orderBook.getBestAskPrices().remove();
                } else if(askSize.compareTo(bidSize) > 0) {

                    askSize = askSize.subtract(bidSize);
                    askBucket.get(0).setSize(askSize);

                    bidBucket.remove(0);
                    orderBook.getBestBidPrices().remove();
                } else {

                    bidBucket.remove(0);
                    orderBook.getBestBidPrices().remove();
                    askBucket.remove(0);
                    orderBook.getBestAskPrices().remove();
                }
            }
        }
	}

}
