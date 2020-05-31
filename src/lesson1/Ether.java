package lesson1;

public class Ether extends Objets{
	private int healingValue;
	public Ether(int prix, String nom,  int healingValue, int ID) {
		super(prix, nom,  ID);
		this.healingValue = healingValue;
		this.type = "ether";
	}
	public int getHealingValue() {
		return healingValue;
	}
	public void setHealingValue(int healingValue) {
		this.healingValue = healingValue;
	}

}
