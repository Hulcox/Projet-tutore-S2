package lesson1;

import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class GameAsset {
	Image battle1,hero, InventoryBackground, battleGrotte, InventoryShop, InfoImage,OrbeBoss1, Henniktamer, battle_groundBoss2;
	Enemie knight, gobelin, Hypou, Antonio;
	Map map1, grotte1, Vailor, Dj1_RDC_sp, Dj1_RDC_sg, Dj1_RDC_sg2, Dj1_ET1_esc, Dj1_RDC_sb, Dj2_RDC_sp, Dj2_RDC_s2, 
	Dj2_RDC_tphd, Dj2_RDC_tphg, Dj2_RDC_tpbd, Dj2_RDC_tpbg, Dj2_RDC_sb;
	Epée copperSword, ironSword, diamondSword, GodGun;
	Potions potion, superPotion, Hypotion;
	Armure copperArmor, ironArmor, diamondArmor;
	KeyItem debug, demonMask, key;
	Booster boosterI;
	DamageSpell fireI, fireII, fireIII, Ultima, MaelStrom, MegaStorm, WaterSpike;
	MonsterDrop metalscrap, gobelinMeat, gobelinSpear, Poncho, Hypoueye;
	Chest chest1,chest2,chest3;
	Quete PeauGobelin, masquedemo;
	Boss KingGobelin, Cagnazzo;
	Music maintheme, cave, Battle, Victory, MenuMusic, Town, BossA;
	Inventaire inventory;
	DialogueAsset bossAtxt,Cagnazzotxt;
	SellingGUI sellGUI1, sellGUI2;
	private Player player;
	private ArrayList<DialogueAsset> allTexts;
	private ArrayList<Map> allMaps;
	private ArrayList<Objets> allAsset;
	private ArrayList<Chest> allChest;
	private ArrayList<Quete> allQuest;
	private ArrayList<Boss> allBoss;
	private ArrayList<SellingGUI> allSells;
	public void loadImage() throws SlickException{
		InfoImage = new Image("texture/DialogueBox.png");
		battle1 = new Image("texture/battle_ground.png");
		battleGrotte = new Image("texture/battle_groundGrotte1.png");
		Henniktamer = new Image("texture/Henniktamer.png");
		battle_groundBoss2 = new Image("texture/battle_groundBoss2.png");
		hero = new Image("texture/hero.png");
		InventoryBackground = new Image("texture/inventory.png");
		InventoryShop = new Image("texture/ShopInventory.png");
		OrbeBoss1 = new Image("texture/boss1.png");
		
	}
	
	public void loadEnemie() throws SlickException{ //Enemy
		//Random encounters
		gobelin = new Enemie(30,5,2, "Gobelin", this.gobelinMeat);
		knight = new Enemie(40,5,2,"knight", this.metalscrap);
		Hypou = new Enemie(40,5,2,"Hypou", this.Hypoueye);
		Antonio = new Enemie(80,5,3,"Antonio", this.Hypoueye);

	}
	public void initinventory(Player player) {
		this.inventory = new Inventaire(player, this.InventoryBackground);
	}
	
	public void loadMap() throws SlickException{
		map1 = new Map("MainMap.tmx", true,battle1, "map1",this.maintheme);
		Vailor = new Map ("Vailor.tmx", false, battle1, "Vailor",this.Town);
		grotte1 = new Map("Grotte1.tmx", true,battleGrotte, "grotte1",this.cave);
		Dj1_RDC_sp = new Map ("Dj1_RDC_sp.tmx", true, battleGrotte, "Dj1_RDC_sp",this.cave); 
		Dj1_RDC_sg = new Map ("Dj1_RDC_sg.tmx", true, battleGrotte, "Dj1_RDC_sg",this.cave);
		Dj1_ET1_esc = new Map ("Dj1_ET1_esc.tmx", true, battleGrotte, "Dj1_ET1_esc",this.cave);
		Dj1_RDC_sg2 = new Map ("Dj1_RDC_sg2.tmx", true, battleGrotte, "Dj1_RDC_sg2",this.cave);
		Dj1_RDC_sb = new Map ("Dj1_RDC_sb.tmx", false, battleGrotte, "Dj1_RDC_sb",this.cave);
		Dj2_RDC_sp = new Map ("Dj2_RDC_sp.tmx", true, battle_groundBoss2, "Dj2_RDC_sp",this.cave);
		Dj2_RDC_s2 = new Map ("Dj2_RDC_s2.tmx", true, Henniktamer, "Dj2_RDC_s2",this.cave);
		Dj2_RDC_tphg = new Map ("Dj2_RDC_tphg.tmx", false, Henniktamer, "Dj2_RDC_tphg",this.cave);
		Dj2_RDC_tphd = new Map ("Dj2_RDC_tphd.tmx", false, Henniktamer, "Dj2_RDC_tphd",this.cave);
		Dj2_RDC_tpbg = new Map ("Dj2_RDC_tpbg.tmx", false, Henniktamer, "Dj2_RDC_tpbg",this.cave);
		Dj2_RDC_tpbd = new Map ("Dj2_RDC_tpbd.tmx", false, Henniktamer, "Dj2_RDC_tpbd",this.cave);
		Dj2_RDC_sb = new Map ("Dj2_RDC_sb.tmx", false, Henniktamer, "Dj2_RDC_sb",this.cave);
		
		map1.addEncounrers(knight); map1.addEncounrers(Antonio);
		grotte1.addEncounrers(gobelin);
		Dj1_ET1_esc.addEncounrers(gobelin);
		Dj1_RDC_sp.addEncounrers(gobelin);
		Dj1_RDC_sg.addEncounrers(gobelin);
		Dj1_RDC_sg2.addEncounrers(gobelin);
		Dj1_RDC_sb.addEncounrers(gobelin);
		Dj2_RDC_sp.addEncounrers(gobelin);
		Dj2_RDC_s2.addEncounrers(gobelin);
		allMaps = new ArrayList<Map>();
		allMaps.add(map1); allMaps.add(grotte1); allMaps.add(Vailor); allMaps.add(Dj1_RDC_sp); allMaps.add(Dj1_RDC_sg);
		allMaps.add(Dj1_ET1_esc); allMaps.add(Dj1_RDC_sg2); allMaps.add(Dj1_RDC_sb); allMaps.add(Dj2_RDC_sp); 
		allMaps.add(Dj2_RDC_s2); allMaps.add(Dj2_RDC_tphg); allMaps.add(Dj2_RDC_tphd); allMaps.add(Dj2_RDC_tpbg); allMaps.add(Dj2_RDC_tpbd); 
		allMaps.add(Dj2_RDC_sb);
		
	}
	public void loadMusic() throws SlickException {
		maintheme = new Music("sound/MainTheme.ogg");
		cave = new Music("sound/Cave.ogg");
		Battle = new Music("sound/Battle.ogg");
		Victory = new Music("sound/Victory.ogg");
		MenuMusic = new Music("sound/MenuMusic.ogg");
		Town = new Music("sound/Town.ogg");
		BossA = new Music("sound/Bossa.ogg");
	}
	
	public void loadObject() {
		allChest = new ArrayList<Chest>();
		allAsset = new ArrayList<Objets>();
		allQuest = new ArrayList<Quete>();
		allBoss = new ArrayList<Boss>();
		//Epée
		copperSword = new Epée(100, "Copper sword", 10,1); allAsset.add(copperSword);
		ironSword = new Epée(300, "Iron sword",  20,2); allAsset.add(ironSword);
		diamondSword = new Epée(1000, "Diamond sword",  40,3); allAsset.add(diamondSword);
		GodGun = new Epée(9999,"Gun",9999,4); allAsset.add(GodGun);
		//Armure
		copperArmor = new Armure(150, "Copper armor", 10,5); allAsset.add(copperArmor);
		ironArmor = new Armure(400, "Iron armor", 15,6); allAsset.add(ironArmor);
		diamondArmor = new Armure(199, "Diamond armor",30,7); allAsset.add(diamondArmor);
		//Loot de mob
		metalscrap = new MonsterDrop(50,"Metal scrap", 8); allAsset.add(metalscrap);
		gobelinMeat = new MonsterDrop(25, "Gobelin meat", 9); allAsset.add(gobelinMeat);
		gobelinSpear = new MonsterDrop(25,"Gobelin spear", 10); allAsset.add(gobelinSpear);
		Poncho = new MonsterDrop(25,"Poncho", 11); allAsset.add(Poncho);
		Hypoueye = new MonsterDrop(25,"Hypoueye", 26); allAsset.add(Hypoueye);
		//Potions
		potion = new Potions(20,"potion",20,12); allAsset.add(potion);
		superPotion = new Potions(40,"Super potion",  40,13); allAsset.add(superPotion);
		Hypotion = new Potions(80,"potion X",  80,14); allAsset.add(Hypotion);
		//Key object
		debug = new KeyItem(1,"droit de passage",15); allAsset.add(debug);
		demonMask = new KeyItem(1,"Masque demoniaque",23); allAsset.add(demonMask);
		key = new KeyItem(1,"cle du boss",24); allAsset.add(key);
		//Spells
		boosterI = new Booster(200,"booster I",true,2,10,16); allAsset.add(boosterI);
		fireI = new DamageSpell(200,"Fire I",false,20,5,17); allAsset.add(fireI);
		fireII = new DamageSpell(400,"Fire II",false,40,10,18); allAsset.add(fireII);
		fireIII = new DamageSpell(800,"Fire III",false,80,20,19); allAsset.add(fireIII);
		Ultima = new DamageSpell(800,"Ultima",false,160,40,20); allAsset.add(Ultima);
		MaelStrom = new DamageSpell(800,"MaelStrom",false,200,45,21); allAsset.add(MaelStrom);
		MegaStorm = new DamageSpell(800,"Mega storm",false,250,50,22); allAsset.add(MegaStorm); 
		WaterSpike = new DamageSpell(400,"Water spike",false,85,20,25); allAsset.add(WaterSpike); //LAST ID:26
		//////////////ID INDEPENDANTE/////////////////////////////////////////////////////////////////
		
		//Chest ID,ITEM
		chest1 = new Chest(1,this.gobelinSpear,this); allChest.add(chest1);
		chest2 = new Chest(2,this.potion,this); allChest.add(chest2);
		chest3 = new Chest(3,this.demonMask,this); allChest.add(chest3);
		//Initialisation des quetes OBJET ATTENDU, QUANTITE, RECOMPENSE, ID
		PeauGobelin = new Quete(this.gobelinMeat,3,this.debug,1); allQuest.add(PeauGobelin);
		masquedemo = new Quete(this.demonMask,3,this.key,2); allQuest.add(masquedemo);
		//Boss PV, DEGATS, NIVEAU, NOM, SORT1, SORT2, SORT3, ID
		KingGobelin = new Boss(500,15,1,"King gobelin",this.gobelinSpear,this.fireI,this.fireII,this.MegaStorm,this.BossA,1);
		this.KingGobelin.setImage(this.OrbeBoss1); allBoss.add(KingGobelin);
		Cagnazzo = new Boss(1000,30,1,"Cagnazzo",this.gobelinSpear,this.WaterSpike,this.WaterSpike,this.MaelStrom,this.BossA,2);
		this.Cagnazzo.setImage(this.OrbeBoss1); allBoss.add(this.Cagnazzo);
		

	}
	public void loadText(GameContainer container) throws SlickException, IOException {
		allSells = new ArrayList<SellingGUI>();
		bossAtxt = new DialogueAsset("Bossa", false);
		this.KingGobelin.setDialogue(bossAtxt);
		Cagnazzotxt = new DialogueAsset("Cagnazzo", false);
		this.Cagnazzo.setDialogue(Cagnazzotxt);
		allTexts = new ArrayList<DialogueAsset>();
		allTexts.add(new DialogueAsset("soldat",false));
		allTexts.add(new DialogueAsset("King",false));
		
		allTexts.add(new DialogueAsset("Rica",true,this.PeauGobelin,container));
		allTexts.add(new DialogueAsset("Konor",true,this.masquedemo,container));
		//Selling GUI init
		sellGUI1 = new SellingGUI(InventoryShop,inventory,1); allSells.add(sellGUI1); //sellGUI1
		sellGUI1.AddTrade(copperArmor, container);
    	sellGUI1.AddTrade(diamondArmor, container);
    	sellGUI1.AddTrade(potion, container);
    	sellGUI1.AddTrade(superPotion, container);
    	sellGUI1.AddTrade(Hypotion, container);
    	sellGUI2 = new SellingGUI(InventoryShop,inventory,2); allSells.add(sellGUI2); //sellGUI2
    	sellGUI2.AddTrade(Hypotion, container);
		
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
			if (i.getPersonne().equals(personne)) {
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
	
	public Boss searchBoss(int ID) {
		for (Boss b: this.allBoss) {
			if(b.getID() == ID) {
				return b;
			}
		}
		return this.KingGobelin;
	}
	public SellingGUI searchsellGUI(int ID) {
		for (SellingGUI i : this.allSells) {
			if(i.getID() == ID) {
				return i;
			}
		}
		return this.sellGUI1;
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
