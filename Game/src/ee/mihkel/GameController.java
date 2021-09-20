package ee.mihkel;

import ee.mihkel.character.Enemy;
import ee.mihkel.character.Healer;
import ee.mihkel.character.Player;
import ee.mihkel.character.QuestMaster;
import ee.mihkel.item.*;

import java.awt.event.ItemListener;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class GameController {
    protected static void checkPlayerInteraction(World world,
                                                 Player player,
                                                 Enemy enemy,
                                                 QuestMaster questMaster,
                                                 Healer healer,
                                                 Dagger dagger,
                                                 Hammer hammer,
                                                 Sword sword,
                                                 Teleporter teleporter,
                                                 Scanner scanner) throws GameOverException {
        GameController.checkIfPlayerAndEnemyMet(player, enemy, scanner, world);
        GameController.checkIfPlayerTakesItem(dagger, player);
        GameController.checkIfPlayerTakesItem(hammer, player);
        GameController.checkIfPlayerTakesItem(sword, player);
        GameController.checkIfPlayerTakesItem(teleporter, player);
        GameController.checkIfPlayerAndQuestMasterMet(world, player, enemy, questMaster);
        GameController.checkIfPlayerAndHealerMet(world, player, healer);
    }

    protected static void checkIfPlayerAndEnemyMet(Player player,
                                                   Enemy enemy,
                                                   Scanner scanner,
                                                   World world) throws GameOverException {
        if (player.getxCoord() == enemy.getxCoord() && player.getyCoord() == enemy.getyCoord() && enemy.isVisible()) {
            if (player.isNoItems()) {
                System.out.println("Sul pole relvi, mine otsi!");
            } else {
                GameController.chooseWeapon(player, enemy, scanner, world);
            }
        }
    }

    protected static void chooseWeapon(Player player,
                                       Enemy enemy,
                                       Scanner scanner,
                                       World world) throws GameOverException {
        String input;
        System.out.println("Kohtusid vaenlasega " + enemy.getEnemyType());
        player.showAllItems();
        Item item = null; // ei taha väärtust anda
        while (item == null) {
            try {
                input = scanner.nextLine();
                item = player.getItemFromList(Integer.parseInt(input));
                if (item.getName().equals("Teleporteerija")) {
                    player.useItem(item);
                    player.randomPlayerCoordinates(world);
                    enemy.randomEnemyCoordinates(world);
                } else {
                    GameController.startFight(player, enemy, scanner, item);
                }
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
            player.addToKilledEnemies(enemy.getEnemyType());
        } else if (player.getHealth() <= 0) {
            throw new GameOverException();
        }
    }

    protected static void fightWithEnemy(Player player,
                                         Enemy enemy,
                                         String input,
                                         Item item,
                                         int randomNumber) throws TooSmallOrLargeException {
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

    protected static void checkIfPlayerAndQuestMasterMet(World world,
                                                         Player player,
                                                         Enemy enemy,
                                                         QuestMaster questMaster) {
        if (player.getxCoord() == questMaster.getxCoord() && player.getyCoord() == questMaster.getyCoord()) {
            enemy.setVisible(true);
            enemy.randomEnemyCoordinates(world);
            enemy.reboost();
            questMaster.setVisible(false);
        } else if (!questMaster.isVisible()) {
            questMaster.setVisible(true);
        }
    }

    private static void checkIfPlayerAndHealerMet(World world, Player player, Healer healer) {
        if (player.getxCoord() == healer.getxCoord() && player.getyCoord() == healer.getyCoord()) {
          player.reboost();
          System.out.println("Ravitseja ravis su elud täis!");
          healer.randomHealerCoordinates(world);
        }
    }

    private static int seconds;

    public static int getSeconds() {
        return seconds;
    }

    public static void startTimer(Timer timer) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seconds++;
            }
        },1000,1000);
    }
}
