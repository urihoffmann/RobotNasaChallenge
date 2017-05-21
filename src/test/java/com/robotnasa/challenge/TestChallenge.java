package com.robotnasa.challenge;


/*
 * Author: Urique Hoffmann
 * 
 * Class that implements unit test for REST
 *  
 * */

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
		// check a possible movement
		mockMvc.perform(get("/rest/mars/MMRMMRMM")).andExpect(status().isOk());
		// check an impossible movement
		mockMvc.perform(get("/rest/mars/AAAA")).andExpect(status().isBadRequest());
		// check movements that will make the robot go after the limits of the area
		mockMvc.perform(get("/rest/mars/MMMMMMMMMMMMMMMMMMMMM")).andExpect(status().isBadRequest());

	}

}
