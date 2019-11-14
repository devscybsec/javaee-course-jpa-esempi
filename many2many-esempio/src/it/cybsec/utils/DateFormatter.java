package it.cybsec.utils;

import java.util.Date;
import java.text.*;
import java.util.Locale;
import java.util.TimeZone;


public class DateFormatter {

	private static SimpleDateFormat dateFormat;
	
	static {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ITALY);
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
	}
	
	static public Date parse(String postDate) throws ParseException {
		return dateFormat.parse(postDate);
	}
	
}
