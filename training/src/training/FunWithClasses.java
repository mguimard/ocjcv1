package training;

@FunctionalInterface
interface Operation{
	int add(int a, int b);
}

interface IOutil{
	/*public abstract*/ void run();
	/*public static final*/ int i = 123;
	default void runv2() {
		
	}
}

class BoiteATruc {	
	static abstract class Outil implements IOutil { 
		/*package friendly*/public abstract void run();
	}
	
	static abstract class Tournevis extends Outil {
	}
	
}

public class FunWithClasses {

	public static void main(String[] args) {
		
		BoiteATruc.Tournevis t = new BoiteATruc.Tournevis() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};		
		
		
		abstract class A {
			abstract void print();			
		}

		int i = 2;

		A a = new A() {
			@Override
			void print() {
				System.out.println("hello");				
			}
		};

		a.print();

		Operation o = new Operation() {
			@Override
			public int add(int a, int b) {				
				return a + b;
			}
		};
		
		int result = o.add(1,2);

	}

}
