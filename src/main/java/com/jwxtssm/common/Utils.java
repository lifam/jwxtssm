package com.jwxtssm.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utils {
	private static MessageDigest sha256 = null;

	static {
		try {
			sha256 = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static String generateSHA256Digest(String str) throws UnsupportedEncodingException {
		sha256.update(str.getBytes("utf8"));
		return new String(sha256.digest(), "utf8");
	}

	public static Date convertYMDToDate(int year, int month, int day) {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		return new Date(calendar.getTime().getTime());
	}

	public static boolean checkDateValid(Date date) {
		Calendar calendar = new GregorianCalendar();
		return date.getTime() >= calendar.getTimeInMillis();
	}

	public static void clearCookie(HttpServletResponse httpServletResponse) {
		Cookie cookie = new Cookie("set", null);
		cookie.setPath("/");
		httpServletResponse.addCookie(cookie);
	}
}
