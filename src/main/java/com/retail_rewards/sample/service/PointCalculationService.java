package com.retail_rewards.sample.service;

import org.springframework.stereotype.Component;

import com.retail_rewards.sample.repository.Customer;

@Component
public interface PointCalculationService {
	public int pointCalculator(String start, Customer customer, int range);
	public int totalPoints(Customer customer);
}
