package training.genericesandcollections;

class Boite<Truc>{
	
	private Truc t;

	Boite(Truc t){
		this.t = t;
	}
	
	Truc get() {
		return t;
	}
}

class Chat{}

// pas de keyword
//class BoiteV2<while>{}

public class GenericsBasics {
	
	public static void main(String[] args) {

		Boite<Integer> boiteAEntiers = new Boite<>(123);
		Integer i = boiteAEntiers.get();
		
		Boite<Chat> chats;
		
	}

}
