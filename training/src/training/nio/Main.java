package training.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("/tmp/somefile");
		System.out.println(p);		
		
		if(!Files.exists(p)) {
			Path created = Files.createFile(p);
			System.out.println(created);
		}	
		
		Files.writeString(p, "Hello from java\nHello again\nTest");		
		
		Files.readAllLines(p)
			.stream()
			.filter(s -> s.startsWith("H"))
			.forEach(System.out::println);
		
		System.out.println("Fin de programme");		
	}

}
