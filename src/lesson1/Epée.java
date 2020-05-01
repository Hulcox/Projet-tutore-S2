package lesson1;

public class Epée extends Objets implements lootable {
	
	private int degats;
	public Epée(int prix, String nom,  boolean loot,int degats, int ID) {
		super(prix, nom, loot, ID);
		this.degats = degats;
		this.type = "Epée";
	}

	@Override
	public boolean isLootable() {
		return this.loot;
	}

	public int getDegats() {
		return degats;
	}





}
