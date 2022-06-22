package lb223qk_assign2;

//returns the score
class Attributes {
	Attribute strength;
	Attribute agility;
	Attribute intelligence;
	Attribute wisdom;

	public Attributes(Attribute strength, Attribute agility, Attribute intelligence, Attribute wisdom) {
		this.strength = strength;
		this.agility = agility;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
	}

	public int getStrengthScore() {
		return strength.getScore();
	}

	public int getAgilityScore() {
		return agility.getScore();
	}

	public int getIntelligenceScore() {
		return intelligence.getScore();
	}

	public int getWisdomScore() {
		return wisdom.getScore();
	}

	public Attribute getStrength() {
		return strength;
	}

	public Attribute getAgility() {
		return agility;
	}

	public Attribute getIntelligence() {
		return intelligence;
	}

	public Attribute getWisdom() {
		return wisdom;
	}

	public void setStrengthScore(int strengthScore) {
		this.strength.setScore(strengthScore);
	}

	public void setAgilityScore(int agilityScore) {
		this.agility.setScore(agilityScore);
	}

	public void setIntelligenceScore(int intelligenceScore) {
		this.intelligence.setScore(intelligenceScore);
	}

	public void setWisdomScore(int wisdomScore) {
		this.wisdom.setScore(wisdomScore);
	}
}