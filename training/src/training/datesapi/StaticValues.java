package training.datesapi;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;

public class StaticValues {

	public static void main(String[] args) {
		
		System.out.println(Year.MIN_VALUE);
		System.out.println(Year.MAX_VALUE);

		System.out.println(Month.JANUARY.getValue());
		System.out.println(Month.DECEMBER.getValue());
		
		System.out.println(DayOfWeek.MONDAY.getValue());
		System.out.println(DayOfWeek.SUNDAY.getValue());
		
		Calendar c = Calendar.getInstance();		
		
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
		
		System.out.println(LocalTime.MIN);
		System.out.println(LocalTime.MAX);		
	}

}
