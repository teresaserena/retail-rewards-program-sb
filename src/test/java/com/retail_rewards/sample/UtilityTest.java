package com.retail_rewards.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.retail_rewards.sample.util.DateRange;
import com.retail_rewards.sample.util.PointCounter;

public class UtilityTest {

	// TODO - find out why mocking is acting up when used here
	private PointCounter pointCountingService = new PointCounter();
	private DateRange dates = new DateRange();

	@Test
	public void pointCounterOver100() {
		int points = pointCountingService.pointCounter(120);
		assertEquals(90, points);
	}

	@Test
	public void pointCounterOver150() {
		int points = pointCountingService.pointCounter(170);
		assertEquals(190, points);
	}

	@Test
	public void pointCounterOver50() {
		int points = pointCountingService.pointCounter(51);
		assertEquals(1, points);
	}

	@Test
	public void oneMonthRange() {
		Boolean isWithinRange = dates.withinDateRange("2020-11-01", "2020-10-31", 30);
		assertTrue(isWithinRange);
	}
	@Test
	public void oneMonthRange_NotWithinRange() {
		Boolean isWithinRange = dates.withinDateRange("2020-11-01", "2020-03-31", 30);
		assertFalse(isWithinRange);
	}
	
	@Test
	public void threeMonthRange() {
		Boolean isWithinRange = dates.withinDateRange("2020-11-01", "2020-09-29", 90);
		assertTrue(isWithinRange);
	}
	
	@Test
	public void threeMonthRange_notWithinRange() {
		Boolean isWithinRange = dates.withinDateRange("2020-11-01", "2020-03-29", 90);
		assertFalse(isWithinRange);
	}
}
