package week04.AdventureGame.Locations.Battle;

import week04.AdventureGame.Monsters.Zombie;
import week04.AdventureGame.Player;

public class Cave extends BattleLocation {
    public Cave(Player player) {
        super(player, "Cave", new Zombie(), 3, "food");

    }

    @Override
    public void giveReward() {
        player.getInventory().setFood(true);
    }

    @Override
    public boolean isCleared() {
        return this.player.getInventory().isFood();
    }
}
