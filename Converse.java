/**
 * @author Isabelle Borgstedt
 * @version 03/03/23
 */

import java.util.Scanner;

public class Converse
{
    public String name;
    public int floorSize;
    public int maxTotalMoves;
    public char row;
    public int col;

    public Converse(){
        this.name = "Player 1";
        this.floorSize = 3;
        this.maxTotalMoves = 5000;
        System.out.println("Welcome");
    }

    /**
     * greeting() method asks the user to input a name or enter quit (case
     * insensitive) to exit the program. It takes in the user input and evaulates
     * whether or not the user entered "quit. It defaults to "Player 1"
     * if the user inputs nothing. Otherwise, it sets the user's input
     * to the name of the player.
     */

    public boolean greeting(){

        System.out.println("Enter a name or enter 'quit' to exit the program.");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.toLowerCase().equals("quit")){
            System.out.println("Quitting");
            return true;
        }
        else if(answer.equals("")){
            System.out.println("Setting name to Player 1");
            this.name = "Player 1";
        }else{
            this.name = answer;
            System.out.println("Hello " + name);
        }
        return false;
    }

    /**
     * floorSetup() method asks the user to enter an integer value from
     * 1-13. It takes in the input as a string and then attempts to type
     * cast it to an int. If type cast is successful (input is an int), 
     * it will check to make sure that the integer is in range. If so, it 
     * sets the input to the floor size. If not, it sets the the default 
     * value to 3. If the type cast is unsuccessful (input is not an int),
     * it will evaluate whether or not the string is equal to "quit" (case
     * insensitive).
     */

    public boolean floorSetup(){

        System.out.println("Enter an integer value from 1-13");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        try {
            int answerInt = Integer.parseInt(answer);
            if(0 < answerInt && answerInt <= 13){
                this.floorSize = answerInt;
                System.out.println("Floor Size = " + floorSize);
                return false;
            }
            System.out.println("Setting default size to 3");
            return false;
        } catch(Exception e){
            if(answer.toLowerCase().equals("quit")){
                System.out.println("Quitting");
                return true;
            }
            System.out.println("Setting default size to 3");
            return false;
        }
    }

    /**
     * maximumMoves() method asks the user to enter an integer value from
     * 1-10,000. It takes in the input as a string and then attempts to 
     * type cast it to an int. If type cast is successful (input is an 
     * int),it will check to make sure that the integer is in range. If 
     * so, it sets the input to the floor size. If not, it sets the the 
     * default value to 5,000. If the type cast is unsuccessful (input is 
     * not an int),it will evaluate whether or not the string is equal to 
     * "quit" (case insensitive).
     */

    public boolean maximumMoves(){

        System.out.println("Enter an integer value from 1-10,000");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        try {
            int answerInt = Integer.parseInt(answer);
            if(0 < answerInt && answerInt <= 10000){
                this.maxTotalMoves = answerInt;
                System.out.println("Max Total Moves = " + maxTotalMoves);
                return false;
            }
            System.out.println("Setting default size to 5,000");
            return false;
        } catch(Exception e){
            if(answer.toLowerCase().equals("quit")){
                System.out.println("Quitting");
                return true;
            }
            System.out.println("Setting default size to 5,000");
            return false;
        }
    }

    /**
     * placementSetup() method takes in a letter and a number as the
     * coordinates for the bug. It takes in the input as a string and
     * evaluates whether or not it equals "quit" (case insensitive). Then,
     * it establishes char a as the character at the first index of the 
     * input string. It establishes int b as the second index of the index
     * string, type casted to an int using Integer.parseInt. Then, it
     * enters an if statement that checks if int b in within
     * range according to the floor size and if char a is within range 
     * based on the corresponding character values (+65 from the int 
     * values). If both are in range, it sets a and b to row and col and
     * the game commences. If not, it stays inside the do while loop, which
     * continues to ask the user to try again until it meets the conditions.
     */

    public boolean placementSetup(){

        System.out.println("Enter a letter followed by a number.");
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                String answer = scanner.nextLine();
                if(answer.toLowerCase().equals("quit")){
                    System.out.println("Quitting");
                    return true;
                }
                char a = answer.charAt(0);
                int b = Integer.parseInt(answer.substring(1));
                if ((b > 0) && (b <= this.floorSize) && (a >= 65) && (a <= this.floorSize + 65)){
                    this.row = a;
                    this.col = b;
                    System.out.println("Setting paramenters to " + a + b + ".");
                    System.out.println("<game play commences>"); 
                    return false;
                }else{
                    System.out.println("Invalid input. Please try again.");
                }  
            } catch(Exception e){
                System.out.println("Invalid input. Please try again.");
            }
        }while (true);
    }
}