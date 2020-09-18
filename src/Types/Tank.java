package Types;

import util.RandomNumbers;

public class Tank extends Contestant {
    private static int counter = 0;
    private int myCount;
    public Tank()
    {
        counter++;
        myCount = counter;
    }
    @Override
    public int modifyDamage(int pHp,int roll) {
        return roll;
    }

    @Override
    public int modifyDamageTaken(int damage) {
        if (this.getHealth() < 55)
        {
            RandomNumbers r = new RandomNumbers();
            r.setMaxValue(1000);
            int chance = r.roll();
            if(chance < 180)
            {
//                System.out.print("reduced Damage!");
                return damage/2;
            }
        }
        return damage;
    }

    @Override
    public int getName() {
        return Contestant.TANK;
    }

    @Override
    public String toString() {
        return "T" + myCount;
    }
}
