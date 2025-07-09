package training.datesapi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

public class Temporals {

	public static void main(String[] args) {
		
		LocalTime t = LocalTime.now();  // ne contient qu'une info horaire
		System.out.println(t);
		
		LocalDate d = LocalDate.now(); // ne contient qu'une info de jour/mois/année
		System.out.println(d);
		
		LocalDateTime ldt = LocalDateTime.now(); // les 2
		System.out.println(ldt);
		
		Temporal t1 = (Temporal) t;
		Temporal t2 = (Temporal) d;
		Temporal t3 = (Temporal) ldt;
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
				
		LocalTime a = LocalTime.now();
		LocalTime b = LocalTime.now().minus(Duration.ofMinutes(10));
	
		// mesure de temps (secondes)
		Duration duration =  Duration.between(a, b);
		System.out.println(duration);
		
		//System.out.println(Duration.between(t, d));		
		
		// mesure de temps (jours)
		Period p = Period.between(d, d);		
		Period p2 = Period.ofDays(2);
		
		p2.plus(Duration.ofMinutes(10));
	}

}

