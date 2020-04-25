package lesson1;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;



public class Inventaire implements ComponentListener{
	private Player player;
	private Image image;
	private ArrayList<Objets> inventoryList;
	private Camera camera;
	private boolean Open;
	private SpellGUI spellgui;
	
	public Inventaire(Player player, Image image, Camera camera)  {
		this.player = player;
		this.image = image;
		this.camera = camera;
		this.inventoryList = new ArrayList<Objets>();
	}
	
	public void AddObjet(Objets objet) throws SlickException {
		boolean found = false;

			if (objet.getType() == "Epée") {
				this.player.setPlayerSword((Epée) objet);
			}
			else if  (objet.getType() == "Armure") {
				this.player.setPlayerArmor((Armure) objet);
			}
			else if (objet.getType() == "potions") {
				//System.out.println("adding items...");
				this.spellgui.AddMouseOverArea(objet);
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

	@Override
	public void componentActivated(AbstractComponent arg0) {
		// TODO Auto-generated method stub
		
	}

	public SpellGUI getSpellgui() {
		return spellgui;
	}

	public void setSpellgui(SpellGUI spellgui) {
		this.spellgui = spellgui;
	}
	
}
