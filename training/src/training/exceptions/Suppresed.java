package training.exceptions;

import java.io.IOException;
import java.sql.SQLException;

public class Suppresed {

	static class MyResource implements AutoCloseable {
		@ Override
		public void close() throws IOException{
			throw new IOException("IOException");
		}
		public void execute() throws SQLException {
			throw new SQLException("SQLException");
		}
	}

	public static void main(String[] args) {		
		try(MyResource resource = new MyResource()) {
			resource.execute();
			// resource.close()
		} catch(Exception e) {
			System.out.println(e.getMessage());
			Throwable[] t = e.getSuppressed();
			// ..			
		}
	}
}
