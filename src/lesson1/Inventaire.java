package lesson1;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;



public class Inventaire{
	private Player player;
	private Image image;
	private ArrayList<Objets> inventoryList;
	private Camera camera;
	private boolean Open;
	
	public Inventaire(Player player, Image image, Camera camera) {
		this.player = player;
		this.image = image;
		this.camera = camera;
		this.inventoryList = new ArrayList<Objets>();
	}
	
	public void AddObjet(Objets objet) {
		boolean found = false;
		if (objet.getType() == "Epée") {
			this.player.setPlayerSword((Epée) objet);
		}
		else if  (objet.getType() == "Armure") {
			this.player.setPlayerArmor((Armure) objet);
		}
		else {
			for(Objets i : inventoryList) {
				if(i.getNom() == objet.getNom()) {
					i.setNumber(i.getNumber() + 1);
					found = true;
				}
			}
			if (!found) {
				inventoryList.add(objet);
				
			}
		}
		
	}
	public void RemoveObject(Objets o) {
			inventoryList.remove(o);
	}
	
	public ArrayList<Objets> getInventoryList() {
		return this.inventoryList;
	}
	public void setInventoryList(ArrayList<Objets> inventoryList) {
		this.inventoryList = inventoryList;
	}
	 public void render(GameContainer container, Graphics g) { 
		 int x = 40, y = 320;
		 Font font = g.getFont();
		 g.resetTransform();
		 this.image.draw(0,0);
		 font.drawString(140,127,"Armure : " + player.getPlayerArmor().getNom() + " Defence : "  + player.getPlayerArmor().getArmure(), Color.yellow);
		 font.drawString(140,225,"Epée: " + player.getPlayerSword().getNom() + " Attaque : "  + player.getPlayerSword().getDegats(), Color.yellow);
		 for (Objets i : inventoryList) {
			 font.drawString(x, y, i.getNom() + " x"+ i.getNumber());
			 y += 20;
			 if (y >= 440) {
				 y = 320;
				 x += 200;		
			 }
		 }
		 
	 }

	public boolean isOpen() {
		return Open;
	}

	public void setOpen(boolean open) {
		Open = open;
	}
	public Player getPlayer() {
		return this.player;
	}
	
}
