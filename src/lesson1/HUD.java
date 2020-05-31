package lesson1;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HUD {

    private Image hud_player;
    private Image hud_enemie;
    private Player player;
    private Enemie enemie;

    private static int P_BAR_X;
    private static int P_BAR_Y;
    private static int E_BAR_X; // position de l'hud des enemies en X
    private static int E_BAR_Y; // position de l'hud des enemies en Y
    private static final int BAR_X = P_BAR_X + 50 + P_BAR_Y;
    private static final int EBAR_X = E_BAR_X + 402 + E_BAR_Y; // position des barres des enemies en X
    private static final int LIFE_BAR_Y = 20 + P_BAR_Y;
    private static final int E_LIFE_BAR_Y = 20 + E_BAR_Y; //position de la barre de vie des enemies
    private static final int MANA_BAR_Y = 40 + P_BAR_Y;
    private static final int BACKGROUND_BAR_Y = 20 + E_BAR_Y;
    private static final int XP_BAR_Y = 60 + P_BAR_Y;
    private static final int BAR_WIDTH = 206;
    private static final int BAR_HEIGHT = 15;

    private static final Color LIFE_COLOR = new Color(255, 0, 0);
    private static final Color MANA_COLOR = new Color(0, 0, 255);
    private static final Color XP_COLOR = new Color(0, 255, 0);
    private static final Color BACKGROUND_COLOR = new Color(10,28,68);
    private String chemin;

    HUD(String chemin, int P_BAR_X, int P_BAR_Y, Player player){
        this.chemin = chemin;
        this.P_BAR_X = P_BAR_X;
        this.P_BAR_Y = P_BAR_Y;
        this.player = player;
    }

    public void initPlayer() throws SlickException {
        this.hud_player = new Image(chemin);
    }

    public void renderPlayer(Graphics g) {
        g.resetTransform();
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(BAR_X, BACKGROUND_BAR_Y,1*BAR_WIDTH,60);
        g.setColor(LIFE_COLOR);
        g.fillRect(BAR_X, LIFE_BAR_Y, ((float)player.getPv()/(float)player.getMaxPV()) * BAR_WIDTH, BAR_HEIGHT);
        g.setColor(MANA_COLOR);
        g.fillRect(BAR_X, MANA_BAR_Y, ((float)player.getMana()/(float)player.getMaxMana()) * BAR_WIDTH, BAR_HEIGHT);
        g.setColor(XP_COLOR);
        g.fillRect(BAR_X, XP_BAR_Y, ((float)player.getXp()/(float)player.getMaxXp()) * BAR_WIDTH, BAR_HEIGHT);
        g.drawImage(this.hud_player, P_BAR_X, P_BAR_Y);
    }

    HUD(String chemin, int E_BAR_X, int E_BAR_Y, Enemie enemie){
        this.chemin = chemin;
        this.E_BAR_X = E_BAR_X;
        this.E_BAR_Y = E_BAR_Y;
        this.enemie = enemie;
    }

    public void initEnemie() throws SlickException {
        this.hud_enemie = new Image(chemin);
    }

    public void renderEnemie(Graphics g) {
        g.resetTransform();
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(EBAR_X, BACKGROUND_BAR_Y,1*BAR_WIDTH,20);
        g.setColor(LIFE_COLOR);
        g.fillRect(EBAR_X, E_LIFE_BAR_Y, ((float)enemie.getPv()/(float)enemie.getMaxHp()) * BAR_WIDTH, BAR_HEIGHT);
        g.drawImage(this.hud_enemie, E_BAR_X, E_BAR_Y);
    }
}

