package training.genericesandcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsSuperAndExtends {
	
	static class Animal{}
	static class Dog extends Animal{}
	static class Chihuahua extends Dog {}
	
	static class BoiteDeTrucsQuiSontDesChiens<Truc extends Dog>{
		void print(Truc t) {}
	}
	
	// KO
	//static class BoiteDeTrucsQuiSontAncetreDeChiens<T super Dog>{}
	
	public static void main(String[] args) {
		
		BoiteDeTrucsQuiSontDesChiens<Chihuahua> b1 = new BoiteDeTrucsQuiSontDesChiens<>();
		BoiteDeTrucsQuiSontDesChiens<Dog> b2 = new BoiteDeTrucsQuiSontDesChiens<>();
		
		b1.print(new Chihuahua());
		//b1.print(new Dog());
		
		b2.print(new Chihuahua());
		b2.print(new Dog());
		
		List<Animal> animaux_orig = Arrays.asList(new Animal(), new Dog(), new Chihuahua());
		List<? extends Animal> animaux = new ArrayList<>();
		List<? extends Animal> animauxv2 = animaux_orig;
		
		//animaux.add(new Animal());
		//animaux.add(new Dog());
		//animaux.add(new Object());
		
		List<? super Animal> list = new ArrayList<>();
		list.add(new Animal());
		list.add(new Dog());
		//list.add(new Object());
		
	}
}
