package training.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

public class FilesListing {

	public static void main(String[] args) throws IOException {
		Path dir = Paths.get("/tmp/super-dossier");		
		Files.walk(dir).forEach(System.out::println);
		
		System.out.println("-------------");
		
		BiPredicate<Path,BasicFileAttributes> filter = (p, attrs) -> {
			// piege String.endsWith vs Path.endsWith
			return p.toString().endsWith(".pdf");
		};
		
		int maxDepth = 10;
		Files.find(dir, maxDepth, filter).forEach(System.out::println);

	}

}
