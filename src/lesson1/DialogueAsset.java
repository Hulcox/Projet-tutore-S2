package lesson1;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class DialogueAsset implements ComponentListener {
	private Image image;
	private String Text = "";
	private String personne;
	private ArrayList<String> textcol;
	private int Index = 0;
	private boolean HaveQuest, click;
	private Quete quete;
	private static final int Y_PADDING = 3; 
	private static final int X_PADDING = 13;
	private MouseOverArea confirm;
	public DialogueAsset (String personne, boolean HaveQuest) throws SlickException, IOException {
		this.setTextcol(new ArrayList<String>());
		this.image = new Image("texture/DialogueBox.png");
		this.personne = personne;
		this.AssignText();
		this.HaveQuest = HaveQuest;
	}
	public DialogueAsset (String personne, boolean HaveQuest, Quete quete, GameContainer container) throws SlickException, IOException {
		Image buttonImage = new Image("texture/buttons.png");
		this.setTextcol(new ArrayList<String>());
		this.image = new Image("texture/DialogueBox.png");
		this.personne = personne;
		this.AssignText();
		this.HaveQuest = HaveQuest;
		this.quete = quete;
		this.confirm = new MouseOverArea(container,buttonImage, this.image.getWidth(),380 ,this);
	}
	
	public void render (GameContainer container, Graphics g) {
		Font font = g.getFont();
		g.resetTransform();
		g.drawImage(image,0,380);
		if (this.Index < this.textcol.size())
			font.drawString( 10, 390,this.personne + " : " + this.textcol.get(this.Index),Color.white);
		else 
			this.Index = 0;
		
		if(this.quete.isComplete()) {
			this.HaveQuest = false;
			this.textcol = new ArrayList<String>();
			this.textcol.add("Quest complete reward : " + "\n" + this.quete.getReward().getNom());
		}
		if(this.isHaveQuest()) {
			this.confirm.render(container, g);
			g.drawString("Give", confirm.getX() + X_PADDING, confirm.getY() + Y_PADDING);
		}
		
	}
	private void AssignText() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("Dialogue/"+this.personne+".txt"));
		String line;
		String phraseTemp = "";
		int i = 0;
		while ((line = in.readLine()) != null)
		{
			if (i < 1) {
				phraseTemp = phraseTemp + line + "\n";
				i++;
			}
			else {
				phraseTemp = phraseTemp + line + "\n";
				textcol.add(phraseTemp);
				i = 0;
				phraseTemp = "";
				
			}
		}
		in.close();
	      
	}
	
	public void verifQuete(Player player) throws SlickException {
		if (this.click) {
			for (Objets m : player.getInventaire().getInventoryList()) {
					if(m.getNom().equals(this.quete.getLoot().getNom()) && m.getNumber() > this.quete.getNumber()) {
						player.getInventaire().AddObjet(this.quete.getReward());
						this.quete.setComplete(true);
						this.HaveQuest = false;
						m.setNumber(m.getNumber()-this.quete.getNumber());
						this.textcol = new ArrayList<String>();
						this.textcol.add("Quest complete reward : " + "\n" + this.quete.getReward().getNom());
					}
					else {
						this.click = false;
					}
				}
		}
		
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public String getPersonne() {
		return personne;
	}

	public void setPersonne(String personne) {
		this.personne = personne;
	}

	public ArrayList<String> getTextcol() {
		return textcol;
	}

	public void setTextcol(ArrayList<String> textcol) {
		this.textcol = textcol;
	}

	public int getIndex() {
		return Index;
	}

	public void setIndex(int index) {
		Index = index;
	}

	public boolean isHaveQuest() {
		return HaveQuest;
	}

	public void setHaveQuest(boolean haveQuest) {
		HaveQuest = haveQuest;
	}
	@Override
	public void componentActivated(AbstractComponent source) {
		if(source == confirm) {
			this.click = true;
		}
		
	}

}
