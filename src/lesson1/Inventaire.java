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
	}
	
	public ArrayList<Objets> getInventoryList() {
		return inventoryList;
	}
	public void setInventoryList(ArrayList<Objets> inventoryList) {
		this.inventoryList = inventoryList;
	}
	 public void render(GameContainer container, Graphics g) { 
		 Font font = g.getFont();
		 g.resetTransform();
		 this.image.draw(0,0);
		 font.drawString(140,127,"Armure : " + player.getPlayerArmor().getNom() + " Defence : "  + player.getPlayerArmor().getArmure(), Color.yellow);
		 font.drawString(140,225,"Epée: " + player.getPlayerSword().getNom() + " Attaque : "  + player.getPlayerSword().getDegats(), Color.yellow);
		 
	 }

	public boolean isOpen() {
		return Open;
	}

	public void setOpen(boolean open) {
		Open = open;
	}
	
}
