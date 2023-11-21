package com.qa.luma.Utilities;

import java.util.Date;

public class DateTimeStamp {
	
		public static String genaratEmailWithDateTimeStamp() {
			Date date = new Date();
			String timeStamp = date.toString().replace(" ", "_").replace(":", "_");

			return "seleniumpanda" + timeStamp + "@gmail.com";
		}

	}
