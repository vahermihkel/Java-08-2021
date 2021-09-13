package ee.mihkel.item;

import ee.mihkel.World;

public class Hammer extends Item {

    public Hammer(World world) {
        super(world, 2,  "Haamer");
    }

    public void regenerateDurability() {
        setDurability(6);
    }
}
