package ee.mihkel.character;

import java.util.Random;

public enum EnemyType {
    ANT, RAT, CAT, DOG, HORSE, DRAGON, WIZARD;

    public static EnemyType getRandomEnemyType() {
        Random random = new Random();
        return EnemyType.values()[random.nextInt(values().length)];
    }
}
