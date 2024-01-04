package com.tutorialsninja.qa.Utilities.pt2;

import java.util.Date;

public class Util {

	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		String emailTimeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda1" + emailTimeStamp + "@gmail.com";
	}
	
	public static final int IMPLICIT_WAIT_TIME = 20;
	public static final int PAGE_LOAD_TIME = 20;
	public static final int SCRIPT_TIMEOUT = 1000;
	
	
}
