package com.robotnasa.challenge;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


public class TestChallenge extends RobotNasaChallengeApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testRobotAbleMoviment() throws Exception {
		mockMvc.perform(get("/rest/mars/MMRMMRMM")).andExpect(status().isOk());
		mockMvc.perform(get("/rest/mars/AAAA")).andExpect(status().isBadRequest());
		mockMvc.perform(get("/rest/mars/MMMMMMMMMMMMMMMMMMMMM")).andExpect(status().isBadRequest());

	}

}
