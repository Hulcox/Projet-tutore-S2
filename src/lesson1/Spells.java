package lesson1;

import org.newdawn.slick.Animation;

public abstract class Spells extends Objets{
	protected Animation[] animation;
	protected boolean onPlayer;
	protected String typeSpell;
	protected int ManaCost;
	public Spells(int prix, String nom, boolean loot, boolean onPlayer, int ManaCost, int ID) {
		super(prix, nom, loot, ID);
		this.type = "spell";
		this.onPlayer = onPlayer;
		this.ManaCost = ManaCost;
	}
	public Animation[] getAnimation() {
		return animation;
	}
	public int getManaCost() {
		return this.ManaCost;
	}

	public void setAnimation(Animation[] animations) {
		this.animation = animations;
	}
	public boolean isOnPlayer() {
		return onPlayer;
	}
	public String getTypeSpell() {
		return typeSpell;
	}



}
