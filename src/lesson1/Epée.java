package lesson1;

public class Epée extends Objets{
	
	private int degats;
	public Epée(int prix, String nom, int degats, int ID) {
		super(prix, nom,  ID);
		this.degats = degats;
		this.type = "Epée";
	}



	public int getDegats() {
		return degats;
	}





}
