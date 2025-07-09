package training.exceptions;

public class TryWith {
	
	static class Reader implements AutoCloseable {
		static int count = 0;
		int num = 0;
		
		boolean closed = false;
		
		public Reader() {
			num = ++ count;
			System.out.println("J'ouvre des resources r" + num);
		}
		
		@Override
		public void close() throws Exception{
			if(closed) {
				throw new Exception("Déja fermé mauvais developpeur !!!");
			}
			
			closed = true;
			System.out.println("Je dois libérer les resources !!! r" + num);			
		}
		
	}
	
	static class Animal{}
	
	public static void main(String[] args) {
		
		try (Reader r1 = new Reader(); Reader r2 = new Reader()){
			System.out.println("Autre code");
			
			// r2.close() implicite
			// r1.close() implicite
			
			System.out.println("A");
			r2.close();
			r1.close();
			System.out.println("B");
			r2.close();
			
			System.out.println("C");
			r2.close();
			
			System.out.println("D");
			r1.close();
			System.out.println("E");
		} catch(Exception e) {
			// ...
			
			System.out.println("Exception ...." + e.getMessage());
		} finally {
			// ...
		}
		
		// KO
		//try(Animal a = new Animal()){}
		
	}
}

