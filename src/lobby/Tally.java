package lobby;

import Types.*;

public class Tally {
    private static int execute;
    private static int healer;
    private static int tank;
    private static int draw;

    public Tally()
    {
        execute = 0;
        healer = 0;
        tank = 0;
        draw = 0;
    }
    public Contestant tally(Contestant val)
    {
        switch (val.getName())
        {
            case Contestant.ASSASSIN:
                execute++;
                return val;
            case Contestant.HEALER:
                healer++;
                return val;

            case Contestant.TANK:
                tank++;
                return val;
            default:
                draw++;
                return val;



        }
    }

    @Override
    public String toString()
    {
        return "Assassin wins: " + execute + "\n" +
                "Tank wins: "  + tank + "\n" +
                "Healer wins: " + healer + "\n" +
                "Draws: " + draw + "\n";
    }

}
