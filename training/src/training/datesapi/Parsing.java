package training.datesapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Parsing {

	public static void main(String[] args) {
		LocalDate d = LocalDate.parse("2025-07-09");
		System.out.println(d);
		
		//LocalDate d2 = LocalDate.parse("2025/07/09"); // DateTimeParseException
		//System.out.println(d2);
		
		//LocalDate d2 = LocalDate.parse("2025-02-29"); // DateTimeParseException
		//System.out.println(d2);
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("YYYY|MM/dd");
		String s = f.format(d);
		System.out.println(s);
		
		//LocalDateTime dd = LocalDateTime.parse(s, f);
		//System.out.println(dd);
		
		Period p = Period.of(1, 2, 3);
		System.out.println(p);
		
		Period p2 = Period.ofWeeks(2);
		System.out.println(p2);
	}

}
