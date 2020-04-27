package lesson1;

import org.newdawn.slick.Animation;

public abstract class Spells {
	private Animation animation;
	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

}
