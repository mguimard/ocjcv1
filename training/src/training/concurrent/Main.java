package training.concurrent;

public class Main {

	public static void main(String[] args) throws InterruptedException {
				
		new Thread(() -> {
			System.out.println("T: "+Thread.currentThread().getId());	
		}).start();	
		
		
		Thread t = new Thread(new Runnable() {			
			@Override
			public void run() {
				System.out.println("T: "+Thread.currentThread().getId());	
			}
		});
		
		
		t.start();
		t.join(); // block main thread, attente
		
		//t.interrupt();
		Thread.State state = t.getState();
		
		
		System.out.println("Main: "+Thread.currentThread().getId());				
		
		System.out.println("Fin de programme");
	}

}
