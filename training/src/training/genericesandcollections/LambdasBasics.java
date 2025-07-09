package training.genericesandcollections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
interface MyInterface{
	void f();
}

@FunctionalInterface
interface MyPredicate{
	boolean f(Integer i);
}

public class LambdasBasics {

	public static void main(String[] args) {

		Predicate<String> commenceParA = s -> s.startsWith("A");
		
		MyInterface i = () -> {};
		MyPredicate j = x -> x % 2 == 0;


		new MyPredicate() {
			public boolean f(Integer x) {
				return 	 x % 2 == 0;
			}
		};

		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ints.add(4);

		ints.forEach(n -> {
			// consumer code ...
		});

		Predicate<Integer> isEven = n -> n % 2 == 0;		
		ints.removeIf(isEven);		
		ints.removeIf(n -> true);


		System.out.println(ints); // 

	}

}


