package Types;

import util.RandomNumbers;

public class RandomContestant {
    public static Contestant generateContestant()
    {
        System.out.println("generated a new contestant!");
        RandomNumbers r = new RandomNumbers();
        r.setMaxValue(2);
        int contestant = r.roll();
        if (contestant == Contestant.ASSASSIN)
            return new Assassin();
        if (contestant == Contestant.HEALER)
            return new Healer();
        if (contestant == Contestant.TANK)
            return new Tank();


        else
        {
            System.out.println(contestant);
            throw new ClassCastException();
        }
    }
}
