package week04.AdventureGame.Locations.Normal;

import week04.AdventureGame.Location;
import week04.AdventureGame.Player;

public class EquipmentShop extends NormalLocation {
    public EquipmentShop(Player player) {
        super(player, "Equipment Shop");
    }
    @Override
    public boolean onLocation() {
        System.out.println("You have entered the equipment shop");

        boolean showMenu = true;

        while(showMenu) {
            System.out.println("--------------------------------");
            System.out.println("1. Buy Weapon\n2. Buy Armor\n3. Exit");
            int selectCase = Location.input.nextInt();

            while (selectCase < 1 || 3 < selectCase) {
                System.out.println("Invalid input. Try again.");
                selectCase = Location.input.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Thank you. Please come again.");
                    showMenu = false;
                    break;
            }

        }
        return true;
    }

    public void printWeapon() {
        System.out.println("----- Weapons -----");
        for(Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + ". Name: " + w.getName() + "\tDamage: " + w.getDamage() + "\tPrice: " + w.getPrice());
        }
        System.out.println("0. Exit");
    }
    public void buyWeapon() {
        System.out.print("Select a weapon: ");
        int selectWeapon = Location.input.nextInt();

        while(selectWeapon < 0 || Weapon.weapons().length < selectWeapon) {
            System.out.println("Invalid value. Try again.");
            selectWeapon = Location.input.nextInt();
        }

        if(selectWeapon != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeapon);
            if(this.getPlayer().getMoney() < selectedWeapon.getPrice()) {
                System.out.println("Not enough money");
            } else {
                int remainder = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(remainder);

                System.out.println("You have bought "+ selectedWeapon.getName() + " for " + selectedWeapon.getPrice());
                System.out.println("Remaining money: " + this.getPlayer().getMoney());

                this.getPlayer().getInventory().setWeapon(selectedWeapon);

            }
        }
    }


    public void printArmor() {
        System.out.println("----- Armors -----");
        for(Armor a : Armor.armors()) {
            System.out.println(a.getId() + ". Name: " + a.getName() + "\tDefence: " + a.getDefence() + "\tPrice: " + a.getPrice());
        }
        System.out.println("0. Exit");
    }

    public void buyArmor() {
        System.out.print("Select an armor: ");
        int selectArmor = Location.input.nextInt();

        while(selectArmor < 0 || Armor.armors().length < selectArmor) {
            System.out.println("Invalid value. Try again.");
            selectArmor = Location.input.nextInt();
        }

        if(selectArmor != 0) {
            Armor selectedArmor = Armor.getArmorObjById(selectArmor);
            if(this.getPlayer().getMoney() < selectedArmor.getPrice()) {
                System.out.println("Not enough money");
            } else {
                int remainder = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(remainder);

                System.out.println("You have bought "+ selectedArmor.getName() + " armor for " + selectedArmor.getPrice());
                System.out.println("Remaining money: " + this.getPlayer().getMoney());


                this.getPlayer().getInventory().setArmor(selectedArmor);

            }
        }
    }
}


