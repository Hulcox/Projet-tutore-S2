package lesson1;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class BattleHUD implements ComponentListener {
	  private static final int SPACE = 5;
	  private static final int Y_PADDING = 3; 
	  private static final int X_PADDING = 13;
	  private MouseOverArea attackButton;
	  private MouseOverArea fleeButton;
	  private MouseOverArea defendButton;
	  private MouseOverArea Items;
	  private MouseOverArea Spells;
	  private Player player;
	  private Camera camera;
	  private Battle battle;
	  
	  public BattleHUD(Player player, Camera camera, Battle battle) {
		  this.player = player;
		  this.camera = camera;
		  this.battle = battle;
	  }
	  
	  public void init(GameContainer container) throws SlickException {
		  Image spellimg = new Image("texture/spellbutton.png");
		  Image attackimg = new Image("texture/AttackButton.png");
		  Image fleeimg = new Image("texture/fleebutton.png");
		  Image Defenceimg = new Image("texture/DefenseButton.png");
		  Image itemimg = new Image("texture/itemsButton.png");
		  Spells = new MouseOverArea(container, spellimg, 152+SPACE*2, container.getHeight() - (spellimg.getHeight() + SPACE) * 2,this);
		  Items = new MouseOverArea(container, itemimg, 152+SPACE*2, container.getHeight() - (spellimg.getHeight() + SPACE) * 1,this);
		  attackButton = new MouseOverArea(container, attackimg, SPACE, container.getHeight() - (spellimg.getHeight() + SPACE) * 3,this);
		  defendButton = new MouseOverArea(container, Defenceimg, SPACE, container.getHeight() - (spellimg.getHeight() + SPACE) * 2,this);
		  fleeButton = new MouseOverArea(container, fleeimg, SPACE, container.getHeight() - (spellimg.getHeight() + SPACE) * 1,this);
		  
	
	  }
	  
	  public void render(GameContainer container, Graphics g) { 
		  g.setColor(Color.black);
		  Spells.render(container, g);
		  //g.drawString("Spells", Spells.getX() + X_PADDING, Spells.getY() + Y_PADDING);
		  Items.render(container, g);
		  //g.drawString("Items", Items.getX() + X_PADDING, Items.getY() + Y_PADDING);
		  attackButton.render(container, g);
		  //g.drawString("Attaquer", attackButton.getX() + X_PADDING, attackButton.getY() + Y_PADDING);
		  defendButton.render(container, g);
		  //g.drawString("Defendre", defendButton.getX() + X_PADDING, defendButton.getY() + Y_PADDING);
		  fleeButton.render(container, g);
		  //g.drawString("Fuire", fleeButton.getX() + X_PADDING, fleeButton.getY() + Y_PADDING);
		  
	  }
	  public void componentActivated(AbstractComponent source) {
		 if (source == attackButton) {
		    player.setAnimstate(1);
		 }
		 else if (source == fleeButton) {
			 battle.setInBattle(false);
			 player.getMap().getArrayList().get(battle.getIndex()).setPv(player.getMap().getArrayList().get(battle.getIndex()).getMaxHp());
			 player.setAnimstate(0);
			 camera.setxCam(camera.getPrevXcam()); 
			 camera.setPrevYcam(camera.getPrevYcam());
		 }
		 else if (source ==  Items) {
			 player.getInventaire().getitemsgui().setIsOpen(!player.getInventaire().getitemsgui().isIsOpen());
		 }
		 else if (source == defendButton) {
			 player.setDefending(true);
			 player.setAnimstate(2);
		 }
		 else if (source == Spells) {
			 this.player.getInventaire().getSpellgui().setIsOpen(!this.player.getInventaire().getSpellgui().isIsOpen());
		 }
	  }



}
