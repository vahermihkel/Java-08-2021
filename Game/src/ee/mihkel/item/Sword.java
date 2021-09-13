package ee.mihkel.item;

import ee.mihkel.World;

public class Sword extends Item {
    public Sword(World world) {
        super(world, 5,  "Mõõk");
    }

    public void regenerateDurability() {
        setDurability(1);
    }
}
