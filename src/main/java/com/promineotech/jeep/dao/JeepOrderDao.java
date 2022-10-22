package com.promineotech.jeep.dao;

import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;

public interface JeepOrderDao {

	Order createOrder(OrderRequest orderRequest);

}
