package com.retail_rewards.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.retail_rewards.sample.config.RewardsApplication;
import com.retail_rewards.sample.repository.Customer;
import com.retail_rewards.sample.repository.Transaction;

public class SetupTest {
	
	@Test
	public void initialTest() {
		RewardsApplication.main(new String [] {} );
	}
	@Test
	public void testCustomer() {
		Customer customer = new Customer();
		customer.setName("Joe Customer");
		assertNotNull(customer);	
	}
	@Test
	public void testTransaction() {
		Transaction transaction = new Transaction();
		assertNotNull(transaction);
	}
}
