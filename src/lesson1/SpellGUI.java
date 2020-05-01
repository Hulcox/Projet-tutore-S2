
package lesson1;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class SpellGUI implements ComponentListener{
	private Inventaire inventory;
	private ArrayList<Spells> Spells;
	private ArrayList<MouseOverArea> SpellsbuttonsList;
	private GameContainer container;
	private boolean IsOpen = false;
	public SpellGUI(GameContainer container, Inventaire inventory) {
		this.SpellsbuttonsList = new ArrayList<MouseOverArea>();
		this.Spells = new ArrayList<Spells>();
		this.container = container;
		this.inventory = inventory;
	}
	public void AddMouseOverArea(Spells spell) throws SlickException  {
		Image buttonImage = new Image("texture/buttons.png");
		Spells.add(spell);
		SpellsbuttonsList.add(new MouseOverArea(this.container, buttonImage, 0,0,this));

		
		
	}
	 public void render(GameContainer container, Graphics g) {
			 g.resetTransform();
			 int j = 0;
			 int x = 400, y = 0;
				  for (MouseOverArea i : SpellsbuttonsList) {
					i.setX(x);
					i.setY(y);
					i.render(container, g);
					g.drawString(Spells.get(j).getNom() + " : " + Spells.get(j).getManaCost(), i.getX()+10, i.getY()+5);
					j++;
					if (y <= 400) {
						y += 40;
					}
					else {
						y = 160;
						x+= 160;
					}
					
					
				  }
		 }
	 
	public void reset() {
		this.SpellsbuttonsList = new ArrayList<MouseOverArea>();
		this.Spells = new ArrayList<Spells>();
	}

	public Inventaire getInventory() {
		return inventory;
	}
	public void setInventory(Inventaire inventory) {
		this.inventory = inventory;
	}
	public ArrayList<Spells> getSpells() {
		return Spells;
	}
	public void setSpells(ArrayList<Spells> spells) {
		Spells = spells;
	}
	public boolean isIsOpen() {
		return IsOpen;
	}
	public void setIsOpen(boolean isOpen) {
		IsOpen = isOpen;
	}
	@Override
	public void componentActivated(AbstractComponent source) {
		int j = 0;
		for (MouseOverArea i : SpellsbuttonsList) {
			if (source == i){
				if(this.inventory.getPlayer().getMana()-this.Spells.get(j).getManaCost() >= 0) {
					if (this.Spells.get(j).getTypeSpell() == "booster") {
						Booster boostertemp = (Booster) this.Spells.get(j);
						this.inventory.getPlayer().setDamage(this.inventory.getPlayer().getDamage()*boostertemp.getModificateur());
						this.inventory.getPlayer().setSpell(boostertemp);
						this.inventory.getPlayer().setCasting(true);
						this.IsOpen = false;
						this.inventory.getPlayer().setAnimstate(1);
					}
					else if (this.Spells.get(j).getTypeSpell() == "damagespell") {
						DamageSpell damageSpellTemp = (DamageSpell) this.Spells.get(j);
						this.inventory.getPlayer().setDamage(this.inventory.getPlayer().getBaseDamage()+damageSpellTemp.getDegats());
						this.inventory.getPlayer().setSpell(damageSpellTemp);
						this.inventory.getPlayer().setCasting(true);
						this.IsOpen = false;
						this.inventory.getPlayer().setAnimstate(1);
					}
					this.inventory.getPlayer().setMana(this.inventory.getPlayer().getMana()-this.Spells.get(j).getManaCost());
				}


			}
			j++;
		}
		
	}

}
