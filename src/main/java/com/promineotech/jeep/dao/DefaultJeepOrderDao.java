package com.promineotech.jeep.dao;

import org.springframework.stereotype.Component;

import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultJeepOrderDao implements JeepOrderDao {

	@Override
	public Order createOrder(OrderRequest orderRequest) {
		log.debug("Order={}", orderRequest);
		return null;
	}

}
