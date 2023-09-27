package week04.AdventureGame.Locations.Battle;

import week04.AdventureGame.Locations.Normal.Armor;
import week04.AdventureGame.Locations.Normal.Weapon;
import week04.AdventureGame.Monsters.Serpent;
import week04.AdventureGame.Player;

import java.util.Random;

public class Mine extends BattleLocation {

    Random r = new Random();
    public Mine(Player player) {
        super(player, "Mine", new Serpent(), 5, "");

    }
    @Override
    public void dropLoot() {
        Weapon[] weaponList = Weapon.weapons();
        Armor[] armorList = Armor.armors();
        int[] moneyList = {1, 5, 10};

        int lootType = lootType();
        int specificLoot = specificLoot();

        switch(lootType) {
            case 0:
                System.out.println(this.getMonster().getName() + " has dropped a weapon!");
                this.getPlayer().getInventory().setWeapon(weaponList[specificLoot]);
            case 1:
                System.out.println(this.getMonster().getName() + " has dropped armor");
                this.getPlayer().getInventory().setArmor(armorList[specificLoot]);
            case 2:
                System.out.println(this.getMonster().getName() + " has dropped money");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + moneyList[specificLoot]);
            case 3:
                System.out.println(this.getMonster().getName() + " has dropped nothing");
        }
    }
    public int lootType() {

        int number = r.nextInt(1,101);

        if(number > 55) { // 56-100 Nothing Drops
            return 3;
        } else if(number > 30) { // 31-55 Money Drops
            return 2;
        } else if(number > 15) { // 16-30 Armor Drops
            return 1;
        } else { // 1-15 Weapon Drops
            return 0;
        }
    }
    public int specificLoot() {

        int number = r.nextInt(1,101);

        if(number > 50) {
            return 0;
        } else if(number > 30) {
            return 1;
        } else {
            return 2;
        }
    }

}
