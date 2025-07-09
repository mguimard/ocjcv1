package training.basics;

public class SwitchesAndWrappers {

	
	static enum Bla {
		A,B,C
	}
	
	public static void main(String[] args) {
		
		Boolean b = null;
		
		if(b) { // BOOOOOOM NPE b.booleanValue()
			System.out.println("B is true");
		} else {
			System.out.println("B is false");
		}
		
	
		Bla a = null;
		a.ordinal(); // boom
		
		Integer i = null;
		
		switch (i) { // BOOM NPE
		case 123: {
			//.. 
			break;
		}
		default:
			break;
		}

	}

}
