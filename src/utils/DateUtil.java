package utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	public static Date convertToDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date myDate = null;

		try {
			java.util.Date d = format.parse(date);
			myDate = new Date(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return myDate;
	}
}
