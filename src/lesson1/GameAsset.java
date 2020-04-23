package lesson1;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameAsset {
	Image battle1,hero, InventoryBackground, battleGrotte, InventoryShop;
	Enemie knight, gobelin;
	Map map1, grotte1, Village;
	Epée copperSword, ironSword, diamondSword, GodGun;
	Potions potion, superPotion, Hypotion;
	Armure copperArmor, ironArmor, diamondArmor;
	MonsterDrop metalscrap, gobelinMeat, gobelinSpear, Poncho;
	private ArrayList<Map> allMaps;
	public void loadImage() throws SlickException{
		battle1 = new Image("texture/battle_ground.png");
		battleGrotte = new Image("texture/battle_groundGrotte1.png");
		hero = new Image("texture/hero.png");
		InventoryBackground = new Image("texture/inventory.png");
		InventoryShop = new Image("texture/ShopInventory.png");
		
	}
	
	public void loadEnemie() throws SlickException{ //Enemy
		gobelin = new Enemie(30,5,2, "Gobelin", this.gobelinMeat);
		knight = new Enemie(40,5,2,"knight", this.metalscrap);

	}
	
	public void loadMap() throws SlickException{
		map1 = new Map("MainMap.tmx", true,battle1, "map1");
		grotte1 = new Map("Grotte1.tmx", true,battleGrotte, "grotte1");
		Village = new Map ("Village.tmx", false, battle1, "Village");
		map1.addEncounrers(knight); 
		grotte1.addEncounrers(gobelin);
		allMaps = new ArrayList<Map>();
		allMaps.add(map1); allMaps.add(grotte1); allMaps.add(Village);
		
	}
	
	public void loadObject() {
		//Epée
		copperSword = new Epée(100, "Copper sword", false, 10);
		ironSword = new Epée(300, "Iron sword", false, 20);
		diamondSword = new Epée(1000, "Diamond sword", false, 40);
		GodGun = new Epée(9999,"Gun",false,9999);
		//Armure
		copperArmor = new Armure(150, "Copper armor", false, 10);
		ironArmor = new Armure(400, "Iron armor", false, 15);
		diamondArmor = new Armure(1500, "Diamond armor", false, 30);
		//Loot de mob
		metalscrap = new MonsterDrop(50,"Metal scrap", true);
		gobelinMeat = new MonsterDrop(25, "Gobelin meat", true);
		gobelinSpear = new MonsterDrop(25,"Gobelin spear", true);
		Poncho = new MonsterDrop(25,"Poncho", true);
		//Potions
		potion = new Potions(20,"potion",false,20);
		superPotion = new Potions(40,"Super potion", false, 40);
		Hypotion = new Potions(80,"potion X", false, 80);
		
		
	}
	public Map searchMap(String name) {
		for(Map i : allMaps) {
			if(i.getName().equals(name)) {
				return i;	
			}
		}
		return map1;
		
	}
	public ArrayList<Map> getallMaps(){
		return this.allMaps;
	}
	

}
