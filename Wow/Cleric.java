package lb223qk_assign2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cleric extends Character {

	Set<Spell> knownSpellsCleric = new HashSet<Spell>();

	Cleric(String name, int level, Attributes attributes) {
		super(name, "Cleric", level, attributes);
	}

	// strength, agility etc
	public Attribute getPrimaryAttribute() {
		return attributes.getWisdom();
	}

	// list of already known spells
	public List<Spell> getKnownSpells() {

		return new ArrayList<>(this.knownSpellsCleric);
	}

	// learn a spell
	public void learnSpell(Spell spell) {
		if (spell.getSchool().equals("Restoration") || spell.getSchool().equals("Divination")) {
			knownSpellsCleric.add(spell);
			System.out.println("Cleric learned: " + spell.getName());
		}

		else {
			System.out.println("Wrong school");
		}
	}

}