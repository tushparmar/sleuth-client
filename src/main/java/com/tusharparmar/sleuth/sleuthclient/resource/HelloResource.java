package com.tusharparmar.sleuth.sleuthclient.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource
{
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloResource.class);

	@Autowired
	public RestTemplate restTemplate;

	@GetMapping(value = "")
	public String hello()
	{
		LOGGER.info("Client: Printing before");
		restTemplate.getForObject("http://localhost:8081/rest/hello/server", String.class);
		LOGGER.info("Client: Printing after");
		return null;
	}
}
