package training.concurrent;

import java.util.stream.IntStream;

public class Streams {
	public static void main(String[] args) {
		
		IntStream.range(0, 10).parallel().forEach(System.out::println);		
	}
}
