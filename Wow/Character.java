package lb223qk_assign2;

//get names, level and primary attributes
class Character {

	String className;
	String name;
	int level;
	Attributes attributes;
	String school;

	Character(String name, String className, int level, Attributes attributes) {
		this.name = name;
		this.className = name;
		this.level = level;
		this.attributes = attributes;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	// strength, agility etc
	public Attribute getPrimaryAttribute() {
		return attributes.getStrength();
	}
}
