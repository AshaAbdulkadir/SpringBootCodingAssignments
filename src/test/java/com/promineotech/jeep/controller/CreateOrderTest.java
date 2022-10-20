package com.promineotech.jeep.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.jeep.JeepSales;
import com.promineotech.jeep.controller.support.CreateOrderTestSupport;
/**
 * 
 * @author Asha
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = JeepSales.class )
@ActiveProfiles("test")
@Sql(scripts = { "classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
				"classpath:flyway/migrations/V1.1__Jeep_Data.sql" }, config = @SqlConfig(encoding = "utf-8"))
class CreateOrderTest extends CreateOrderTestSupport {
	
	/**
	 * 
	 */
	@Test
	void testCreateOrderResturnsSuccess201() {
		
		String body = createOrderBody();

	}


}
