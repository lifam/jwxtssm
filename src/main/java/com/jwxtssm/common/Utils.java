package com.jwxtssm.common;

import com.jwxtssm.exception.CustomException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
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

	public static Date constructNewDate() {
		Calendar calendar = new GregorianCalendar();
		return convertYMDToDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
	}

	public static boolean checkDateValid(Date date) {
		Calendar calendar = new GregorianCalendar();
		return date.getTime() >= calendar.getTimeInMillis();
	}

	public static void clearCookie(HttpServletResponse httpServletResponse, String clearField) {
		Cookie cookie = new Cookie(clearField, null);
		cookie.setPath("/");
		httpServletResponse.addCookie(cookie);
	}

	public static void setCookie(HttpServletResponse httpServletResponse, String setField, String setValue, String setPath) {
		Cookie cookie = new Cookie(setField, Utils.processStringToFitCookie(setValue));
		cookie.setPath(setPath);
		httpServletResponse.addCookie(cookie);
	}

	public static String constructFileName(int basicId, String fileName) {
		return String.valueOf(basicId) + '-' + fileName;
	}

	public static String processStringToFitCookie(String raw) {
		raw.replace(',', '#');
		raw.replace(' ', '#');
		return raw;
	}

	public static void setSessionAttribute(HttpSession session, String setField, Object setValue) {
		session.setAttribute(setField, setValue);
	}

	public static void clearSessionAttribute(HttpSession session, String setField) {
		session.removeAttribute(setField);
	}
}
