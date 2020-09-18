package Types;

import util.RandomNumbers;

public class Assassin extends Contestant {

    private static int counter = 0;
    private static final int CHANCE = 52; // 52/1000 or 5.2 percent
    private int myCount;
    public Assassin()
    {
        counter++;
        myCount = counter;
    }
    @Override
    public int modifyDamage(int pHealth,int roll) {
        RandomNumbers r = new RandomNumbers();
        r.setMaxValue(1000);
        int chance = r.roll();
        if(chance < CHANCE)
        {
//            System.out.println("crit!");
            roll = roll + (int)((100 -pHealth)*.12);
        }
        return roll;
    }

    @Override
    public int modifyDamageTaken(int damage) {
        return damage;
    }

    @Override
    public int getName() {
        return Contestant.ASSASSIN;
    }

    public String toString()
    {
        return "A" + myCount;
    }

}
