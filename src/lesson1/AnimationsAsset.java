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
        animations[4] = loadAnimation(spriteSheet, 1, 7, 0);
        animations[5] = loadAnimation(spriteSheet, 1, 7, 1);
        animations[6] = loadAnimation(spriteSheet, 1, 7, 2);
        animations[7] = loadAnimation(spriteSheet, 1, 7, 3);
        p1.setAnimations(animations);
	}
	public void loadBattlersAnimation(SpriteSheet spriteSheet,Player p1) {
		Animation animations[] = new Animation[2];
		animations[0] = loadAnimation(spriteSheet, 0,4,1);
		animations[1] = loadAnimation(spriteSheet, 0,10,0);
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
    	SpriteSheet spriteSheetBooster = new SpriteSheet("texture/booster.png",92,92);
    	SpriteSheet spriteSheetFire = new SpriteSheet("texture/Fire.png",98,64);
    	SpriteSheet spriteSheetWaterSpike = new SpriteSheet("texture/WaterSpike.png",80,96);
    	SpriteSheet spriteSheetHeal = new SpriteSheet("texture/Heal.png",137,128);
    	SpriteSheet spriteSheetUltima = new SpriteSheet("texture/Ultima.png",186,315);
    	SpriteSheet spriteSheetMaelStrom = new SpriteSheet("texture/Maelstrom.png",130,128);
    	SpriteSheet spriteSheetMegaStorm = new SpriteSheet("texture/MegaStorm.png",140,176);
    	SpriteSheet spriteSheetChest = new SpriteSheet("texture/Chest.png",32,32);
    	SpriteSheet spriteSheetKingGobelin = new SpriteSheet("texture/Floressia.png",320,320);
    	SpriteSheet spriteSheetCagnazzo = new SpriteSheet("texture/Cagnazzo.png",320,320);
    	SpriteSheet spriteSheetAntonio = new SpriteSheet("texture/Antonio.png",128,128);
    	SpriteSheet spriteSheetRicardo = new SpriteSheet("texture/Ricardo.png",128,128);
    	SpriteSheet spriteSheetBlackblop = new SpriteSheet("texture/Blackblop.png",128,128);
    	SpriteSheet spriteSheetGreenblop = new SpriteSheet("texture/Greenblop.png",128,128);
    	SpriteSheet spriteSheetRedblop = new SpriteSheet("texture/Redblop.png",128,128);
    	SpriteSheet spriteSheetBlueblop = new SpriteSheet("texture/Blueblop.png",128,128);
    	SpriteSheet spriteSheetDemons = new SpriteSheet("texture/Demons.png",128,128);
    	SpriteSheet spriteSheetDemonking = new SpriteSheet("texture/phase1.png",320,320);
    	SpriteSheet spriteSheetTrueDemonking = new SpriteSheet("texture/finalboss.png",320,320);
    	SpriteSheet spriteSheetForm = new SpriteSheet("texture/transform.png",320,320);
    	//Transform animation for last boss
    	Animation animations[] = new Animation[1];
        animations[0] = loadAnimation(spriteSheetForm, 0, 30, 0);
        imageasset.DemonKing2.setTrans(animations);
    	//Enemy animations
    	this.setEnemyAnimation(spriteSheetKnight, 3, imageasset.knight);
    	this.setEnemyAnimation(spriteSheetGobelin, 2, imageasset.gobelin);
    	this.setEnemyAnimation(spriteSheetAntonio, 12, imageasset.Antonio);
    	this.setEnemyAnimation(spriteSheetRicardo, 10, imageasset.Ricardo);
    	this.setEnemyAnimation(spriteSheetBlackblop, 7, imageasset.Blackblop);
    	this.setEnemyAnimation(spriteSheetBlueblop, 7, imageasset.Blueblop);
    	this.setEnemyAnimation(spriteSheetGreenblop, 7, imageasset.Greenblop);
    	this.setEnemyAnimation(spriteSheetRedblop, 7, imageasset.Redblop);
    	this.setEnemyAnimation(spriteSheetDemons, 7, imageasset.Demons);
    	//Boss animations
    	this.setBossAnimation(spriteSheetKingGobelin, 10, imageasset.KingGobelin);
    	this.setBossAnimation(spriteSheetCagnazzo, 21, imageasset.Cagnazzo);
    	this.setBossAnimation(spriteSheetDemonking, 8, imageasset.DemonKing1);
    	this.setBossAnimation(spriteSheetTrueDemonking, 17, imageasset.DemonKing2);
    	//SpellAnimations
    	this.setSpellAnimation(spriteSheetBooster, 10, imageasset.boosterI);
    	this.setSpellAnimation(spriteSheetFire, 6, imageasset.fireI);
    	this.setSpellAnimation(spriteSheetFire, 6, imageasset.fireII);
    	this.setSpellAnimation(spriteSheetFire, 6, imageasset.fireIII);
    	this.setSpellAnimation(spriteSheetUltima, 4, imageasset.Ultima);
    	this.setSpellAnimation(spriteSheetMaelStrom, 5, imageasset.MaelStrom);
    	this.setSpellAnimation(spriteSheetMegaStorm, 8, imageasset.MegaStorm);
    	this.setSpellAnimation(spriteSheetWaterSpike, 3, imageasset.WaterSpike);
    	this.setSpellAnimation(spriteSheetHeal, 5, imageasset.healI);
    	this.setSpellAnimation(spriteSheetHeal, 5, imageasset.healII);
    	this.setSpellAnimation(spriteSheetHeal, 5, imageasset.healIII);
    	//Chest animations
    	this.setChestAnimation(spriteSheetChest, 12, imageasset.chest1, imageasset);
    }
    public void setEnemyAnimation(SpriteSheet spriteSheet, int numberOfFrame, Enemie enemie) {
    	Animation animations[] = new Animation[2];
        animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
        animations[1] = loadAnimation(spriteSheet, 1, numberOfFrame, 0);
        enemie.setBattleanim(animations);
    	
    }
    public void setSpellAnimation(SpriteSheet spriteSheet, int numberOfFrame, Spells spell) {
    	Animation animations[] = new Animation[1];
        animations[0] = loadAnimation(spriteSheet, 0, numberOfFrame, 0);
    	spell.setAnimation(animations);
    }
   
    public void setBossAnimation(SpriteSheet spriteSheet, int numberOfFrame, Boss boss) {
    	Animation animations[] = new Animation[3];
    	animations[0] = loadAnimation(spriteSheet, 0, numberOfFrame, 1);
    	animations[1] = loadAnimation(spriteSheet, 0, numberOfFrame, 0);
    	animations[2] = loadAnimation(spriteSheet, 0, numberOfFrame, 2);
    	boss.setBattleanim(animations);
    }
    public void setChestAnimation(SpriteSheet spriteSheet, int numberOfFrame, Chest chest, GameAsset imageasset) {
    	Animation animations[] = new Animation[3];
        animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
        animations[1] = loadAnimation(spriteSheet, 1, numberOfFrame, 0);
        animations[2] = loadAnimation(spriteSheet, numberOfFrame-1, numberOfFrame, 0);
        chest.setAnimations(animations);
        imageasset.chest2.setAnimations(animations);
        imageasset.chest3.setAnimations(animations);
        imageasset.chest4.setAnimations(animations);
        imageasset.chest5.setAnimations(animations);
    }


}
