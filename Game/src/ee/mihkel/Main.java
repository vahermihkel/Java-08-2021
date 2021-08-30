package ee.mihkel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    World world = new World(10,10);
	    Player player = new Player(world);
	    world.addPlayer(player);
		world.printMap();
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		while (!input.equals("end")) {
			player.move(input, world);
			world.printMap();
			input = scanner.nextLine();
		}
    }
}
