package joyfe.gamesMiniverse.secondaryClasses;

public class Achievement {
	private long id;
	private String name;
	
	public Achievement(long _id, String _name) {
		this.id = _id;
		this.name = _name;
	}
	
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
	
}
