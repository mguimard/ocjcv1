package training.genericesandcollections;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeuesBasics {

	public static void main(String[] args) {
		
		Deque<Integer> ints = new ArrayDeque<Integer>();
		ints.add(1);
		ints.add(2);		
		System.out.println(ints);
		
		Integer i = ints.peek();
		System.out.println(i); // 		
		
		System.out.println(ints.size()); //[1,2]
		i = ints.pop();   System.out.println(i); // 	
		i = ints.poll();  System.out.println(i); // 	
		
		System.out.println(ints.size()); // 0
		
		// ??
		//ints.pop();
		//ints.pop();
		//ints.pop();
		ints.poll();
		ints.peek();		
		
		ints.offer(1);
		ints.offerFirst(2);
		System.out.println(ints); // ?
		
		ints.remove();
		System.out.println(ints); // ?
		
		ints.remove(1);
		System.out.println(ints); // ?				
		
	}

}
