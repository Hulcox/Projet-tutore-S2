package lesson1;

public class Boss extends Enemie {

    private Spells Spell1;
    private Spells Spell2;
    private Spells Spell3;
    private Spells currentSpell;
    private int BaseDamage;
    
    
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

    
    public Boss(int pv, int degats, int level, String name, MonsterDrop loot, Spells Spell1, Spells Spell2, Spells Spell3) {
        super(pv, degats, level, name, loot);
        this.BaseDamage = degats;
        this.Spell1 = Spell1;
        this.setCurrentSpell(Spell1);
        this.Spell2 = Spell2;
        this.Spell3 = Spell3;

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

}
