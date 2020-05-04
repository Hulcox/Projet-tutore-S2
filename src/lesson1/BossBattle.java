package lesson1;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class BossBattle {
	
	private Boss boss;
	private Player player;
	private int time;
	private boolean EnemyAttack = true;
	private boolean InBattle = false;
	private boolean damagetaken = false;
	private boolean next = false;
	private int RNG;
	private boolean bossCasting = false;
	public BossBattle(Player player) {
		this.player = player;
	}
	
	public void setNext(boolean next) {
		this.next = next;
	}
	
	public void render (GameContainer container, Graphics g,EventObject singleFireEvent) throws SlickException {
		g.resetTransform();
		Font font = g.getFont();
		String playerPv = Integer.toString(player.getPv());
		String playerMaxPv = Integer.toString(player.getMaxPV());
		String playerMana = Integer.toString(player.getMana());
		String playerMaxMana = Integer.toString(player.getMaxMana());
		String BossPv = Integer.toString(this.boss.getPv());
		String playerXp = Integer.toString(player.getXp());
		String playerMaxXp = Integer.toString(player.getMaxXp());
		String playerLevel = Integer.toString(player.getLevel());
		g.drawImage(player.getMap().getBattleImg(),0,0);
		if(singleFireEvent.isReady() && player.getAnimstate() >= 1) {
			if (player.getAnimstate() == 2 && EnemyAttack) {
				this.time = 2;
				this.EnemyAttack = false;
			}
			this.RNG = (int) (Math.random()*100);
			time++; 
		}
		TurnAnimation(g);
		font.drawString(550,30, "Pv : " + BossPv, Color.red);
		font.drawString(0,45, "Mana : " + playerMana + "/" + playerMaxMana, Color.blue);
		font.drawString(0,30 , "Pv : " + playerPv + "/"+playerMaxPv, Color.green);
		font.drawString(0,60, "XP : " + playerXp + "/" + playerMaxXp + " Level : " + playerLevel , Color.yellow);
	}

	public void TurnAnimation (Graphics g) throws SlickException {
		g.resetTransform();
		if (time > 1) {  
			this.damagetaken = false;
			if (boss.getPv() <= 0) { //Battle win
				if (this.next) {
					this.next = false;
					this.setInBattle(false);
					this.time = 0;
					this.player.setAnimstate(0);
					this.EnemyAttack = true;
					player.setDefending(false);
					player.setCasting(false);
					player.setDamage(player.getBaseDamage());
					player.setXp(boss.getXp());
					player.setLevel();
					player.getInventaire().getSpellgui().AddMouseOverArea(this.boss.getSpell3());
				}
				else {
					g.drawAnimation(player.getBattleanim()[0], 0, 240);
					g.drawString("Victory ! loot : " + this.boss.getSpell3().getNom()  + " Press 'e' to continue" , 100, 240);
					time = 2;
				}
			}
			else if (time > 2) { //ENEMY TURN
				g.drawAnimation(player.getBattleanim()[0], 0, 240);
				
				if(this.RNG < 50) { //NORMAL ATTACK
					g.drawAnimation(boss.getBattleanim()[1],0+boss.getBattleanim()[1].getWidth()/2,240-boss.getBattleanim()[1].getHeight()/2); //ENEMY ON PLAYER
				}
				else { //SPELL ON PLAYER
					this.bossCasting = true;
					if(!boss.getCurrentSpell().isOnPlayer()) { //damaging spell
						g.drawAnimation(boss.getBattleanim()[0],580-boss.getBattleanim()[0].getWidth(),360-boss.getBattleanim()[0].getHeight());
						g.drawAnimation(boss.getCurrentSpell().getAnimation()[0], 0+player.getAnimations()[0].getWidth()/2,240+player.getAnimations()[0].getHeight()/2);
						
					}
					else { //Buff spell
						g.drawAnimation(boss.getBattleanim()[0],580-boss.getBattleanim()[0].getWidth(),360-boss.getBattleanim()[0].getHeight());
						g.drawAnimation(boss.getCurrentSpell().getAnimation()[0], 580-(boss.getBattleanim()[0].getWidth()/2+boss.getCurrentSpell().getAnimation()[0].getWidth()/2), 360-(boss.getBattleanim()[0].getHeight()/2 + boss.getCurrentSpell().getAnimation()[0].getHeight()/2));
					}
					
				}
				if (time > 3) { //End turn
					time = 0;
					if(player.isCasting() && !player.getSpell().isOnPlayer()) {
						player.setDamage(player.getBaseDamage());
					}
					if(this.bossCasting) {
						this.SpellDamage(boss);
						this.bossCasting = false;
					}
					player.setAnimstate(0);
					player.setDegats(boss.getDegats()); //Degats sur le joueur
					boss.setDegats(boss.getBaseDamage());
					this.EnemyAttack = true;
					player.setDefending(false);
					player.setCasting(false);
				}
			}
			else {
				g.drawAnimation(player.getBattleanim()[0], 0, 240);
				g.drawAnimation(boss.getBattleanim()[0],580-boss.getBattleanim()[0].getWidth(),360-boss.getBattleanim()[0].getHeight());
			}
		}
		else if (time > 0) { //PLAYER TURN
			g.drawAnimation(boss.getBattleanim()[0],580-boss.getBattleanim()[0].getWidth(),360-boss.getBattleanim()[0].getHeight());
			if (!player.isCasting()) {
				g.drawAnimation(player.getBattleanim()[1], 580-boss.getBattleanim()[0].getWidth()-player.getBattleanim()[1].getWidth()/2, 360-boss.getBattleanim()[0].getHeight());
			}//PLAYER ON ENEMY
			else {
				if (player.getSpell().isOnPlayer()) { //Casting spell on player
					g.drawAnimation(player.getBattleanim()[0], 0, 240); 
					g.drawAnimation(player.getSpell().getAnimation()[0], 0+player.getSpell().getAnimation()[0].getWidth()/2,240+player.getSpell().getAnimation()[0].getHeight()/2);
				}
				else if (!player.getSpell().isOnPlayer() && player.isCasting()){ //Casting spell on enemy
					g.drawAnimation(player.getBattleanim()[0], 0, 240);
					g.drawAnimation(player.getSpell().getAnimation()[0], 580-(boss.getBattleanim()[0].getWidth()/2+player.getSpell().getAnimation()[0].getWidth()/2), 360-(boss.getBattleanim()[0].getHeight()/2 + player.getSpell().getAnimation()[0].getHeight()/2));
				}
			}
			if (!damagetaken) {
				damagetaken = true;
				if (!player.isCasting()) {
					boss.setDamage(boss.getPv()-player.getDamage()); //Damaging boss
				}//Damage spell
				if (player.isCasting() && !player.getSpell().isOnPlayer()) {
					boss.setDamage(boss.getPv()-player.getDamage()); //Damaging boss
					
				}
			}
		}
		else {
			g.drawAnimation(boss.getBattleanim()[0],580-boss.getBattleanim()[0].getWidth(),360-boss.getBattleanim()[0].getHeight());
			g.drawAnimation(player.getBattleanim()[0], 0, 240);
		}
		
	}
	
	public void SpellDamage(Boss boss) {
		if(this.boss.getCurrentSpell().getTypeSpell().equals("damagespell")){
			DamageSpell damageSpellTemp = (DamageSpell) this.boss.getCurrentSpell();
			this.boss.setDegats((int) (this.boss.getDegats()+damageSpellTemp.getDegats()));

			
		}
	}
	public Boss getBoss() {
		return boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}


	public boolean isInBattle() {
		return InBattle;
	}


	public void setInBattle(boolean inBattle) {
		InBattle = inBattle;
	}

}
