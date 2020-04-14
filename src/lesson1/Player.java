package lesson1;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;




public class Player {

	private float x = 300, y = 300;
	private int direction = 0;
	private boolean moving = false;
	private float speed = 0.1f;
	private int damage = 20;
	private Map map;
	private int pv = 70;
	private int animstate = 0;
	private Image image;
	private Animation[] animations = new Animation[8];
	private Animation[] battleanim = new Animation[2];
	public Animation[] getAnimations() {
		return animations;
	}
	public void setAnimations(Animation[] animations) {
		this.animations = animations;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}


	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Animation[] getBattleanim() {
		return battleanim;
	}
	public void setBattleanim(Animation[] battleanim) {
		this.battleanim = battleanim;
	}
	public int getAnimstate() {
		return animstate;
	}
	public void setAnimstate(int animstate) {
		this.animstate = animstate;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	
	

}
