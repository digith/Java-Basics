package com.digithkv.java.basics.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeExample {
	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		System.out.println("LocalDateTime "+ldt+ "\nLocalDate "+ld+"\nLocalTime "+lt);
		System.out.println("Indian Independence day "+LocalDate.of(1947, Month.AUGUST, 15));
		
		
		LocalDate nextMonthSecondWeekStart = LocalDate
				.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue()+1, 1).plusWeeks(2);
		
		int diff = DayOfWeek.THURSDAY.ordinal() - nextMonthSecondWeekStart.getDayOfWeek().ordinal();
		LocalDate nextMonthSecondWeekThursay=nextMonthSecondWeekStart;
		if(diff<0) {
			nextMonthSecondWeekThursay = nextMonthSecondWeekStart.minusDays(-1*diff);
		} else if(diff>0) {
			nextMonthSecondWeekThursay = nextMonthSecondWeekStart.plusDays(diff);
		}
		System.out.println("nextMonthSecondWeek "+nextMonthSecondWeekThursay);
	}
}
