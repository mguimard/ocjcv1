package training.genericesandcollections;

import java.util.HashMap;
import java.util.Map;

public class MapsBasics {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(null, null);
		map.put(null, "hello");		
		map.put(1, "hello");

		System.out.println(map);

		String s = map.get(null);
		System.out.println(s);

		System.out.println(map.containsKey(null));
		System.out.println(map.containsValue("hello"));
		
		System.out.println(map.remove(123));
		System.out.println(map.remove(123, "coucou"));
		
		System.out.println(map.remove(null, "hello"));
		
	}

}
