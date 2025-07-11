package training.vars;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	static abstract class Animal {
		abstract void mange(String... aliments);
	}

	static class Chien extends Animal {
		@Override
		void mange(String... aliments) {		
			int numberOfAliments = aliments.length;
			System.out.println("Je mange " + numberOfAliments + " trucs") ;
		}
	}

	public static void f() { System.out.println("f1");}
	public static void f(String s) { System.out.println("f2");}
	public static void f(String s1, String s2) { System.out.println("f3");}
	public static void f(String... strings) { System.out.println("f4");}
	//static void f(String[] strings) { System.out.println("f4");}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		

		f();
		f("A");
		f("A","B");
		f("A","B","C");

		String[] trucs0 = {};
		String[] trucs1 = {"1"};
		String[] trucs2 = {"1", "2"};
		String[] trucs3 = {"1", "2","3"};

		f(trucs0);
		f(trucs1);
		f(trucs2);
		f(trucs3);		
		
		System.out.println("------------");

		Class c = Main.class;
		Method f2 = c.getMethod("f", String.class);
		System.out.println(f2);
		f2.invoke(null,"A");
		
		Method f4 = c.getMethod("f", String[].class);
		System.out.println(f4);
		f4.invoke(null, (Object[])trucs3);
		
		System.out.println("------------");
		
		Chien max = new Chien();
		max.mange("croquettes", "gateaux", "rats");
		max.mange();

		String[] autresAliments = {"A","B","C"};
		max.mange(autresAliments);

	}

}
