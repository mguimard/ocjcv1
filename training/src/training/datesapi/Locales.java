package training.datesapi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class Locales {
	public static void main(String[] args) {
		
		Locale.getAvailableLocales();
		
		Locale.getDefault();
		Locale.setDefault(new Locale("en","US"));
		
		System.out.println(LocalDate.now());
		
	}
}
