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
	private boolean ShopOpen = false;
	private boolean PlayerOverArea = false;
	
	public SellingGUI(Image image) {
		this.image = image;
		this.buttonsList = new ArrayList<MouseOverArea>();
	}
	
	
	  public void render(GameContainer container, Graphics g) { 
		  g.resetTransform();
		  g.drawImage(image, 0, 0);
		  
	  }


	@Override
	public void componentActivated(AbstractComponent arg0) {

		
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
	

}
