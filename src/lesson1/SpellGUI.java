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
	private ArrayList<Objets> trades;
	private ArrayList<MouseOverArea> buttonsList;
	private GameContainer container;
	private int x = 100,y = 0;
	private boolean IsOpen = false;

	//private Image buttonImage = new Image("texture/buttons.png");
	
	
	
	//public void init
	
	public SpellGUI (){
		this.buttonsList = new ArrayList<MouseOverArea>();
		this.trades = new ArrayList<Objets>();
	}
	
	public void AddMouseOverArea(Objets objet)  {
		
		trades.add(objet);
		//buttonsList.add(new MouseOverArea(container, buttonImage, x,y,this));
		if (y <= 400) {
			y += 40;
		}
		else {
			y = 160;
			x+= 160;
		}
		
		
		
	}
	
	
	 public void render(GameContainer container, Graphics g) {
		 g.resetTransform();
		 int j = 0;
		  for (MouseOverArea i : buttonsList) {
			i.render(container, g);
			g.drawString(trades.get(j).getNom(), i.getX()+10, i.getY()+5); 		
			j++;
		  }
	 }
	
	@Override
	public void componentActivated(AbstractComponent source) {
		int j = 0;
		for (MouseOverArea i : buttonsList) {
			if (source == i){
				if (this.trades.get(j).getType() == "potions") {
					Potions potionTemp = (Potions) this.trades.get(j);
					this.inventory.getPlayer().setPv(this.inventory.getPlayer().getPv() + potionTemp.getHealingValue());
					buttonsList.remove(i);
					trades.remove(j);
				}
			}
			j++;
		}
		
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
