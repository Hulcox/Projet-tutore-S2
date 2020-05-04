package lesson1;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;


public class Chest {
	private boolean Open = false;
	private int ID;
	private Animation[] animations;
	private Objets loot;
	private GameAsset gameasset;
	private boolean playerOverArea = false;

	public Chest(int ID, Objets objet, GameAsset gameasset) {
		this.ID = ID;
		this.loot = objet;
		this.gameasset = gameasset;
	}
		
	public void render(GameContainer container, Graphics g, int x , int y) { 
		if (!this.Open) {
			g.drawAnimation(this.animations[0], x, y);
		}
		else {
			g.drawAnimation(this.animations[2], x, y);
		}
   }
	public void renderText(GameContainer container, Graphics g) {
		Font font = g.getFont();
		//g.resetTransform();
		g.drawImage(gameasset.InfoImage,0,380);
		font.drawString( 10, 390, "Item that was in this chest : " + this.loot.getNom() ,Color.white);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public boolean isOpen() {
		return Open;
	}

	public void setOpen(boolean open) {
		Open = open;
	}

	public Animation[] getAnimations() {
		return animations;
	}

	public void setAnimations(Animation[] animations) {
		this.animations = animations;
	}

	public Objets getLoot() {
		return loot;
	}

	public void setLoot(Objets loot) {
		this.loot = loot;
	}

	public boolean isPlayerOverArea() {
		return playerOverArea;
	}

	public void setPlayerOverArea(boolean playerOverArea) {
		this.playerOverArea = playerOverArea;
	}

}
