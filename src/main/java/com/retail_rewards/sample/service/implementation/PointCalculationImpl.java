package com.retail_rewards.sample.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail_rewards.sample.repository.Customer;
import com.retail_rewards.sample.repository.Transaction;
import com.retail_rewards.sample.service.PointCalculationService;
import com.retail_rewards.sample.util.DateRange;
import com.retail_rewards.sample.util.PointCounter;


@Service
public class PointCalculationImpl implements PointCalculationService {

	@Autowired
	private DateRange dateChecker;

	@Autowired
	private PointCounter pointCounter;

	// checks for any given 30 or 90 day period
	public int pointCalculator(String endDate, Customer customer, int range) {
		try {
			List<Transaction> transactions = customer.getTransactions();
			int totalPoints = 0;
			for (int i = 0; i < transactions.size(); i++) {
				String dateToCheck = transactions.get(i).getDate();
				if (dateChecker.withinDateRange(endDate, dateToCheck, range)) {
					totalPoints += pointCounter.pointCounter(transactions.get(i).getAmount());
				}
			}
			return totalPoints;
		} catch (Exception exception) {
			// TODO - configure LOG4j
			System.out.println(exception.getMessage());
			return 0;
		}

	}

	// customer total
	public int totalPoints(Customer customer) {
		try {
			List<Transaction> transactions = customer.getTransactions();
			int totalPoints = 0;
			for (int i = 0; i < transactions.size(); i++) {
				totalPoints += pointCounter.pointCounter(transactions.get(i).getAmount());
			}
			return totalPoints;
		} catch (Exception exception) {
			// TODO - configure LOG4j
			System.out.println(exception.getMessage());
			return 0;
		}
	}

}
