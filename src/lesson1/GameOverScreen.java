package lesson1;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class GameOverScreen implements ComponentListener{
	private boolean GameDeath = false;
	private boolean triggerMusic = true;
	private Image image;
	private String imgpath;
	private MouseOverArea continueGame;
	private static final int Y_PADDING = 3; 
	private static final int X_PADDING = 13;
	
	public GameOverScreen(String imgpath) {
		this.imgpath = imgpath;
	}
	public void init (GameContainer container) throws SlickException {
	   	  Image buttonImage = new Image("texture/buttons.png");
		  this.image = new Image(imgpath);
		  continueGame = new MouseOverArea(container, buttonImage,320-buttonImage.getWidth()/2,420 ,this);
	}
	   public void render(GameContainer container, Graphics g) { 
		   g.resetTransform();
		   g.setColor(Color.black);
		   g.drawImage(this.image,0,0);
		   continueGame.render(container, g);
		   g.drawString("Exit", continueGame.getX() + X_PADDING, continueGame.getY() + Y_PADDING);
		   if(this.GameDeath) {
			   container.exit();
		   }
			  
	   }
	@Override
	public void componentActivated(AbstractComponent source) {
		if (source == continueGame) {
			this.GameDeath = true;
			
		}
		
	}
	public boolean isGameDeath() {
		return GameDeath;
	}
	public void setGameDeath(boolean gameDeath) {
		GameDeath = gameDeath;
	}
	public boolean isTriggerMusic() {
		return triggerMusic;
	}
	public void setTriggerMusic(boolean triggerMusic) {
		this.triggerMusic = triggerMusic;
	}


}
