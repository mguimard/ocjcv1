package training;

public class MskingConstructors {

	static class Contenant{
		
		public Contenant(int capacity) {
		}
	}
	
	static class TasseACafe extends Contenant {
		
		
		TasseACafe(String color) {
			super(102);
		}
	}	
	
	public static void main(String[] args) {
		TasseACafe t = new TasseACafe("blue");
	}

}
