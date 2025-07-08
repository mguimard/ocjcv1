package training.genericesandcollections;

import java.util.stream.IntStream;

public class IntStreams {

	public static void main(String[] args) {
		String s = "hello";
		IntStream is = s.chars();
		
		is.count();
	}
	
}
