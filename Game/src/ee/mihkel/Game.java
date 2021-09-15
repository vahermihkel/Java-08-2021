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

public class Game {

	// Tõstan välja funktsioonid Main funktsioonist GameController klassi

	// Enemy'le Enum - erinevad tugevuse tüübid: ANT, RAT, CAT, DOG, HORSE, DRAGON, WIZARD
	// Genereeritakse suvaline tüüp Constructoris
	// Switch case abil kontrollitakse mis tüüp on ja vastavalt sellele ka antakse elud Enemy'le
	// Vastavalt tüübile võetakse ka mängijalt elusid (switch case)

	// Itemil uued väljad/muutujad - level ja tüüp
	// Tüüp on enum: BRONZE, SILVER, GOLD, PLATINUM
	// level on int mis suureneb iga kord
	// Iga kord kui kasutatakse eset, siis level suureneb
	// Kui on jõutud kindlale levelile siis tüüp läheb paremaks
	// Tüüp korrutatakse läbi tugevusega - switch case mis tüüp on ja siis korrutatakse strength seal sees

	// Kui mäng läbi saab, siis näidatakse kasutajale mitu tüüpi ta maha tappis
	// ANT:4, RAT:1, CAT:3 jne

	// Sekundid kokku liita kui kaua mängisid enne surma saamist

	// Uus Character - Healer, kui kokku satud, siis ravib elud täis - tema sümbol on nähtamatu
	// Uus Item - Teleporter, saad seda kasutada et põgeneda selle vaenlase tüübi eest

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
				GameController.checkPlayerInteraction(world, player, enemy, questMaster, dagger, hammer, sword, scanner);
				world.printMap();
				input = scanner.nextLine();
			}
		} catch (GameOverException e) {
			e.printStackTrace();
			System.out.println("MÄNG LÄBI!");
		}
	}
}
