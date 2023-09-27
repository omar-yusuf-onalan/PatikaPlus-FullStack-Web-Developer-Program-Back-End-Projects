package week04.AdventureGame.Locations.Battle;

import week04.AdventureGame.Monsters.Vampire;
import week04.AdventureGame.Player;

public class Forest extends BattleLocation {
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), 3, "firewood");
    }

    @Override
    public void giveReward() {
        player.getInventory().setFirewood(true);
    }

    @Override
    public boolean isCleared() {
        return this.player.getInventory().isFirewood();
    }
}
