package week04.AdventureGame.Monsters;

import java.util.Random;

public class Serpent extends Monster {

    Random r = new Random();
    public Serpent() {
        super(4, "Serpent", 0,12,0);
    }


    @Override
    public int setRandomDamage() {
        return r.nextInt(3,7);
    }
}
