package lesson1;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;




public class Player {
	private int mana = 20;
	private int MaxMana;
	private float x = 300, y = 300;
	private int direction = 0;
	private boolean moving = false;
	private boolean defending = false;
	private boolean isCasting = false;
	private Spells spell;
	private int money = 0;
	private float speed = 0.1f;
	private int damage = 20;
	private int baseDamage;
	private Map map;
	private Epée playerSword;
	private Armure playerArmor;
	private int pv = 70;
	private int MaxPV;
	private int animstate = 0;
	private Image image;
	private Camera camera;
	private Inventaire inventaire;
	private Animation[] animations = new Animation[8];
	private Animation[] battleanim = new Animation[2];
	
	public Player(int MaxPv, int MaxMana) {
		this.MaxPV = MaxPv;
		this.MaxMana = MaxMana;
		this.pv = MaxPV;
		this.mana = this.MaxMana;
		this.baseDamage = damage;
	}
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
	public void setDegats(double degats) {
		if(this.isDefending()) {
			degats = degats/2;
		}
		this.pv = (int) (this.getPv()-Math.round(degats*(100/(100+playerArmor.getArmure()))));
	}
	public void setPv(int pv) {
		if(pv > this.MaxPV)
		{
			this.pv = this.MaxPV;
		}
		else {
			this.pv = pv;
		}
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
		return damage + playerSword.getDegats();
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public Epée getPlayerSword() {
		return playerSword;
	}
	public void setPlayerSword(Epée playerSword) {
		this.playerSword = playerSword;
	}
	public Armure getPlayerArmor() {
		return playerArmor;
	}
	public void setPlayerArmor(Armure playerArmor) {
		this.playerArmor = playerArmor;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Inventaire getInventaire() {
		return inventaire;
	}
	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
	public int getMaxPV() {
		return MaxPV;
	}
	public void setMaxPV(int maxPV) {
		MaxPV = maxPV;
	}
	public boolean isDefending() {
		return defending;
	}
	public void setDefending(boolean defending) {
		this.defending = defending;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getMaxMana() {
		return MaxMana;
	}
	public void setMaxMana(int MaxMana) {
		this.MaxMana  = MaxMana;
	}
	public int getBaseDamage() {
		return baseDamage;
	}
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	public boolean isCasting() {
		return isCasting;
	}
	public void setCasting(boolean isCasting) {
		this.isCasting = isCasting;
	}
	public Spells getSpell() {
		return spell;
	}
	public void setSpell(Spells spell) {
		this.spell = spell;
	}
	public Camera getCamera() {
		return camera;
	}
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	
	
	

}
