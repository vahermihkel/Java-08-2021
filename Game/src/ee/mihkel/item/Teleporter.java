package ee.mihkel.item;

import ee.mihkel.World;

public class Teleporter extends Item {

    public Teleporter(World world) {
        super(world,"Teleporteerija", 'P');
    }

    public void regenerateDurability() {
        setDurability(3);
    }
}
