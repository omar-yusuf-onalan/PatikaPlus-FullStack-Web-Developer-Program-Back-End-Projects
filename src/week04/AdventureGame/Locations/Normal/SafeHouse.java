package week04.AdventureGame.Locations.Normal;

import week04.AdventureGame.Player;

public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {

        System.out.println("--------------------------------");
        System.out.println("You have entered the Safe House");

        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());

        System.out.println("Your health has been restored");
        System.out.println("--------------------------------");

        return true;
    }
}
