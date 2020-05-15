package lesson1;

public class DamageSpell extends Spells{
	private int degats;
	public DamageSpell(int prix, String nom,  boolean onPlayer, int degats, int ManaCost, int ID) {
		super(prix, nom, onPlayer, ManaCost, ID);
		this.degats = degats;
		this.typeSpell = "damagespell";
	}
	public int getDegats() {
		return degats;
	}
	public void setDegats(int degats) {
		this.degats = degats;
	}



}
