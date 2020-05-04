package lesson1;

import org.newdawn.slick.Animation;


public class Enemie {
	protected int pv;
	protected String name;
	protected double degats;
	protected int maxHp;
	protected int level;
	protected int xp;
	protected MonsterDrop loot;
	protected Animation[] battleanim = new Animation[2];

	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		if (pv < 0) {
			this.pv = 0;
		}
		else {
			this.pv = pv;
		}
		
	}
	public void setDamage(int damage) {
		if (damage < 0)
			this.pv = 0;
		else
			this.pv = damage;
		
	}
	public String getName() {

		return name;
	}
	public void setName(String name) {

		this.name = name;
	}
	public double getDegats() {

		return degats;
	}
	public void setDegats(int degats) {

		this.degats = degats;
	}
	public int getLevel() {

		return level;
	}
	public void setLevel(int level) {
		this.level = level;
		this.pv = this.pv + ((level * this.pv)/4);
		this.degats = this.degats + this.level;
		this.maxHp = this.pv;
	}

	public Enemie (int pv, int degats, int level, String name, MonsterDrop loot) {
		this.setDegats(degats);
		this.setName(name);
		this.setPv(pv);
		this.maxHp = pv;
		this.setLevel(level);
		this.loot = loot;
		this.setXp(getLevel());
	}
	public int getMaxHp() {

		return maxHp;
	}
	public Animation[] getBattleanim() {

		return battleanim;
	}
	public void setBattleanim(Animation[] battleanim) {
		this.battleanim = battleanim;
		System.out.print("hello world");
	}

	public MonsterDrop getLoot() {

		return loot;
	}
	public void setLoot(MonsterDrop loot) {

		this.loot = loot;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int level) {
		if(level <= 2)
			this.xp = (level*1/2);
	}

}



