package lesson1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.newdawn.slick.SlickException;

public class Save {
	private Player player;
	private GameAsset gameasset;
	public Save(Player player) {
		this.player = player;
	}
	
	
	public void SaveData() {
	    try {
	        FileWriter myWriter = new FileWriter("save/savedata.txt");
	       
	        myWriter.write(Integer.toString(this.player.getMaxPV()) + "\n"); // line 0
	        myWriter.write(Integer.toString(this.player.getMaxMana()) + "\n"); // line 1
	        myWriter.write(Integer.toString(this.player.getPv()) + "\n"); // line 2
	        myWriter.write(Integer.toString(this.player.getMana()) + "\n"); // line 3
	        myWriter.write(Integer.toString(this.player.getDamage()) + "\n"); // line 4
	        myWriter.write(Integer.toString(this.player.getBaseDamage()) + "\n"); // line 5
	        myWriter.write(Integer.toString(this.player.getMoney()) + "\n"); // line 6
	        myWriter.write(Double.toString(this.player.getX()) + "\n"); // line 7
	        myWriter.write(Double.toString(this.player.getY()) + "\n"); // line 8
	        myWriter.write(Double.toString(this.player.getCamera().getxCam()) + "\n"); // line 9
	        myWriter.write(Double.toString(this.player.getCamera().getyCam()) + "\n"); // line 10
	        myWriter.write(this.player.getMap().getName() + "\n"); //line 11
	        myWriter.write(this.player.getPlayerSword().getID() + "\n"); //line 12 player sword 
	        myWriter.write(this.player.getPlayerArmor().getID() + "\n"); //line 13 player Armor
	        for (Spells i : this.player.getInventaire().getSpellgui().getSpells()) {
	        	myWriter.write( Integer.toString(i.getID())+ "|"); //line 14  
	        }
	        myWriter.write("\n");
	        for (Objets i : this.player.getInventaire().getInventoryList()) {
	        	for (int j = 0; j < i.getNumber(); j++) {
	        		myWriter.write( Integer.toString(i.getID())+ "|"); //line 15  
	        	}
	        }
	        myWriter.write("\n");
	        for (Objets i: this.player.getInventaire().getitemsgui().getItems()) {
	        	myWriter.write( Integer.toString(i.getID())+ "|"); //line 16
	        }
	        myWriter.write("\n");
	        myWriter.write(this.player.getDirection() + "\n"); //line 17
	        myWriter.write(this.player.getLevel() + "\n"); //line 18 player level
	        myWriter.write(this.player.getXp() + "\n"); //line 19 player current xp
	        myWriter.write(this.player.getMaxXp() + "\n"); // line 20 player max xp
	        for (Objets i : this.player.getInventaire().getKeyItemList()) {
	        	myWriter.write( Integer.toString(i.getID())+ "|"); //line 21
	        }
	        myWriter.write("\n");
	        for(Chest i : this.gameasset.getAllChest()) {
	        	if(i.isOpen()) {
	        		myWriter.write( Integer.toString(i.getID())+ "|"); //line 22 open chest
	        	}
	        }
	        myWriter.write("\n");
	        for(Quete i : this.gameasset.getAllQuest()) {
	        	if(i.isComplete()) {
	        		myWriter.write( Integer.toString(i.getID())+ "|"); //line 23 Quest complete
	        	}
	        }
	        myWriter.write("\n"); //line 24 boss defeat
	        for (Boss b : this.gameasset.getAllBoss()) {
	        	if(b.isDefeated()) {
	        		myWriter.write(Integer.toString(b.getID())+"|"); 
	        	}
	        }

	        myWriter.close();
	        System.out.println("Successfully saved the game");
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}
	
	
	public void LoadData() throws IOException, SlickException {
		BufferedReader in = new BufferedReader(new FileReader("save/savedata.txt"));
		String line;
		int nbline = 0;
		while ((line = in.readLine()) != null)
		{
			switch (nbline) {
			case 0: this.gameasset.reset();this.player.setMaxPV(Integer.parseInt(line)); break;
			case 1: this.player.setMaxMana(Integer.parseInt(line)); break;
			case 2: this.player.setPv(Integer.parseInt(line)) ;break;
			case 3: this.player.setMana(Integer.parseInt(line)); break;
			case 5: this.player.setBaseDamage(Integer.parseInt(line)); this.player.setDamage(Integer.parseInt(line)); break;
			case 6: this.player.setMoney(Integer.parseInt(line)); break;
			case 7: this.player.setX(Float.parseFloat(line)); break;
			case 8: this.player.setY(Float.parseFloat(line)); break;
			case 9: this.player.getCamera().setxCam(Float.parseFloat(line)); break;
			case 10: this.player.getCamera().setyCam(Float.parseFloat(line)); break;
			case 11: this.player.setMap(this.gameasset.searchMap(line)); break;
			case 12: this.gameasset.loadWeapons(Integer.parseInt(line));break;
			case 13: this.gameasset.loadWeapons(Integer.parseInt(line)); break;
			case 14: this.gameasset.loadSpells(this.gameasset.loadIDS(line)); break;
			case 15: this.gameasset.loadSpells(this.gameasset.loadIDS(line)); break;
			case 16: this.gameasset.loadSpells(this.gameasset.loadIDS(line)); break;
			case 17: this.player.setDirection(Integer.parseInt(line)); break;
			case 18: this.player.LevelInit(Integer.parseInt(line));break;
			case 19: this.player.setXp(Integer.parseInt(line));break;
			case 20: this.player.setMaxXp(Integer.parseInt(line));break;
			case 21: this.gameasset.loadSpells(this.gameasset.loadIDS(line));break;
			case 22: this.gameasset.loadChest(this.gameasset.loadIDS(line));break;
			case 23: this.gameasset.loadQuest(this.gameasset.loadIDS(line)); break;
			case 24: this.gameasset.loadBoss(this.gameasset.loadIDS(line)); break;
			}
			nbline++;

		}
		in.close();
	}


	public GameAsset getGameasset() {
		return gameasset;
	}


	public void setGameasset(GameAsset gameasset) {
		this.gameasset = gameasset;
	}

}
