package training.nio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Relativize {

	public static void main(String[] args) throws IOException {
		Path p1 = Paths.get("/a/b/c");
		Path p2 = Paths.get("/a/b/d");
		
		// relativize 
		// cd p1 vers p2
		System.out.println(p1.relativize(p2)); // ../d
		System.out.println(p2.relativize(p1)); // ../c
				
		
		// Atention  windows
		Path p3 = Paths.get("C:\\A\\B\\C");
		Path p4 = Paths.get("D:\\A\\B\\D");		
		
		System.out.println(p3.relativize(p4)); 
				
		
		Path a = Paths.get("/A/B/C/D");
		Path sub = a.subpath(1, 4);
		System.out.println(sub);
		
		
		System.out.println(Paths.get("/A/B/C/D").startsWith("/A/B/C"));
		System.out.println(Paths.get("/A/B/C/D").startsWith(Paths.get("/A/B/C")));

		System.out.println(Paths.get("/x","y","z"));
		
		
		Path b = Paths.get("/A/B/C/D");
		System.out.println(b.resolve("/C/E/F"));
		
		System.out.println(b.toRealPath());
		
		
		
	}

}
