package lb223qk_assign2;

public class Battle {

	int level;
	int totalAmountOfSpells;
	int totalAmountOfAbilities;
	String className;
	String name;
	String spellName;

	// denna ska ba printa
	// prints
	public static void printStatistics(Character party[]) {
	
		System.out.println("\n");
		getTotalSpells(party);
		getTotalAbilities(party);
	}

	// get the avg level
	static int getAveragelevel(Character party[]) {

		int averageLevel = 0;
		int totalLevel = 0;
		// avg level of party
		for (int i = 0; i < party.length; i++) {
			Character partyMember = party[i];
			totalLevel += partyMember.getLevel();
		}
		averageLevel = totalLevel /= party.length;
		return averageLevel;
	}

	// get total spells
	static void getTotalSpells(Character party[]) {

		int mageSpells = 0;
		int clericSpells = 0;
		int totalSpells = 0;

		for (int i = 0; i < party.length; i++) {
			if (party[i] instanceof Mage) {
				Mage FireMage = (Mage) party[i];
				mageSpells += FireMage.getKnownSpells().size();
			}
			if (party[i] instanceof Cleric) {
				Cleric Cler = (Cleric) party[i];
				clericSpells += Cler.getKnownSpells().size();
			}
			totalSpells = mageSpells + clericSpells;
		}
		System.out.println("Mage spells: " + mageSpells);
		System.out.println("Cleric spells: " + clericSpells);
		System.out.println("Total spells: " + totalSpells);
	}

	static void getTotalAbilities(Character party[]) {

		int warriorAbilities = 0;
		int rogueAbilities = 0;
		int totalAbilities = 0;

		for (int i = 0; i < party.length; i++) {
			if (party[i] instanceof Warrior) {
				Warrior warr = (Warrior) party[i];
				warriorAbilities += warr.getKnownAbilities().size();
			}
			if (party[i] instanceof Rogue) {
				Rogue rog = (Rogue) party[i];
				rogueAbilities += rog.getKnownAbilities().size();
			}
			totalAbilities = warriorAbilities + rogueAbilities;
		}
		System.out.println("Warrior abilities: " + warriorAbilities);
		System.out.println("Rogue Abilities: " + rogueAbilities);
		System.out.println("Total Abilities: " + totalAbilities);
	}


	// return winning party
	public static Character[] resolve(Character party1[], Character party2[]) {
		Character winningParty[] = null;

		// most characters win
		if (party1.length > party2.length) {
			System.out.println("party 1 wins");
			winningParty = party1;
		}
		if (party2.length > party1.length) {
			System.out.println("party 2 wins");
			winningParty = party2;
		}

		// if its the same amount of characters check avg level
		if (party1.length == party2.length) {
			int avgLevelP1 = getAveragelevel(party1);
			int avgLevelP2 = getAveragelevel(party2);
			if (avgLevelP1 < avgLevelP2) {
				System.out.println("P2 wins");
				winningParty = party2;

			} else if (avgLevelP2 < avgLevelP1) {
				System.out.println("P1 wins");
				winningParty = party1;
			} else {
				int sumPrimaryAttributesP1 = 0;
				int sumPrimaryAttributesP2 = 0;

				for (int i = 0; i < party1.length; i++) {
					sumPrimaryAttributesP1 += party1[i].getPrimaryAttribute().getScore();
					sumPrimaryAttributesP2 += party2[i].getPrimaryAttribute().getScore();
				}
				if (sumPrimaryAttributesP1 < sumPrimaryAttributesP2) {
					System.out.println("P2 wins");
					winningParty = party2;
				} else if (sumPrimaryAttributesP1 > sumPrimaryAttributesP2) {
					System.out.println("P1 wins");
					winningParty = party1;

				} else {
					System.out.println("Its a tie");
				}
			}
		}
		return winningParty;
	}

	// class versus class and returning winning character
	static Character singleCombat(Character c1, Character c2) {
		Character winningCharacter = null;

		if (c1.getLevel() < c2.getLevel()) {
			System.out.println("c2 wins");
			winningCharacter = c2;
		} else if (c2.getLevel() < c1.getLevel()) {
			System.out.println("c1 wins");
			winningCharacter = c1;
		} else {
			if (c1.getPrimaryAttribute().getScore() < c2.getPrimaryAttribute().getScore()) {
				System.out.println("c2 wins");
				winningCharacter = c2;
			} else if (c2.getPrimaryAttribute().getScore() < c1.getPrimaryAttribute().getScore()) {
				System.out.println("c1 wins");
				winningCharacter = c1;
			} else {
				if ((c1 instanceof Mage || c1 instanceof Cleric)
				 && (c2 instanceof Mage || c2 instanceof Cleric)) {
					int c1Spells = 0;
					int c2Spells = 0;
					if (c1 instanceof Mage) {
						Mage m1 = (Mage) c1;
						c1Spells = m1.getKnownSpells().size();
					} else if (c1 instanceof Cleric) {
						Cleric cler1 = (Cleric) c1;
						c1Spells = cler1.getKnownSpells().size();

					}
					if (c2 instanceof Mage) {
						Mage m1 = (Mage) c2;
						c2Spells = m1.getKnownSpells().size();
					} else if (c2 instanceof Cleric) {
						Cleric cler1 = (Cleric) c2;
						c2Spells = cler1.getKnownSpells().size();
					}
					if (c1Spells < c2Spells) {
						System.out.println("c2 wins");
						winningCharacter = c2;
					} else if (c2Spells < c1Spells) {
						System.out.println("c1 wins");
						winningCharacter = c1;
					} else {
						System.out.println("tie");
					}
				} else if ((c1 instanceof Mage || c1 instanceof Cleric)
						&& (c2 instanceof Warrior || c2 instanceof Rogue)) {
					System.out.println("tie");

				} else if ((c2 instanceof Mage || c2 instanceof Cleric)
						&& (c1 instanceof Warrior || c1 instanceof Rogue)) {
					System.out.println("tie");

				} else if ((c1 instanceof Warrior || c1 instanceof Rogue)
						&& (c2 instanceof Warrior || c2 instanceof Rogue)) {
					// add winner when implemented abilities
					int c1Abilities = 0;
					int c2Abilities = 0;
					if (c1 instanceof Warrior) {
						Warrior w = (Warrior) c1;
						c1Abilities = w.getKnownAbilities().size();
					} else if (c1 instanceof Rogue) {
						Rogue r = (Rogue) c1;
						c1Abilities = r.getKnownAbilities().size();

					}
					if (c2 instanceof Warrior) {
						Warrior w = (Warrior) c2;
						c2Abilities = w.getKnownAbilities().size();
					} else if (c2 instanceof Rogue) {
						Rogue r = (Rogue) c2;
						c2Abilities = r.getKnownAbilities().size();
					}
					if (c1Abilities < c2Abilities) {
						System.out.println("c2 wins");
						winningCharacter = c2;
					} else if (c2Abilities < c1Abilities) {
						System.out.println("c1 wins");
						winningCharacter = c1;
					} else {
						System.out.println("tie");
					}
				}
			}
		}
		return winningCharacter;
	}

}
