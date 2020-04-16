package lesson1;

public class Epee extends Objet{
	private int damage;
	Epee(String name, int prix) {
		super(name, prix);

	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}

}
