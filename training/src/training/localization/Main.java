package training.localization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

class MyStringsBundle extends ListResourceBundle{
	public MyStringsBundle() {}
	
	@Override
	protected Object[][] getContents() {
		Object[][] data = {
				{"sauce","mayo"},
				{"city","city"}
			};
		return data;
	}
}

class MyStringsBundle_fr_FR extends ListResourceBundle{
	public MyStringsBundle_fr_FR() {}
	
	@Override
	protected Object[][] getContents() {
		Object[][] data = {
				{"sauce","ketchup"},
				{"city","ville"},
		};
		return data;
	}
}


public class Main {

	public static void main(String[] args) {
		static_bundles(args);
	}
	
	
	public static void dynamic_bundles(String[] args) {
		var rb = ResourceBundle.getBundle("training.localization.MyStringsBundle", new Locale("fr","FR"));
		var it = rb.getKeys().asIterator();

		while(it.hasNext()) {
			String key = it.next();
			String value = rb.getString(key);			
			System.out.println(key + ":" + value);
		}	
	}


	public static void localeAPI(String[] args) {
		Locale locale = Locale.getDefault();

		System.out.println(locale);
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getDisplayLanguage());
		System.out.println(locale.getDisplayName());

	}

	public static void numbers(String[] args) {		
		Locale fr = new Locale("fr","FR");
		Locale us = new Locale("en", "US");

		NumberFormat devise = NumberFormat.getCurrencyInstance(fr);
		NumberFormat currency = NumberFormat.getCurrencyInstance(us);

		System.out.println(devise.format(12.50));
		System.out.println(currency.format(12.50));

		DateTimeFormatter us_dtf = DateTimeFormatter.ofPattern("YYYY MMM dd", us);
		System.out.println(us_dtf.format(LocalDateTime.now()));

		DateTimeFormatter fr_dtf = DateTimeFormatter.ofPattern("YYYY MMM dd", fr);
		System.out.println(fr_dtf.format(LocalDateTime.now()));

		NumberFormat nf_us = NumberFormat.getIntegerInstance(us);
		System.out.println(nf_us.format(1_000_000));

		NumberFormat nf_fr = NumberFormat.getIntegerInstance(fr);
		System.out.println(nf_fr.format(1_000_000));

		NumberFormat p_us = NumberFormat.getPercentInstance(us);
		System.out.println(p_us.format(0.98));

	}

	public static void unknownLocale(String[] args) {

		Locale locale = new Locale("hello", "WORLD");

		var rb = ResourceBundle.getBundle("training.localization.ApplicationResources", locale);
		var it = rb.getKeys().asIterator();

		while(it.hasNext()) {
			String key = it.next();
			String value = rb.getString(key);			
			System.out.println(key + ":" + value);
		}	

	}

	public static void props(String[] args) throws FileNotFoundException, IOException {

		try(var fis = new FileInputStream("src/training/localization/ApplicationResources.properties")){
			Properties p = new Properties();
			p.load(fis);

			System.out.println(p.getProperty("city", "Toulouse"));
			System.out.println(p.getProperty("weather"));
		}

	}

	public static void static_bundles(String[] args) {

		Locale locale = new Locale("fr", "FR");

		var rb = ResourceBundle.getBundle("training.localization.ApplicationResources", locale);
		var keys = rb.getKeys();

		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = rb.getString(key);			
			System.out.println(key + ":" + value);
		}	

	}

	public static void locales(String[] args) {	
		Arrays.stream(Locale.getAvailableLocales())
		.filter(l -> l.toString().contains("fr"))
		.forEach(System.out::println);

		System.out.println(Locale.getDefault());		
		Locale.setDefault(new Locale("fr","FR"));		
		System.out.println(Locale.getDefault());
	}
}
