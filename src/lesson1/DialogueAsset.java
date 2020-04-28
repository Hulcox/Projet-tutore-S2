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

public class DialogueAsset {
	private Image image;
	private String Text = "";
	private String personne;
	private ArrayList<String> textcol;
	private int Index = 0;
	public DialogueAsset (String personne) throws SlickException, IOException {
		this.setTextcol(new ArrayList<String>());
		this.image = new Image("texture/DialogueBox.png");
		this.personne = personne;
		this.AssignText();
	}
	
	public void render (GameContainer container, Graphics g) {
		Font font = g.getFont();
		g.resetTransform();
		g.drawImage(image,0,380);
		if (this.Index < this.textcol.size())
			font.drawString( 10, 390,this.personne + " : " + this.textcol.get(this.Index),Color.white);
		else 
			this.Index = 0;
		
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

}
