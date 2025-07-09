package training.exceptions;

public class Propagation {

	public static void main(String[] args) {
		
		try {
			int i = 1 / 0;
		} finally {
			System.out.println("Oooops");
		}
		
		System.out.println("Fin de programme");
	}

}
