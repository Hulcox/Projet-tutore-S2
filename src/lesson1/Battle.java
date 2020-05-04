package lesson1;


import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Battle {
	private boolean musicTrigger = true;
	private boolean damagetaken = false;
	private int time = 0;
	private Enemie enemie1;
	private int index;
	private Player player;
	private Image imgBackground;
	private Font font;
	private boolean isInBattle = false;
	private boolean next = false;
	private boolean EnemyAttack = true;
	public Enemie getEnemie1() {

		return enemie1;
	}
	public void setEnemie1(Enemie enemie1) {

		this.enemie1 = enemie1;
	}
	public Battle(Player player) {

		this.player = player;
	}
	public Image getImgBackground() {
		return imgBackground;
	}
	public void setImgBackground(Image imgBackground) {

		this.imgBackground = imgBackground;
	}
	public void DrawBattle(Graphics g, Player player, Map map, Camera camera, int i,EventObject singleFireEvent) throws SlickException{
		g.resetTransform();
		this.index = i;
		font = g.getFont();
		String playerPv = Integer.toString(player.getPv());
		String playerMaxPv = Integer.toString(player.getMaxPV());
		String playerMana = Integer.toString(player.getMana());
		String playerMaxMana = Integer.toString(player.getMaxMana());
		String EnemiePv = Integer.toString(player.getMap().getArrayList().get(i).getPv());
		String playerXp = Integer.toString(player.getXp());
		String playerMaxXp = Integer.toString(player.getMaxXp());
		String playerLevel = Integer.toString(player.getLevel());

		g.drawImage(player.getMap().getBattleImg(),0,0);
		if(singleFireEvent.isReady() && player.getAnimstate() >= 1) {
			if (player.getAnimstate() == 2 && EnemyAttack) {
				this.time = 2;
				this.EnemyAttack = false;
			}
			time++; 
		}
		this.TurnAnimation(g, player, i);
		font.drawString(550,30, "Pv : " + EnemiePv, Color.red);
		font.drawString(0,45, "Mana : " + playerMana + "/" + playerMaxMana, Color.blue);
		font.drawString(0,30 , "Pv : " + playerPv + "/"+playerMaxPv, Color.green);
		font.drawString(0,60, "XP : " + playerXp + "/" + playerMaxXp + " Level : " + playerLevel , Color.yellow);
	}
	public void TurnAnimation (Graphics g, Player player, int i) throws SlickException {
		g.resetTransform();
		if (time > 1) {   //ENEMY TURN
			this.damagetaken = false;
			if (player.getMap().getArrayList().get(i).getPv() <= 0) { //Battle win
				if (this.next) {
					
					this.next = false;
					this.setInBattle(false);
					player.getMap().getArrayList().get(i).setPv(player.getMap().getArrayList().get(i).getMaxHp());
					this.time = 0;
					this.player.setAnimstate(0);
					this.EnemyAttack = true;
					player.setDefending(false);
					player.setCasting(false);
					player.setDamage(player.getBaseDamage());
					player.getInventaire().AddObjet(player.getMap().getArrayList().get(i).getLoot());
					player.setXp(this.player.getMap().getArrayList().get(i).getXp());
					player.setLevel();
					this.player.setAffichageState(false);
					this.musicTrigger = true;
					
				}
				else {
					this.player.setAffichageState(true);
					g.drawAnimation(player.getBattleanim()[0], 0, 240);
					g.drawString("Victory ! " + "Loot : " + player.getMap().getArrayList().get(i).getLoot().getNom() + " Press 'e' to continue" , 100, 240);
					time = 2;
				}
			}
			else if (time > 2) {
				g.drawAnimation(player.getBattleanim()[0], 0, 240);
				g.drawAnimation(player.getMap().getArrayList().get(i).getBattleanim()[1],0+player.getMap().getArrayList().get(i).getBattleanim()[1].getWidth()/2,240); //ENEMY ON PLAYER
				if (time > 3) { //End turn
					time = 0;
					if(player.isCasting() && !player.getSpell().isOnPlayer()) {
						player.setDamage(player.getBaseDamage());
					}
					player.setAnimstate(0);
					player.setDegats(player.getMap().getArrayList().get(i).getDegats());
					this.EnemyAttack = true;
					player.setDefending(false);
					player.setCasting(false);
				}
			}
			else {
				g.drawAnimation(player.getBattleanim()[0], 0, 240);
				g.drawAnimation(player.getMap().getArrayList().get(i).getBattleanim()[0],580-player.getMap().getArrayList().get(i).getBattleanim()[0].getWidth(),360-player.getMap().getArrayList().get(i).getBattleanim()[0].getHeight());
			}
		}
		else if (time > 0) { //PLAYER TURN
			g.drawAnimation(player.getMap().getArrayList().get(i).getBattleanim()[0],580-player.getMap().getArrayList().get(i).getBattleanim()[0].getWidth(),360-player.getMap().getArrayList().get(i).getBattleanim()[0].getHeight());
			if (!player.isCasting()) {
				g.drawAnimation(player.getBattleanim()[1], 580-player.getMap().getArrayList().get(i).getBattleanim()[0].getWidth()-player.getBattleanim()[1].getWidth()/2, 360-player.getMap().getArrayList().get(i).getBattleanim()[0].getHeight());
			}//PLAYER ON ENEMY
			else {
				if (player.getSpell().isOnPlayer()) { //Casting spell on player
					g.drawAnimation(player.getBattleanim()[0], 0, 240); 
					g.drawAnimation(player.getSpell().getAnimation()[0], 0+player.getSpell().getAnimation()[0].getWidth()/2,240+player.getSpell().getAnimation()[0].getHeight()/2);
				}
				else if (!player.getSpell().isOnPlayer() && player.isCasting()){ //Casting spell on enemy
					g.drawAnimation(player.getBattleanim()[0], 0, 240);
					g.drawAnimation(player.getSpell().getAnimation()[0], 580-(player.getMap().getArrayList().get(i).getBattleanim()[0].getWidth()/2+player.getSpell().getAnimation()[0].getWidth()/2), 360-(player.getMap().getArrayList().get(i).getBattleanim()[0].getHeight()/2 + player.getSpell().getAnimation()[0].getHeight()/2));
				}
			}
			if (!damagetaken) {
				damagetaken = true;
				if (!player.isCasting()) {
					player.getMap().getArrayList().get(i).setDamage(player.getMap().getArrayList().get(i).getPv()-player.getDamage());
				}//Damage spell
				if (player.isCasting() && !player.getSpell().isOnPlayer()) {
					player.getMap().getArrayList().get(i).setDamage(player.getMap().getArrayList().get(i).getPv()-player.getDamage());
					
				}
			}
		}
		else {
			g.drawAnimation(player.getMap().getArrayList().get(i).getBattleanim()[0],580-player.getMap().getArrayList().get(i).getBattleanim()[0].getWidth(),360-player.getMap().getArrayList().get(i).getBattleanim()[0].getHeight());
			g.drawAnimation(player.getBattleanim()[0], 0, 240);
		}
		
	}
	
	
	public boolean isInBattle() {
		return isInBattle;
	}
	public void setInBattle(boolean isInBattle) {
		this.isInBattle = isInBattle;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public boolean isMusicTrigger() {
		return musicTrigger;
	}
	public void setMusicTrigger(boolean musicTrigger) {
		this.musicTrigger = musicTrigger;
	}



}
