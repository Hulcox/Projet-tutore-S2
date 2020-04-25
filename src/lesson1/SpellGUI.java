package lesson1;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class SpellGUI implements ComponentListener{
	private Inventaire inventory;
	private ArrayList<Objets> Items;
	private ArrayList<MouseOverArea> ItemsbuttonsList;
	private GameContainer container;
	private int x = 100,y = 0;
	private boolean IsOpen = false;
	private boolean IsComponentActivated = true;
	private AbstractComponent source;

	
	
	
	//public void init
	
	public SpellGUI (GameContainer container, Inventaire inventory){
		this.ItemsbuttonsList = new ArrayList<MouseOverArea>();
		this.Items = new ArrayList<Objets>();
		this.container = container;
		this.inventory = inventory;
	}
	
	public void AddMouseOverArea(Objets objet) throws SlickException  {
		//System.out.println("Adding : " + objet.getNom());
		Image buttonImage = new Image("texture/buttons.png");
		Items.add(objet);
		ItemsbuttonsList.add(new MouseOverArea(this.container, buttonImage, x,y,this));
		if (y <= 400) {
			y += 40;
		}
		else {
			y = 160;
			x+= 160;
		}
		
		
		
	}
	
	
	 public void render(GameContainer container, Graphics g) {
		 if (!this.IsComponentActivated){
			 g.resetTransform();
			 int j = 0;
				  for (MouseOverArea i : ItemsbuttonsList) {
					i.render(container, g);
					g.drawString(Items.get(j).getNom(), i.getX()+10, i.getY()+5);
					j++;
					
				  }
		 }
		 else {
			 this.refreshGUI();
		 }
	 }
	
	public void refreshGUI() {
		int j = 0;
		MouseOverArea toDelBtnLst = null;
		Objets toDelObjet = null;
		for (MouseOverArea i : ItemsbuttonsList) {
			if (this.source == i){
				if (this.Items.get(j).getType() == "potions") {
					Potions potionTemp = (Potions) this.Items.get(j);
					this.inventory.getPlayer().setPv(this.inventory.getPlayer().getPv() + potionTemp.getHealingValue());
					this.IsOpen = false;
					this.inventory.getPlayer().setAnimstate(1);
					toDelObjet = potionTemp;
					toDelBtnLst = i;
				}

			}
			j++;
		}
		
		this.Items.remove(toDelObjet);
		this.ItemsbuttonsList.remove(toDelBtnLst);
		this.IsComponentActivated = false;
	}
	 
	@Override	
	public void componentActivated(AbstractComponent source) {
		this.source = source;
		this.IsComponentActivated = true;
		
	}

	public Inventaire getInventory() {
		return inventory;
	}

	public void setInventory(Inventaire inventory) {
		this.inventory = inventory;
	}

	public boolean isIsOpen() {
		return IsOpen;
	}

	public void setIsOpen(boolean isOpen) {
		IsOpen = isOpen;
	}



}
