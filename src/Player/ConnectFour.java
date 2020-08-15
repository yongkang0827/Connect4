/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

/**
 *
 * @author User
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// we are going to create a simple 2-players Connect Four implementation in Java 8
public class ConnectFour {

  // we define characters for players (R for Red, Y for Yellow)
  private static final char[] PLAYERS = {'R', 'Y'};
  // dimensions for our board
  private final int width, height;
  // grid for the board
  private final char[][] grid;
  // we store last move made by a player
  private int lastCol = -1, lastTop = -1;
  static int round = 1;
  public static String[] currentPlayers = new String[]{};
  public static String[] allPlayers = new String[]{};
  public static String[] winner = new String[]{};
  
  public ConnectFour(int w, int h) {
    width = w;
    height = h;
    grid = new char[h][];

    // init the grid will blank cell
    for (int i = 0; i < h; i++) {
      Arrays.fill(grid[i] = new char[w], '.');
    }
  }

  // we use Streams to make a more concise method 
  // for representing the board
  @Override
  public String toString() {
    return IntStream.range(0,  width).
           mapToObj(Integer::toString).
           collect(Collectors.joining()) + 
           "\n" +
           Arrays.stream(grid).
           map(String::new).
           collect(Collectors.joining("\n"));
  }

  // get string representation of the row containing 
  // the last play of the user
  public String horizontal() {
    return new String(grid[lastTop]);
  }

  // get string representation fo the col containing 
  // the last play of the user
  public String vertical() {
    StringBuilder sb = new StringBuilder(height);

    for (int h = 0; h < height; h++) {
      sb.append(grid[h][lastCol]);
    }

    return sb.toString();
  }

  // get string representation of the "/" diagonal 
  // containing the last play of the user
  public String slashDiagonal() {
    StringBuilder sb = new StringBuilder(height);

    for (int h = 0; h < height; h++) {
      int w = lastCol + lastTop - h;

      if (0 <= w && w < width) {
        sb.append(grid[h][w]);
      }
    }

    return sb.toString();
  }

  // get string representation of the "\" 
  // diagonal containing the last play of the user
  public String backslashDiagonal() {
    StringBuilder sb = new StringBuilder(height);

    for (int h = 0; h < height; h++) {
      int w = lastCol - lastTop + h;

      if (0 <= w && w < width) {
        sb.append(grid[h][w]);
      }
    }

    return sb.toString();
  }

  // static method checking if a substring is in str
  public static boolean contains(String str, String substring) {
    return str.indexOf(substring) >= 0;
  }

  // now, we create a method checking if last play is a winning play
  public boolean isWinningPlay() {
    if (lastCol == -1) {
      System.err.println("No move has been made yet");
      return false;
    }
     round++;
    char sym = grid[lastTop][lastCol];
    // winning streak with the last play symbol
    String streak = String.format("%c%c%c%c", sym, sym, sym, sym);

    // check if streak is in row, col, 
    // diagonal or backslash diagonal
    return contains(horizontal(), streak) || 
           contains(vertical(), streak) || 
           contains(slashDiagonal(), streak) || 
           contains(backslashDiagonal(), streak);
  }

  // prompts the user for a column, repeating until a valid choice is made
  public void chooseAndDrop(char symbol, Scanner input) {
    do {
      System.out.println("\nPlayer " + symbol + " turn: ");
      int col = input.nextInt();

      // check if column is ok
      if (!(0 <= col && col < width)) {
        System.out.println("Column must be between 0 and " + (width - 1));
        continue;
      }

      // now we can place the symbol to the first 
      // available row in the asked column
      for (int h = height - 1; h >= 0; h--) {
        if (grid[h][col] == '.') {
          grid[lastTop = h][lastCol = col] = symbol;
          return;
        }
      }

      // if column is full ==> we need to ask for a new input
      System.out.println("Column " + col + " is full.");
    } while (true);
  }

  public static void main(String[] args) {
      
      //ADD THE PLAYER BEFORE START THE GAME BOARD
      //DECLARATION
      Player playerN = new Player();
      ArrayList<Player> PlayerList = new ArrayList<>();
      PlayerConnectFour play = new PlayerConnectFour();
      
      //GET THE NUMBER OF PLAYER AFTER ADDING ALL THE PLAYER
      int numOfPlayer = play.addPlayer(playerN, PlayerList);
      
      //ASSIGN THE PLAYER INTO AN ARRAY
      
      allPlayers = play.assignedPlayer(playerN, PlayerList,numOfPlayer);
     
      
      //System.out.println(Arrays.toString(players));
      System.out.printf("\n\nLoading...");
      
      for(int i = 0; i < 10; i++){
          System.out.printf(".");
      }
      System.out.printf("\n");
    // we assemble all the pieces of the puzzle for 
    // building our Connect Four Game
    
      play.displayPlayerDetails(PlayerList);

        
        
     do{  
       try (Scanner input = new Scanner(System.in)) {
        
       currentPlayers = play.retrievePlayerForEachRound(allPlayers, winner, round);
       
       System.out.println(Arrays.toString(currentPlayers));
      // we define some variables for our game like 
      // dimensions and nb max of moves
      int height = 6; int width = 8; int moves = height * width;

      
      // we create the ConnectFour instance
      ConnectFour board = new ConnectFour(width, height);

      // we explain users how to enter their choices
      System.out.println("Use 0-" + (width - 1) + " to choose a column");
      // we display initial board
      System.out.println(board);

      // we iterate until max nb moves be reached
      // simple trick to change player turn at each iteration
      for (int player = 0; moves-- > 0; player = 1 - player) {
        // token for current player
        char symbol = currentPlayers[player].charAt(0);

        // we ask user to choose a column
        board.chooseAndDrop(symbol, input);

        // we display the board
        System.out.println(board);

        // we need to check if a player won. If not, 
        // we continue, otherwise, we display a message
        if (board.isWinningPlay()) {
           
          System.out.println("\nPlayer " + symbol + " wins!");
          
        }
      }
    
      System.out.println("Game over. No winner. Try again!");
    }
     }while(round < (play.getNumberofRoundInAGame(numOfPlayer)));
              
        
      
    
    
  }

}
//view rawConnectFour.java hosted with ❤ by GitHub