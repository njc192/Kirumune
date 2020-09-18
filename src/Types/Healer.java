package Types;

import util.RandomNumbers;

public class Healer extends Contestant {

    private static int counter = 0;
    private int myCount;

    public Healer()
    {
        counter++;
        myCount = counter;
    }
    @Override
    public int modifyDamage(int php, int roll) {
        return roll;
    }

    @Override
    public int modifyDamageTaken(int damage) {
        if (getHealth() < 100)
        {
            RandomNumbers r = new RandomNumbers();

            r.setMaxValue(1000);
            if (r.roll() <30)
            {
                r.setMaxValue(10);
                return -1*r.roll();
            }
        }
        return damage;
    }

    @Override
    public int getName() {
        return Contestant.HEALER;
    }

    @Override
    public String toString() {
        return "H" + myCount;
    }
}
