package lb223qk_assign2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Warrior extends Character {

	Set<Ability> knownAbilitesWarrior = new HashSet<Ability>();

	Warrior(String name, int level, Attributes attributes) {
		super(name, "Warrior", level, attributes);
	}

	// strength, agility etc
	public Attribute getPrimaryAttribute() {
		return attributes.getStrength();
	}

	// list of already known abilities
	public List<Ability> getKnownAbilities() {
		return new ArrayList<>(this.knownAbilitesWarrior);
	}

	// learn ability
	public void learnAbility(Ability ability) {
		if (ability.getProficiency().equals("Athletics") ||
				ability.getProficiency().equals("Survival")) {
			knownAbilitesWarrior.add(ability);
			System.out.println("Warrior learned: " + ability.getName());
		}

		else {
			System.out.println("Wrong proficiency");
		}
	}
}