package com.promineotech.jeep.controller.support;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

public class FetchJeepTestSupport extends BaseTest{
	protected List<Jeep> buildExpected() {
		List<Jeep> list = new LinkedList<>();
		
		// @formatter: off
		list.add(Jeep.builder()
			      .modelId(JeepModel.WRANGLER)
			      .trimLevel("Sport")
			      .numDoors(2)
			      .wheelSize(17)
			      .basePrice(new BigDecimal("28475.00"))
			      .build());
			      
			      list.add(Jeep.builder()
			          .modelId(JeepModel.WRANGLER)
			          .trimLevel("Sport")
			          .numDoors(4)
			          .wheelSize(17)
			          .basePrice(new BigDecimal("31975.00"))
			          .build()
			      
			      );
		// @formatter: on 
		
		return list;
	}

}
