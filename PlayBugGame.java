
/**
 * Write a description of class PlayBugGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayBugGame
{
    Bug buggie;

    /**
     * This constructor creates a new Converse object x and a new GameStats object score. Then it enters
     * a while loop that executes as long as none of the methods from the Converse class return true (aka
     * the user has asked to quit). In the while loop, it creates a new Bug object buggie, which has the
     * floorSize, maxTotalMoves, and row/col from the Converse class (given by user input). It calls
     * play() and isWinner() on buggie and then it calls win() or lose() on score depending on whether or not
     * isWinner returns true or false. Finally, it outputs both toString() methods to show the user the floor
     * and tell the user whether or not buggie has won or lost as well as the total amount of games played.
     * It is designed to continue playing as long as the user does not enter quit.
     */
    public PlayBugGame(){
        Converse x = new Converse();
        GameStats score = new GameStats();
        while (!(x.greeting()) && !(x.floorSetup()) && !(x.maximumMoves()) && !(x.placementSetup())){
            Bug buggie = new Bug(x.floorSize, x.maxTotalMoves, new Coord(x.row, x.col));
            buggie.play();
            buggie.isWinner();
            if (buggie.isWinner()){
                score.win();
            }else{
                score.lose();
            }
            System.out.println("--------------------------------------------------");
            System.out.println(buggie.toString());
            System.out.println(score.toString());
            System.out.println("--------------------------------------------------");
        }
    }

    public static void main(String[] args){
        //main method which creates a PlayBugGame object p, executing the code from above.
        PlayBugGame p = new PlayBugGame();
    }
}