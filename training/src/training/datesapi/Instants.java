package training.datesapi;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Instants {

	public static void main(String[] args) {

		Instant i = Instant.now();		
		System.out.println(i);

		LocalDateTime d = LocalDateTime.now();
		System.out.println(d);

		System.out.println(Instant.MIN);		
		System.out.println(Instant.EPOCH);
		
		System.out.println(d.toInstant(ZoneOffset.UTC));
		
		Instant i2 = Instant.ofEpochMilli(-1000);
		System.out.println(i2);

	}

}

