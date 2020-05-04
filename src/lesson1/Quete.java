package lesson1;

public class Quete {
	private Objets loot;
	private int number;
	private KeyItem reward;
	private int ID;
	private boolean Complete = false;
	public Quete(Objets loot, int number, KeyItem reward, int ID) {
		this.loot = loot;
		this.number = number;
		this.reward = reward;
		this.ID  = ID;
	}
	public Objets getLoot() {
		return loot;
	}
	public void setLoot(MonsterDrop loot) {
		this.loot = loot;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public KeyItem getReward() {
		return reward;
	}

	public int getID() {
		return ID;
	}
	public boolean isComplete() {
		return Complete;
	}
	public void setComplete(boolean complete) {
		Complete = complete;
	}

	

	

}
