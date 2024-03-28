package com.java.Java8Features.StreamAPI.DateAndTime;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalTimeExample {

	public static void main(String[] args) {
		
		//Current Time
		LocalTime time = LocalTime.now();
		System.out.println("Current Time="+time);
		
		//Creating LocalTime by providing input arguments
		LocalTime specificTime = LocalTime.of(12,20,25,40);
		System.out.println("Specific Time of Day="+specificTime);

		System.out.println(time.getHour()+"--"+time.getMinute()+"--"+time.getSecond()+"--"+time.getNano());

		// parse

		LocalTime parseTime = LocalTime.parse("12:32:14");
		System.out.println(parseTime.getHour());


		
		//Try creating time by providing invalid inputs
		//LocalTime invalidTime = LocalTime.of(25,20);
		//Exception in thread "main" java.time.DateTimeException: 
		//Invalid value for HourOfDay (valid values 0 - 23): 25
		
		//Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
//		LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
//		System.out.println("Current Time in IST="+timeKolkata);
//
//		//java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
//		//LocalTime todayIST = LocalTime.now(ZoneId.of("IST"));
//
//		//Getting date from the base date i.e 01/01/1970
//		LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
//		System.out.println("10000th second time= "+specificSecondTime);

	}

}