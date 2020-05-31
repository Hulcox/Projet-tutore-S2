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



public class Inventaire implements ComponentListener{
	private Player player;
	private Image image;
	private ArrayList<Objets> inventoryList;
	private ArrayList<KeyItem> keyItemList;
	private boolean Open;
	private ItemsGUI itemsgui;
	private SpellGUI spellgui;
	
	public void reset() {
		this.inventoryList = new ArrayList<Objets>();
		this.keyItemList = new ArrayList<KeyItem>();
	}
	
	public ArrayList<KeyItem> getKeyItemList(){
		return this.keyItemList;
	}
	
	public void addKeyItem(KeyItem keyitem) {
		this.keyItemList.add(keyitem);
	}
	
	public Inventaire(Player player, Image image)  {
		this.player = player;
		this.image = image;
		this.inventoryList = new ArrayList<Objets>();
		this.keyItemList = new ArrayList<KeyItem>();
	}
	
	public void AddObjet(Objets objet) throws SlickException {
		boolean found = false;

			if (objet.getType().equals("Epée")) {
				this.player.setPlayerSword((Epée) objet);
			}
			else if  (objet.getType().equals( "Armure")) {
				this.player.setPlayerArmor((Armure) objet);
			}
			else if (objet.getType().equals("potions") || objet.getType().equals("ether")) {
				if (this.itemsgui.getItems().size() < 10) {
					this.itemsgui.AddMouseOverArea(objet);
				}
				else {
					this.player.setMoney(this.player.getMoney()+objet.getPrix());
				}
				
			}
			else if (objet.getType().equals("spell")) {
				this.spellgui.AddMouseOverArea((Spells) objet);
			}
			else if(objet.getType().equals("key")) {
				KeyItem temp = (KeyItem) objet;
				this.keyItemList.add(temp);
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
		 int xk = 350, yk =320;
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
		 for (KeyItem k : this.keyItemList) {
			 font.drawString(xk, yk, k.getNom());
			 yk += 20;
			 if (yk >= 440) {
				 yk = 320;
				 xk += 200;		
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

	public ItemsGUI getitemsgui() {
		return itemsgui;
	}

	public void setitemsgui(ItemsGUI itemsgui) {
		this.itemsgui = itemsgui;
	}

	public SpellGUI getSpellgui() {
		return spellgui;
	}

	public void setSpellgui(SpellGUI spellgui) {
		this.spellgui = spellgui;
	}
	
}
