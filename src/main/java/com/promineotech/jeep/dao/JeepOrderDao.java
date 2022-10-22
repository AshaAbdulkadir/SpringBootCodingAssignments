package com.promineotech.jeep.dao;

import com.promineotech.jeep.entity.Customer;

public interface JeepOrderDao {
	
	Customer fetchCustomer(String customer);

}
