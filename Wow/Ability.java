package lb223qk_assign2;

//abilities
class Ability {

	String abilityName;
	String proficiency;
	int level;

	Ability() {
	}

	Ability(String abilityName, String proficiency) {
		this.abilityName = abilityName;
		this.proficiency = proficiency;
	}

	public void setName(String abilityName) {
		this.abilityName = abilityName;
	}

	public String getName() {
		return abilityName;
	}

	public void setProficiency(String proficiency) {
		this.proficiency = proficiency;
	}

//strength, agility etc
	public String getProficiency() {
		return proficiency;
	}
}