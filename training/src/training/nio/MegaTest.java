package training.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MegaTest {

	public static void main(String[] args) {
		Path file = Paths.get("Book.java");
		System.out.println(file.toAbsolutePath());
	}

}
