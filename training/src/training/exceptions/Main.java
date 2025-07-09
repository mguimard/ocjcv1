package training.exceptions;

public class Main {

	static class MyException extends Exception{}
	
	public static void main(String[] args) {
		
		// Nous ne devrions pas nous soucier des Error.
		
		try {
			//.. du code qui remplit la mémoire
		} catch (OutOfMemoryError e) {
			// arghhhhh
		}
		
		
		// Unchecked VS Checked		
		try {
			// pas de code....
		} catch(NullPointerException e) {
			
		}		
		/*// KO
		try {
			// pas de code....
		} catch(MyException e) {
			System.out.println("Hey tout est pété");
		}
		*/
		
		try {
			// pas de code....
		} catch(Exception e) {
			
		}
		
		try {
			// du code
		} finally {
			// ...
		}		
				
	}

}
