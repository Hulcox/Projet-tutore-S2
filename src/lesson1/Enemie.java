package lesson1;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Enemie {
	private int pv;
	private String name;
	private int degats;
	private int maxHp;
	private int level;
	private Animation[] battleanim = new Animation[2];
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	public void setDamage(int damage) {
		if ((this.pv - damage) < 0)
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
	public int getDegats() {
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

	public Enemie (int pv, int degats, int level, String name) {
		this.setDegats(degats);
		this.setName(name);
		this.setPv(pv);
		this.maxHp = pv;
		this.setLevel(level);
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
	public void xp(){
		
	}
	

}



