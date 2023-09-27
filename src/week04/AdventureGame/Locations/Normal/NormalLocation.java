package week04.AdventureGame.Locations.Normal;

import week04.AdventureGame.Location;
import week04.AdventureGame.Player;

public abstract class NormalLocation extends Location {

    public NormalLocation(Player player, String name) {
        super(player, name);
    }
    @Override
    public boolean onLocation() {
        return true;
    }
}
