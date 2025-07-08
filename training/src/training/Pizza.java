package training;

// implicit
//import java.lang.*;

public class Pizza /*extends Object */{

	/*
	Pizza(){
		super();
	}
	*/	
	
	public static void main(String[] args) {
		Pizza p = new Pizza();
		System.out.println(p); // ??? toString() classname@hashcode() // ?
		
		
	}
	
	
	public String name = "";
	
	@Override
	public String toString() {
		return super.toString() + " pizza !";
	}
	
	@Override
	public int hashCode() {	
		return 255;
	}
	
	@Override
	public boolean equals(Object other) {
		
		if(other == null) {
			return false;
		}
		
		if(!(other instanceof Pizza)) {
			return false;
		}
		
		return name.equals(((Pizza)other).name);		
	}

}
