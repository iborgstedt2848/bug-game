
/**
 * Write a description of class Coord here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coord
{
    int row;
    int col;
    
    public Coord(char row, int col){
       this.row = (int) row - 65;
       this.col = col - 1;
    }
    
    public Coord(int row, int col){
        this.row = row;
        this.col = col;
    }
    
}
