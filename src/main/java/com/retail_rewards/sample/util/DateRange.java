package com.retail_rewards.sample.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/*
* Pulls in a date, if empty, use today
* Range will be either 30 or 90, depending on what today is
*/

public class DateRange {
	public Boolean withinDateRange(String start, String today, int range) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern(pattern);
		
		//if date is null, use today as start point
		if(start.isEmpty()) {
			start = simpleDate.format(new Date());
		}
		LocalDate end = LocalDate.parse(start, dateTime);
		LocalDate current = LocalDate.parse(today, dateTime);
		LocalDate begin = end.minusDays(range);
		
		if(current.isAfter(begin) && current.isBefore(end)) {
			return true;
		}else {	
			return false;
		}
	}
	
}
