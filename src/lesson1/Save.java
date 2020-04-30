package lesson1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
	private Player player;
	private GameAsset gameasset;
	public Save(Player player) {
		this.player = player;
	}
	
	
	public void SaveData() {
	    try {
	        FileWriter myWriter = new FileWriter("save/savedata.txt");
	        myWriter.write(Integer.toString(this.player.getPv()) + "\n"); // line 0
	        myWriter.write(Integer.toString(this.player.getMaxPV()) + "\n"); // line 1
	        myWriter.write(Integer.toString(this.player.getMana()) + "\n"); // line 2
	        myWriter.write(Integer.toString(this.player.getMaxMana()) + "\n"); // line 3
	        myWriter.write(Integer.toString(this.player.getDamage()) + "\n"); // line 4
	        myWriter.write(Integer.toString(this.player.getBaseDamage()) + "\n"); // line 5
	        myWriter.write(Integer.toString(this.player.getMoney()) + "\n"); // line 6
	        myWriter.write(Double.toString(this.player.getX()) + "\n"); // line 7
	        myWriter.write(Double.toString(this.player.getY()) + "\n"); // line 8
	        myWriter.write(Double.toString(this.player.getCamera().getxCam()) + "\n"); // line 9
	        myWriter.write(Double.toString(this.player.getCamera().getyCam()) + "\n"); // line 10
	        myWriter.write(this.player.getMap().getName() + "\n"); //line 11
	        
	        myWriter.close();
	        System.out.println("Successfully saved the game");
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}
	
	
	public void LoadData() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("save/savedata.txt"));
		String line;
		int nbline = 0;
		while ((line = in.readLine()) != null)
		{
			switch (nbline) {
			case 0: this.player.setPv(Integer.parseInt(line)); break;
			case 1: this.player.setMaxPV(Integer.parseInt(line)); break;
			case 2: this.player.setMana(Integer.parseInt(line)); break;
			case 3: this.player.setMaxMana(Integer.parseInt(line)); break;
			case 4: this.player.setDamage(Integer.parseInt(line)); break;
			case 5: this.player.setBaseDamage(Integer.parseInt(line)); break;
			case 6: this.player.setMoney(Integer.parseInt(line)); break;
			case 7: this.player.setX(Float.parseFloat(line)); break;
			case 8: this.player.setY(Float.parseFloat(line)); break;
			case 9: this.player.getCamera().setxCam(Float.parseFloat(line)); break;
			case 10: this.player.getCamera().setyCam(Float.parseFloat(line)); break;
			case 11: this.player.setMap(this.gameasset.searchMap(line)); break;
			
			}
			nbline++;

		}
		in.close();
	}


	public GameAsset getGameasset() {
		return gameasset;
	}


	public void setGameasset(GameAsset gameasset) {
		this.gameasset = gameasset;
	}

}
