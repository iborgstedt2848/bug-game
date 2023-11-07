
/**
 * Write a description of class GameStats here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameStats
{
    int totalGames;
    int gamesWon;
    int gamesLost;

    public void win(){
        //increments totalGames and gamesWon if win() is called.
        totalGames++;
        gamesWon++;
    }

    public void lose(){
        //increments totalGames and gamesWon if lose() is called.
        totalGames++;
        gamesLost++;
    }

    public String toString(){
        //returns a string that tells the user total # of games, # of games won, & # of games lost.
        return "Total Games: " + totalGames + "\n" + "Games Won: " + gamesWon + "\n" + "Games Lost: " + gamesLost;
    }
}