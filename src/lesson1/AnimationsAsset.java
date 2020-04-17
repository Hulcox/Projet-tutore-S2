package lesson1;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class AnimationsAsset {
	public void addAnimation(SpriteSheet spriteSheet, Player p1) {
        Animation animations[] = new Animation[8];
        animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
        animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
        animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
        animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
        animations[4] = loadAnimation(spriteSheet, 1, 9, 0);
        animations[5] = loadAnimation(spriteSheet, 1, 9, 1);
        animations[6] = loadAnimation(spriteSheet, 1, 9, 2);
        animations[7] = loadAnimation(spriteSheet, 1, 9, 3);
        p1.setAnimations(animations);
	}
	public void loadBattlersAnimation(SpriteSheet spriteSheet,Player p1) {
		Animation animations[] = new Animation[2];
		animations[0] = loadAnimation(spriteSheet, 0,1,0);
		animations[1] = loadAnimation(spriteSheet, 1,9,0);
		p1.setBattleanim(animations);
	}
	
    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }
    public void loadEnemyAnimation(GameAsset imageasset) throws SlickException {
    	
    	SpriteSheet spriteSheetKnight = new SpriteSheet("texture/Knight_enemy_1.png", 128, 128);
    	SpriteSheet spriteSheetGobelin = new SpriteSheet("texture/gobelin.png",128,128);
    	this.setEnemyAnimation(spriteSheetKnight, 3, imageasset.knight);
    	this.setEnemyAnimation(spriteSheetGobelin, 2, imageasset.gobelin);
    	
    }
    public void setEnemyAnimation(SpriteSheet spriteSheet, int numberOfFrame, Enemie enemie) {
    	Animation animations[] = new Animation[2];
        animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
        animations[1] = loadAnimation(spriteSheet, 1, numberOfFrame, 0);
        enemie.setBattleanim(animations);
    	
    }

}
