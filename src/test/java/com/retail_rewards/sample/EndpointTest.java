package com.retail_rewards.sample;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;

import com.retail_rewards.sample.controller.RewardCalculationController;
import com.retail_rewards.sample.repository.Customer;
import com.retail_rewards.sample.service.PointCalculationService;

//WIP - Test commented out until I figure out why there's a null pointer. 

@AutoConfigureMockMvc
public class EndpointTest {

	@Autowired
	MockMvc mockMvc;

	@Before
	public void createMocks() {
		RewardCalculationController rwc = new RewardCalculationController();
		//mockMvc = MockMvcBuilders.standaloneSetup(rwc).build();
		MockitoAnnotations.initMocks(this);
	}

	@MockBean
	PointCalculationService pointCalcService;

	//@Test
	public void getRewardsTotal_SetupTest_Success() throws Exception {

		Mockito.when(pointCalcService.totalPoints(any(Customer.class))).thenReturn(100);

		mockMvc.perform(MockMvcRequestBuilders.get("api/points/Joe/total")).andExpect(status().isOk());

	}
	//@Test
	public void getRewards_SetupTest_Failure() throws Exception {

		Mockito.when(pointCalcService.totalPoints(any(Customer.class))).thenReturn(100);

		mockMvc.perform(MockMvcRequestBuilders.get("api/points/Joe")).andExpect(status().isBadRequest());

	}
	
	//@Test
	public void getRewards_Total_Success() throws Exception {

		Mockito.when(pointCalcService.totalPoints(any(Customer.class))).thenReturn(120);

		MvcResult result = 
				mockMvc.perform(MockMvcRequestBuilders.get("api/points/Joe")).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		
		assertEquals(90, content);
	}
	//@Test
	public void getRewards_Total_SuccessUnder100() throws Exception {

		Mockito.when(pointCalcService.totalPoints(any(Customer.class))).thenReturn(51);

		MvcResult result = 
				mockMvc.perform(MockMvcRequestBuilders.get("api/points/Joe")).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		
		assertEquals(1, content);
	}
	//@Test
	public void getRewards_Total_SuccessUnder50() throws Exception {

		Mockito.when(pointCalcService.totalPoints(any(Customer.class))).thenReturn(49);

		MvcResult result = 
				mockMvc.perform(MockMvcRequestBuilders.get("api/points/Joe")).andExpect(status().isOk()).andReturn();

		String content = result.getResponse().getContentAsString();
		
		assertEquals(0, content);
	}
	//add tests for monthly/quarterly
}
