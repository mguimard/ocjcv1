package training.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyExamples {
	
	static int i = 0;
	
	static AtomicInteger ai = new AtomicInteger(0);
	
	static class Homme {
		
		int tache1 = 0;
		int tache2 = 0;
		
		synchronized void doSomething() {
			
		}
		
		void essayeDeFaireLaTache1() {			
			synchronized (this) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tache1 ++;
			}			
		}

		void essayeDeFaireLaTache2() {			
			synchronized (this) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tache2 ++;
			}			
		}
	}
	
	
	public static void main(String[] args) {
		
		synchronized (ConcurrencyExamples.class) {
			// lock les accès static
		}
		
		Lock l = new ReentrantLock();
		
		new Thread(() -> {
			
			l.lock();			
			i++;
			l.unlock();
			
			System.out.println(ai.getAndIncrement());
			
		}).start();
		
		new Thread(() -> {

			l.lock();
			i++;
			l.unlock();
			
			System.out.println(ai.getAndIncrement());
		}).start();
	
		List<String> cities = new ArrayList<String>(Arrays.asList("Paris", "Brest", "Toulouse", "Biarritz"));
		/*
		for(String city: cities) {
			if(city.startsWith("B")) {
				cities.remove(city);
			}
		}*/
		/*
		Iterator<String> it = cities.iterator();
		while(it.hasNext()) {
			String city = it.next();
			if(city.startsWith("B")) {
				it.remove();
			}
		}*/
		
		CopyOnWriteArrayList<String> safeCities = new CopyOnWriteArrayList<>(cities);
		for(String city: safeCities) {
			if(city.startsWith("B")) {
				safeCities.remove(city);
			}
		}
		
		System.out.println(safeCities);		
	}

}
