package training.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public class Serializables {

	static class Kebab implements Serializable {
		static final long serialVersionUID = 231354456;
		String sauce = "blanche";
		int prix = 108;
		boolean bon = false;
		
		@Override
		public int hashCode() {
			return Objects.hash(bon, prix, sauce);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Kebab other = (Kebab) obj;
			return bon == other.bon && prix == other.prix && Objects.equals(sauce, other.sauce);
		}
		
		
	}
		
	public static void main(String[] args) throws IOException {
		
		File f = new File("/tmp/kebab");

		if(!f.canWrite()) {
			System.out.println("Cannot write");
			return;
		}
		
		Kebab k1 = new Kebab();
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
			oos.writeObject(k1);
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
			Object o = ois.readObject();					
			
			if(o instanceof Kebab k2) {
				//Kebab k2 = (Kebab) o;
				System.out.println(k1.equals(k2));
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Ooops error: " + e.getMessage());
		}
		
		
	}

}
