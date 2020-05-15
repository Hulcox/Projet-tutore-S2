package lesson1;

public class Armure extends Objets {

	private double armure;
	public Armure(int prix, String nom,  int armure, int ID) {
		super(prix, nom,  ID);
		this.armure = armure;
		this.type = "Armure";

	}


	public double getArmure() {
		return armure;
	}
	public void setArmure(double armure) {
		this.armure = armure;
	}



}
