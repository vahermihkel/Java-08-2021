package ee.mihkel.item;

import ee.mihkel.World;

public class Dagger extends Item {

    public Dagger(World world) {
        super(world, 3, "Pistoda", 'L');
    }

    // polymorphism
    public void regenerateDurability() {
        setDurability(2);
    }
}
