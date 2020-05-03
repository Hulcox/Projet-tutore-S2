package lesson1;

import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class GameAsset {
	Image battle1,hero, InventoryBackground, battleGrotte, InventoryShop, InfoImage;
	Enemie knight, gobelin;
	Map map1, grotte1, Village, EtagedeDonjon, Dj_RDC_sg, Dj_ET1_escalier;
	Epée copperSword, ironSword, diamondSword, GodGun;
	Potions potion, superPotion, Hypotion;
	Armure copperArmor, ironArmor, diamondArmor;
	KeyItem debug;
	Booster boosterI;
	DamageSpell fireI, fireII, fireIII, Ultima, MaelStrom, MegaStorm;
	MonsterDrop metalscrap, gobelinMeat, gobelinSpear, Poncho;
	Chest chest1;
	Quete PeauGobelin;
	Boss KingGobelin;
	Music maintheme, cave, Battle, Victory;
	private Player player;
	private ArrayList<DialogueAsset> allTexts;
	private ArrayList<Map> allMaps;
	private ArrayList<Objets> allAsset;
	private ArrayList<Chest> allChest;
	private ArrayList<Quete> allQuest;
	public void loadImage() throws SlickException{
		InfoImage = new Image("texture/DialogueBox.png");
		battle1 = new Image("texture/battle_ground.png");
		battleGrotte = new Image("texture/battle_groundGrotte1.png");
		hero = new Image("texture/hero.png");
		InventoryBackground = new Image("texture/inventory.png");
		InventoryShop = new Image("texture/ShopInventory.png");
		
	}
	
	public void loadEnemie() throws SlickException{ //Enemy
		//Random encounters
		gobelin = new Enemie(30,5,2, "Gobelin", this.gobelinMeat);
		knight = new Enemie(40,5,2,"knight", this.metalscrap);


	}
	
	public void loadMap() throws SlickException{
		map1 = new Map("MainMap.tmx", true,battle1, "map1",this.maintheme);
		grotte1 = new Map("Grotte1.tmx", true,battleGrotte, "grotte1",this.cave);
		Village = new Map ("Village.tmx", false, battle1, "Village",this.maintheme);
		EtagedeDonjon = new Map ("EtagedeDonjon.tmx", false, battle1, "EtagedeDonjon",this.cave); 
		Dj_RDC_sg = new Map ("Dj_RDC_sg.tmx", false, battle1, "Dj_RDC_sg",this.cave);
		Dj_ET1_escalier = new Map ("Dj_ET1_escalier.tmx", true, battle1, "Dj_ET1_escalier",this.cave);
		map1.addEncounrers(knight);
		grotte1.addEncounrers(gobelin);
		Dj_ET1_escalier.addEncounrers(gobelin);
		allMaps = new ArrayList<Map>();
		allMaps.add(map1); allMaps.add(grotte1); allMaps.add(Village); allMaps.add(EtagedeDonjon); allMaps.add(Dj_RDC_sg);
		allMaps.add(Dj_ET1_escalier);
		
	}
	public void loadMusic() throws SlickException {
		maintheme = new Music("sound/MainTheme.ogg");
		cave = new Music("sound/Cave.ogg");
		Battle = new Music("sound/Battle.ogg");
		Victory = new Music("sound/Victory.ogg");
	}
	
	public void loadObject() {
		allChest = new ArrayList<Chest>();
		allAsset = new ArrayList<Objets>();
		allQuest = new ArrayList<Quete>();
		//Epée
		copperSword = new Epée(100, "Copper sword", false, 10,1); allAsset.add(copperSword);
		ironSword = new Epée(300, "Iron sword", false, 20,2); allAsset.add(ironSword);
		diamondSword = new Epée(1000, "Diamond sword", false, 40,3); allAsset.add(diamondSword);
		GodGun = new Epée(9999,"Gun",false,9999,4); allAsset.add(GodGun);
		//Armure
		copperArmor = new Armure(150, "Copper armor", false, 10,5); allAsset.add(copperArmor);
		ironArmor = new Armure(400, "Iron armor", false, 15,6); allAsset.add(ironArmor);
		diamondArmor = new Armure(199, "Diamond armor", false, 30,7); allAsset.add(diamondArmor);
		//Loot de mob
		metalscrap = new MonsterDrop(50,"Metal scrap", true,8); allAsset.add(metalscrap);
		gobelinMeat = new MonsterDrop(25, "Gobelin meat", true,9); allAsset.add(gobelinMeat);
		gobelinSpear = new MonsterDrop(25,"Gobelin spear", true,10); allAsset.add(gobelinSpear);
		Poncho = new MonsterDrop(25,"Poncho", true,11); allAsset.add(Poncho);
		//Potions
		potion = new Potions(20,"potion",false,20,12); allAsset.add(potion);
		superPotion = new Potions(40,"Super potion", false, 40,13); allAsset.add(superPotion);
		Hypotion = new Potions(80,"potion X", false, 80,14); allAsset.add(Hypotion);
		//Key object
		debug = new KeyItem(1,"droit de passage",false,15); allAsset.add(debug);
		//Spells
		boosterI = new Booster(200,"booster I",false,true,2,10,16); allAsset.add(boosterI);
		fireI = new DamageSpell(200,"Fire I",false,false,20,5,17); allAsset.add(fireI);
		fireII = new DamageSpell(400,"Fire II",false,false,40,10,18); allAsset.add(fireII);
		fireIII = new DamageSpell(800,"Fire III",false,false,80,20,19); allAsset.add(fireIII);
		Ultima = new DamageSpell(800,"Ultima",false,false,160,40,20); allAsset.add(Ultima);
		MaelStrom = new DamageSpell(800,"MaelStrom",false,false,200,45,21); allAsset.add(MaelStrom);
		MegaStorm = new DamageSpell(800,"Mega storm",false,false,250,50,22); allAsset.add(MegaStorm);
		//Chest
		chest1 = new Chest(1,this.gobelinSpear,this); allChest.add(chest1);
		//Initialisation des quetes
		PeauGobelin = new Quete(this.gobelinMeat,3,this.debug,1); allQuest.add(PeauGobelin);
		//Boss
		KingGobelin = new Boss(500,15,1,"King gobelin",this.gobelinSpear,this.fireI,this.fireII,this.MegaStorm);

	}
	public void loadText(GameContainer container) throws SlickException, IOException {
		allTexts = new ArrayList<DialogueAsset>();
		allTexts.add(new DialogueAsset("soldat",false));
		allTexts.add(new DialogueAsset("King",false));
		allTexts.add(new DialogueAsset("Quete peau de gobelin",true,this.PeauGobelin,container));

		
	}
	public void loadWeapons(int ID) throws SlickException {
		for (Objets j : allAsset) {
			if(j.getID() == ID) {
				this.player.getInventaire().AddObjet(j);
			}
			
		}
	}
	public ArrayList<Integer> loadIDS(String IDString) {
		ArrayList<Integer> ID = new ArrayList<Integer>();
		String IDstr = "";
		for (int i = 0; i < IDString.length(); i++) {
			if(IDString.charAt(i) == '|') {
				ID.add(Integer.parseInt(IDstr));
				IDstr = "";
			}
			else {
				IDstr += IDString.charAt(i);
			}
		}
		return ID;
	}
	public void reset() {
		this.player.getInventaire().getSpellgui().reset();
		this.player.getInventaire().reset();
		this.player.getInventaire().getitemsgui().reset();
		for (Objets o : allAsset) {
			o.setNumber(1);
		}
	}
	
	public void loadSpells(ArrayList<Integer> ID) throws SlickException { //Changement de l'inventaire avec l'inventaire sauvegarder

		for (int i : ID) {
			for (Objets j : allAsset) {
				if(j.getID() == i) {
					this.player.getInventaire().AddObjet(j);
				}
				
			}
		}
	}
	public void loadChest(ArrayList<Integer> ID) {
		for (int i : ID) {
			for (Chest c : this.allChest) {
				if(c.getID() == i) {
					
					c.setOpen(true);
				}
			}
		}
	}
	public void loadQuest(ArrayList<Integer> ID) {
		for (int i : ID) {
			for (Quete q : this.allQuest) {
				if (q.getID() == i) {
					q.setComplete(true);
				}
			}
		}
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

	public ArrayList<DialogueAsset> getAllTexts() {
		return allTexts;
	}
	
	public DialogueAsset searchText(String personne) throws SlickException, IOException {
		for (DialogueAsset i : allTexts) {
			if (i.getPersonne().contentEquals(personne)) {
				return i;
				
			}
		}
		return new DialogueAsset("erreur",false);
	}
	public Chest SearchChest(int ID) {
		for(Chest i : this.allChest) {
			if(i.getID() == ID) {
				return i;
			}
		}
		return null;
	}
	public ArrayList<Quete> getAllQuest(){
		return this.allQuest;
	}
	public ArrayList<Objets> getAllAsset() {
		return allAsset;
	}

	public void setAllAsset(ArrayList<Objets> allAsset) {
		this.allAsset = allAsset;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Chest> getAllChest() {
		return allChest;
	}

	public void setAllChest(ArrayList<Chest> allChest) {
		this.allChest = allChest;
	}



}
