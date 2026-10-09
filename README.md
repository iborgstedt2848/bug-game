# Bug Game

An interactive Java game built for my Data Structures and Algorithms course. A bug wanders randomly around an n x n board, and you find out whether it can cover every square before it runs out of moves.

## How the game works

You choose:

- **Board size:** `n` x `n`
- **Maximum moves:** `m`
- **Starting coordinate** of the bug

The bug then moves randomly `m` times, marking every square it lands on with an **X**. After `m` moves:

- **The bug wins** if every square on the board is marked.
- **The bug loses** if any squares are left unmarked.

You can keep playing round after round until you choose to quit. The game keeps a running tally of how many times the bug has won and lost.

## Running the game

1. Make sure you have the [Java JDK](https://adoptium.net/) installed (or use [BlueJ](https://www.bluej.org/), which this project was built in).
2. Clone the repository:
   ```bash
   git clone https://github.com/iborgstedt2848/bug-game.git
   cd bug-game
   ```
3. Compile and run `PlayBugGame`:
   ```bash
   javac *.java
   java PlayBugGame
   ```
   In BlueJ, open the project folder and run `PlayBugGame` to start the program.
4. Follow the prompts to enter the board size, number of moves, and starting coordinate.

## Project structure

| File | Purpose |
|------|---------|
| `PlayBugGame.java` | Entry point; run this class to start the game |
| `Bug.java` | The bug and its random movement |
| `Floor.java` | The n x n board and the marked squares |
| `Coord.java` | Board coordinates |
| `GameStats.java` | Tracks the bug's wins and losses across rounds |
| `Converse.java` | Handles the interaction with the user |
| `MyTest.java`, `TestMethods.java`, `TestPlacement.java`, `GradingTest.java` | Test classes |
| `Game Description` | Original project description |
| `package.bluej` | BlueJ project file |

The repository also contains compiled `.class` files and BlueJ `.ctxt` files, which are generated automatically.

## Version

03/23/23

## Author

Isabelle Borgstedt
