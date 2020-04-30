package lesson1;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class InGameHUD implements ComponentListener {
    private MouseOverArea Menu;
	private MouseOverArea Save;
	private boolean open = false;
	private static final int Y_PADDING = 3; 
	private static final int X_PADDING = 13;
	public InGameHUD() {
		// TODO Auto-generated constructor stub
	}
	
	
	   public void init(GameContainer container) throws SlickException {
		   	  Image buttonImage = new Image("texture/buttons.png");
			  Menu = new MouseOverArea(container,buttonImage, 475,0 ,this);
			  Save = new MouseOverArea(container, buttonImage,475,60 ,this);
	    }
	   public void render(GameContainer container, Graphics g) { 
		   g.resetTransform();
		   g.setColor(Color.black);
		   Menu.render(container, g);
		   g.drawString("Menu", Menu.getX() + X_PADDING, Menu.getY() + Y_PADDING);
		   if (this.open) {
			   Save.render(container, g);
			   g.drawString("Save", Save.getX() + X_PADDING, Save.getY() + Y_PADDING);
		   }
			  
	   }
		

	@Override
	public void componentActivated(AbstractComponent source) {
		if (source == Menu) {
			this.open = !open;
		} 
		
	}

}
