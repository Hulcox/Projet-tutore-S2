package lesson1;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Chest {
	private boolean Open = false;
	private int ID;
	private Animation[] animations;
	private Objets loot;
	private int stage;

	public Chest(int ID, Objets objet) {
		this.ID = ID;
		this.loot = objet;
	}
		
	public void render(GameContainer container, Graphics g, int x , int y) { 
		if (!this.Open) {
			g.drawAnimation(this.animations[0], x, y);
		}
		else {
			g.drawAnimation(this.animations[1], x, y);
		}
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

}
