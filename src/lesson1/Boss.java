package lesson1;

public class Boss extends Enemie {

    private Spells Spell1;
    private Spells Spell2;
    private Spells Spell3;

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

        this.degats = degats;
        this.name = name;
        this.pv = pv;
        this.maxHp = pv;
        this.level = level;
        this.loot = loot;

        this.setSpell1(Spell1);
        this.setSpell2(Spell2);
        this.setSpell3(Spell3);
    }

}
