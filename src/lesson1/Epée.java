package lesson1;

public class Ep�e extends Objets implements lootable {
	
	private int degats;
	public Ep�e(int prix, String nom,  boolean loot,int degats, int ID) {
		super(prix, nom, loot, ID);
		this.degats = degats;
		this.type = "Ep�e";
	}

	@Override
	public boolean isLootable() {
		return this.loot;
	}

	public int getDegats() {
		return degats;
	}





}
