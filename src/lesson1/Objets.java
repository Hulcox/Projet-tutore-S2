package lesson1;

public abstract class Objets {
	protected int prix;
	protected String nom;

	protected int number = 1;
	protected String type;
	protected int ID;
	public Objets (int prix, String nom, int ID) {
		this.prix = prix;
		this.nom = nom;
		this.ID = ID;
	}
	
	
	public int getID() {
		return this.ID;
	}
	public int getPrix() {
		return prix;
	}
	public String getNom() {
		return nom;
	}
	public int getSellingPrice() {
		return this.prix/2;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getType() {
		return this.type;
	}





}
