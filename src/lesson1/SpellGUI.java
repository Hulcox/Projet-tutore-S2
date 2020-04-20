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
	private int x,y;
	
	
	
	public SpellGUI (){
		this.buttonsList = new ArrayList<MouseOverArea>();
		this.trades = new ArrayList<Objets>();
	}
	
	public void AddMouseOverArea(Objets objet) throws SlickException {
		Image buttonImage = new Image("texture/buttons.png");
		trades.add(objet);
		buttonsList.add(new MouseOverArea(container, buttonImage, x,y,this));
		if (y <= 400) {
			y += 40;
		}
		else {
			y = 160;
			x+= 160;
		}
		
		
		
	}
	
	
	 public void render(GameContainer container, Graphics g) {
		 
	 }
	
	@Override
	public void componentActivated(AbstractComponent source) {
		int j =0;
		for (MouseOverArea i : buttonsList) {
			if (source == i) {

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

}
