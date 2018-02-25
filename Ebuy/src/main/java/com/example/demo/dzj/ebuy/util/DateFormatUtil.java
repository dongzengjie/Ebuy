package com.example.demo.dzj.ebuy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	
	public static String getDateFormat(Date date){
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd"); 
		
		
		return time.format(date);
		
		
	}
}
