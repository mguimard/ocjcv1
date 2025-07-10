package training.io;

import java.io.File;
import java.io.FilenameFilter;

public class FilesAPI {

	public static void main(String[] args) {
		
		System.out.println(File.separator);
		
		File dir = new File("/tmp");
		
		System.out.println(dir.isFile());
		System.out.println(dir.isDirectory());
		
		File[] files = dir.listFiles(new FilenameFilter() {			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");				
			}
		});
		
		for(File f : files) {
			System.out.println(f.getAbsolutePath());
		}
				

	}

}
