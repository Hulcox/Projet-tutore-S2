package lesson1;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;





public class Player {
	private boolean affichageState = false;
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
	private int level;
	private int xp;
	private int MaxXp;
	
	public Player(int pv, int mana) {
		this.baseDamage = damage;
		this.setLevel();
		this.setMaxXp(0);
		this.setMaxMana(mana);
		this.setMaxPV(pv);
		this.setPv(getMaxPV());
		this.setMana(getMaxMana());
		MaxXp();
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
	public void MaxPV() {
		if(getLevel() <= 10)
			this.MaxPV += 10 ;
		if(getLevel() > 10 && getLevel() <= 20)
			this.MaxPV += 20 ;
		if(getLevel() > 20 && getLevel() <= 30)
			this.MaxPV += 25 ;
		if(getLevel() > 30 && getLevel() <= 40)
			this.MaxPV += 30 ;
		if(getLevel() > 40 && getLevel() <= 50)
			this.MaxPV += 50 ;
		if(getLevel() > 50 && getLevel() <= 60)
			this.MaxPV += 60 ;
		if(getLevel() > 60 && getLevel() <= 70)
			this.MaxPV += 65 ;
		if(getLevel() > 70 && getLevel() <= 80)
			this.MaxPV += 70;
		if(getLevel() > 80 && getLevel() <= 90)
			this.MaxPV += 75 ;
		if(getLevel() > 90 && getLevel() <= 99)
			this.MaxPV += 80 ;
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
		if(this.mana + mana < this.getMaxMana()) {
			this.mana = mana;
		}
		else {
			this.mana = this.MaxMana;
		}
	}
	public int getMaxMana() {

		return MaxMana;
	}
	public void MaxMana() {
		if(getLevel() <= 10)
			this.MaxMana += 10 ;
		if(getLevel() > 10 && getLevel() <= 20)
			this.MaxMana += 20 ;
		if(getLevel() > 20 && getLevel() <= 30)
			this.MaxMana += 30 ;
		if(getLevel() > 30 && getLevel() <= 40)
			this.MaxMana += 45 ;
		if(getLevel() > 40 && getLevel() <= 50)
			this.MaxMana += 50 ;
		if(getLevel() > 50 && getLevel() <= 60)
			this.MaxMana += 60 ;
		if(getLevel() > 60 && getLevel() <= 70)
			this.MaxMana += 70 ;
		if(getLevel() > 70 && getLevel() <= 80)
			this.MaxMana += 75;
		if(getLevel() > 80 && getLevel() <= 90)
			this.MaxMana += 80 ;
		if(getLevel() > 90 && getLevel() <= 99)
			this.MaxMana += 100 ;
	}
	public int getBaseDamage() {

		return baseDamage;
	}
	public void setBaseDamage(int baseDamage) {

		this.baseDamage = baseDamage;
	}

	public void BaseDamage(){
		if(getLevel() <= 10)
			this.baseDamage  += 2 ;
		if(getLevel() > 10 && getLevel() <= 20)
			this.baseDamage  += 5 ;
		if(getLevel() > 20 && getLevel() <= 30)
			this.baseDamage += 10 ;
		if(getLevel() > 30 && getLevel() <= 40)
			this.baseDamage  += 12 ;
		if(getLevel() > 40 && getLevel() <= 50)
			this.baseDamage  += 15 ;
		if(getLevel() > 50 && getLevel() <= 60)
			this.baseDamage  += 20 ;
		if(getLevel() > 60 && getLevel() <= 70)
			this.baseDamage  += 30 ;
		if(getLevel() > 70 && getLevel() <= 80)
			this.baseDamage  += 35;
		if(getLevel() > 80 && getLevel() <= 90)
			this.baseDamage  += 40 ;
		if(getLevel() > 90 && getLevel() <= 99)
			this.baseDamage  += 50 ;
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

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = this.xp+xp;
	}

	public int getMaxXp() {
		return MaxXp;
	}

	public void MaxXp() {
		if(getLevel() <= 10)
			this.MaxXp = (int)(Math.sqrt(Math.exp(getLevel())))+1;
		if(getLevel() > 10 && getLevel() <= 20)
			this.MaxXp = (int)((Math.sqrt(Math.exp(getLevel())))/getLevel())*7;
		if(getLevel() > 20 && getLevel() <= 30)
			this.MaxXp = (int)((Math.sqrt(Math.exp(getLevel())))/getLevel())*5;
		if(getLevel() > 30 && getLevel() < 50)
			this.MaxXp = (int)((Math.sqrt(Math.exp(getLevel())))/getLevel())*4;
		if(getLevel() >= 50 && getLevel() <= 60)
			this.MaxXp = (int) ((Math.sqrt(Math.exp(getLevel()+1)))/(getLevel()+1) * (getLevel()+1));
		if(getLevel() > 60 && getLevel() <= 70)
			this.MaxXp = (int) ((Math.sqrt(Math.exp(getLevel()+1)))/(getLevel()+1) * (getLevel()+1))/2;
		if(getLevel() > 60 && getLevel() <= 70)
			this.MaxXp = (int) ((Math.sqrt(Math.exp(getLevel()+1)))/(getLevel()+1) * (getLevel()+1))/4;
		if(getLevel() > 70 && getLevel() <= 80)
			this.MaxXp = (int) ((Math.sqrt(Math.exp(getLevel()+1)))/(getLevel()+1) * (getLevel()+1))/5;
		if(getLevel() > 80 && getLevel() <= 99)
			this.MaxXp = (int) ((Math.sqrt(Math.exp(getLevel()+1)))/(getLevel()+1) * (getLevel()+1))/6;
	}

	public int getLevel() {
		return level;
	}
	public void LevelInit(int level) {
		this.level = level;
	}
	public void setMaxXp(int MaxXp) {
		this.MaxXp = MaxXp;
	}
	public void setMaxPV(int MaxPV) {
		this.MaxPV = MaxPV;
	}
	public void setMaxMana(int MaxMana) {
		this.MaxMana = MaxMana;
	}

	public void setLevel() {
		if(getXp() >= getMaxXp()) {
			this.level = this.level + 1;
			int xptransition = getXp() - getMaxXp();
			this.xp = 0;
			this.xp =+ xptransition;
			MaxXp();
			MaxMana();
			MaxPV();
		}
	}

	public boolean isAffichageState() {
		return affichageState;
	}
	public void setAffichageState(boolean affichageState) {
		this.affichageState = affichageState;
	}
}
