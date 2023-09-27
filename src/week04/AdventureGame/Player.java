package week04.AdventureGame;

import week04.AdventureGame.GameCharacters.Archer;
import week04.AdventureGame.GameCharacters.GameCharacter;
import week04.AdventureGame.GameCharacters.Knight;
import week04.AdventureGame.GameCharacters.Samurai;

import java.util.Scanner;

public class Player {
    private int id;
    private int damage;
    private int health;

    private int originalHealth;
    private int money;
    private String charName;
    private String name;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCharacter() {
        GameCharacter[] characterList = {new Samurai(), new Archer(), new Knight()};

        for (GameCharacter gameCharacter : characterList) {
            System.out.println(
                "ID: " + gameCharacter.getId() +
                "\tCharacter: " + gameCharacter.getName() +
                "\tDamage: " + gameCharacter.getDamage() +
                "\tHealth: " + gameCharacter.getHealth() +
                "\tMoney: " + gameCharacter.getMoney());
        }

        System.out.print("Choose a character: ");
        int selectChar = input.nextInt();

        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());


        }
    }

    public void initPlayer(GameCharacter gameCharacter) {
        this.setId(gameCharacter.getId());
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOriginalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setCharName(gameCharacter.getName());
    }

    public void printPlayerStats() {
        System.out.println(
            "Health: " + this.getHealth() +
            "\tWeapon: " + this.getInventory().getWeapon().getName() +
            "\tArmor: " + this.getInventory().getArmor().getName() +
            "\tDamage: " + this.getTotalDamage() +
            "\tDefence: " + this.getInventory().getArmor().getDefence() +
            "\tMoney: " + this.getMoney()
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
