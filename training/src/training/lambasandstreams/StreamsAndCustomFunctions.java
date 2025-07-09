package training.lambasandstreams;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamsAndCustomFunctions {

	static class Kebab{
		@Override
		public String toString() {
			return "kebab";
		}
		
		boolean hasSauce(){
			return true;
		}
	}
	static class Boite<T>{
		T t;
		Boite(T t){
			this.t = t;
		}
		@Override
		public String toString() {		
			return "Boite avec un " + t;
		}
	}

	static int stock = 10;

	public static void main(String[] args) {		
		Supplier<Kebab> kebabier = () ->  new Kebab();		
		Predicate<Kebab> gouteur = k -> true;
		Function<Kebab, Boite<Kebab>> livreur = Boite::new;		
		Predicate<Kebab> checkStock = (k) -> stock-- > 0; 
		Consumer<Boite<Kebab>> jeanKevin = k -> System.out.println("Miam " + k);

		Stream.generate(kebabier)
		.takeWhile(checkStock)
		.filter(gouteur)
		.map(livreur)
		.filter(b -> b.t.hasSauce())
		.forEach(jeanKevin);

	}

}
