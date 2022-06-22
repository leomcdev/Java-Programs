package lb223qk_assign2;

//spells
class Spell {

	// spellname and its school
	String spellName;
	String schoolName;

	Spell() {
	};

	Spell(String spellName, String schoolName) {
		this.schoolName = schoolName;
		this.spellName = spellName;
	}

	public void setName(String spellName) {
		this.spellName = spellName;
	}

	public String getName() {
		return this.spellName;
	}

	public String getSchool() {
		return schoolName;
	}

	public void setSchool(String schoolName) {
		this.schoolName = schoolName;
	}

}