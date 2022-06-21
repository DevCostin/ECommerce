package net.devcostin.code.domain.util;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatUtil{
	
	public static String formatDateToString(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
		return date.format(formatter).toString();
	}
	
	public static String formatDouble(double number) {	
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(number);
	}
	
}