package com.practice.Spring.boot.practice.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private HelloConttroller helloCon;
	
	@Before
	public void setUp() throws Exception {
		// TODO Auto-generated method stub
       mockMvc=MockMvcBuilders.standaloneSetup(helloCon).build();
	}
	
	@Test
	public void testHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hi"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Welcome"));
	}
}
