package com.promineotech.jeep.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Slf4j
public class BasicJeepSalesController implements JeepSalesController {
	 Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public List<Jeep> fetchJeeps(JeepModel model, String trim) {
		log.info("model={}, trim={}", model, trim);
		return null;
	}

}
