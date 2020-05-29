package lesson1;

public class Heal extends Spells{
	private int healingvalue;
	public Heal(int prix, String nom, boolean onPlayer, int healingvalue,int ManaCost, int ID) {
		super(prix, nom, onPlayer, ManaCost, ID);
		this.healingvalue = healingvalue;
		this.typeSpell = "heal";
		// TODO Auto-generated constructor stub
	}
	public int getHealingvalue() {
		return healingvalue;
	}

}
