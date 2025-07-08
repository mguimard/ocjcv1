package training;

public class StaticIsFun {
	
	static {
		// executé 1 seule fois au chargement de la classe dans la JVM
		System.out.println("Hello StaticIsFun 1");
		
		//System.out.println(1 / 0); // Arithmetic exception
	}
	
	static {
		// executé 1 seule fois au chargement de la classe dans la JVM
		System.out.println("Hello StaticIsFun 2");
	}
	
	static class SkateBoard{
		static String model = "Super skate";

		static {
			// executé 1 seule fois au chargement de la classe dans la JVM
			System.out.println("Hello SkateBoard");
			
			model+= " hello";
		}
		
		int roues = 4;
		
		static int count; // 0
		static String marque; // null
		
		public SkateBoard() {
			count++;
		}
		
	}

	public static void main(String[] args) {
		SkateBoard p = null;		
		System.out.println(SkateBoard.model); // Super skate 
		System.out.println(p.model); // Super skate 
		//System.out.println(p.roues); // NPE
		
		
		SkateBoard s = new SkateBoard();
		System.out.println(SkateBoard.count); // 1
		System.out.println(SkateBoard.marque); // null
		SkateBoard s2 = new SkateBoard();
		System.out.println(SkateBoard.count); // 2
		
	}

}
