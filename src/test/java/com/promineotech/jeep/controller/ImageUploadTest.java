package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ImageUploadTest {

	private static final String JEEP_IMAGE = "Jeep.jpeg";
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testThatTheServerReceivesAnImageAndReturnsAnOkResponse() {
		Resource image = new ClassPathResource(JEEP_IMAGE);
		
		if(!image.exists()) {
			fail("Could not find %s", JEEP_IMAGE);
		}
	}

}
