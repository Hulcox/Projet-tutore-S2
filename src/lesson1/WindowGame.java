package lesson1;



import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.tiled.TiledMap;


public class WindowGame extends BasicGame {
	
	private GameContainer container;
	private boolean textrender = false;
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
	EventObject singleFireEvent;
	BattleHUD hud;
	SellingGUI sellGUI;
	SpellGUI spellgui;
	ItemsGUI itemsgui;
	DialogueAsset dialogue;
	StartScreen menu;
	InGameHUD IngameHUD;
    public WindowGame() {
        super("Lesson 1 :: WindowGame");
    }
    
    public void loadAsset(GameContainer container) throws SlickException, IOException {
    	GameAsset.loadImage();
    	GameAsset.loadObject();
    	GameAsset.loadEnemie();
    	GameAsset.loadMap();
    	GameAsset.loadText();
    	menu = new StartScreen();

    	input = container.getInput();
    	camera = new Camera();
    	p1 = new Player(70,999);
    	IngameHUD = new InGameHUD(p1);
    	GameAsset.setPlayer(p1);
    	this.menu.init(container);
    	this.IngameHUD.init(container);
    	this.map = GameAsset.map1.getMap();
    	p1.setMap(GameAsset.map1);
    	animationasset = new AnimationsAsset();
    	battle = new Battle(p1);
    	p1.setImage(GameAsset.hero);
    	p1.setPlayerArmor(GameAsset.copperArmor);
    	p1.setPlayerSword(GameAsset.copperSword);
    	hud = new BattleHUD(p1,camera,battle);
    	inventory = new Inventaire(p1, GameAsset.InventoryBackground);
    	p1.setInventaire(inventory);
    	inventory.setOpen(false); //Inventaire initialisation
    	inventory.AddObjet(GameAsset.metalscrap);
    	inventory.AddObjet(GameAsset.metalscrap);
    	inventory.AddObjet(GameAsset.gobelinMeat);
    	inventory.AddObjet(GameAsset.gobelinMeat);
    	inventory.AddObjet(GameAsset.gobelinSpear);
    	inventory.AddObjet(GameAsset.Poncho);
    	sellGUI = new SellingGUI(GameAsset.InventoryShop, inventory); //initialisations des vendables
    	sellGUI.AddTrade(GameAsset.copperArmor, container);
    	sellGUI.AddTrade(GameAsset.diamondArmor, container);
    	sellGUI.AddTrade(GameAsset.potion, container);
    	sellGUI.AddTrade(GameAsset.superPotion, container);
    	sellGUI.AddTrade(GameAsset.Hypotion, container);
    	spellgui = new SpellGUI(container, inventory);
    	spellgui.AddMouseOverArea(GameAsset.boosterI);
    	spellgui.AddMouseOverArea(GameAsset.fireI);
    	spellgui.AddMouseOverArea(GameAsset.fireII);
    	spellgui.AddMouseOverArea(GameAsset.fireIII);
    	spellgui.AddMouseOverArea(GameAsset.Ultima);
    	spellgui.AddMouseOverArea(GameAsset.MaelStrom);
    	spellgui.AddMouseOverArea(GameAsset.MegaStorm);
    	itemsgui = new ItemsGUI(container, inventory);
    	inventory.setitemsgui(itemsgui);
    	inventory.setSpellgui(spellgui);
    	itemsgui.AddMouseOverArea(GameAsset.Hypotion);
    	itemsgui.AddMouseOverArea(GameAsset.potion);
    	itemsgui.AddMouseOverArea(GameAsset.superPotion);
    	itemsgui.AddMouseOverArea(GameAsset.superPotion);
    	itemsgui.AddMouseOverArea(GameAsset.superPotion);
    	p1.setCamera(camera);
    	IngameHUD.getSave().setGameasset(GameAsset);
    	menu.setSave(IngameHUD.getSave());
    	
    }

    
    @Override
    public void init(GameContainer container) throws SlickException {
    	singleFireEvent = new EventObject(1000, false);
    	this.container = container;
    	container.setFullscreen(true);
        SpriteSheet spriteSheet = new SpriteSheet("texture/character.png", 64, 64);
        SpriteSheet battlers = new SpriteSheet("texture/FightAnimation.png", 196, 128);
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
    	this.sellGUI.init(container);
    	

    }
    
    


