package week04.AdventureGame.Locations.Battle;

import week04.AdventureGame.Monsters.Bear;
import week04.AdventureGame.Player;

public class River extends BattleLocation {
    public River(Player player) {
        super(player, "River", new Bear(), 2, "water");
    }


    @Override
    public void giveReward() {
        player.getInventory().setWater(true);
    }
    @Override
    public boolean isCleared() {
        return this.player.getInventory().isWater();
    }
}
