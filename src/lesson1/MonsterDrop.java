package lesson1;

public class MonsterDrop extends Objets implements lootable {

	public MonsterDrop(int prix, String nom, boolean loot) {
		super(prix, nom, loot);

	}
	public int getSellingPrice() {
		return this.prix;
	}

	@Override
	public boolean isLootable() {
		return this.loot;
	}

}
