package lesson1;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;

public class Boss extends Enemie {

    private Spells Spell1;
    private Spells Spell2;
    private Spells Spell3;
    private Spells currentSpell;
    private int BaseDamage;
    private Image image;
    private int ID;
    private int x, y;
    private boolean isDefeated = false;
    private boolean Trigger = true;
    private Music music;
    public void setDamage(int damage) {
    	this.pv = damage;
        if(this.pv < (this.maxHp-(this.maxHp*0.49))) {
            this.currentSpell = this.Spell3;
        }
        else if(this.pv < (this.maxHp-(this.maxHp*0.24))) {
            this.currentSpell = this.Spell2;
        }
    }
    public Spells getSpell1() {
        return Spell1;
    }

    public void setSpell1(Spells spell1) {
        if(pv > (pv-(pv*0.24))) {
            Spell1 = spell1;
        }
    }

    public Spells getSpell2() {
        return Spell2;
    }

    public void setSpell2(Spells spell2) {
        if(pv > (pv-(pv*0.49))) {
            Spell2 = spell2;
        }
    }

    public Spells getSpell3() {
        return Spell3;
    }

    public void setSpell3(Spells spell3) {
        if(pv > (pv-(pv*0.74))) {
            Spell3 = spell3;
        }
    }

    
    public Boss(int pv, int degats, int level, String name, MonsterDrop loot, Spells Spell1, Spells Spell2, Spells Spell3,Music music, int ID) {
        super(pv, degats, level, name, loot);
        this.BaseDamage = degats;
        this.Spell1 = Spell1;
        this.setCurrentSpell(Spell1);
        this.Spell2 = Spell2;
        this.Spell3 = Spell3;
        this.ID = ID;
        this.music = music;

    }
    public void render(GameContainer container, Graphics g) {
    	g.drawImage(image, x,y);
    }

	public Spells getCurrentSpell() {
		return currentSpell;
	}

	public void setCurrentSpell(Spells currentSpell) {
		this.currentSpell = currentSpell;
	}
	public int getBaseDamage() {
		return BaseDamage;
	}
	public void setBaseDamage(int baseDamage) {
		BaseDamage = baseDamage;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public boolean isDefeated() {
		return isDefeated;
	}
	public void setDefeated(boolean isDefeated) {
		this.isDefeated = isDefeated;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Music getMusic() {
		return music;
	}
	public void setMusic(Music music) {
		this.music = music;
	}
	public boolean isTrigger() {
		return Trigger;
	}
	public void setTrigger(boolean trigger) {
		Trigger = trigger;
	}

}
