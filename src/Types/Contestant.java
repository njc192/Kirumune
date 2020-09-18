package Types;

import util.RandomNumbers;


public abstract class Contestant implements Turn {

    public static final int ASSASSIN = 0;
    public static final int HEALER = 1;
    public static final int TANK = 2;

    private static final int HEALTHVALUE = 100;
    private int health;
    private RandomNumbers generator ;
    private boolean isAlive;

    public Contestant()
    {
        health = HEALTHVALUE;
        generator = new RandomNumbers();
        isAlive = true;
    }

    @Override
    public int rollDamage(Contestant player) {
        if (!isAlive)
            throw new ClassCastException();
        int roll = generator.roll();
        roll = modifyDamage(player.getHealth(),roll);
        return roll;
    }

    @Override
    public void takeDamage(int dmg) {
        dmg = modifyDamageTaken(dmg);
//        System.out.print("health was: " + health);
        health = health-dmg;
//        System.out.println(" now is: " + health);

        if (health <= 0)
            isAlive = false;
    }

    public boolean isAlive()
    {
        return health> 0;
    }

    public int getHealth()
    {
        return health;
    }

    public abstract int modifyDamage(int player,int roll);
    public abstract int modifyDamageTaken(int damage);
    public abstract int getName();
}
