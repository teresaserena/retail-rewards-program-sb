package com.retail_rewards.sample;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;

import com.retail_rewards.sample.repository.Customer;
import com.retail_rewards.sample.repository.Transaction;
import com.retail_rewards.sample.service.PointCalculationService;
import com.retail_rewards.sample.util.DateRange;
import com.retail_rewards.sample.util.PointCounter;

public class PointCalculationTest {
	
	@Mock
	PointCalculationService pointCalc;
	
	@Mock
	private DateRange dateChecker;
	
	@Mock
	private PointCounter pointCounter;
	
	  @Before
	  public void createMocks() {
	    MockitoAnnotations.initMocks(this);
	  }
	
	public Customer setUpCustomer() {
		Customer customer = new Customer();
		customer.setName("George Folk");
		List<Transaction> transactionsList = new ArrayList<Transaction>();
		Transaction transaction1 = new Transaction();
		Transaction transaction2 = new Transaction();
		Transaction transaction3 = new Transaction();
		transaction1.setAmount(120);
		transaction1.setDate("2020-01-11");
		transaction2.setAmount(120);
		transaction2.setDate("2020-01-12");
		transaction3.setAmount(51);
		transaction3.setDate("2020-01-13");
		transactionsList.add(transaction1);
		transactionsList.add(transaction2);
		customer.setTransactions(transactionsList);
		return customer;
	}
	
	@Test
	public void totalPoints_setsUp() {
		assertNotNull(pointCalc.totalPoints(setUpCustomer()));
	}

	//TODO - add more tests here
	
}
