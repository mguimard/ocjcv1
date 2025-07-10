package training.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runnables {
	
	static class MyRunnable implements Runnable{
		
		int result = 0;
		int i = 0;
		
		public MyRunnable(int i) {
			this.i = i;
		}
		
		@Override
		public void run() {
			System.out.println("T: "+Thread.currentThread().getId());
			// ....
			if(i % 2 == 0) {
				result = 2;
			} else {
				
				result = -1;
				//throw new RuntimeException("Boom");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyRunnable r1 = new MyRunnable(23);
		MyRunnable r2 = new MyRunnable(42);
		MyRunnable r3 = new MyRunnable(128);
		//r.run(); // main thread		
		//new Thread(r).start();
		
		ExecutorService es = Executors.newFixedThreadPool(3);
						
		Future<?> f1 = es.submit(r1);		
		Future<?> f2 = es.submit(r2);
		Future<?> f3 = es.submit(r3);
		
		Object o = f1.get(); f2.get(); f3.get();
		
		System.out.println(o);
		
		System.out.println(r1.result);
		System.out.println(r2.result);
		System.out.println(r3.result);
		
		System.out.println("Fin de programme");
	}

}
