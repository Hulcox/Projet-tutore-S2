package lesson1;

import org.newdawn.slick.Animation;

public abstract class Spells extends Objets{
	protected Animation animation;
	protected boolean onPlayer;
	protected String typeSpell;
	protected int ManaCost;
	public Spells(int prix, String nom, boolean loot, boolean onPlayer, int ManaCost) {
		super(prix, nom, loot);
		this.type = "spell";
		this.onPlayer = onPlayer;
		this.ManaCost = ManaCost;
	}
	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
	public boolean isOnPlayer() {
		return onPlayer;
	}
	public String getTypeSpell() {
		return typeSpell;
	}



}
