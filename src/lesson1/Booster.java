package lesson1;

public class Booster extends Spells{
	private int Modificateur;
	public Booster(int prix, String nom,  boolean onPlayer, int Modificateur, int ManaCost, int ID) {
		super(prix, nom,  onPlayer, ManaCost, ID);
		this.Modificateur = Modificateur;
		this.typeSpell = "booster";
	}
	public int getModificateur() {
		return Modificateur;
	}




}
