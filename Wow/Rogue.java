package lb223qk_assign2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rogue extends Character {

	Set<Ability> knownAbilitiesRogue = new HashSet<Ability>();

	Rogue(String name, int level, Attributes attributes) {
		super(name, "Rogue", level, attributes);
	}

	// strength, agility etc
	public Attribute getPrimaryAttribute() {
		return attributes.getAgility();
	}

	// list of already known attributes
	public List<Ability> getKnownAbilities() {
		return new ArrayList<>(this.knownAbilitiesRogue);
	}

	// learn attributes
	public void learnAbility(Ability ability) {
		if (ability.getProficiency().equals("Acrobatics") ||
			ability.getProficiency().equals("Stealth")) {
			knownAbilitiesRogue.add(ability);
			System.out.println("Rogue learned: " + ability.getName());
		}

		else {
			System.out.println("Wrong proficiency");
		}
	}
}