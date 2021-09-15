package ee.mihkel;

import ee.mihkel.character.Enemy;
import ee.mihkel.character.Player;
import ee.mihkel.character.QuestMaster;
import ee.mihkel.item.Dagger;
import ee.mihkel.item.Hammer;
import ee.mihkel.item.Item;
import ee.mihkel.item.Sword;

import java.util.Random;
import java.util.Scanner;

public class GameController {
    protected static void checkPlayerInteraction(World world, Player player, Enemy enemy, QuestMaster questMaster, Dagger dagger, Hammer hammer, Sword sword, Scanner scanner) throws GameOverException {
        GameController.checkIfPlayerAndEnemyMet(player, enemy, scanner);
        GameController.checkIfPlayerTakesItem(dagger, player);
        GameController.checkIfPlayerTakesItem(hammer, player);
        GameController.checkIfPlayerTakesItem(sword, player);
        GameController.checkIfPlayerAndQuestMasterMet(world, player, enemy, questMaster);
    }

    protected static void checkIfPlayerAndEnemyMet(Player player, Enemy enemy, Scanner scanner) throws GameOverException {
        if (player.getxCoord() == enemy.getxCoord() && player.getyCoord() == enemy.getyCoord() && enemy.isVisible()) {
            if (player.isNoItems()) {
                System.out.println("Sul pole relvi, mine otsi!");
            } else {
                GameController.chooseWeapon(player, enemy, scanner);
            }
        }
    }

    protected static void chooseWeapon(Player player, Enemy enemy, Scanner scanner) throws GameOverException {
        String input;
        System.out.println("Kohtusid vaenlasega " + enemy.getEnemyType());
        player.showAllItems();
        Item item = null; // ei taha väärtust anda
        while (item == null) {
            try {
                input = scanner.nextLine();
                item = player.getItemFromList(Integer.parseInt(input));
                GameController.startFight(player, enemy, scanner, item);
            } catch (NumberFormatException e) {
                System.out.println("Ütlesid numbri asemel sümboli! Ütle uus number:");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ütlesid liiga suure või väikse numbri! Ütle uus number:");
            }
        }
    }

    protected static void startFight(Player player, Enemy enemy, Scanner scanner, Item item) throws GameOverException {
        String input;
        System.out.println("Valisid eseme: " + item.getName());
        player.useItem(item);
        Random random = new Random();
        while (enemy.getHealth() > 0 && player.getHealth() > 0) {
            try {
                int randomNumber = random.nextInt(3)+1;
                System.out.println("Ütle üks number ühest kolmeni: ");
                input = scanner.nextLine();
                GameController.fightWithEnemy(player, enemy, input, item, randomNumber);
            } catch (TooSmallOrLargeException e) {
                System.out.println("Sisestasid liiga suure või väikse numbri, sisesta uuesti");
            } catch (NumberFormatException e) {
                System.out.println("Sisestaid numbri asemel muu sümboli, sisesta uuesti");
            }
        }
        if (enemy.getHealth() <= 0) {
            enemy.setVisible(false);
            // lisan listi
            // ütlen mis enemy tüübi tapsin
        } else if (player.getHealth() <= 0) {
            throw new GameOverException();
        }
    }

    protected static void fightWithEnemy(Player player, Enemy enemy, String input, Item item, int randomNumber) throws TooSmallOrLargeException {
        int userNumber = Integer.parseInt(input);
        if (userNumber < 1 || userNumber > 3) {
            throw new TooSmallOrLargeException();
        }
        if (randomNumber == userNumber) {
            enemy.takeHealth(item.getStrength());
            System.out.println("Võtsid vastaselt " + item.getStrength() + " elu! Tema elusid alles: " + enemy.getHealth());
        } else {
            player.takeHealth(enemy.getEnemyStrength());
            System.out.println("Kaotasid " + enemy.getEnemyStrength() + " elu! Sinu elusid alles: " + player.getHealth());
        }
    }

    protected static void checkIfPlayerTakesItem(Item item, Player player) {
        if (item.getxCoord() == player.getxCoord() && item.getyCoord() == player.getyCoord()) {
            player.addItem(item);
        }
    }

    protected static void checkIfPlayerAndQuestMasterMet(World world, Player player, Enemy enemy, QuestMaster questMaster) {
        if (player.getxCoord() == questMaster.getxCoord() && player.getyCoord() == questMaster.getyCoord()) {
            enemy.setVisible(true);
            enemy.reboost();
            questMaster.setVisible(false);
            enemy.randomEnemyCoordinates(world);
        } else if (!questMaster.isVisible()) {
            questMaster.setVisible(true);
        }
    }
}
