package lesson1;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class InGameHUD implements ComponentListener {
    private MouseOverArea Menu;
	private MouseOverArea Save;
	private MouseOverArea SoundUp;
	private MouseOverArea SoundDown;
	private Player player;
	private float sound = 1.2f;
	private boolean open = false;
	private static final int Y_PADDING = 3; 
	private static final int X_PADDING = 13;
	private Save save;
	private HUD hud_player;
	public InGameHUD(Player player) {
		this.player = player;
	}
	
	
	   public void init(GameContainer container) throws SlickException {
		   	  Image buttonImage = new Image("texture/buttons.png");
			  this.hud_player = new HUD("texture/hud/Hud_player.png", 5, -5, player);
			  this.hud_player.initPlayer();
			  Menu = new MouseOverArea(container,buttonImage, 475,0 ,this);
			  Save = new MouseOverArea(container, buttonImage,475,60 ,this);
			  SoundUp = new MouseOverArea(container, buttonImage,475,90 ,this);
			  SoundDown = new MouseOverArea(container, buttonImage,475,120 ,this);
			  save = new Save(player);
	    }
	   public void render(GameContainer container, Graphics g) { 
		   g.resetTransform();
		   g.setColor(Color.black);
		   Menu.render(container, g);
		   g.drawString("Menu", Menu.getX() + X_PADDING, Menu.getY() + Y_PADDING);
		   if (this.open) {
			   Save.render(container, g);
			   g.drawString("Save", Save.getX() + X_PADDING, Save.getY() + Y_PADDING);
			   SoundUp.render(container, g);
			   g.drawString("Sound up", SoundUp.getX() + X_PADDING, SoundUp.getY() + Y_PADDING);
			   SoundDown.render(container, g);
			   g.drawString("Sound Down", SoundDown.getX() + X_PADDING, SoundDown.getY() + Y_PADDING);
			   this.hud_player.renderPlayer(g);
			   Font font = g.getFont();
			   String playerLevel = Integer.toString(player.getLevel());
			   font.drawString(300,60," Level : " + playerLevel , Color.green);
		   }
			  
	   }
		

	@Override
	public void componentActivated(AbstractComponent source) {
		if (source == Menu) {
			this.open = !open;
		} 
		if (source == Save) {
			this.save.SaveData();
		}
		if(source == SoundUp) {
			this.sound += 0.2;
		}
		if(source == SoundDown) {
			this.sound -= 0.2;
		}
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}
	public Save getSave() {
		return this.save;
	}


	public float getSound() {
		return sound;
	}


	public void setSound(float sound) {
		this.sound = sound;
	}

}
