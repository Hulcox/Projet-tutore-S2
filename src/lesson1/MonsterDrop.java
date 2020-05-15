package lesson1;

public class MonsterDrop extends Objets {
	
	
	public MonsterDrop(int prix, String nom, int ID) {
		super(prix, nom, ID);
		this.type = "MonsterDrop";

	}
	public int getSellingPrice() {
		return this.prix;
	}



}
