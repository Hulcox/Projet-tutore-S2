package lesson1;

public class MonsterDrop extends Objets implements lootable {
	
	
	public MonsterDrop(int prix, String nom, boolean loot, int ID) {
		super(prix, nom, loot, ID);
		this.type = "MonsterDrop";

	}
	public int getSellingPrice() {
		return this.prix;
	}

	@Override
	public boolean isLootable() {
		return this.loot;
	}

}
