package lesson1;


import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Battle {
	private boolean turn = true;
	private boolean damagetaken = false;
	private int time = 0;
	private Enemie enemie1;
	private int index;
	private Player player;
	private Image imgBackground;
	private Font font;
	private boolean isInBattle = false;
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
		this.index = i;
		font = g.getFont();
		String playerPv = Integer.toString(player.getPv());
		String EnemiePv = Integer.toString(player.getMap().getArrayList().get(i).getPv());
		camera.setxCam(0);
		camera.setyCam(0);
		g.drawImage(player.getMap().getBattleImg(),0,0);
		if(singleFireEvent.isReady() && player.getAnimstate() == 1) {
			time++;
		}
		this.TurnAnimation(g, player, i);
		font.drawString(550,30, "Pv : " + EnemiePv, Color.red);
		font.drawString(0,30 , "Pv : " + playerPv, Color.green);	
	}
	public void TurnAnimation (Graphics g, Player player, int i) {
		
		if (time > 1) {   //ENEMY TURN
			this.damagetaken = false;
			if (player.getMap().getArrayList().get(i).getPv() <= 0) {
				this.setInBattle(false);
				player.getMap().getArrayList().get(i).setPv(player.getMap().getArrayList().get(i).getMaxHp());
				this.time = 0;
				this.player.setAnimstate(0);
			}
			if (time > 2) {
				g.drawAnimation(player.getBattleanim()[0], 0, 240);
				g.drawAnimation(player.getMap().getArrayList().get(i).getBattleanim()[1],0+player.getMap().getArrayList().get(i).getBattleanim()[1].getWidth()/2,240); //ENEMY ON PLAYER
				if (time > 3) { //Battle win
					time = 0;
					player.setAnimstate(0);
					player.setPv(player.getPv()-player.getMap().getArrayList().get(i).getDegats());
				}
			}
			else {
				g.drawAnimation(player.getMap().getArrayList().get(i).getBattleanim()[0],580-player.getMap().getArrayList().get(i).getBattleanim()[0].getWidth(),360-player.getMap().getArrayList().get(i).getBattleanim()[0].getHeight());
				g.drawAnimation(player.getBattleanim()[0], 0, 240);
			}
		}
		else if (time > 0) { //PLAYER TURN
			g.drawAnimation(player.getMap().getArrayList().get(i).getBattleanim()[0],580-player.getMap().getArrayList().get(i).getBattleanim()[0].getWidth(),360-player.getMap().getArrayList().get(i).getBattleanim()[0].getHeight());
			g.drawAnimation(player.getBattleanim()[1], 580-player.getMap().getArrayList().get(i).getBattleanim()[0].getWidth()-player.getBattleanim()[1].getWidth()/2, 360-player.getMap().getArrayList().get(i).getBattleanim()[0].getHeight());//PLAYER ON ENEMY
			if (!damagetaken) {
				damagetaken = true;
				player.getMap().getArrayList().get(i).setDamage(player.getMap().getArrayList().get(i).getPv()-player.getDamage());
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



}
