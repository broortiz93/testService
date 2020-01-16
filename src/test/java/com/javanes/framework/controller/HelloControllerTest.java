package com.javanes.framework.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@ActiveProfiles("default,dev")
@WebAppConfiguration
@SpringBootTest
public class HelloControllerTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	@InjectMocks
	private HelloController activacionEmailV1Controller;
	private static final Logger LOG = LoggerFactory.getLogger(HelloControllerTest.class);
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void sucess() {
		try {


			mockMvc.perform(MockMvcRequestBuilders.get("/hello-controller/hello")
					.contentType(MediaType.APPLICATION_JSON)
					//.content(jsonString)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}