package ee.mihkel.character;

import ee.mihkel.World;

public class Enemy extends Character {
    private EnemyType enemyType;

    public Enemy(World world) {
       super(world, 'Z');
       this.enemyType = EnemyType.getRandomEnemyType();
       setEnemyHealthByType();
    }

    private void setEnemyHealthByType() {
        this.health = determineType();
    }

    public int getEnemyStrength() {
        return determineType();
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    private int determineType() {
        switch (enemyType) {
            case RAT:
                return 2;
            case CAT:
                return 3;
            case DOG:
                return 4;
            case HORSE:
                return 5;
            case DRAGON:
                return 6;
            case WIZARD:
                return 7;
            default:
                return 1;
        }
    }

    public void randomEnemyCoordinates(World world) {
        randomiseCoordinates(world);
    }


}
