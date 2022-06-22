package net.devcostin.code.domain.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatUtil{
	
	public static String formatDateToString(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
		return date.format(formatter).toString();
	}
	
	public static LocalDateTime formatStringToDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"); 
		return LocalDateTime.parse(date, formatter);
	}
	
	public static String doubleToStringTwoDecimals(Double number) {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat df = (DecimalFormat) nf;
		try {
			df.applyPattern("#.00");
			return df.format(number);
		} catch (Exception e) {
			throw new NumberFormatException("Invalid number to format:" + number);
		}
	}
}