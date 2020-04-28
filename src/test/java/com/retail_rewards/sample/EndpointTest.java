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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.any;

import com.retail_rewards.sample.controller.RewardCalculationController;
import com.retail_rewards.sample.repository.Customer;
import com.retail_rewards.sample.service.PointCalculationService;

//WIP

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

		mockMvc.perform(MockMvcRequestBuilders.get("/Joe/total")).andExpect(status().isOk());

	}

}
