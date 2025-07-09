package training.exceptions;

public class Hierarchie {

	static class E1 extends Exception{}
	static class E2 extends E1 {}
	static class E3 extends E1 {}

	static void f() throws E1 {
		//
	}

	public static void main(String[] args) {

		try {
			f();
		} catch(Exception e) {}

		
		try {
			f();
		} catch(E1 e) {}


		try {
			f();
		} 
		catch(E2 | E3 e) {	}
		catch(E1 e) {}
		
		/*// KO
		try {
			f();
		} 
		catch(E1 e) {}
		catch(E2 | E3 e) {}		
		*/
		
	}

}
