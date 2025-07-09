package training.lambasandstreams;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@FunctionalInterface
interface MyIntegerSupplier {
	Integer get();
}

@FunctionalInterface
interface MySupplier<T>{
	T get();
}

@FunctionalInterface
interface MyPredicate<T>{
	boolean test(T t);
}

@FunctionalInterface
interface TriFunction<A,B,C,R>{
	R apply(A a, B b, C c);
}



public class Functional {

	
	static class Kebab{}
	static class Pizza{}
	static class Biere{}
	
	public static void main(String[] args) {

		MyIntegerSupplier fourniUnDix = () -> 10;
		MyIntegerSupplier fourniUnDixHuit = () -> 18;
		MyIntegerSupplier fournitUnRandom = () -> (int)Math.round(1000*Math.random());

		Integer randValue = fournitUnRandom.get();
		System.out.println(randValue);

		// debut de chaine
		Supplier<Integer> fournitUnDixV2 = () -> 10;
		MySupplier<Integer> fournitUnDixV3 = () -> 10;

		// filtres
		Predicate<Integer> estPair = i -> i % 2 == 0;
		System.out.println(estPair.test(4));
		MyPredicate<Integer> estPairv2 = i -> i % 2 == 0;

		// transformation
		UnaryOperator<Integer> multipliePar2 = i -> i *2;
		Function<Integer, Integer> multipliePar3 = i -> i*3;

		// utilisation
		Consumer<Integer> doSomething = i -> System.out.println(i);

		// 	chaine
		Integer n = fournitUnDixV2.get();
		if(estPair.test(n)) {
			n = multipliePar2.apply(n);
			doSomething.accept(n);
		}
		
		Function<Integer, String> transformeEnString = i -> "" + i;
		Function<String, Integer> calculeLongeur = s -> s.length();
		
		TriFunction<Pizza,Kebab,Biere,Boolean> testRestau = (p,k,b) -> true; 
		
		Boolean content = testRestau.apply(new Pizza(), new Kebab(), new Biere());
		
		Function<Integer,Integer> transformeEtcalcule  = transformeEnString.andThen(calculeLongeur);
		
		Integer longueur = transformeEtcalcule.apply(123);
		System.out.println(longueur);
		
		// Supplier => get
		// Predicate => test
		// Function => apply + possibilité de combiner
		// Consumer => accept
		
		Supplier<Double> rand = () -> {
			return Math.random();
		};
		
		Supplier<Double> randv2 = Math::random;
		
		
	}

}
