package training.genericesandcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListsBasics {
	
	static class Pizza{}
	static class Pizzeria {		
		private List<Pizza> pizzas = new ArrayList<>();
		
		public List<Pizza> getPizzas(){
			return Collections.unmodifiableList(pizzas);
		}
	}
	

	public static void main(String[] args) {	
		
		Pizzeria p = new Pizzeria();
		//p.getPizzas().add(new Pizza());		
		
		List<Integer> entiers = new ArrayList<>();		
		entiers.add(123);
		
		Integer i = 123;
		System.out.println(entiers); // ? [123]
		entiers.remove(i);
		//entiers.remove(123); // IndexOutOfBoundsException
		
		// List.remove(Object o)
		// List.remove(int index)
		
		System.out.println(entiers);
		
		List<Integer> entiers2 = Arrays.asList(1,2,3);
		
		entiers2.add(4); // boom
		
		System.out.println(entiers2); // UnsupportedOperationException
		
	}

}
