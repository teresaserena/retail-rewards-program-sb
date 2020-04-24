package com.retail_rewards.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retail_rewards.sample.persistence.FakePersistence;
import com.retail_rewards.sample.service.PointCalculationService;

@RestController
public class RewardCalculationController {
	
	PointCalculationService pointCalculationService;
	
	FakePersistence fakeUser;

	
	@GetMapping("/{customerName}/total")
	public Integer getCustomerTotal(@PathVariable String customerName) {
		return pointCalculationService.totalPoints(FakePersistence.returnUser(customerName));
	}
	/*
	* Pass in a customer name
	* customer name used to retrieve an object with transaction history
	* Date is in format yyyy-MM-dd, and goes x days in the past
	*/
	@GetMapping("/{customerName}/quarter")
	public Integer getCustomerQuarterTotal(@PathVariable String customerName, 
			@RequestParam(name = "date", required = false) String date){
		return pointCalculationService.pointCalculator(date, FakePersistence.returnUser(customerName), 90);
	}
	/*
	* Pass in a customer name
	* customer name used to retrieve an object with transaction history
	* Date is in format yyyy-MM-dd, and goes x days in the past
	*/
	@GetMapping("/{customerName}/single")
	public Integer getCustomerMonthTotal(@PathVariable String customerName, 
			@RequestParam(name = "date", required = false) String date){
		return pointCalculationService.pointCalculator(date, FakePersistence.returnUser(customerName), 30);
	}
}
