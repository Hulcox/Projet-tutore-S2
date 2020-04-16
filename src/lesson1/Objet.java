package lesson1;

public abstract class Objet {
	protected String name;
	protected int prix;
	
	Objet(String name, int prix){
		this.name = name;
		this.prix = prix;
	}
	
	
	
	public int getPrix() {
		return this.prix;
	}

	public String getName() {
		return name;
	}
	
	public int sellingPrice() {
		return this.prix/2;
	}


}
