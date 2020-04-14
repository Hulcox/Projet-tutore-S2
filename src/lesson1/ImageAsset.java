package lesson1;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageAsset {
	Image battle1,hero;
	Enemie knight;
	Map map1, grotte1;
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
