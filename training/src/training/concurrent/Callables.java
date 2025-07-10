package training.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callables {

	static class Kebab{}
	
	static class MyCallable implements Callable<Kebab>{
		@Override
		public Kebab call() throws Exception {
			Thread.sleep(1000);			
			return new Kebab();
		}		
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		Future<Kebab> peutEtreUnKebabOuPas = es.submit(new MyCallable());		
		Kebab k = peutEtreUnKebabOuPas.get();		
		System.out.println(k);	
		
		List<Future<Kebab>> futurKebabs = es.invokeAll(Arrays.asList(new MyCallable(),new MyCallable()));
		
		
	}

}
