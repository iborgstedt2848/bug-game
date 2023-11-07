
/**
 * Write a description of class Bug here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bug
{
    Floor f;
    Coord location;
    int maxMoves;
    char symbol = 'X';
    Coord[] adjacentCells;
    int floorSize;
    int currentMoves = 0;

    /**
     * (row, column) of adjacent cells given a bug's location, noted by X
    below:
     * Starting clockwise from upper left (you can start relative to any
    location here)
     *
     * 0 | 1 | 2
     * ---|---|---
     * 7 | X | 3
     * ---|---|---
     * 6 | 5 | 4
     *
     * The coordinate values are relative to the bug's location!
     * Just add the appropriate row/col values to the bug's current location.
     * So, the relative/adjacent coordinates are as follows:
     * 0: (-1, 1) 1: ( 0, 1) 2: ( 1, 1)
     * 3: ( 1, 0) 4: ( 1,-1) 5: ( 0,-1)
     * 6: (-1,-1) 7: (-1, 0)
     * Example: adding coord(-1, 1) to bug's last known location specified by
    coord named 'X',
     * will move the bug to the upper left cell named '0' as long as cell 0 is
    a valid cell.
     * If the coord named 'X' is located at (0,0) in the floor's array, this
    is not a valid cell to move to.
     *
     */
    
    /**
     * Constructor that creates a new floor of floorSize and initializes the 
     * 8 adjacent cells as new coordinates.
     */

    public Bug(int floorSize, int maxMoves, Coord startingLocation){
        this.f = new Floor(floorSize);
        this.floorSize = floorSize;
        this.maxMoves = maxMoves;
        this.currentMoves = 0;
        this.location = startingLocation;
        adjacentCells = new Coord[8];
        adjacentCells[0] = new Coord(-1, 1);
        adjacentCells[1] = new Coord(0, 1);
        adjacentCells[2] = new Coord(1, 1);
        adjacentCells[3] = new Coord(1, 0);
        adjacentCells[4] = new Coord(1, -1);
        adjacentCells[5] = new Coord(0, -1);
        adjacentCells[6] = new Coord(-1, -1);
        adjacentCells[7] = new Coord(-1, 0);
    }

    public Bug(int maxMoves, Coord startingLocation){
        this(3, maxMoves, startingLocation);
        //default maxMoves is set to 3.
    }

    /**
     * This private walk() method starts by creating a new Coord object x,
     * which is not a valid move. This is a temporary location because we
     * do not yet know if the location is valid. It enters a while loop that
     * executes as longa s the move is not valid. It creates int i, which
     * randomizes the move by selecting one of the coords from the adjacentCells
     * array. It sets the row of coord x equal to the row of the location plus
     * the row of the adjacentCell (does the same for col), and only updates
     * location after breaking out of the loop. It calls move() and increments
     * currentMoves once the move is executed.
     */
    private void walk(){
        Coord x = new Coord(-1, -1);
        //temporary location because we do not know if the location is valid.
        while(!(f.isValidMove(x))){
            int i = (int)(Math.random()* 8);
            x.row = location.row + adjacentCells[i].row;
            x.col = location.col + adjacentCells[i].col;
        }
        location = x;
        f.move(x, symbol);
        currentMoves++;
    }

    /**
     * This private method returns a boolean that tells us whether or not the bug
     * has finished walking. Returns true if the currentMoves is equal to maxMoves.
     * Otherwise (meaning there are more moves left) it runs through the entire floor 
     * and checks to see if there are any empty cells. If so, it returns false.
     */
    private boolean isFinishedWalking(){
        if(currentMoves == maxMoves){
            return true;
        }else{
            for (int i=0; i<floorSize; i++){
                for (int j=0; j<floorSize; j++){
                    if (f.grid[i][j] == ' '){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * This public method keeps the bug walking as long as the bug is not finished
     * walking. Executed with a while loop.
     */
    public void play(){
        while(!isFinishedWalking()){
            walk();
        }
    }

    /**
     * Determines that the player has won if the bug is finished walking
     * and still has moves left over (currentMoves < maxMoves).
     */
    public boolean isWinner(){
        if(isFinishedWalking() && currentMoves < maxMoves){
            return true;
        }
        return false;  
    }

    /**
     * toString() method which returns one of two messages dependng on whether
     * or not the player has won.
     */
    public String toString(){
        if(isWinner()){
            return(f.toString() + "Congrats! Bug won!\n");   
        }
        return(f.toString() + "Sorry, bug lost. Try again!\n");
    }
}