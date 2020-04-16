package lesson1;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameAsset {
	Image battle1,hero;
	Enemie knight;
	Map map1, grotte1;
	Ep�e copperSword, ironSword, diamondSword;
	Armure copperArmor, ironArmor, diamondArmor;
	private ArrayList<Map> allMaps;
	public void loadImage() throws SlickException{
		battle1 = new Image("texture/battle_ground.png");
		hero = new Image("texture/hero.png");
	}
	
	public void loadEnemie() throws SlickException{
		knight = new Enemie(40,5,2,"knight");

	}
	
	public void loadMap() throws SlickException{
		map1 = new Map("MainMap.tmx", true,battle1, "map1");
		grotte1 = new Map("Grotte1.tmx", false,battle1, "grotte1");
		map1.addEncounrers(knight); 
		allMaps = new ArrayList<Map>();
		allMaps.add(map1); allMaps.add(grotte1);
		
	}
	
	public void loadObject() {
		//Ep�e
		copperSword = new Ep�e(100, "Copper sword", false, 10);
		ironSword = new Ep�e(300, "Iron sword", false, 20);
		diamondSword = new Ep�e(1000, "Diamond sword", false, 40);
		//Armure
		copperArmor = new Armure(150, "Copper armor", false, 10);
		ironArmor = new Armure(400, "Iron armor", false, 15);
		diamondArmor = new Armure(1500, "Diamond armor", false, 30);
		
		
	}
	public Map searchMap(String name) {
		for(Map i : allMaps) {
			if(i.getName().equals(name)) {
               	System.out.println("found!");
				return i;	
			}
		}
		return map1;
		
	}
	public ArrayList<Map> getallMaps(){
		return this.allMaps;
	}
	

}