package lesson1;

public class Ep�e extends Objets{
	
	private int degats;
	public Ep�e(int prix, String nom, int degats, int ID) {
		super(prix, nom,  ID);
		this.degats = degats;
		this.type = "Ep�e";
	}



	public int getDegats() {
		return degats;
	}





}
