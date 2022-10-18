package com.promineotech.jeep.service;

import java.util.List;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Slf4j
public class DefaultJeepSaleService implements JeepSalesService {
	Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public List<Jeep> fetchJeeps(JeepModel model, String trim) {
		log.info("The fetchJeeps method was called with model={} and trim={}", 
				model, trim);
		return null;
	}

}
