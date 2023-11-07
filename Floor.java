
/**
 * Write a description of class Floor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Floor
{
    char [][] grid;
    int floorSize;

    /**
     * Constructor which initializes floorSize and creates a grid of empty cells according to the dimensions
     * of floorSize.
     */
    public Floor(int floorSize){
        this.floorSize = floorSize;
        grid = new char[floorSize][floorSize];
        for (int i=0; i<floorSize; i++){
            for(int j=0; j<floorSize; j++){
                grid[i][j] = ' ';
            }
        }
    }

    /**
     * Sets the size of the default floorSize to 3 by calling the other constructor.
     */
    public Floor(){
        this(3);
    }

    /**
     * A method which returns a graphical representation of my 2D array by appending lines and dashes to
     * a long string that takes into account the dimensions of the square grid set by the floorSize.
     */
    public String toString(){
        String str = " ";
        for (int i=1; i<=floorSize; i++){
            if (i>=10){
                str += " " + i + " ";
            }else{
                str += "  " + i + " " ;
            }
        }
        str += "\n";
        char counter = 'A';
        for (int i=0; i<floorSize; i++){
            str += counter + " ";
            for (int j=0; j<floorSize; j++){
                if (j != floorSize-1){
                    str += grid[i][j] + "  |";
                }else{
                    str += grid[i][j];
                }
            }
            str +=  "\n  ";
            for (int k=0; k<floorSize; k++){
                if (k != floorSize-1){
                    str += "---|";
                }else{
                    str += "---";
                }
            }
            str += "\n";
            counter++;
        }
        return str;
    }
    
    /**
     * A method that returns the size of the floor we are using.
     */
    public int getFloorSize(){
        return this.floorSize;
    }
    
    /**
     * A method that returns the char value at a given position in the floor.
     */
    public char getFloorValue(Coord object){
        return grid[object.row][object.col];
    }
    
    /**
     * A method that returns a boolean stating whether or not the parameter 
     * contains a row and column within the confines of the floor.
     */
    public boolean isValidMove(Coord object){
        if (object.row >= 0 && object.row < floorSize && object.col >= 0 && object.col < floorSize){
            return true;
        }
        return false;
    }
    
    /**
     * A method that returns a boolean signifying if that position in the floor
     * "is valid" and places the symbol at the specified coordinate in the floor.
     */
    public boolean move(Coord object, char symbol){
        if (this.isValidMove(object)){
            grid[object.row][object.col] = symbol;
            return true;
        }
        return false;
    }
    
    /**
     * Prints the grid from the toString method according to the floorSize.
     */
    public static void main (String[] args){
        Floor f = new Floor(13);
        System.out.print(f);
    }
}