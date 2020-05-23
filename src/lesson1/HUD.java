package lesson1;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class HUD {

    private Image hud;
    private static  int P_BAR_X;
    private static int P_BAR_Y;
    private String chemin;

    HUD(String chemin, int P_BAR_X, int P_BAR_Y ){
        this.chemin = chemin;
        this.P_BAR_X = P_BAR_X;
        this.P_BAR_Y = P_BAR_Y;
    }

    public void init() throws SlickException {
        this.hud = new Image(chemin);
    }

    public void render(Graphics g) {
        g.resetTransform();
        g.drawImage(this.hud, this.P_BAR_X, this.P_BAR_Y);
    }
}

