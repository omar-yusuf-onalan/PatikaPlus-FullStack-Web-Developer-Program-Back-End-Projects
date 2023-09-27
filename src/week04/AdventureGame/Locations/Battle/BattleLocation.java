package week04.AdventureGame.Locations.Battle;

import week04.AdventureGame.Location;
import week04.AdventureGame.Monsters.Monster;
import week04.AdventureGame.Player;

import java.util.Random;

public abstract class BattleLocation extends Location {

    private static final int PLAYER_STARTS_THRESHOLD = 50;
    private Monster monster;

    private int maxMonsterNumber;

    private int monsterNumber;

    private String rewardName;

    public BattleLocation(Player player, String name, Monster monster, int maxMonsterNumber, String rewardName) {
        super(player, name);
        this.monster = monster;
        this.maxMonsterNumber = maxMonsterNumber;
        this.rewardName = rewardName;
    }

    @Override
    public boolean onLocation() {
        if (isCleared()) {
            System.out.println("You have already cleared this zone");
            return true;
        }
        randomMonsterNumber();
        System.out.println("You have entered combat zone " + getName());
        System.out.println("There are " + monsterNumber + " " + monster.getName() + "(s) in this zone");
        System.out.println("<B>attle or <F>lee?");
        String selectBattleCase = input.nextLine().toUpperCase();

        return selectBattleCase.equals("B") ? combat(monsterNumber) : true;
    }

    public boolean combat(int monsterNumber) {
        boolean isAlive = true;

        for (int i = 1; i <= monsterNumber && isAlive; i++) {
            isAlive = singleCombat();
        }

        if(this.getPlayer().getHealth() > 0 && !this.rewardName.isEmpty()) {
            this.giveReward();
            System.out.println("You have obtained " + this.getRewardName());
        }

        return isAlive;
    }

    private boolean singleCombat() {
//        printPlayerStats();
//        printMonsterStats();

        boolean playerTurn = playerStarts();
        boolean isAlive = true;
        boolean willFlee;

        while (this.getPlayer().getHealth() > 0 && this.monsterNumber > 0) {
            if (playerTurn) {
                willFlee = playerTurn();
                if (willFlee) break;
            } else {
                isAlive = monsterTurn();
            }
            playerTurn = !playerTurn;
        }

        return isAlive;
    }

    private boolean playerTurn() {
        System.out.println("<S>trike or <F>lee?");
        String selectAction = input.nextLine().toUpperCase();

        if (selectAction.equals("S")) {
            playerStrikesMonster(this.getPlayer(), this.getMonster());
            if (monster.getHealth() <= 0) {
                monsterDefeated(this.getPlayer(), this.getMonster());
                return false;
            }
            return false;
        } else {
            System.out.println("You have chosen to flee");
            return true;
        }
    }

    private boolean monsterTurn() {
        monsterStrikesPlayer(this.getMonster(), this.getPlayer());
        if (player.getHealth() <= 0) {
            playerDefeated(this.getPlayer());
            return false;
        }
        return true;
    }

    private void playerStrikesMonster(Player player, Monster monster) {
        monster.setHealth(this.getMonster().getHealth() - player.getTotalDamage());
        System.out.println("You have dealt " + player.getTotalDamage() + " to a " + monster.getName());
    }

    private void monsterStrikesPlayer(Monster monster, Player player) {
        if(monster.getHealth() <= 0) {
            System.out.println();
        } else {

            int netMonsterDamage = monster.setRandomDamage() - player.getInventory().getArmor().getDefence();

            if(netMonsterDamage < 0) {
                netMonsterDamage = 0;
            }

            player.setHealth(player.getHealth() - netMonsterDamage);
            System.out.println("A " + monster.getName() + " has dealt " + netMonsterDamage + " damage to you");
        }
    }

    private void monsterDefeated(Player player, Monster monster) {
        System.out.println("You have slain a " + monster.getName());
        player.setMoney(player.getMoney() + monster.getLoot());
        this.dropLoot();

        monster.setHealth(monster.getOriginalHealth());
        this.monsterNumber--;
    }

    private void playerDefeated(Player player) {
        player.setHealth(0);
        System.out.println("Your health reaches zero");
    }

//    public void printPlayerStats() {
//        System.out.println("Character Stats" +
//            "------------------------------------------------" +
//            "Health: " + this.getPlayer().getHealth() +
//            "Weapon: " + this.getPlayer().getInventory().getWeapon().getName() +
//            "Armor: " + this.getPlayer().getInventory().getArmor().getName() +
//            "Damage: " + this.getPlayer().getTotalDamage() +
//            "Defence: " + this.getPlayer().getInventory().getArmor().getDefence()
//        );
//    }
//
//    public void printMonsterStats() {
//        System.out.println("Monster Stats" +
//            "------------------------------------------------" +
//            "Health: " + this.getMonster().getHealth() +
//            "Damage: " + this.getPlayer().getTotalDamage()
//        );
//    }

    public void randomMonsterNumber() {
        Random r = new Random();
        this.monsterNumber = r.nextInt(this.getMaxMonsterNumber()) + 1;
    }

    public boolean playerStarts() {
        return Math.random() * 100 >= PLAYER_STARTS_THRESHOLD;
    }

    public void giveReward() {}

    public void dropLoot(){}

    public boolean isCleared() {
        return false;
    }
    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public int getMaxMonsterNumber() {
        return maxMonsterNumber;
    }

    public void setMaxMonsterNumber(int maxMonsterNumber) {
        this.maxMonsterNumber = maxMonsterNumber;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }
}
