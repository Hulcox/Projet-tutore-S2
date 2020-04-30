package lesson1;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Map {
	private TiledMap map;
	private boolean IsEncounter;
	private ArrayList<Enemie> encounters;
	private Image battleImg;
	private String name;
	public TiledMap getMap() {
		return map;
	}
	public void setTildeMap(TiledMap tiled) {
		this.map = tiled;
	}
	public Map(String map, boolean IsEncounter, Image battleImg, String name) throws SlickException{
		this.map = new TiledMap("map/" + map);
		this.IsEncounter = IsEncounter;
		this.encounters = new ArrayList<Enemie>();
		this.battleImg = battleImg;
		this.name = name;
	}
	public void addEncounrers (Enemie enemie) {
		this.encounters.add(enemie);
	}
	public Image getBattleImg() {
		return battleImg;
	}
	public ArrayList<Enemie> getArrayList(){
		return this.encounters;
	}
	public String getName() {
		return name;
	}
	public boolean isIsEncounter() {
		return IsEncounter;
	}



}
