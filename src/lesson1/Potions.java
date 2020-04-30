package lesson1;

public class Potions extends Objets{
	private int healingValue;
	public Potions(int prix, String nom, boolean loot, int healingValue, int ID) {
		super(prix, nom, loot, ID);
		this.healingValue = healingValue;
		this.type = "potions";

	}
	public int getHealingValue() {
		return healingValue;
	}
	public void setHealingValue(int healingValue) {
		this.healingValue = healingValue;
	}
	

}
