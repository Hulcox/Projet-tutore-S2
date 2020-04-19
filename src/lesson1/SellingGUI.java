package lesson1;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class SellingGUI implements ComponentListener {
	private Image image;
	private ArrayList<MouseOverArea> buttonsList;
	private ArrayList<Objets> trades;
	private boolean ShopOpen = false;
	private boolean PlayerOverArea = false;
	private int x,y;
	private String InfoBox = "What do you want ?";
	private Inventaire inventory;
	
	public SellingGUI(Image image , Inventaire inventory) {
		this.image = image;
		this.buttonsList = new ArrayList<MouseOverArea>();
		this.trades = new ArrayList<Objets>();
		this.x = 0;
		this.y = 160;
		this.inventory = inventory;

	}
	public void AddTrade(Objets objet, GameContainer container) throws SlickException {
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
		  int txtx = 0;
		  int txty = 0;
		  int padding = 0;
		  g.setColor(Color.black);
		  int j = 0;
		  g.resetTransform();
		  g.drawImage(image, 0, 0);
		  for (int i = 0; i < InfoBox.length(); i++) {
			  padding ++;
			  if (padding > 17)
			  {
				  padding = 0;
				  txty += 20;
				  txtx = 0;
			  }  
			  txtx += 10;
			  g.drawString(Character.toString((this.InfoBox.charAt(i))),440+txtx,407+txty);
		  }
		  
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
			if (source == i) {
				this.setInfoBox("You bought : " + trades.get(j).getNom() + " for : " + trades.get(j).getPrix());
				this.inventory.AddObjet(trades.get(j));
			}
			j++;
		}

		
	}

	public ArrayList<MouseOverArea> getButtonsList() {
		return buttonsList;
	}

	public void setButtonsList(ArrayList<MouseOverArea> buttonsList) {
		this.buttonsList = buttonsList;
	}


	public boolean isShopOpen() {
		return ShopOpen;
	}


	public void setShopOpen(boolean shopOpen) {
		ShopOpen = shopOpen;
	}


	public boolean isPlayerOverArea() {
		return PlayerOverArea;
	}


	public void setPlayerOverArea(boolean playerOverArea) {
		PlayerOverArea = playerOverArea;
	}
	public String getInfoBox() {
		return InfoBox;
	}
	public void setInfoBox(String infoBox) {
		InfoBox = infoBox;
	}
	

}
