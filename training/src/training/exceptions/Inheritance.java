package training.exceptions;

public class Inheritance {

	static class E1 extends Exception{}
	static class E2 extends E1{}
	
	static class Printer{
		void print() throws E2 {}
	}
	
	static class ConsolePrinter extends Printer{
		void print()  throws E2 // baisse ou meme niveau
		{}
	}
	
	public static void main(String[] args) {
		Printer p = new ConsolePrinter();
		
		try {
			p.print();
		} catch (E2 e) {
			e.printStackTrace();
		}
	}

}

