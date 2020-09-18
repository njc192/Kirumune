package lobby;

import Types.*;

public class Table {

    private static Contestant [] bracket;
    public static void main(String[] args)
    {
        System.out.println(createBracket(5));
    }

    public static Tally createBracket(int contestants)
    {
        int val = (int)Math.pow(2,0);
        int counter = 1;
        while(contestants > val)
        {
            val = (int)Math.pow(2,counter++);
        }
        contestants = val;
        Tally t = new Tally();
        bracket = new Contestant[2*contestants];

        for(int i = bracket.length-1; i > 0; i--)
        {
            if(2*i >= bracket.length -1)
            {

                bracket[i] = RandomContestant.generateContestant();
            }
            else
            {
                bracket[i] = t.tally(simulate(bracket[2*i],bracket[(2*i)  + 1]));
            }
        }
        String SPACE = "            ";

        int goal = (bracket.length-1)/2;
        int rowCounter = 1;
        for (int i = bracket.length-1; i > 0; i--)
        {
            if(i == goal)
            {
                System.out.println();
                goal = goal/2;
                for (int j = 0; j < rowCounter; j++)
                {
                    System.out.print(SPACE + SPACE);
                }
                rowCounter++;


            }
            if (i/2 > 0 && i %2 == 0)
            {
                int idxI = (i/2)*2;
                int idxII = (i/2)*2 + 1;
                System.out.print(bracket[idxII] + " vs. " + bracket[idxI]);
                for (int n = 0; n < rowCounter +1; n++ )
                {
                    System.out.print(SPACE);
                }
            }

        }
        System.out.println("\n\n\n\n\n"+ SPACE + SPACE + SPACE + SPACE + "THE CHAMPION:" + bracket[1]);
        return t;

    }

    private static int sumOfnMinusOne(int n) {
        //math... dont try understand this.
        return ((n + 1) * (n) / 2);
    }

    public static Contestant simulate(Contestant p1, Contestant p2)
    {
        while(p1.isAlive() && p2.isAlive()) {


            int damage1 = p1.rollDamage(p1);
            int damage2 = p2.rollDamage(p2);


            p2.takeDamage(damage1);
            p1.takeDamage(damage2);

//            System.out.println("execute hp:" + p1.getHealth());
//            System.out.println("tank hp:" + p2.getHealth());
        }

        //todo player 2 has a slight advantage because p1 must be greater than p2

        return p1.getHealth() > p2.getHealth() ? p1:p2;
    }

    private static void run(int times)
    {
        Tally t = new Tally();
        for (int i = 0; i < times; i++)
        {
            t.tally(simulate(new Assassin(), new Healer()));
            t.tally(simulate(new Assassin(),new Tank()));
            t.tally(simulate(new Healer(),new Tank()));
        }


        System.out.println(t);


    }
}
