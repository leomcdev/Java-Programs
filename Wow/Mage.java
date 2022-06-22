package lb223qk_assign2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mage extends Character {

	// spellbook
	Set<Spell> knownSpellsMage = new HashSet<Spell>();

	Mage(String name, int level, Attributes attributes) {
		super(name, "Mage", level, attributes);
	}

	// strength, agility etc
	public Attribute getPrimaryAttribute() {
		return attributes.getIntelligence();
	}

	// list of already known spells
	public List<Spell> getKnownSpells() {
		return new ArrayList<>(this.knownSpellsMage);
	}

	// learn a spell
	public void learnSpell(Spell spell) {
		if (spell.getSchool().equals("Alteration") || spell.getSchool().equals("Evocation")) {
			knownSpellsMage.add(spell);
			System.out.println("Mage learned: " + spell.getName());
		}
		else {
			System.out.println("Wrong school");
		}
	}
}