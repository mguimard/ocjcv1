package training.exceptions;

// utiliser -ea
// enable assertions

public class Assertions {

	public static void main(String[] args) {
		try {
			run();
		} catch (AssertionError e) {
			System.out.println("Catch de l'error");
		}		

		System.out.println("Fin de programme");
	}
	
	public static void run() {		
		String s = renvoieUneStringQuiCommenceParF();		
		assert s.startsWith("f") : "Olala y'a un bug dans la matrice";
	}

	static String renvoieUneStringQuiCommenceParF() {
		return "hello";
	}

}
