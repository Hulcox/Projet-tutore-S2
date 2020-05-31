package lesson1;

import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class GameAsset {
	Image battle1,hero, InventoryBackground, battleGrotte, InventoryShop, InfoImage,OrbeBoss1, Henniktamer, battle_groundBoss2;
	Enemie knight, gobelin, Antonio, Ricardo, Blackblop, Greenblop, Blueblop, Redblop, Demons;
	Map map1, grotte1, Vailor, Dj1_RDC_sp, Dj1_RDC_sg, Dj1_RDC_sg2, Dj1_ET1_esc, Dj1_RDC_sb, Dj2_RDC_sp, Dj2_RDC_s2, 
	Dj2_RDC_tphd, Dj2_RDC_tphg, Dj2_RDC_tpbd, Dj2_RDC_tpbg, Dj2_RDC_sb, Dj3_RDC_sp, Dj3_RDC_s2, Dj3_RDC_s3, Dj3_RDC_sb, Dj3_RDC_sb2 ;
	Epée copperSword, ironSword, diamondSword, GodGun;
	Potions potion, superPotion, Hypotion;
	Armure copperArmor, ironArmor, diamondArmor;
	KeyItem debug, demonMask, Wildkey, demontear, Abyssalkey, Ariapass, Izariapass, Shanpass, Wildorb, Abyssalorb, 
	Demonorb, lavatunic, Melpass, Demonickey;
	Booster boosterI;
	Heal healI, healII, healIII;
	DamageSpell fireI, fireII, fireIII, Ultima, MaelStrom, MegaStorm, WaterSpike;
	MonsterDrop Metalscrap, Gobelinmeat, Gobelinspear, Poncho, Hypoueye, Watertrident, Blueslime, Blackslime, 
	Redslime, Greenslime,Fireshard;
	Chest chest1,chest2,chest3,chest4,chest5;
	Quete PeauGobelin, masquedemo, larmedemo, Leslimedaria, Leslimedizaria, Grosbras, Lebroalrick, Hypoumel;
	Boss KingGobelin, Cagnazzo;
	Music maintheme, cave, Battle, Victory, MenuMusic, Town, BossA, death;
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
		gobelin = new Enemie(30,5,2, "Gobelin", this.Gobelinmeat);
		knight = new Enemie(40,5,2,"knight", this.Metalscrap);
		Antonio = new Enemie(80,6,2,"Antonio", this.Watertrident);
		Ricardo = new Enemie(70,5,2,"Ricardo", this.Hypoueye);
		Blackblop = new Enemie(30,3,2, "Blackblop", this.Blackslime);
		Redblop = new Enemie(30,3,2, "Redblop", this.Redslime);
		Greenblop = new Enemie(30,3,2, "Greenblop", this.Greenslime);
		Blueblop = new Enemie(30,3,2, "Blueblop", this.Blueslime);
		Demons = new Enemie(100,8,2,"Demons",this.Fireshard);
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
		Dj2_RDC_s2 = new Map ("Dj2_RDC_s2.tmx", true, battle_groundBoss2, "Dj2_RDC_s2",this.cave);
		Dj2_RDC_tphg = new Map ("Dj2_RDC_tphg.tmx", true, battle_groundBoss2, "Dj2_RDC_tphg",this.cave);
		Dj2_RDC_tphd = new Map ("Dj2_RDC_tphd.tmx", true, battle_groundBoss2, "Dj2_RDC_tphd",this.cave);
		Dj2_RDC_tpbg = new Map ("Dj2_RDC_tpbg.tmx", true, battle_groundBoss2, "Dj2_RDC_tpbg",this.cave);
		Dj2_RDC_tpbd = new Map ("Dj2_RDC_tpbd.tmx", true, battle_groundBoss2, "Dj2_RDC_tpbd",this.cave);
		Dj2_RDC_sb = new Map ("Dj2_RDC_sb.tmx", false, battle_groundBoss2, "Dj2_RDC_sb",this.cave);
		Dj3_RDC_sp = new Map ("Dj3_RDC_sp.tmx", true, battle_groundBoss2, "Dj3_RDC_sp",this.cave);
		Dj3_RDC_s2 = new Map ("Dj3_RDC_s2.tmx", true, battle_groundBoss2, "Dj3_RDC_s2",this.cave);
		Dj3_RDC_s3 = new Map ("Dj3_RDC_s3.tmx", true, battle_groundBoss2, "Dj3_RDC_s3",this.cave);
		Dj3_RDC_sb = new Map ("Dj3_RDC_sb.tmx", false, battle_groundBoss2, "Dj3_RDC_sb",this.cave);
		Dj3_RDC_sb2 = new Map ("Dj3_RDC_sb2.tmx", false, battle_groundBoss2, "Dj3_RDC_sb2",this.cave);

		map1.addEncounrers(knight); map1.addEncounrers(Blueblop); map1.addEncounrers(Greenblop);
		Dj1_ET1_esc.addEncounrers(gobelin);Dj1_ET1_esc.addEncounrers(Greenblop);
		Dj1_RDC_sp.addEncounrers(gobelin);Dj1_RDC_sp.addEncounrers(Greenblop);
		Dj1_RDC_sg.addEncounrers(gobelin);Dj1_RDC_sg.addEncounrers(Greenblop);
		Dj1_RDC_sg2.addEncounrers(gobelin);Dj1_RDC_sg2.addEncounrers(Greenblop);
		Dj2_RDC_sp.addEncounrers(Blueblop);Dj2_RDC_sp.addEncounrers(Antonio);Dj2_RDC_sp.addEncounrers(Blackblop);
		Dj2_RDC_s2.addEncounrers(Blueblop);Dj2_RDC_s2.addEncounrers(Antonio);Dj2_RDC_s2.addEncounrers(Blackblop);
		Dj2_RDC_tphg.addEncounrers(Blueblop);Dj2_RDC_tphg.addEncounrers(Antonio);Dj2_RDC_tphg.addEncounrers(Blackblop);
		Dj2_RDC_tphd.addEncounrers(Blueblop);Dj2_RDC_tphd.addEncounrers(Antonio);Dj2_RDC_tphd.addEncounrers(Blackblop);
		Dj2_RDC_tpbg.addEncounrers(Blueblop);Dj2_RDC_tpbg.addEncounrers(Antonio);Dj2_RDC_tpbg.addEncounrers(Blackblop);
		Dj2_RDC_tpbd.addEncounrers(Blueblop);Dj2_RDC_tpbd.addEncounrers(Antonio);Dj2_RDC_tpbd.addEncounrers(Blackblop);
		
		allMaps = new ArrayList<Map>();
		allMaps.add(map1); allMaps.add(grotte1); allMaps.add(Vailor); allMaps.add(Dj1_RDC_sp); allMaps.add(Dj1_RDC_sg);
		allMaps.add(Dj1_ET1_esc); allMaps.add(Dj1_RDC_sg2); allMaps.add(Dj1_RDC_sb); allMaps.add(Dj2_RDC_sp); 
		allMaps.add(Dj2_RDC_s2); allMaps.add(Dj2_RDC_tphg); allMaps.add(Dj2_RDC_tphd); allMaps.add(Dj2_RDC_tpbg); allMaps.add(Dj2_RDC_tpbd); 
		allMaps.add(Dj2_RDC_sb); allMaps.add(Dj3_RDC_sp); allMaps.add(Dj3_RDC_s2); allMaps.add(Dj3_RDC_s3); allMaps.add(Dj3_RDC_sb); 
		allMaps.add(Dj3_RDC_sb2);
		
	}
	public void loadMusic() throws SlickException {
		maintheme = new Music("sound/MainTheme.ogg");
		cave = new Music("sound/Cave.ogg");
		Battle = new Music("sound/Battle.ogg");
		Victory = new Music("sound/Victory.ogg");
		MenuMusic = new Music("sound/MenuMusic.ogg");
		Town = new Music("sound/Town.ogg");
		BossA = new Music("sound/Bossa.ogg");
		death = new Music("sound/death.ogg");
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
		Metalscrap = new MonsterDrop(50,"Metal scrap", 8); allAsset.add(Metalscrap);
		Gobelinmeat = new MonsterDrop(25, "Gobelin meat", 9); allAsset.add(Gobelinmeat);
		Gobelinspear = new MonsterDrop(25,"Gobelin spear", 10); allAsset.add(Gobelinspear);
		Poncho = new MonsterDrop(25,"Poncho", 11); allAsset.add(Poncho);
		Hypoueye = new MonsterDrop(35,"Hypoueye", 26); allAsset.add(Hypoueye);
		Greenslime = new MonsterDrop(30," Green slime", 27); allAsset.add(Greenslime);
		Blueslime = new MonsterDrop(30," Blue slime", 28); allAsset.add(Blueslime);
		Blackslime = new MonsterDrop(30," Black slime", 29); allAsset.add(Blackslime);
		Redslime = new MonsterDrop(30," Red slime", 30); allAsset.add(Redslime);
		Fireshard = new MonsterDrop(100, "Fire shard", 31); allAsset.add(Fireshard);
		Watertrident = new MonsterDrop(30,"WaterTrident", 32); allAsset.add(Watertrident);
		//Potions
		potion = new Potions(20,"potion",20,12); allAsset.add(potion);
		superPotion = new Potions(40,"Super potion",  40,13); allAsset.add(superPotion);
		Hypotion = new Potions(80,"potion X",  80,14); allAsset.add(Hypotion);
		//Key object
		debug = new KeyItem(1,"droit de passage",15); allAsset.add(debug);
		demonMask = new KeyItem(1,"Demon Mask",23); allAsset.add(demonMask);
		Wildkey = new KeyItem(1,"Wild key",24); allAsset.add(Wildkey);
		demontear = new KeyItem(1,"Demon Tear",33); allAsset.add(demontear);
		Abyssalkey = new KeyItem(1,"Abyssal key",34); allAsset.add(Abyssalkey);
		Ariapass = new KeyItem(1,"Aria pass",35); allAsset.add(Ariapass);
		Izariapass = new KeyItem(1,"Izaria pass",36); allAsset.add(Izariapass);
		Shanpass = new KeyItem(1,"Shan pass",37); allAsset.add(Shanpass);
		lavatunic = new KeyItem(1,"Lava Tunic",38); allAsset.add(Shanpass);
		Melpass = new KeyItem(1,"Mel pass",39); allAsset.add(Shanpass);
		Demonickey = new KeyItem(1,"Demonic key",40); allAsset.add(Demonickey);
		//Spells
		boosterI = new Booster(200,"booster I",true,2,10,16); allAsset.add(boosterI);
		healI = new Heal(100,"Heal I",true,20,5,41); allAsset.add(healI);
		healII = new Heal(200,"Heal II",true,40,10,42); allAsset.add(healII);
		healIII = new Heal(400,"Heal III",true,80,20,43); allAsset.add(healIII);
		fireI = new DamageSpell(200,"Fire I",false,20,5,17); allAsset.add(fireI);
		fireII = new DamageSpell(400,"Fire II",false,40,10,18); allAsset.add(fireII);
		fireIII = new DamageSpell(800,"Fire III",false,80,20,19); allAsset.add(fireIII);
		Ultima = new DamageSpell(800,"Ultima",false,160,40,20); allAsset.add(Ultima);
		MaelStrom = new DamageSpell(800,"MaelStrom",false,200,45,21); allAsset.add(MaelStrom);
		MegaStorm = new DamageSpell(800,"Mega storm",false,250,50,22); allAsset.add(MegaStorm); 
		WaterSpike = new DamageSpell(400,"Water spike",false,85,20,25); allAsset.add(WaterSpike); //LAST ID:43
		//////////////ID INDEPENDANTE/////////////////////////////////////////////////////////////////
		
		//Chest ID,ITEM
		chest1 = new Chest(1,this.Gobelinspear,this); allChest.add(chest1);
		chest2 = new Chest(2,this.potion,this); allChest.add(chest2);
		chest3 = new Chest(3,this.demonMask,this); allChest.add(chest3);
		chest4 = new Chest(4,this.lavatunic,this); allChest.add(chest4);
		chest5 = new Chest(5,this.lavatunic,this); allChest.add(chest5);
		//Initialisation des quetes OBJET ATTENDU, QUANTITE, RECOMPENSE, ID
		PeauGobelin = new Quete(this.Gobelinmeat,3,this.debug,1); allQuest.add(PeauGobelin);
		masquedemo = new Quete(this.demonMask,1,this.Wildkey,2); allQuest.add(masquedemo);
		larmedemo = new Quete(this.demontear,1,this.Abyssalkey,3); allQuest.add(larmedemo);
		Leslimedaria = new Quete(this.Greenslime,10,this.Ariapass,4); allQuest.add(Leslimedaria);
		Leslimedizaria = new Quete(this.Blueslime,15,this.Izariapass,5); allQuest.add(Leslimedizaria);
		Grosbras = new Quete(this.Watertrident,15,this.Shanpass,6); allQuest.add(Grosbras);
		Lebroalrick = new Quete(this.Shanpass,1,this.demontear,7); allQuest.add(Lebroalrick);
		Hypoumel = new Quete(this.Hypoueye,15,this.Melpass,8); allQuest.add(Hypoumel);
		//Boss PV, DEGATS, NIVEAU, NOM, SORT1, SORT2, SORT3, ID
		KingGobelin = new Boss(500,15,1,"King gobelin",this.Gobelinspear,this.fireI,this.fireII,this.MegaStorm,this.BossA,1);
		this.KingGobelin.setImage(this.OrbeBoss1); allBoss.add(KingGobelin);
		Cagnazzo = new Boss(1000,30,1,"Cagnazzo",this.Gobelinspear,this.WaterSpike,this.WaterSpike,this.MaelStrom,this.BossA,2);
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
		allTexts.add(new DialogueAsset("Yon",false));
		allTexts.add(new DialogueAsset("Guard Vulcan",false));
		
		allTexts.add(new DialogueAsset("Rica",true,this.PeauGobelin,container));
		allTexts.add(new DialogueAsset("Konor",true,this.masquedemo,container));
		allTexts.add(new DialogueAsset("Abduul",true,this.larmedemo,container));
		allTexts.add(new DialogueAsset("Servant Aria",true,this.Leslimedaria,container));
		allTexts.add(new DialogueAsset("Super servant Izaria",true,this.Leslimedizaria,container));
		allTexts.add(new DialogueAsset("Hyper servant Shan",true,this.Grosbras,container));
		allTexts.add(new DialogueAsset("Guard Mel",true,this.Hypoumel,container));


		//Selling GUI init
		sellGUI1 = new SellingGUI(InventoryShop,inventory,1); allSells.add(sellGUI1); //sellGUI1
		sellGUI1.AddTrade(copperArmor, container);
    	sellGUI1.AddTrade(diamondArmor, container);
    	sellGUI1.AddTrade(potion, container);
    	sellGUI1.AddTrade(superPotion, container);
    	sellGUI1.AddTrade(Hypotion, container);
    	sellGUI1.init(container);
    	sellGUI2 = new SellingGUI(InventoryShop,inventory,2); allSells.add(sellGUI2); //sellGUI2
    	sellGUI2.AddTrade(Hypotion, container);
    	sellGUI2.init(container);
		
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
	public ArrayList<Boss> getAllBoss(){
		return allBoss;
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
