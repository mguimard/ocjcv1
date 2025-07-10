package training.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barriers {

	 static class Formation implements Runnable {
		@Override
		public void run() {
			System.out.println("La formation démarre");			
		}
	 }
	
	static class Participant extends Thread {
		
		private CyclicBarrier feuille = null;
		
		public Participant(CyclicBarrier feuille) {
			this.feuille = feuille;
		}
		
		@Override
		public void run() {
			prepare();		
		}
		
		void prepare() {
			try {				
				System.out.println("Participant " + Thread.currentThread().getId() + " se prépare");
				Thread.sleep((long)(Math.random() * 3000));
				System.out.println("Participant " + Thread.currentThread().getId() + " a signé");			
			
				
				feuille.await();								
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {

		Formation f = new Formation();		 
		CyclicBarrier feuilleEmargement = new CyclicBarrier(4, f);
		
		Participant p1 = new Participant(feuilleEmargement);
		p1.start();		

		Participant p2= new Participant(feuilleEmargement);
		p2.start();		

		Participant p3 = new Participant(feuilleEmargement);
		p3.start();		

		Participant p4 = new Participant(feuilleEmargement);
		p4.start();	
		

	}

}
