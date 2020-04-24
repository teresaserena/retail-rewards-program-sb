package com.retail_rewards.sample.persistence;

import java.util.ArrayList;
import java.util.List;

import com.retail_rewards.sample.repository.Customer;
import com.retail_rewards.sample.repository.Transaction;

//TODO - Set up h2 or JPA

public class FakePersistence {
	public static Customer returnUser(String userName) {
		Customer customer = new Customer();
		customer.setName("George Folk");
		customer.setTransactions(getTransactionList());
		return customer;
	}
	public static List<Transaction> getTransactionList(){
		List<Transaction> transactionsList = new ArrayList<Transaction>();
		Transaction transaction1 = new Transaction();
		Transaction transaction2 = new Transaction();
		transaction1.setAmount(100);
		transaction1.setDate("2020-01-11");
		transaction2.setAmount(100);
		transaction2.setDate("2020-01-11");
		transactionsList.add(transaction1);
		transactionsList.add(transaction2);
		return transactionsList;
	}
}
