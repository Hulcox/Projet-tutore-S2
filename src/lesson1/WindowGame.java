package lesson1;



import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.tiled.TiledMap;


public class WindowGame extends BasicGame {
	
	private GameContainer container;
	private boolean textrender = false, chestTextRender = false, triggerMusic = false, bossrender = false, DisplayinfoMessage = false, winrender = false;
	Inventaire inventory;
	GameAsset GameAsset = new GameAsset();
	Texture text;
	Input input;
	TiledMap map;
	int RNG = 500, enemieselect;
	float prevX = 300, prevY = 300;
	Player p1;
	Camera camera;
	AnimationsAsset animationasset;
	Battle battle;
	BossBattle bossbattle;
	EventObject singleFireEvent, singleFireEvent2;
	BattleHUD hud;
	SellingGUI sellGUI;
	SpellGUI spellgui;
	Chest tempchest;
	ItemsGUI itemsgui;
	DialogueAsset dialogue;
	StartScreen menu;
	InGameHUD IngameHUD;
	Graphics g;
	Music playedmusic;
	Boss temp;
	GameOverScreen gameover, win;
	private ArrayList<Integer> ID;
	private String info;

	

    public WindowGame() {
        super("Knight VOW");
    }
    
    public void loadAsset(GameContainer container) throws SlickException, IOException {
    	this.ID = new ArrayList<Integer>();
    	GameAsset.loadMusic();
    	GameAsset.loadImage();
    	GameAsset.loadObject();
    	GameAsset.loadEnemie();
    	GameAsset.loadMap();
    	menu = new StartScreen();
    	input = container.getInput();
    	container.setTargetFrameRate(120);
    	camera = new Camera();
    	p1 = new Player(25,20);
    	gameover = new GameOverScreen("texture/Ecran_Game_Over.png");
    	win = new GameOverScreen("texture/endscreen.png");
    	GameAsset.initinventory(p1);
    	GameAsset.loadText(this.container);
    	IngameHUD = new InGameHUD(p1);
    	GameAsset.setPlayer(p1);
    	this.menu.init(container);
    	this.IngameHUD.init(container);
    	this.gameover.init(container);
    	this.win.init(container);
    	this.map = GameAsset.map1.getMap();
    	p1.setMap(GameAsset.hauteglise);
    	p1.setX(527);
    	p1.setY(355);
    	this.MapLoading(GameAsset.map1.getMap());
    	animationasset = new AnimationsAsset();
    	battle = new Battle(p1);
    	p1.setImage(GameAsset.hero);
    	//armure et �pee en cooper
    	p1.setPlayerArmor(GameAsset.copperArmor);
    	p1.setPlayerSword(GameAsset.copperSword);
    	hud = new BattleHUD(p1,camera,battle);
    	this.inventory = GameAsset.inventory;
    	p1.setInventaire(inventory);
    	inventory.setOpen(false); //Inventaire initialisation
    	//sellGUI = GameAsset.sellGUI1;
    	spellgui = new SpellGUI(container, inventory);
    	itemsgui = new ItemsGUI(container, inventory);
    	inventory.setitemsgui(itemsgui);
    	inventory.setSpellgui(spellgui);
    	itemsgui.AddMouseOverArea(GameAsset.potion);
    	itemsgui.AddMouseOverArea(GameAsset.potion);
    	p1.setCamera(camera);
    	IngameHUD.getSave().setGameasset(GameAsset);
    	menu.setSave(IngameHUD.getSave());
    	bossbattle = new BossBattle(p1);
    	sellGUI = GameAsset.sellGUI1;
    	container.setIcon("texture/Icone.png");

    }

    
    @Override
    public void init(GameContainer container) throws SlickException {

    	singleFireEvent = new EventObject(1000, false);
    	singleFireEvent2 = new EventObject(1000, false);
    	this.container = container;
    	container.setFullscreen(true);
        SpriteSheet spriteSheet = new SpriteSheet("texture/character2.png", 64, 64);
        SpriteSheet battlers = new SpriteSheet("texture/truebattle.png", 128, 128);
    	try {
			loadAsset(container);
		} catch (SlickException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	animationasset.addAnimation(spriteSheet, p1);
    	animationasset.loadBattlersAnimation(battlers, p1);
    	animationasset.loadEnemyAnimation(GameAsset);

    	this.hud.init(container);
    	this.playedmusic = GameAsset.MenuMusic;
    	this.playedmusic.loop();

    }
    
    


	@Override
    public void render(GameContainer container, Graphics g) throws SlickException {

		this.map = this.p1.getMap().getMap();
		this.playedmusic.setVolume(this.IngameHUD.getSound());
		this.MapLoading(this.map);
		if (!this.menu.isGameStart()) {
			this.menu.render(container, g);
			this.triggerMusic = true;
		}
		else if(winrender) {
			this.win.render(container, g);
			if(win.isTriggerMusic()) {
				this.playedmusic = GameAsset.Victory;
				this.playedmusic.loop();
				win.setTriggerMusic(false);
			}
		}
		else if(this.p1.getPv() <= 0) {
			this.gameover.render(container, g);
			if(gameover.isTriggerMusic()) {
				this.playedmusic = GameAsset.death;
				this.playedmusic.loop();
				gameover.setTriggerMusic(false);
			}
			
			
		}
		else if (bossbattle.isInBattle()) {
			p1.setMoving(false);
			bossbattle.render(container, g, singleFireEvent, singleFireEvent2);
			this.hud.render(container, g);
			if (spellgui.isIsOpen()) {
				spellgui.render(container, g);
			}
			if(itemsgui.isIsOpen()) {
				itemsgui.render(container, g);
			}
			if(temp.isTrigger()) {
				this.playedmusic.loop();
				temp.setTrigger(false);
			}
			if(p1.isAffichageState()) {
				if(this.battle.isMusicTrigger()) {
					this.playedmusic = GameAsset.Victory;
					this.playedmusic.loop();
					this.battle.setMusicTrigger(false);
				}
			}
			this.triggerMusic = true;
		}
		else if  (battle.isInBattle()) {	 //Boucle de la bataille
			p1.setMoving(false);
    			battle.DrawBattle(g,p1,p1.getMap(), camera,enemieselect,singleFireEvent);
    			this.hud.render(container, g);
    			if (spellgui.isIsOpen()) {
    				spellgui.render(container, g);
    			}
    			if(itemsgui.isIsOpen()) {
    				itemsgui.render(container, g);
    			}
    			if(p1.isAffichageState()) {
    				if(this.battle.isMusicTrigger()) {
    					this.playedmusic = GameAsset.Victory;
    					this.playedmusic.loop();
    					this.battle.setMusicTrigger(false);
    				}
    			}
    			this.triggerMusic = true;
		}
		else {
			
			
			if(triggerMusic) {
				this.playedmusic = p1.getMap().getMusic();
				this.playedmusic.loop();
				this.triggerMusic = false;
			}
			g.translate(container.getWidth() / 2 - (int) camera.getxCam(), 
	                container.getHeight() / 2 - (int) camera.getyCam());
		    this.map.render(0, 0, 0);
		    this.map.render(0, 0, 1);
	    	this.map.render(0, 0, 2);	
	    	if(this.ID.size() > 1) {
		    	for (int i = 0; i < this.ID.size()-2; i++) {
		    		for (Chest c : GameAsset.getAllChest()) {
		    			if(c.getID() == this.ID.get(i)) {
		    				c.render(container, g, this.ID.get(i+1), this.ID.get(i+2));

		    			}
		    			
		    		}

		    	}
	    	}
	    	if(this.bossrender) {
	    		this.temp.render(container, g);
	    	}
	    	g.drawAnimation(p1.getAnimations()[p1.getDirection() + (p1.isMoving() ? 4 : 0)], p1.getX()-32, p1.getY()-60);
	    	this.IngameHUD.render(container, g);

			

	    	if (sellGUI.isPlayerOverArea()){
		    	
	    		this.sellGUI.render(container, g);
	    	}
	    	if (this.inventory.isOpen()) {
	    		this.inventory.render(container, g);
	    	}
	    	if(this.textrender) {
	    		this.dialogue.render(container, g);
	    	}
	    	if(this.chestTextRender) {
	    		this.tempchest.renderText(container, g);
	    	}
	    	if(this.DisplayinfoMessage) {
	    		g.setColor(Color.white);
	    		g.drawImage(GameAsset.InfoImage, 10, 390);
	    		g.drawString(this.info, 20, 400);
	    	}

	        if ((Math.abs(p1.getX() - prevX) > 30 || Math.abs(p1.getY() - prevY) > 30) && p1.getMap().isIsEncounter()) //Rencontre al�atoire de monstre
	        {
	        	RNG = (int) (Math.random()*100);
	        	prevX = p1.getX();
	        	prevY = p1.getY();
	        	if (RNG < 5) { //Taux de pourcentage de rencontre des monstres en fonction des pas du personnages.
	        		this.bossbattle.setNext(false);
	        		this.battle.setNext(false);
	        		this.playedmusic = GameAsset.Battle;
	        		this.playedmusic.loop();
	        		enemieselect = (int) (Math.random()*(p1.getMap().getArrayList().size()));
	        		battle.setInBattle(true);
	        		itemsgui.setIsOpen(false);

	        	}
	        }

		}
    	
    }
	
	public void MapLoading(TiledMap map) {
		this.ID = new ArrayList<Integer>();
		this.bossrender = false;
		for (int objectID = 0; objectID < map.getObjectCount(0); objectID++) {
			if ("Chest".equals(map.getObjectType(0, objectID))) {
				this.ID.add(Integer.parseInt(this.map.getObjectProperty(0, objectID, "ID", "undefined")));
				this.ID.add(map.getObjectX(0, objectID));
				this.ID.add(map.getObjectY(0, objectID));
			}
            if("boss".equals(map.getObjectType(0, objectID))){
            	temp = GameAsset.searchBoss(Integer.parseInt(this.map.getObjectProperty(0, objectID, "ID","undefined")));
            	if (!temp.isDefeated()) {
            		this.dialogue = this.temp.getDialogue();
            		this.textrender = true;
            		this.temp.setX( (map.getObjectX(0, objectID)+(map.getObjectWidth(0, objectID)/2))-temp.getImage().getWidth()/2);
            		this.temp.setY( (map.getObjectY(0, objectID)+(map.getObjectHeight(0, objectID)/2))-temp.getImage().getHeight()/2);
            		this.bossrender = true;
            	}
            }

		}
	}

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    	
        for (int objectID = 0; objectID < map.getObjectCount(0); objectID++) {				//Detection des events sur la tiled map.
            if (p1.getX() > map.getObjectX(0, objectID)
                    && p1.getX() < map.getObjectX(0, objectID) + map.getObjectWidth(0, objectID)
                    && p1.getY() > map.getObjectY(0, objectID)
                    && p1.getY() < map.getObjectY(0, objectID) + map.getObjectHeight(0, objectID)) { //Si le joueur est dans un event
            	
            	
                if ("transition".equals(map.getObjectType(0, objectID))) {
                    p1.setX(Float.parseFloat(map.getObjectProperty(0, objectID, "detx", Float.toString(p1.getX())))); 
                    p1.setY(Float.parseFloat(map.getObjectProperty(0, objectID, "dety", Float.toString(p1.getY()))));
                } 
                else if ("regen".equals(map.getObjectType(0, objectID))) {
                	this.p1.setPv(p1.getMaxPV());
                	this.p1.setMana(p1.getMaxMana());
            		this.info = ("MP HP fully restored ! ");
            		this.DisplayinfoMessage = true;
                }
                else if ("transitionc".equals(map.getObjectType(0, objectID))) {
                	String keyName = this.map.getObjectProperty(0, objectID, "key","undefined");
                	boolean textfound = false;
                	for (KeyItem k : p1.getInventaire().getKeyItemList()) {
                		if (k.getNom().equals(keyName)) {
                			p1.setX(Float.parseFloat(map.getObjectProperty(0, objectID, "detx", Float.toString(p1.getX())))); 
                            p1.setY(Float.parseFloat(map.getObjectProperty(0, objectID, "dety", Float.toString(p1.getY()))));
                		}
                	}
                	if(!textfound) {
                		this.info = ("You need the item : " + keyName);
                		this.DisplayinfoMessage = true;
                	}
                }
                else if ("vendeur".equals(map.getObjectType(0, objectID))) {
                	this.sellGUI = GameAsset.searchsellGUI(Integer.parseInt(this.map.getObjectProperty(0, objectID, "ID","undefined")));
                	if (sellGUI.isShopOpen()) {
                		this.sellGUI.setPlayerOverArea(true);
                		this.p1.setMoving(false);
                	}
                	else {
                		this.sellGUI.setPlayerOverArea(false);
                	}
                		
                }
                else if ("changement".equals(map.getObjectType(0, objectID))) {
                	p1.setMap(GameAsset.searchMap(this.map.getObjectProperty(0, objectID, "detmap", "undefined")));
                    p1.setX(Float.parseFloat(map.getObjectProperty(0, objectID, "detx", Float.toString(p1.getX())))); 
                    p1.setY(Float.parseFloat(map.getObjectProperty(0, objectID, "dety", Float.toString(p1.getY()))));
                	this.map = GameAsset.searchMap(this.map.getObjectProperty(0, objectID, "detmap", "undefined")).getMap();
                	this.MapLoading(this.map);
                	if(!p1.getMap().getMusic().equals(this.playedmusic)) {
	                	this.playedmusic = this.p1.getMap().getMusic();
	                	this.playedmusic.loop();
                	}
                	
                }
                
                else if("Dialogue".equals(map.getObjectType(0, objectID))){
                	try {
						this.dialogue = GameAsset.searchText(this.map.getObjectProperty(0, objectID, "personne","undefined"));
					} catch (SlickException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
                	this.textrender = true;
                	if(this.dialogue.isHaveQuest()) {
                		this.dialogue.verifQuete(p1);
                	}
                }
                else if("Chest".equals(map.getObjectType(0, objectID))) {
                	tempchest = GameAsset.SearchChest(Integer.parseInt(this.map.getObjectProperty(0, objectID, "ID","undefined")));
                	if(sellGUI.isShopOpen()) {
                		if(!tempchest.isOpen()) {
                			p1.getInventaire().AddObjet(tempchest.getLoot());
                			tempchest.setOpen(true);
                			this.sellGUI.setShopOpen(false);
                		}
                		this.chestTextRender = true;
                		
                	}
                	

                }
                else if("end".equals(map.getObjectType(0, objectID))) {
                	p1.setMoving(false);
                	winrender = true;
                	
                }
                else if("changementc".equals(map.getObjectType(0, objectID))){
                	String keyName = this.map.getObjectProperty(0, objectID, "key","undefined");
                	boolean textfound = false;
                	for (KeyItem k : p1.getInventaire().getKeyItemList()) {
                		if (k.getNom().equals(keyName)) {
                        	p1.setMap(GameAsset.searchMap(this.map.getObjectProperty(0, objectID, "detmap", "undefined")));
                            p1.setX(Float.parseFloat(map.getObjectProperty(0, objectID, "detx", Float.toString(p1.getX())))); 
                            p1.setY(Float.parseFloat(map.getObjectProperty(0, objectID, "dety", Float.toString(p1.getY()))));
                        	this.map = GameAsset.searchMap(this.map.getObjectProperty(0, objectID, "detmap", "undefined")).getMap();
                        	this.MapLoading(this.map);
                        	textfound = true;
                        	if(!p1.getMap().getMusic().equals(this.playedmusic)) {
        	                	this.playedmusic = this.p1.getMap().getMusic();
        	                	this.playedmusic.loop();
                        	}
                		}
                	}
                	if(!textfound) {
                		this.info = ("You need the item : " + keyName);
                		this.DisplayinfoMessage = true;
                	}
                }
                else if("boss".equals(map.getObjectType(0, objectID))) {
                	this.textrender = false;
                	if (!this.temp.isDefeated()) {
                		this.textrender = false;
                		this.playedmusic = this.temp.getMusic();
                		this.bossbattle.setBoss(temp);
                		this.bossbattle.setInBattle(true);
                	}
                }





            }


            

            
 

 
         }
        
    	singleFireEvent.update(delta);
    	singleFireEvent2.update(delta);
        if (p1.isMoving()) {
        	this.chestTextRender = false;
        	this.textrender  = false;
        	this.DisplayinfoMessage = false;
            float futurX = getFuturX(delta);
            float futurY = getFuturY(delta);
            boolean collision = isCollision(futurX, futurY);
            this.RNG = (int) Math.random()*100;
            if (collision) {
                p1.setMoving(false);
            } else {
                p1.setX(futurX);
                p1.setY(futurY);
            }
        }
        if (!battle.isInBattle()) {
	        int w = container.getWidth() / 4;
	        if (p1.getX() > camera.getxCam() + w) camera.setxCam(p1.getX() - w);
	        if (p1.getX() < camera.getxCam() - w) camera.setxCam(p1.getX() + w);
	        int h = container.getHeight() / 4;
	        if (p1.getY() > camera.getyCam() + h) camera.setyCam(p1.getY() - h);
	        if (p1.getY() < camera.getyCam() - h) camera.setyCam(p1.getY() + h);
        }
        

    }
    
    public static void main(String[] args) throws SlickException {
    	
        new AppGameContainer(new WindowGame(), 640,480, false).start();
       
        

        
    }

    @Override
    public void keyReleased(int key, char c) {
    	p1.setMoving(false);
    }
    

    public void keyPressed(int key, char c) {

    	if (!battle.isInBattle() && !bossbattle.isInBattle()) { //Commande hors bataille
    		if(key != Input.KEY_LSHIFT) {
    			p1.setSpeed(0.1f);
    		}
    		else {
    			p1.setSpeed(0.2f);
    		}
	        switch (key) {
	        case Input.KEY_UP:    p1.setDirection(0); p1.setMoving(true); break;
	        case Input.KEY_LEFT:  p1.setDirection(1); p1.setMoving(true); break;
	        case Input.KEY_DOWN:  p1.setDirection(2); p1.setMoving(true); break;
	        case Input.KEY_RIGHT: p1.setDirection(3); p1.setMoving(true); break;
	        case Input.KEY_E: inventory.setOpen(!inventory.isOpen());break;
	        case Input.KEY_A: sellGUI.setShopOpen(!sellGUI.isShopOpen()); sellGUI.setInfoBox("Hello what do you want ?");break;
	        }

    	}

 
    	else {
    		switch (key) { //Commande bataille
    		case Input.KEY_F: battle.setInBattle(false); this.battle.setinit(true); this.p1.setAnimstate(0);break; 
    		case Input.KEY_A: p1.setAnimstate(1);break;
    		case Input.KEY_E: battle.setNext(true); bossbattle.setNext(true);break;
    		case Input.KEY_I: itemsgui.setIsOpen(!itemsgui.isIsOpen());break;
    		case Input.KEY_S: spellgui.setIsOpen(!spellgui.isIsOpen());break;
    		case Input.KEY_D: p1.setDefending(true);p1.setAnimstate(2);break;
    		}
    	}
    	
    	if(this.textrender) {
    		switch (key) { 
    			case Input.KEY_A: dialogue.setIndex(dialogue.getIndex()+1);  break; 
    		}
    	}
    }
      private boolean isCollision(float x , float y) { //Collision avec le layer "logic"
           int tileW = this.map.getTileWidth();
           int tileH = this.map.getTileHeight();
           int logicLayer = this.map.getLayerIndex("Logic");
           Image tile = this.map.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
           boolean collision = tile != null;
            if (collision) {
               Color color = tile.getColor((int) x % tileW, (int) y % tileH);
               collision = color.getAlpha() > 0;
           }
           return collision;
        }

        private float getFuturX(int delta){
            float futurX = p1.getX();
            switch (p1.getDirection()) {
            case 1: futurX = p1.getX() - p1.getSpeed() * delta; break;
            case 3: futurX = p1.getX() + p1.getSpeed() * delta; break;
            }
            return futurX;
        }

        private float getFuturY(int delta) {
            float futurY = p1.getY();
            switch (p1.getDirection()) {
            case 0: futurY = p1.getY() - p1.getSpeed() * delta; break;
            case 2: futurY = p1.getY() + p1.getSpeed() * delta; break;
            }
            return futurY;
        }
     	
}

