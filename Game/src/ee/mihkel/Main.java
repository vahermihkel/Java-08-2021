package ee.mihkel;

import ee.mihkel.character.Character;
import ee.mihkel.character.Enemy;
import ee.mihkel.character.Player;
import ee.mihkel.character.QuestMaster;
import ee.mihkel.item.Dagger;
import ee.mihkel.item.Hammer;
import ee.mihkel.item.Item;
import ee.mihkel.item.Sword;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    World world = new World(6,6);

	    Player player = new Player(world);
	    world.addCharacter(player);
	    Enemy enemy = new Enemy(world);
	    world.addCharacter(enemy);
	    QuestMaster questMaster = new QuestMaster(world);
	    world.addCharacter(questMaster);

		Dagger dagger = new Dagger(world);
		world.addItem(dagger);
		Hammer hammer = new Hammer(world);
		world.addItem(hammer);
		Sword sword = new Sword(world);
		world.addItem(sword);

		world.printMap();
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		try {
			while (!input.equals("end")) {
				player.move(input, world);
				if (player.getxCoord() == enemy.getxCoord() && player.getyCoord() == enemy.getyCoord() && enemy.isVisible()) {
					if (player.isNoItems()) {
						System.out.println("Sul pole relvi, mine otsi!");
					} else {
						System.out.println("Kohtusid vaenlasega!");
						player.showAllItems();
						Item item = null; // ei taha väärtust anda
						while (item == null) {
							try {
								input = scanner.nextLine();
								item = player.getItemFromList(Integer.parseInt(input));
								System.out.println("Valisid eseme: " + item.getName());
								player.useItem(item);
								Random random = new Random();
								while (enemy.getHealth() > 0 && player.getHealth() > 0) {
									try {
										int randomNumber = random.nextInt(3)+1;
										System.out.println("Ütle üks number ühest kolmeni: ");
										input = scanner.nextLine();
										int userNumber = Integer.parseInt(input);
										if (userNumber < 1 || userNumber > 3) {
											throw new TooSmallOrLargeException();
										}
										if (randomNumber == userNumber) {
											enemy.takeHealth(item.getStrength());
											System.out.println("Võtsid vastaselt elu! Tema elusid alles: " + enemy.getHealth());
										} else {
											player.takeHealth(1);
											System.out.println("Kaotasid elu! Sinu elusid alles: " + player.getHealth());
										}
									} catch (TooSmallOrLargeException e) {
										System.out.println("Sisestasid liiga suure või väikse numbri, sisesta uuesti");
									} catch (NumberFormatException e) {
										System.out.println("Sisestaid numbri asemel muu sümboli, sisesta uuesti");
									}
								}
								if (enemy.getHealth() <= 0) {
									enemy.setVisible(false);
								} else if (player.getHealth() <= 0) {
									throw new GameOverException();
								}
							} catch (NumberFormatException e) {
								System.out.println("Ütlesid numbri asemel tähe! Ütle uus number:");
							} catch (IndexOutOfBoundsException e) {
								System.out.println("Ütlesid liiga suure või väikse numbri!  Ütle uus number:");
							}
						}
					}
				}
				checkIfPlayerTakesItem(dagger, player);
				checkIfPlayerTakesItem(hammer, player);
				checkIfPlayerTakesItem(sword, player);
				if (player.getxCoord() == questMaster.getxCoord() && player.getyCoord() == questMaster.getyCoord()) {
					enemy.setVisible(true);
					enemy.reboost();
					questMaster.setVisible(false);
					enemy.randomEnemyCoordinates(world);
				} else if (!questMaster.isVisible()) {
					questMaster.setVisible(true);
				}
				world.printMap();
				input = scanner.nextLine();
			}
		} catch (GameOverException e) {
			e.printStackTrace();
			System.out.println("MÄNG LÄBI!");
		}
	}

    private static void checkIfPlayerTakesItem(Item item, Player player) {
		if (item.getxCoord() == player.getxCoord() && item.getyCoord() == player.getyCoord()) {
			player.addItem(item);
		}
	}
}
