/*
 * Copyright (c) 2018 IPS, All rights reserved.
 *
 * The contents of this file are subject to the terms of the Apache License, Version 2.0.
 * Release: v1.0, By IPS, 2021.01.
 *
 */
package rdbms.DBMeter;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Utilities
 * 
 * @version 1.0
 */
public class Util implements Config {

	private static String str = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ12345678909876543210zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBAabcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ12345678909876543210zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBAabcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ12345678909876543210zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBAabcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ12345678909876543210zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBAabcdefghigklmnopqrs";
	private static long count = 0;
	private static long randomSeed1 = System.currentTimeMillis();
	private static long randomSeed2 = 7154621119293732143L;

	public static String getSysProp(String inSysProperty, String defaultValue) {
		String outPropertyValue = null;
		try {
			outPropertyValue = System.getProperty(inSysProperty, defaultValue);
			if (inSysProperty.equals("password")) {
				System.out.println(inSysProperty + "=*****");
			} else {
				System.out.println(inSysProperty + "=" + outPropertyValue);
			}
		} catch (Exception e) {
			System.out.println("Error Reading Required System Property '"
					+ inSysProperty + "'");
		}
		return (outPropertyValue);
	}

	public static String randomStr(long strLen) {
		if (strLen < 1) {
			return "";
		} else {
			if (strLen > 100) {
				return str.substring(0, (int) strLen - 1);
			} else {
				count++;
				int countlength = String.valueOf(count).length();
				if (strLen - 1 - countlength < 0) {
					return str.substring(0, (int) strLen - 1);
				} else {
					return str.substring(0, (int) strLen - 1 - countlength)
							+ count;
				}
			}
		}
	}

	public static String getCurrentTime() {
		return dateFormat.format(new java.util.Date());
	}

	public static String formattedDouble(double d) {
		String dS = "" + d;
		return dS.length() > 6 ? dS.substring(0, 6) : dS;
	}

	public static int getItemID(Random r) {
		return nonUniformRandom(8191, 1, 100000, r);
	}

	public static int getCustomerID(Random r) {
		return nonUniformRandom(1023, 1, 3000, r);
	}

	public static String getLastName(Random r) {
		int num = (int) nonUniformRandom(255, 0, 999, r);
		return nameTokens[num / 100] + nameTokens[(num / 10) % 10]
				+ nameTokens[num % 10];
	}

	public static int randomNumber(int min, int max, Random r) {
		return (int) (r.nextDouble() * (max - min + 1) + min);
	}

	public static int nonUniformRandom(int x, int min, int max, Random r) {
		return (((randomNumber(0, x, r) | randomNumber(min, max, r)) + randomNumber(
				0, x, r)) % (max - min + 1))
				+ min;
	}

	public synchronized static long genRandomSeed(long randomSeed3) {
		return (++randomSeed1 + randomSeed3) % (++randomSeed2);
	}

	public static String getFileNameSuffix() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(new java.util.Date());
	}
}
