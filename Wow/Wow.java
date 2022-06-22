package lb223qk_assign2;

// tests
public class Wow {

	public static void main(String[] args) {

		Character party1[] = new Character[2];
		Character party2[] = new Character[2];

		// mage spells
		Spell m1 = new Spell("Ice", "Alteration");
		Spell m2 = new Spell("Fire", "Evocation");
		Spell m3 = new Spell("Freeze", "Evocation");
		Spell m4 = new Spell("Wave", "Evocation");

		// cleric spells
		Spell c1 = new Spell("Smite", "Divination");
		Spell c2 = new Spell("Heal", "Restoration");
		Spell c3 = new Spell("Dmg", "Restoration");
		Spell c4 = new Spell("Atk", "Restoration");

		// warrior abilities
		Ability w1 = new Ability("Atk", "Athletics");
		Ability w2 = new Ability("Spear", "Athletics");
		Ability w3 = new Ability("Shield", "Survival");
		Ability w4 = new Ability("Crit", "Survival");

		// rogue abilities
		Ability r1 = new Ability("Slice", "Stealth");
		Ability r2 = new Ability("Cut", "Acrobatics");
		Ability r3 = new Ability("Snear", "Acrobatics");
		Ability r4 = new Ability("Dagger", "Stealth");

		Attribute fireMageStrength = new Attribute("Strength", 5);
		Attribute fireMageAgility = new Attribute("Agility", 5);
		Attribute fireMageIntelligence = new Attribute("Intelligence", 8);
		Attribute fireMageWisdom = new Attribute("Wisdom", 5);

		party2[0] = new Mage("FireMage", 5,
				new Attributes(fireMageStrength, fireMageAgility, fireMageIntelligence, fireMageWisdom));
		Mage FireMage = (Mage) party2[0];

		FireMage.learnSpell(m1);
		FireMage.learnSpell(m2);
		FireMage.learnSpell(m3);

		// cleric
		Attribute clericStrength = new Attribute("Strength", 5);
		Attribute clericAgility = new Attribute("Agility", 5);
		Attribute clericIntelligence = new Attribute("Intelligence", 5);
		Attribute clericWisdom = new Attribute("Wisdom", 7);

		party1[0] = new Cleric("ClericHealer", 5,
				new Attributes(clericStrength, clericAgility, clericIntelligence, clericWisdom));
		Cleric ClericHealer = (Cleric) party1[0];

		ClericHealer.learnSpell(c1);
		ClericHealer.learnSpell(c2);
		ClericHealer.learnSpell(c3);
		ClericHealer.learnSpell(c4);

		// Warrior
		Attribute warriorStrength = new Attribute("Strength", 8);
		Attribute warriorAgility = new Attribute("Agility", 5);
		Attribute warriorIntelligence = new Attribute("Intelligence", 5);
		Attribute warriorWisdom = new Attribute("Wisdom", 3);

		party1[1] = new Warrior("WarriorTank", 5,
				new Attributes(warriorStrength, warriorAgility, warriorIntelligence, warriorWisdom));
		Warrior WarriorTank = (Warrior) party1[1];

		WarriorTank.learnAbility(w1);
		WarriorTank.learnAbility(w2);
		WarriorTank.learnAbility(w3);
		WarriorTank.learnAbility(w4);

		// Rogue
		Attribute rogueStrength = new Attribute("Strength", 5);
		Attribute rogueAgility = new Attribute("Agility", 15);
		Attribute rogueIntelligence = new Attribute("Intelligence", 5);
		Attribute rogueWisdom = new Attribute("Wisdom", 7);

		party2[1] = new Rogue("RogueSlice", 5,
				new Attributes(rogueStrength, rogueAgility, rogueIntelligence, rogueWisdom));
		Rogue RogueSlice = (Rogue) party2[1];

		RogueSlice.learnAbility(r1);
		RogueSlice.learnAbility(r2);
		RogueSlice.learnAbility(r3);
		RogueSlice.learnAbility(r4);

		Battle.printStatistics(party1);
		Battle.resolve(party1, party2);

	}

}
