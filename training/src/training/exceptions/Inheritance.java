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
	
	static class Animal{
		void cri() throws Exception{};
	}

	static class Chien extends Animal {
		void cri() {};
	}
	
	public static void main(String[] args) {
		
		Chien c = new Chien();
		c.cri();
		
		try {
			((Animal) c).cri();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Animal a = new Chien();
		
		//a.cri();		
		
		
		Printer p = new ConsolePrinter();
		
		try {
			p.print();
		} catch (E2 e) {
			e.printStackTrace();
		}
	}

}

