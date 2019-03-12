package com.jwxtssm.common;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class RandomBirthdayGenerator {
	private static Random random = new Random();

	public static Date generateBirthday(int expectedAge) {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - expectedAge);
		calendar.set(Calendar.MONTH, random.nextInt(12));
		calendar.set(Calendar.DAY_OF_MONTH, random.nextInt(28));
		return new Date(calendar.getTime().getTime());
	}
}
