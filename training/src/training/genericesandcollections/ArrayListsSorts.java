package training.genericesandcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListsSorts {
	
	static class Pizza implements Comparable<Pizza> {
		int prix;
		
		Pizza(int prix){
			this.prix = prix;
		}
		
		@Override
		public int compareTo(Pizza other) {
			return this.prix - other.prix;
		}		
		
		@Override
		public int hashCode() {		
			return prix;
		}
	}
	

	public static void main(String[] args) {
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(2);
		list2.add(1);
		list2.add(null);
		
		list2.sort(null);
		
		
		List<Pizza> pizzas  = Arrays.asList(new Pizza(6), new Pizza(5), null);
		
		pizzas.sort(null);
		System.out.println(pizzas); // ?		
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(2);
		list.add(1);
		
		list.sort(null);
		
		System.out.println(list);
		
		list.sort((a,b) -> a - b);
		System.out.println(list);
		
		list.sort((a,b) -> b - a);
		System.out.println(list);
		
		list.sort((a,b) -> a.compareTo(b));
		System.out.println(list);		
	}

}
