package training.jpms;

import java.util.ServiceLoader;

import com.example.kebab.IKebabService;

public class Main {
	public static void main(String[] args) {
	
		var implementations = ServiceLoader.load(IKebabService.class);
		
		var impl = implementations.findFirst();
		
		impl.get().achete();
		
		implementations.forEach((i) -> {
			i.achete();
			
			/*if(i.getClass().isAnnotationPresent(SomeAnnotation.class)) {
				// ...
			}*/
			
		});
		
	}
}
