package lesson1;

public class MonsterDrop extends Objets implements lootable {
	private int number = 1;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

}
