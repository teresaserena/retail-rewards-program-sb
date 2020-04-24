package com.retail_rewards.sample.repository;

import java.util.List;

public class Customer {
	private String name;
	private List<Transaction> transactions;
	private int totalRewards;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the transactions
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}
	/**
	 * @param transactions the transactions to set
	 */
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	/**
	 * @return the totalRewards
	 */
	public int getTotalRewards() {
		return totalRewards;
	}
	/**
	 * @param totalRewards the totalRewards to set
	 */
	public void setTotalRewards(int totalRewards) {
		this.totalRewards = totalRewards;
	}
}
