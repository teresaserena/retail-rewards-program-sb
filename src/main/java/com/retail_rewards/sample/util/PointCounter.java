package com.retail_rewards.sample.util;

public class PointCounter {
	public int pointCounter(int saleAmt) {
		int points = 0;
		if(saleAmt > 100) {
			points += (saleAmt-100)*2+50;
		}
		else if(saleAmt > 50 && saleAmt < 100) {
			points += saleAmt-50;
		}
		return points;
	}
}
