package ee.mihkel.character;

import ee.mihkel.World;

public class Enemy extends Character {

    public Enemy(World world) {
       super(world, 'Z');
    }

    public void randomEnemyCoordinates(World world) {
        randomiseCoordinates(world);
    }
}
