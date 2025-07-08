package training.classdesign;

class M {
	private int num1 = 100;
	
	class N {
		private int num2 = 200;
	}
	
	public static void main(String[] args) {
		M outer = new M();
		M.N inner = outer.new N();
		System.out.println(outer.num1 + inner.num2);
	}
}

public class Enums {

	static enum State {
		STARTED(0), STOPPED(1), KILLED(2);

		private State(int i) {
			// 
		}
	}

	public static void main(String[] args) {
		
		State s1 = State.KILLED;
		State s2 = State.STARTED;

		print(s1);

		/*
		 * byte, short, char, and int primitive data types.
		 *  the String class, Character, Byte, Short, and Integer 
		 *  Enums
		 * */
		switch(s1) {
		case STARTED: System.out.println("2");
		case KILLED: System.out.println("1");
		case STOPPED: System.out.println("3");
		break;
		default: System.out.println("4");
		}

	}

	static void print(State x) {
		System.out.println(x); // ?
	}

}
