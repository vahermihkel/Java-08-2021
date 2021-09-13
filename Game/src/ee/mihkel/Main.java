package ee.mihkel;

import ee.mihkel.character.Character;
import ee.mihkel.character.Enemy;
import ee.mihkel.character.Player;
import ee.mihkel.character.QuestMaster;
import ee.mihkel.item.Dagger;
import ee.mihkel.item.Hammer;
import ee.mihkel.item.Item;
import ee.mihkel.item.Sword;

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
		while (!input.equals("end")) {
			player.move(input, world);
			if (player.getxCoord() == enemy.getxCoord() && player.getyCoord() == enemy.getyCoord() && enemy.isVisible()) {
				if (player.isNoItems()) {
					System.out.println("Sul pole relvi, mine otsi!");
				} else {
					System.out.println("Kohtusid vaenlasega!");
					player.showAllItems();
					Item item = null;
					while (item == null) {
						try {
							input = scanner.nextLine();
							item = player.getItemFromList(Integer.parseInt(input));
							System.out.println("Valisid eseme: " + item.getName());
							enemy.setVisible(false);
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
				questMaster.setVisible(false);
				enemy.randomEnemyCoordinates(world);
			} else if (!questMaster.isVisible()) {
				questMaster.setVisible(true);
			}
			world.printMap();
			input = scanner.nextLine();
		}
    }

    private static void checkIfPlayerTakesItem(Item item, Player player) {
		if (item.getxCoord() == player.getxCoord() && item.getyCoord() == player.getyCoord()) {
			player.addItem(item);
		}
	}
}
