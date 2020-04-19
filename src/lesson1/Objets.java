package lesson1;

public abstract class Objets {
	protected int prix;
	protected String nom;
	protected boolean loot;
	protected int number = 1;
	protected String type;
	public Objets (int prix, String nom, boolean loot) {
		this.prix = prix;
		this.nom = nom;
		this.loot = loot;
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
