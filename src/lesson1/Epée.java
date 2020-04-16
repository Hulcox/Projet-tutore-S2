package lesson1;

public class Epée extends Objets implements lootable {
	
	private int degats;
	public Epée(int prix, String nom,  boolean loot,int degats) {
		super(prix, nom, loot);
		this.degats = degats;
	}

	@Override
	public boolean isLootable() {
		return this.loot;
	}

	public int getDegats() {
		return degats;
	}





}
