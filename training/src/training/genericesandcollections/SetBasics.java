package training.genericesandcollections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetBasics {

	static class Fruit{
		String s;
		Fruit(String s){
			this.s = s;
		}
		
		@Override
		public int hashCode() {
			System.out.println("hashCode");
			return s.length();
		}
		
		@Override
		public boolean equals(Object obj) {
			System.out.println("EQUALS");
			if(obj == null) return false;
			if(obj instanceof Fruit) {
				return ((Fruit) obj).s.equals(s);
			}
			return false;
		}
		
		static int superCompare(Fruit a, Fruit b) {
			return -1;
		}
	}
	
	
	public static void main(String[] args) {
		
//		Set<Fruit> fruits2 = new TreeSet<>((a,b) -> a.s.compareTo(b.s));
		Set<Fruit> fruits2 = new TreeSet<>(Fruit::superCompare);
		fruits2.add(new Fruit("pomme"));
		fruits2.add(new Fruit("pomme"));
		
		System.out.println(fruits2);	
		
		
		Set<Fruit> fruits = new HashSet<>();
		fruits.add(new Fruit("pomme"));
		fruits.add(new Fruit("pomme"));
		fruits.add(new Fruit("pomme"));
		fruits.add(null);
		fruits.add(null);

		System.out.println(new Fruit("pomme") == new Fruit("pomme"));
		System.out.println(new Fruit("pomme").equals(new Fruit("pomme")));
		
		
		System.out.println(fruits);		
		
		
		Set<Integer> ints = new HashSet<Integer>();
		ints.add(1);
		ints.add(1);
		ints.add(1);		
		System.out.println(ints);
		
		
		
	}

}
