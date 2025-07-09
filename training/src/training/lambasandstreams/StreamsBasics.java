package training.lambasandstreams;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsBasics {
	
	static int count = 0;
	
	static class Pizza{
		int price =2;
	}

	public static void main(String[] args) {
		Optional<Integer> optional = Optional.ofNullable(null);
		System.out.println(optional);
		Stream<Pizza> ss = Stream.of(new Pizza(), new Pizza());
		Set<Pizza> pizzas = ss.collect(Collectors.toSet());				
		
		int sum2 = IntStream.range(0, 11)
				.reduce(0, (i, acc) -> acc + i);
		
		System.out.println(sum2);
		
		
		int value = IntStream.range(0, 20).sum();
		System.out.println(value);
		
		Stream.iterate(123, (i) -> i +1)
		.takeWhile(i -> i < 130)
		.forEach(System.out::println);		
		
		
		Predicate<Integer> estPair = i -> i % 2 == 0;		
		Stream<Integer> integers = Stream.of(1,2,3,4);		
		Stream<Integer> filteredStream = integers.filter(estPair);		
		long result = filteredStream.count();		
		System.out.println(result);		

		result = Stream.of(1,2,3,4)
				.filter(i -> i%2==0)
				.count();

		System.out.println(result);
		
		// short circuit intermediate vs terminal
		
		// intermediate
		Stream.generate(() -> 123)
			//.limit(10)
			.takeWhile((i) -> ++count<10)
			.forEach(System.out::println);;
		
		// terminale	
		Stream<Integer> s = Stream.generate(() -> 456);
		Optional<Integer> o = s.findFirst();
		System.out.println(o.orElse(789));
		System.out.println(s.count());
	}

}
