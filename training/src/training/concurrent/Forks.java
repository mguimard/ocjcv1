package training.concurrent;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Forks {
	
	// runnable pas de retour => RecursiveAction
	// callable retour => RecursiveTask	
	
	
	static class Kebab{}
	
	static class MegaKebabier extends RecursiveTask<List<Kebab>>{
		@Override
		
		protected List<Kebab> compute() {
			// TODO Auto-generated method stub
			return null;
		}		
	}

	static class MegaCalculator extends RecursiveAction {
		
		int[] arr;
		final static int maxPerRun = 10;
		
		int start = 0;
		int end = 0;		
		
		// PAS THREAD SAFE !!!
		static int result = 0;
		
		// THREAD SAFE
		static AtomicInteger safeResult = new AtomicInteger(0);
		
		public MegaCalculator(int[] arr, int start, int end) {
			System.out.println("New Fork : " + start + " -> " + end);
			this.arr = arr;
			this.start = start;
			this.end = end;
		}
		
		@Override
		protected void compute() {
			if(end - start <= maxPerRun) {
				int localSum = 0;
				for(int i = start; i < end; i++) {
					result += arr[i];
					localSum += arr[i];
				}
				
				safeResult.getAndAdd(localSum);
				
			} else {
				int mid = ( start + end ) / 2;
				MegaCalculator m1 = new MegaCalculator(arr, start, mid);
				MegaCalculator m2 = new MegaCalculator(arr, mid, end);
				m1.fork();
				m2.fork();
				m1.join();
				m2.join();
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[10000];
		for(int i = 0 ; i < arr.length; i++)
			arr[i] = i;
		
		MegaCalculator m = new MegaCalculator(arr, 0 , arr.length);
		
		ForkJoinPool fjp = new ForkJoinPool();
		Future<?> f = fjp.submit(m);
		
		try {
			f.get();
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error " + e.getMessage());
		}
		
		System.out.println(MegaCalculator.result);
		System.out.println(MegaCalculator.safeResult);		
		
	}

}
