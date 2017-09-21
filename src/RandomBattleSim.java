import javax.swing.JOptionPane;

public class RandomBattleSim {

	public static void main(String[] args) {
		int roll = 0;
		int health, faith, stress, attack, defend, magic;
		String fullquirk = "";
		String fullquirk2 = "";
		String[] quirk = { "Hungry", "Masochist", "Unbeliever", "Awkward", "Weak", "Terrified", "Paranoid" };
		String fullname = "";
		String[] name = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
				"t", "u", "v", "w", "x", "y", "z" };
		do {

			int k = (int) (Math.random() * 26);
			roll = roll + 1;
			if (roll == 1) {
				fullname = fullname + name[k].toUpperCase();
			} else {
				fullname = fullname + name[k];
			}
		} while (roll < (int) (Math.random() * 5 + 3));

		String[] title = { "Mighty", "Bro", "Drunk", "Small", "Slightly Unshaven", "Old", "Unready", "Beardless",
				"Faithful", "Pious", "Red", "Purple", "Bonecrusher" };
		int l = (int) (Math.random() * 13);
		fullname = fullname + " the " + title[l];
		health = (int) (Math.random() * 30 + 100);
		faith = (int) (Math.random() * 16);
		stress = (int) (Math.random() * 16);
		attack = (int) (Math.random() * 16);
		defend = (int) (Math.random() * 16);
		magic = (int) (Math.random() * 16);
		JOptionPane.showMessageDialog(null, fullname + " has " + health + " health, " + faith + " faith,\n" + stress
				+ " stress, " + attack + " attack,\n" + defend + " defend, and " + magic + " magic.");

		int roll2 = 0;
		int health2, faith2, stress2, attack2, defend2, magic2;
		String fullname2 = "";

		do {

			int k = (int) (Math.random() * 26);
			roll2 = roll2 + 1;
			if (roll2 == 1) {
				fullname2 = fullname2 + name[k].toUpperCase();
			} else {
				fullname2 = fullname2 + name[k];
			}
		} while (roll2 < (int) (Math.random() * 5 + 3));

		int l2 = (int) (Math.random() * 13);
		fullname2 = fullname2 + " the " + title[l2];
		health2 = (int) (Math.random() * 30 + 100);
		faith2 = (int) (Math.random() * 16);
		stress2 = (int) (Math.random() * 16);
		attack2 = (int) (Math.random() * 16);
		defend2 = (int) (Math.random() * 16);
		magic2 = (int) (Math.random() * 16);
		JOptionPane.showMessageDialog(null, fullname2 + " has " + health2 + " health, " + faith2 + " faith,\n" + stress2
				+ " stress, " + attack2 + " attack,\n" + defend2 + " defend, and " + magic2 + " magic.");

		String[] weaponfirst = { "Orb", "Sword", "Staff", "Flask", "Dagger", "Pole", "Cleaver", "Halberd", "Scimitar",
				"Two-Handed Sword", "Hand Grenade", "Hatchet", "Javelin", "Axe", "Warhammer", "Dart", "Shield",
				"Reaper", "Sickle", "Mace", "Machete" };

		String[] weapondescription = { "Healing", "Attack", "Souls", "Fire", "Water", "Faith", "Earth", "Air", "Lust",
				"Greed", "Anger", "Death", "Scrying", "Blood", "Stress", "Love", "Defense", "Wrath", "Hearth",
				"Horror" };

