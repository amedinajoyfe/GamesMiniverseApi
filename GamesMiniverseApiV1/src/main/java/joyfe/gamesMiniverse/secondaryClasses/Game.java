package joyfe.gamesMiniverse.secondaryClasses;

public class Game {
	long id;
	String name;
	int[] highestScores = new int[5];
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getScores() {
		return highestScores;
	}
	public void addNewScore(int _newScore) {
		if(_newScore < highestScores[0]) {
			return;
		}
		for (int i = 0; i < highestScores.length; i++) {
			if(_newScore > highestScores[i]) {
				continue;
			}
			
		}
	}
}