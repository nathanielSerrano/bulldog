# Bulldog

This is a repo that hosts different iterations of a program that simulates a dice game known as Bulldog. The purpose of this project is to compare the outputs of AI tools with regular, man-made code. This is done as a part of course COS 420 (Object-Oriented Analysis and Design) at the University of Southern Maine.

Author:
 * Nathaniel Serrano: https://github.com/nathanielSerrano

## What is Bulldog
The game of Bulldog is played by several players, who each take turns rolling a single six-sided die as many times as they wish, adding all of their roll results to a running total.
However, if the player rolls a 6, the player loses their score for that turn. The game ends when any player's score is greater than or equal to the winning score, which is 104 points by default.

## Navigating the Repository
 * The `Bulldog Writeups` directory contains files in .pdf format that possess lab books and reflections on different Bulldog Assignments and updates.
 * The `src` directory contains two subdirectories:
   * `Bulldog`
     * An early implementation of the Bulldog game without the use of AI tools. No updates were made to this version after its initial creation.
   * `Bulldog with AI`
     * The final release of Bulldog, created with the assistance of AI tools. This form of Bulldog offers ways to play it through a GUI made in Java's Swing or the CLI.
    
## How to Run
- To play the most recent version of the Bulldog game, download the `src/Bulldog with AI/src/` directory and all of its files, and run `BulldogGameGUI.java` in a compiler for Java, ensuring all downloaded files are in the same directory.
- This will launch the GUI's starting screen, where the user is prompted to create players for the game.
   <p align="center"> <img width="600" align="center" alt="Screenshot 2025-04-30 at 12 49 02 PM" src="https://github.com/user-attachments/assets/95bea06c-0b54-44d9-9cef-f8f37108b54c" />
   
- When creating players, the user can choose between 5 different types of `Player` objects for each player in the game, most of them being autonomous:
  * HumanPlayer
    * The HumanPlayer requires user input to determine whether to continue rolling or end their turn. If the user wishes to play a game of Bulldog themself, they should have at least one HumanPlayer in their game.
  * RandomPlayer
    * The RandomPlayer is an autonomous player that randomly chooses between rolling again or ending their turn.
  * FifteenPlayer
    * The FifteenPlayer is an autonomous player that will continue rolling until their turn score is equal to or greater than 15.
  * UniquePlayer
    * The UniquePlayer is an autonomous player conceptualized by an AI tool that continues rolling until they have rolled at least 3 times and their turn score is greater than 10.
  * WimpPlayer
    * The WimpPlayer is an autonomous player that always chooses to end their turn after their initial roll.
