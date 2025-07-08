package training.genericesandcollections;

import java.util.Map;
import java.util.TreeMap;

public class MoreMaps {

	static class Souris implements Comparable<Souris>{
		int age;
		public Souris(int age) {
			this.age = age;
		}
		@Override
		public int compareTo(Souris other) {
			if(other == null) return -1;
			return this.age - other.age;
		}
		
		@Override
		public String toString() {		
			return ""+age;
		}
	}
	
	public static void main(String[] args) {
		Map<Souris, String> sourisMap = new TreeMap<>();
		System.out.println(sourisMap);
		
		sourisMap.put(new Souris(10), "whatever");
		sourisMap.put(new Souris(5), "whatever");
		
		System.out.println(sourisMap); // ?
		
		sourisMap.forEach((k, v) -> {
			System.out.println("Key: " + k + " Value: " + v);
		});
	}

}








