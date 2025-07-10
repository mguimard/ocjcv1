package training.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedAndFiles {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("/tmp/super-dossier/b/text.txt");
		
		try(BufferedWriter bw = Files.newBufferedWriter(p)){			
			bw.write("Hello");			
		}
		
		try(BufferedReader br = Files.newBufferedReader(p)){
			String s = br.readLine();
			System.out.println(s);
			s = br.readLine();
			System.out.println(s);
		}
		
		System.out.println("Fin de programme");
		
	}

}