		do {
			int k = (int) (Math.random() * 21);
			int a = (int) (Math.random() * 20);
			String weapon1 = weaponfirst[k] + " of " + weapondescription[a];
			k = (int) (Math.random() * 21);
			a = (int) (Math.random() * 20);
			String weapon2 = weaponfirst[k] + " of " + weapondescription[a];
			k = (int) (Math.random() * 21);
			a = (int) (Math.random() * 20);
			String weapon3 = weaponfirst[k] + " of " + weapondescription[a];
			String move;
			int fullmove;
			do {
				move = JOptionPane.showInputDialog(fullname + " approaches " + fullname2 + ".\nType 1 to use their "
						+ weapon1 + ", 2 to use their " + weapon2 + ", and 3 to use their " + weapon3 + ".");
				fullmove = Integer.parseInt(move);
			} while (fullmove < 1 || fullmove > 3);

			if (fullmove == 1) {
				a = (int) (Math.random() * 31 + attack);
				a = a - defend2;
				if (a < 0) {
					a = 0;
				}
				health2 = health2 - a;

				health2 = fixHealth2(health2);
				JOptionPane.showMessageDialog(null, fullname + " used their " + weapon1 + " and " + fullname2 + " lost "
						+ a + " hitpoints.\nTheir health is now " + health2 + ".");
				if (a > 30) {
					stress2 = stress2 + 5;
					JOptionPane.showMessageDialog(null, "Due to" + fullname + "'s powerful attack, " + fullname2
							+ " gained 5 stress.\nThey now have " + stress2 + " stress.");
				}
				if (weapon1.contains("Healing") || weapon1.contains("Flask")) {
					a = (int) (Math.random() * 6);
					health = health + a;
					JOptionPane.showMessageDialog(null,
							"Using their " + weapon1 + ", " + fullname + " was able to heal themself by " + a
									+ " hitpoints.\nTheir health is now " + health + ".");
				} 
				if (weapon1.contains("Attack") || weapon1.contains("Blood")) {
					health2 = health2 - attack;
					health2 = fixHealth2(health2);
					JOptionPane.showMessageDialog(null,
							"Using their " + weapon1 + ", " + fullname + " was able to deal additional damage.\n"
									+ fullname2 + " lost " + attack + " hitpoints. Their health is now " + health2
									+ ".");
				} else if (weapon1.contains("Fire") || weapon1.contains("Water") || weapon1.contains("Air")
						|| weapon1.contains("Earth")) {
					if (magic > 0) {
						health2 = health2 - magic;
						health2 = fixHealth2(health2);
						JOptionPane.showMessageDialog(null,
								"Using their knowledge of the mystic arts, " + fullname + " deals an extra " + magic
										+ " damage.\n" + fullname2 + "now has " + health2 + " health.");
					}
				} else if (weapon1.contains("Faith") || weapon1.contains("Souls")) {
					if (faith > 0) {
						health2 = health2 - faith;
						health2 = fixHealth2(health2);
						JOptionPane.showMessageDialog(null,
								"Using their faith in the gods above, " + fullname + " deals an additional " + faith
										+ " damage.\n" + fullname2 + " now has " + health2 + " health.");
					}
				} else if (weapon1.contains("Stress") || weapon1.contains("Horror")) {
					health2 = health2 - stress;
					health2 = fixHealth2(health2);
					JOptionPane.showMessageDialog(null,
							"Using their " + weapon1 + ", " + fullname
									+ " is able to use their stress to deal an additional " + stress + " damage.\n"
									+ fullname2 + " now has " + health2 + " health.");
					int add = (int) (Math.random() * 10 + 1);
					stress = stress + add;
					JOptionPane.showMessageDialog(null, "Due to using such a powerful weapon, " + fullname
							+ "'s stress increases by " + add + "\nTheir stress is now " + stress + ".");
					if (stress > 19) {

						a = (int) (Math.random() * 7);
						fullquirk = fullquirk + quirk[a];
						JOptionPane.showMessageDialog(null, "Due to " + fullname
								+ "'s high level of stress, they have gained the quirk: " + fullquirk + ".");
						if (fullquirk.contains("Hungry")) {
							health = quirkHungry(health, fullname);
						} else if (fullquirk.contains("Masochist")) {
							health = quirkMasochist(health, fullname);
						} else if (fullquirk.contains("Unbeliever")) {
							faith = quirkUnbeliever(faith, fullname);
						} else if (fullquirk.contains("Awkward")) {
							attack = quirkAwkward(attack, fullname);
						} else if (fullquirk.contains("Weak")) {
							defend = quirkWeak(defend, fullname);
						} else if (fullquirk.contains("Terrified")) {
							stress = quirkTerrified(stress, fullname);
						} else if (fullquirk.contains("Paranoid")) {
							health = health - 5;
							health = fixHealth(health);
							stress = stress + 20;
							JOptionPane.showMessageDialog(null,
									"Due to their paranoia, " + fullname
											+ " loses 5 health and gains 20 stress.\nThey now have " + health
											+ " health and " + stress + " stress.");
						}
						fullquirk = "";
					}
				}
			} else if (fullmove == 2) {
				a = (int) (Math.random() * 31 + attack);
				a = a - defend2;
				if (a < 0) {
					a = 0;
				}
				health2 = health2 - a;

				health2 = fixHealth2(health2);
				JOptionPane.showMessageDialog(null, fullname + " used their " + weapon2 + " and " + fullname2 + " lost "
						+ a + " hitpoints.\nTheir health is now " + health2 + ".");
				if (a > 30) {
					stress2 = stress2 + 5;
					JOptionPane.showMessageDialog(null, "Due to" + fullname + "'s powerful attack, " + fullname2
							+ " gained 5 stress.\nThey now have " + stress2 + " stress.");
				}
				if (weapon2.contains("Healing") || weapon2.contains("Flask")) {
					a = (int) (Math.random() * 10 + 1);
					health = health + a;
					JOptionPane.showMessageDialog(null,
							"Using their " + weapon2 + ", " + fullname + " was able to heal themself by " + a
									+ " hitpoints.\nTheir health is now " + health + ".");
				} 
				if (weapon2.contains("Attack") || weapon2.contains("Blood")) {
					health2 = health2 - attack;
					health2 = fixHealth2(health2);
					JOptionPane.showMessageDialog(null,
							"Using their " + weapon2 + ", " + fullname + " was able to deal additional damage.\n"
									+ fullname2 + " lost " + attack + " hitpoints. Their health is now " + health2
									+ ".");
				} else if (weapon2.contains("Fire") || weapon2.contains("Water") || weapon2.contains("Air")
						|| weapon2.contains("Earth")) {
					if (magic > 0) {
						health2 = health2 - magic;
						health2 = fixHealth2(health2);
						JOptionPane.showMessageDialog(null,
								"Using their knowledge of the mystic arts, " + fullname + " deals an extra " + magic
										+ " damage.\n" + fullname2 + "now has " + health2 + " health.");
					}
				} else if (weapon2.contains("Faith") || weapon2.contains("Souls")) {
					if (faith > 0) {
						health2 = health2 - faith;
						health2 = fixHealth2(health2);
						JOptionPane.showMessageDialog(null,
								"Using their faith in the gods above, " + fullname + " deals an additional " + faith
										+ " damage.\n" + fullname2 + " now has " + health2 + " health.");
					}
				} else if (weapon2.contains("Stress") || weapon2.contains("Horror")) {
					health2 = health2 - stress;
					health2 = fixHealth2(health2);
					JOptionPane.showMessageDialog(null,
							"Using their " + weapon2 + ", " + fullname
									+ " is able to use their stress to deal an additional " + stress + " damage.\n"
									+ fullname2 + " now has " + health2 + " health.");
					int add = (int) (Math.random() * 10 + 1);
					stress = stress + add;
					JOptionPane.showMessageDialog(null, "Due to using such a powerful weapon, " + fullname
							+ "'s stress increases by " + add + "\nTheir stress is now " + stress + ".");
					if (stress > 19) {

						a = (int) (Math.random() * 7);
						fullquirk = fullquirk + quirk[a];
						JOptionPane.showMessageDialog(null, "Due to " + fullname
								+ "'s high level of stress, they have gained the quirk: " + fullquirk + ".");
						if (fullquirk.contains("Hungry")) {
							health = quirkHungry(health, fullname);
						} else if (fullquirk.contains("Masochist")) {
							health = quirkMasochist(health, fullname);
						} else if (fullquirk.contains("Unbeliever")) {
							faith = quirkUnbeliever(faith, fullname);
						} else if (fullquirk.contains("Awkward")) {
							 attack = quirkAwkward(attack, fullname);
						} else if (fullquirk.contains("Weak")) {
							defend = quirkWeak(defend, fullname);
						} else if (fullquirk.contains("Terrified")) {
							stress = quirkTerrified(stress, fullname);
						} else if (fullquirk.contains("Paranoid")) {
							health = health - 5;
							health = fixHealth(health);
							stress = stress + 20;
							JOptionPane.showMessageDialog(null,
									"Due to their paranoia, " + fullname
											+ " loses 5 health and gains 20 stress.\nThey now have " + health
											+ " health and " + stress + " stress.");
						}
						fullquirk = "";
					}
				}
			} else {
				a = (int) (Math.random() * 31 + attack);
				a = a - defend2;
				if (a < 0) {
					a = 0;
				}
				health2 = health2 - a;
				health2 = fixHealth2(health2);
				JOptionPane.showMessageDialog(null, fullname + " used their " + weapon3 + " and " + fullname2 + " lost "
						+ a + " hitpoints.\nTheir health is now " + health2 + ".");
				if (a > 30) {
					stress2 = stress2 + 5;
					JOptionPane.showMessageDialog(null, "Due to" + fullname + "'s powerful attack, " + fullname2
							+ " gained 5 stress.\nThey now have " + stress2 + " stress.");
				}
				if (weapon3.contains("Healing") || weapon3.contains("Flask")) {
					a = (int) (Math.random() * 6);
					health = health + a;
					JOptionPane.showMessageDialog(null,
							"Using their " + weapon3 + ", " + fullname + " was able to heal themself by " + a
									+ " hitpoints.\nTheir health is now " + health + ".");
				} 
				if (weapon3.contains("Attack") || weapon3.contains("Blood")) {
					health2 = health2 - attack;
					health2 = fixHealth2(health2);
					JOptionPane.showMessageDialog(null,
							"Using their " + weapon3 + ", " + fullname + " was able to deal additional damage.\n"
									+ fullname2 + " lost " + attack + " hitpoints. Their health is now " + health2
									+ ".");
				} else if (weapon3.contains("Fire") || weapon3.contains("Water") || weapon3.contains("Air")
						|| weapon3.contains("Earth")) {
					if (magic > 0) {
						health2 = health2 - magic;
						health2 = fixHealth2(health2);
						JOptionPane.showMessageDialog(null,
								"Using their knowledge of the mystic arts, " + fullname + " deals an extra " + magic
										+ " damage.\n" + fullname2 + "now has " + health2 + " health.");
					}
				} else if (weapon3.contains("Faith") || weapon3.contains("Souls")) {
					if (faith > 0) {
						health2 = health2 - faith;
						health2 = fixHealth2(health2);
						JOptionPane.showMessageDialog(null,
								"Using their faith in the gods above, " + fullname + " deals an additional " + faith
										+ " damage.\n" + fullname2 + " now has " + health2 + " health.");
					}
				} else if (weapon3.contains("Stress") || weapon3.contains("Horror")) {
					health2 = health2 - stress;
					health2 = fixHealth2(health2);
					JOptionPane.showMessageDialog(null,
							"Using their " + weapon3 + ", " + fullname
									+ " is able to use their stress to deal an additional " + stress + " damage.\n"
									+ fullname2 + " now has " + health2 + " health.");
					int add = (int) (Math.random() * 10 + 1);
					stress = stress + add;
					JOptionPane.showMessageDialog(null, "Due to using such a powerful weapon, " + fullname
							+ "'s stress increases by " + add + "\nTheir stress is now " + stress + ".");
					if (stress > 19) {

						a = (int) (Math.random() * 7);
						fullquirk = fullquirk + quirk[a];
						JOptionPane.showMessageDialog(null, "Due to " + fullname
								+ "'s high level of stress, they have gained the quirk: " + fullquirk + ".");
						if (fullquirk.contains("Hungry")) {
							health = quirkHungry(health, fullname);
						} else if (fullquirk.contains("Masochist")) {
							health = quirkMasochist(health, fullname);
						} else if (fullquirk.contains("Unbeliever")) {
							faith = quirkUnbeliever(faith, fullname);
						} else if (fullquirk.contains("Awkward")) {
							attack = quirkAwkward(attack, fullname);
						} else if (fullquirk.contains("Weak")) {
							defend = quirkWeak(defend, fullname);
						} else if (fullquirk.contains("Terrified")) {
							stress = quirkTerrified(stress, fullname);
						} else if (fullquirk.contains("Paranoid")) {
							health = health - 5;
							health = fixHealth(health);
							stress = stress + 20;
							JOptionPane.showMessageDialog(null,
									"Due to their paranoia, " + fullname
											+ " loses 5 health and gains 20 stress.\nThey now have " + health
											+ " health and " + stress + " stress.");
						}
						fullquirk = "";
					}
				}
			}
			if (health2 > 0) {
				k = (int) (Math.random() * 21);
				a = (int) (Math.random() * 20);
				weapon1 = weaponfirst[k] + " of " + weapondescription[a];
				k = (int) (Math.random() * 21);
				a = (int) (Math.random() * 20);
				weapon2 = weaponfirst[k] + " of " + weapondescription[a];
				k = (int) (Math.random() * 21);
				a = (int) (Math.random() * 20);
				weapon3 = weaponfirst[k] + " of " + weapondescription[a];
				do {
					move = JOptionPane.showInputDialog(fullname2 + " approaches " + fullname + ".\nType 1 to use their "
							+ weapon1 + ", 2 to use their " + weapon2 + ", and 3 to use their " + weapon3 + ".");
					fullmove = Integer.parseInt(move);
				} while (fullmove < 1 || fullmove > 3);

				if (fullmove == 1) {
					a = (int) (Math.random() * 31 + attack2);
					a = a - defend;
					if (a < 0) {
						a = 0;
					}
					health = health - a;

					health = fixHealth(health);
					JOptionPane.showMessageDialog(null, fullname2 + " used their " + weapon1 + " and " + fullname
							+ " lost " + a + " hitpoints.\nTheir health is now " + health + ".");
					if (a > 30) {
						stress = stress + 5;
						JOptionPane.showMessageDialog(null, "Due to" + fullname2 + "'s powerful attack, " + fullname
								+ " gained 5 stress.\nThey now have " + stress + " stress.");
					}
					if (weapon1.contains("Healing") || weapon1.contains("Flask")) {
						a = (int) (Math.random() * 6);
						health2 = health2 + a;
						JOptionPane.showMessageDialog(null,
								"Using their " + weapon1 + ", " + fullname2 + " was able to heal themself by " + a
										+ " hitpoints.\nTheir health is now " + health2 + ".");
					} 
					if (weapon1.contains("Attack") || weapon1.contains("Blood")) {
						health = health - attack2;
						health = fixHealth(health);
						JOptionPane.showMessageDialog(null,
								"Using their " + weapon1 + ", " + fullname2 + " was able to deal additional damage.\n"
										+ fullname + " lost " + attack2 + " hitpoints. Their health is now " + health
										+ ".");
					} else if (weapon1.contains("Fire") || weapon1.contains("Water") || weapon1.contains("Air")
							|| weapon1.contains("Earth")) {
						if (magic2 > 0) {
							health = health - magic2;
							JOptionPane.showMessageDialog(null,
									"Using their knowledge of the mystic arts, " + fullname2 + " deals an extra "
											+ magic2 + " damage.\n" + fullname + "now has " + health + " health.");
						}
					} else if (weapon1.contains("Faith") || weapon1.contains("Souls")) {
						if (faith2 > 0) {
							health = health - faith2;
							health = fixHealth(health);
							JOptionPane.showMessageDialog(null,
									"Using their faith in the gods above, " + fullname2 + " deals an additional "
											+ faith2 + " damage.\n" + fullname + " now has " + health + " health.");
						}
					} else if (weapon1.contains("Stress") || weapon1.contains("Horror")) {
						health = health - stress2;
						health = fixHealth(health);
						JOptionPane.showMessageDialog(null,
								"Using their " + weapon1 + ", " + fullname2
										+ " is able to use their stress to deal an additional " + stress2 + " damage.\n"
										+ fullname + " now has " + health + " health.");
						int add = (int) (Math.random() * 11);
						stress2 = stress2 + add;
						JOptionPane.showMessageDialog(null, "Due to using such a powerful weapon, " + fullname2
								+ "'s stress increases by " + add + "\nTheir stress is now " + stress2 + ".");
						if (stress2 > 19) {

							a = (int) (Math.random() * 7);
							fullquirk2 = fullquirk2 + quirk[a];
							JOptionPane.showMessageDialog(null, "Due to " + fullname2
									+ "'s high level of stress, they have gained the quirk: " + fullquirk2 + ".");
							if (fullquirk2.contains("Hungry")) {
								health2 = quirk2Hungry(health2, fullname2);
							} else if (fullquirk2.contains("Masochist")) {
								health2 = quirk2Masochist(health2, fullname2);
							} else if (fullquirk2.contains("Unbeliever")) {
								faith2 = quirk2Unbeliever(faith2, fullname2);
							} else if (fullquirk2.contains("Awkward")) {
								attack2 = quirk2Awkward(attack2, fullname2);
							} else if (fullquirk2.contains("Weak")) {
								defend2 = quirk2Weak(defend2, fullname2);
							} else if (fullquirk2.contains("Terrified")) {
								stress2 = quirk2Terrified(stress2, fullname2);
							} else if (fullquirk2.contains("Paranoid")) {
								health2 = health2 - 5;
								health2 = fixHealth2(health2);
								stress2 = stress2 + 20;
								JOptionPane.showMessageDialog(null,
										"Due to their paranoia, " + fullname2
												+ " loses 5 health and gains 20 stress.\nThey now have " + health2
												+ " health and " + stress2 + " stress.");
							}
							fullquirk2 = "";
						}
					}
				} else if (fullmove == 2) {
					a = (int) (Math.random() * 31 + attack2);
					a = a - defend;
					if (a < 0) {
						a = 0;
					}
					health = health - a;

					health = fixHealth(health);
					JOptionPane.showMessageDialog(null, fullname2 + " used their " + weapon2 + " and " + fullname
							+ " lost " + a + " hitpoints.\nTheir health is now " + health + ".");
					if (a > 30) {
						stress = stress + 5;
						JOptionPane.showMessageDialog(null, "Due to" + fullname2 + "'s powerful attack, " + fullname
								+ " gained 5 stress.\nThey now have " + stress + " stress.");
					}
					if (weapon2.contains("Healing") || weapon2.contains("Flask")) {
						a = (int) (Math.random() * 6);
						health2 = health2 + a;
						JOptionPane.showMessageDialog(null,
								"Using their " + weapon2 + ", " + fullname2 + " was able to heal themself by " + a
										+ " hitpoints.\nTheir health is now " + health2 + ".");
					} 
					if (weapon2.contains("Attack") || weapon2.contains("Blood")) {
						health = health - attack2;
						health = fixHealth(health);
						JOptionPane.showMessageDialog(null,
								"Using their " + weapon2 + ", " + fullname2 + " was able to deal additional damage.\n"
										+ fullname + " lost " + attack2 + " hitpoints. Their health is now " + health
										+ ".");
					} else if (weapon2.contains("Fire") || weapon2.contains("Water") || weapon2.contains("Air")
							|| weapon2.contains("Earth")) {
						if (magic2 > 0) {
							health = health - magic2;
							health = fixHealth(health);
							JOptionPane.showMessageDialog(null,
									"Using their knowledge of the mystic arts, " + fullname2 + " deals an extra "
											+ magic2 + " damage.\n" + fullname + "now has " + health + " health.");
						}
					} else if (weapon2.contains("Faith") || weapon2.contains("Souls")) {
						if (faith2 > 0) {
							health = health - faith2;
							health = fixHealth(health);
							JOptionPane.showMessageDialog(null,
									"Using their faith in the gods above, " + fullname2 + " deals an additional "
											+ faith2 + " damage.\n" + fullname + " now has " + health + " health.");
						}
					} else if (weapon2.contains("Stress") || weapon2.contains("Horror")) {
						health = health - stress2;
						health = fixHealth(health);
						JOptionPane.showMessageDialog(null,
								"Using their " + weapon2 + ", " + fullname2
										+ " is able to use their stress to deal an additional " + stress2 + " damage.\n"
										+ fullname + " now has " + health + " health.");
						int add = (int) (Math.random() * 10 + 1);
						stress2 = stress2 + add;
						JOptionPane.showMessageDialog(null, "Due to using such a powerful weapon, " + fullname2
								+ "'s stress increases by " + add + "\nTheir stress is now " + stress2 + ".");
						if (stress2 > 19) {

							a = (int) (Math.random() * 7);
							fullquirk2 = fullquirk2 + quirk[a];
							JOptionPane.showMessageDialog(null, "Due to " + fullname2
									+ "'s high level of stress, they have gained the quirk: " + fullquirk2 + ".");
							if (fullquirk2.contains("Hungry")) {
								health2 = quirk2Hungry(health2, fullname2);
							} else if (fullquirk2.contains("Masochist")) {
								health2 = quirk2Masochist(health2, fullname2);
							} else if (fullquirk2.contains("Unbeliever")) {
								faith2 = quirk2Unbeliever(faith2, fullname2);
							} else if (fullquirk2.contains("Awkward")) {
								attack2 = quirk2Awkward(attack2, fullname2);
							} else if (fullquirk2.contains("Weak")) {
								defend2 = quirk2Weak(defend2, fullname2);
							} else if (fullquirk2.contains("Terrified")) {
								stress2 = quirk2Terrified(stress2, fullname2);
							} else if (fullquirk2.contains("Paranoid")) {
								health2 = health2 - 5;
								health2 = fixHealth2(health2);
								stress2 = stress2 + 20;
								JOptionPane.showMessageDialog(null,
										"Due to their paranoia, " + fullname2
												+ " loses 5 health and gains 20 stress.\nThey now have " + health2
												+ " health and " + stress2 + " stress.");
							}
							fullquirk2 = "";
						}
					}
				} else {
					a = (int) (Math.random() * 31 + attack2);
					a = a - defend;
					if (a < 0) {
						a = 0;
					}
					health = health - a;

					health = fixHealth(health);
					JOptionPane.showMessageDialog(null, fullname2 + " used their " + weapon3 + " and " + fullname
							+ " lost " + a + " hitpoints.\nTheir health is now " + health + ".");
					if (a > 30) {
						stress = stress + 5;
						JOptionPane.showMessageDialog(null, "Due to" + fullname2 + "'s powerful attack, " + fullname
								+ " gained 5 stress.\nThey now have " + stress + " stress.");
					}
					if (weapon3.contains("Healing") || weapon3.contains("Flask")) {
						a = (int) (Math.random() * 6);
						health2 = health2 + a;
						JOptionPane.showMessageDialog(null,
								"Using their " + weapon3 + ", " + fullname2 + " was able to heal themself by " + a
										+ " hitpoints.\nTheir health is now " + health2 + ".");
					} 
					if (weapon3.contains("Attack") || weapon3.contains("Blood")) {
						health = health - attack2;
						health = fixHealth(health);
						JOptionPane.showMessageDialog(null,
								"Using their " + weapon3 + ", " + fullname2 + " was able to deal additional damage.\n"
										+ fullname + " lost " + attack2 + " hitpoints. Their health is now " + health
										+ ".");
					} else if (weapon3.contains("Fire") || weapon3.contains("Water") || weapon3.contains("Air")
							|| weapon3.contains("Earth")) {
						if (magic2 > 0) {
							health = health - magic2;
							health = fixHealth(health);
							JOptionPane.showMessageDialog(null,
									"Using their knowledge of the mystic arts, " + fullname2 + " deals an extra "
											+ magic2 + " damage.\n" + fullname + "now has " + health + " health.");
						}
					} else if (weapon3.contains("Faith") || weapon3.contains("Souls")) {
						if (faith2 > 0) {
							health = health - faith2;
							health = fixHealth(health);
							JOptionPane.showMessageDialog(null,
									"Using their faith in the gods above, " + fullname2 + " deals an additional "
											+ faith2 + " damage.\n" + fullname + " now has " + health + " health.");
						}
					} else if (weapon3.contains("Stress") || weapon3.contains("Horror")) {
						health = health - stress2;
						health = fixHealth(health);
						JOptionPane.showMessageDialog(null,
								"Using their " + weapon3 + ", " + fullname2
										+ " is able to use their stress to deal an additional " + stress2 + " damage.\n"
										+ fullname + " now has " + health + " health.");
						int add = (int) (Math.random() * 10 + 1);
						stress2 = stress2 + add;
						JOptionPane.showMessageDialog(null, "Due to using such a powerful weapon, " + fullname2
								+ "'s stress increases by " + add + "\nTheir stress is now " + stress2 + ".");
						if (stress2 > 19) {
							a = (int) (Math.random() * 7);
							fullquirk2 = fullquirk2 + quirk[a];
							JOptionPane.showMessageDialog(null, "Due to " + fullname2
									+ "'s high level of stress, they have gained the quirk: " + fullquirk2 + ".");
							if (fullquirk2.contains("Hungry")) {
								health2 = quirk2Hungry(health2, fullname2);
							} else if (fullquirk2.contains("Masochist")) {
								health2 = quirk2Masochist(health2, fullname2);
							} else if (fullquirk2.contains("Unbeliever")) {
								faith2 = quirk2Unbeliever(faith2, fullname2);
							} else if (fullquirk2.contains("Awkward")) {
								attack2 = quirk2Awkward(attack2, fullname2);
							} else if (fullquirk2.contains("Weak")) {
								defend2 = quirk2Weak(defend2, fullname2);
							} else if (fullquirk2.contains("Terrified")) {
								stress2 = quirk2Terrified(stress2, fullname2);
							} else if (fullquirk2.contains("Paranoid")) {
								health2 = health2 - 5;
								health2 = fixHealth2(health2);
								stress2 = stress2 + 20;
								JOptionPane.showMessageDialog(null,
										"Due to their paranoia, " + fullname2
												+ " loses 5 health and gains 20 stress.\nThey now have " + health2
												+ " health and " + stress2 + " stress.");
							}
							fullquirk2 = "";
						}

					}
				}
			}

		} while (health > 0 && health2 > 0);
		if (health2 == 0) {
			JOptionPane.showMessageDialog(null, fullname + " destroyed " + fullname2 + ".");
		} else {
			JOptionPane.showMessageDialog(null, fullname2 + " destroyed " + fullname + ".");
		}
	}

	public static int fixHealth2(int health2) {
		if (health2 < 0) {
			health2 = 0;
		}
		return health2;
	}

	public static int fixHealth(int health) {
		if (health < 0) {
			health = 0;
		}
		return health;
	}
	public static int quirk2Hungry(int health2, String fullname2) {
		health2 = health2 - 20;
		health2 = fixHealth2(health2);
		JOptionPane.showMessageDialog(null, "Due to their hunger, " + fullname2
				+ " loses 20 health.\nThey now have " + health2 + " health.");
		return health2;
	}
	public static int quirkHungry(int health, String fullname) {
		health = health - 20;
		health = fixHealth(health);
		JOptionPane.showMessageDialog(null, "Due to their hunger, " + fullname
				+ " loses 20 health.\nThey now have " + health + " health.");
		return health;
	}
	public static int quirk2Masochist(int health2, String fullname2) {
		health2 = health2 - 15;
		health2 = fixHealth2(health2);
		JOptionPane.showMessageDialog(null, "Due to their love of pain, " + fullname2
				+ " loses 15 health.\nThey now have " + health2 + " health.");
		return health2;
	}
	public static int quirkMasochist(int health, String fullname) {
		health = health - 15;
		health = fixHealth(health);
		JOptionPane.showMessageDialog(null, "Due to their love of pain, " + fullname
				+ " loses 15 health.\nThey now have " + health + " health.");
		return health;
	}
	public static int quirk2Unbeliever(int faith2, String fullname2) {
		faith2 = 0;
		JOptionPane.showMessageDialog(null,
				"Due to their now lack of faith, " + fullname2 + " has 0 faith.");
		return faith2;
	}
	public static int quirkUnbeliever(int faith, String fullname) {
		faith = 0;
		JOptionPane.showMessageDialog(null,
				"Due to their now lack of faith, " + fullname + " has 0 faith.");
		return faith;
	}
	public static int quirk2Awkward(int attack2, String fullname2) {
		attack2 = (int) attack2 / 2;
		JOptionPane.showMessageDialog(null,
				fullname2 + " now becomes clumsy.\nThey now have " + attack2 + " attack.");
		return attack2;
	}
	public static int quirkAwkward(int attack, String fullname) {
		attack = (int) attack / 2;
		JOptionPane.showMessageDialog(null,
				fullname + " now becomes clumsy.\nThey now have " + attack + " attack.");
		return attack;
	}
	public static int quirk2Weak(int defend2, String fullname2) {
		defend2 = (int) defend2 / 2;
		JOptionPane.showMessageDialog(null,
				fullname2 + " becomes weak.\nThey now have only " + defend2 + " defense.");
		return defend2;
	}
	public static int quirkWeak(int defend, String fullname) {
		defend = (int) defend / 2;
		JOptionPane.showMessageDialog(null,
				fullname + " becomes weak.\nThey now have only " + defend + " defense.");
		return defend;
	}
	public static int quirk2Terrified(int stress2, String fullname2) {
		stress2 = stress2 + 10;
		JOptionPane.showMessageDialog(null, "Due to their fear, " + fullname2
				+ "'s stress increases by 10.\nThey now have " + stress2 + " stress.");
		return stress2;
	}
	public static int quirkTerrified(int stress, String fullname) {
		stress = stress + 10;
		JOptionPane.showMessageDialog(null, "Due to their fear, " + fullname
				+ "'s stress increases by 10.\nThey now have " + stress + " stress.");
		return stress;
	}
}
