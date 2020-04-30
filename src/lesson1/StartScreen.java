package lesson1;

import java.io.IOException;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class StartScreen implements ComponentListener{
	private boolean GameStart = false;
	private Image Menu;
    private MouseOverArea newGame;
	private MouseOverArea continueGame;
	private static final int Y_PADDING = 3; 
	private static final int X_PADDING = 13;
	private Save save;
	
   public void init(GameContainer container) throws SlickException {
	   	  Image buttonImage = new Image("texture/buttons.png");
		  Menu = new Image("texture/Menu.png");
		  newGame = new MouseOverArea(container, buttonImage,320-buttonImage.getWidth()/2,240-buttonImage.getHeight() ,this);
		  continueGame = new MouseOverArea(container, buttonImage,320-buttonImage.getWidth()/2,260 ,this);
    }
   public void render(GameContainer container, Graphics g) { 
	   g.resetTransform();
	   g.setColor(Color.black);
	   g.drawImage(this.Menu,0,0);
	   newGame.render(container, g);
	   g.drawString("New game", newGame.getX() + X_PADDING, newGame.getY() + Y_PADDING);
	   continueGame.render(container, g);
	   g.drawString("Continue", continueGame.getX() + X_PADDING, continueGame.getY() + Y_PADDING);
		  
   }
	public boolean isGameStart() {
		return GameStart;
	}
	public void setGameStart(boolean gameStart) {
		GameStart = gameStart;
	}


	@Override
	public void componentActivated(AbstractComponent source) {
		if(source == newGame) {
			this.GameStart = true;
		}
		if (source == continueGame) {
			try {
				save.LoadData();
			} catch (IOException | SlickException e) {
				e.printStackTrace();
			}
			this.GameStart  = true;
		}
		
	}
	public Save getSave() {
		return save;
	}
	public void setSave(Save save) {
		this.save = save;
	}

}
