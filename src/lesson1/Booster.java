package lesson1;

public class Booster extends Spells{
	private int Modificateur;
	public Booster(int prix, String nom, boolean loot, boolean onPlayer, int Modificateur, int ManaCost) {
		super(prix, nom, loot, onPlayer, ManaCost);
		this.Modificateur = Modificateur;
		this.typeSpell = "booster";
	}
	public int getModificateur() {
		return Modificateur;
	}




}
