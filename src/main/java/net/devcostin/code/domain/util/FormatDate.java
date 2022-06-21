package net.devcostin.code.domain.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDate{
	
	public static String formatDateToString(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
		return date.format(formatter).toString();
	}
	
}