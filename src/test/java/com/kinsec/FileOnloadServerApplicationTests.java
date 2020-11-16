package com.kinsec;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class FileOnloadServerApplicationTests {

	private TestRestTemplate restTemplate;
	@Test
	void contextLoads() {
		System.out.println("sdsd");
	}

}