	@Override
    public void render(GameContainer container, Graphics g) throws SlickException {
		this.map = this.p1.getMap().getMap();
		if (!this.menu.isGameStart()) {
			this.menu.render(container, g);
		}
		else if  (battle.isInBattle()) {	 //Boucle de la bataille
    			battle.DrawBattle(g,p1,p1.getMap(), camera,enemieselect,singleFireEvent);
    			this.hud.render(container, g);
    			if (spellgui.isIsOpen()) {
    				spellgui.render(container, g);
    			}
    			if(itemsgui.isIsOpen()) {
    				itemsgui.render(container, g);
    			}
		}
		else {
			g.translate(container.getWidth() / 2 - (int) camera.getxCam(), 
	                container.getHeight() / 2 - (int) camera.getyCam());
		    this.map.render(0, 0, 0);
		    this.map.render(0, 0, 1);
	    	this.map.render(0, 0, 2);
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
	        if ((Math.abs(p1.getX() - prevX) > 30 || Math.abs(p1.getY() - prevY) > 30) && p1.getMap().isIsEncounter()) //Rencontre aléatoire de monstre
	        {
	        	RNG = (int) (Math.random()*100);
	        	prevX = p1.getX();
	        	prevY = p1.getY();
	        	if (RNG < 10) { //Taux de pourcentage de rencontre des monstres en fonction des pas du personnages.
	        		enemieselect = (int) (Math.random()*(p1.getMap().getArrayList().size()));
	        		battle.setInBattle(true);
	        		itemsgui.setIsOpen(false);

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
                if ("vendeur".equals(map.getObjectType(0, objectID))) {
                	if (sellGUI.isShopOpen()) {
                		this.sellGUI.setPlayerOverArea(true);
                	}
                	else {
                		this.sellGUI.setPlayerOverArea(false);
                	}
                		
                }
                if ("changement".equals(map.getObjectType(0, objectID))) {
                	p1.setMap(GameAsset.searchMap(this.map.getObjectProperty(0, objectID, "detmap", "undefined")));
                    p1.setX(Float.parseFloat(map.getObjectProperty(0, objectID, "detx", Float.toString(p1.getX())))); 
                    p1.setY(Float.parseFloat(map.getObjectProperty(0, objectID, "dety", Float.toString(p1.getY()))));
                	this.map = GameAsset.searchMap(this.map.getObjectProperty(0, objectID, "detmap", "undefined")).getMap();
                	
                }
                
                if("Dialogue".equals(map.getObjectType(0, objectID))){
                	try {
						this.dialogue = GameAsset.searchText(this.map.getObjectProperty(0, objectID, "personne","undefined"));
					} catch (SlickException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
                	this.textrender = true;
                }


            }
            else {
            	this.textrender  = false;
            }
 

 
         }
        
    	singleFireEvent.update(delta);
        if (p1.isMoving()) {
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

    	if (!battle.isInBattle()) { //Commande hors bataille
	        switch (key) {
	        case Input.KEY_UP:    p1.setDirection(0); p1.setMoving(true); break;
	        case Input.KEY_LEFT:  p1.setDirection(1); p1.setMoving(true); break;
	        case Input.KEY_DOWN:  p1.setDirection(2); p1.setMoving(true); break;
	        case Input.KEY_RIGHT: p1.setDirection(3); p1.setMoving(true); break;
	        case Input.KEY_ESCAPE: container.exit(); break;
	        case Input.KEY_E: inventory.setOpen(!inventory.isOpen());break;
	        case Input.KEY_A: sellGUI.setShopOpen(!sellGUI.isShopOpen()); sellGUI.setInfoBox("Hello what do you want ?");break;
	        }

    	}

 
    	else {
    		switch (key) { //Commande bataille
    		case Input.KEY_F: battle.setInBattle(false);  break; 
    		case Input.KEY_A: p1.setAnimstate(1);break;
    		case Input.KEY_E: battle.setNext(true); break;
    		case Input.KEY_I: itemsgui.setIsOpen(!itemsgui.isIsOpen());break;
    		case Input.KEY_S: spellgui.setIsOpen(!spellgui.isIsOpen());break;
    		case Input.KEY_D: p1.setDefending(true);p1.setAnimstate(2);break;
    		}
    	}
    	
    	if(this.textrender) {
    		switch (key) { //Commande bataille
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
