package com.promineotech.jeep.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

public class BaseTest {
	private int serverPort;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	protected String getBaseUri() {
		return String.format("http;//localhost:%d/jeeps", serverPort);
	}

	public TestRestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
