package training.vars;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

public class VarType {
	
	/*
	enum var {A,B,C}
	interface var{}
	class var{}
	*/
	
	public static String var() {
		return "var";
	}
	
	public static void main(String[] args) {		
		int i = 12;
		CopyOnWriteArrayList<String> myCopyOnWriteArrayList = new CopyOnWriteArrayList<>();
		var mySafeList = new CopyOnWriteArrayList<String>();
		
		var j = 12; // 32 bits
		byte b = 12; // 8 bits

		var var = var();
		
		//var int = 1;		
		var String = 123;
		
		
		var x = 123;
		//x = "test";

		var t = (Object)null;
		
		t = "test";
		System.out.println(t);
		t = Integer.valueOf(123);
		System.out.println(t);
		
		
		Predicate<String> checkSiCaContientE = (s) -> s.contains("E");
		
		// KO
		//var testPred = (s) -> s.contains("E");
		
	}
	
	

}
