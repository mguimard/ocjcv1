package training.lambasandstreams;

import java.util.stream.IntStream;

public class ParallelStreams {
	
	public static void main(String[] args) {
		
		IntStream.rangeClosed(0, 10).parallel().forEach(System.out::println);
		
	}
}
