package lesson1;



import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class DialogueAsset {
	private Image image;
	private String Text;
	private String personne;
	private ArrayList<String> textcol;
	public DialogueAsset(String Text, String personne) throws SlickException {
		this.setTextcol(new ArrayList<String>());
		this.image = new Image("texture/DialogueBox.png");
		this.Text = Text;
		this.personne = personne;
	}
	
	public void render (GameContainer container, Graphics g) {
		Font font = g.getFont();
		g.resetTransform();
		g.drawImage(image,236,380);
		font.drawString( 246, 390,this.personne + " : " +this.Text,Color.white);
		
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

}
