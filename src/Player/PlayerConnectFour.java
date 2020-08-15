/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class PlayerConnectFour {
    
    //for testing purpose
    String addtoken(String playerName, int numOfPlayer){
         String tokenName = null;
         ArrayList<token> tokenList = new ArrayList<>();
         
         String name = Character.toString(playerName.charAt(0));
         token t1 = new token(name);
         
         tokenList.add(t1);
         
         for (int i = 0; i < tokenList.getLength(); i++){
            tokenName  = tokenList.getEntry(i).getTokenColour();
             
         }
         
         return tokenName;
    }
    
    int addPlayer(Player player, ArrayList<Player> PlayerList){
        
        int numOfPlayer;
        int check = 0;
       
        
        Scanner scan = new Scanner(System.in);
        System.out.printf("         ==========================\n");
        System.out.printf("             Player Registration\n");
        System.out.printf("         ==========================\n");
        
        System.out.printf("Please Enter The Number Of Player For This Round:   ");
        numOfPlayer = scan.nextInt();
 
        System.out.printf("\nPlease Enter The Player Name:    \n\n");
        scan.nextLine();
        
        for(int i = 0; i < numOfPlayer; i++){
           
            System.out.printf("Player%2d Name:    ", i+1);
            
            String playerName = scan.nextLine();
            
            for(int j = 0; j < PlayerList.getLength(); j++){
                
                if(Character.compare(playerName.charAt(0), PlayerList.getEntry(j).getName().charAt(0)) == 0){
                    check = -1;
                }
                else{
                    check = 0;
                }
            }
            
            if(Player.validateName(playerName) && check == 0){
                
                String tokenName = addtoken(playerName, numOfPlayer);
            
                player = new Player(playerName,tokenName);
            
                PlayerList.add(player);
          
                
            }
            else if (-1 == check || !Player.validateName(playerName)){
                i--;
                System.out.println("\nError Detected! Please Enter Again\n");
            }
           
        }
      return numOfPlayer;
    }
    
    String[] assignedPlayer(Player player,ArrayList<Player> PlayerList,int numOfPlayer){
        
      
        int length = PlayerList.getLength();
        int x = 0;
        
        
        String[] playerName = new String[numOfPlayer];
        
        for(int i = 0; i < length; i ++){
            
            playerName[x] = PlayerList.getEntry(i).getName();
            System.out.println(PlayerList.getEntry(i).toString());
            x++;
        }
        
        return playerName;
    }
    
    String[] retrievePlayerForEachRound(String[] players,String[] winner,int round){
        
        String [] playerName = new String[2];
        int length = winner.length;
        
        if(length == 0 && round == 1){
            
            playerName[0] = players[0];
            playerName[1] = players[1];
            
        }
        else if (length > 0 && round > 1){
            
            playerName[0] = winner[length - 1];
            playerName[1] = players[length + 1];
 
        }
        
        return playerName;
    }
    
    int getNumberofRoundInAGame(int numOfPlayer){
        
        int round = numOfPlayer - 1;
        
        return round;
    }
    
    // prompts the user for a column, repeating until a valid choice is made
    //insert the token for symbol
    //insert the top of height and width of the gameboard for height and width
    //insert the board size for grid
    //
    public void insertToken(char symbol, Scanner input, int height, int width,char[][] grid,int lastCol,int lastTop) {
        //to assigned token in the main before pass in to function
        // token for current player
        //char symbol = currentPlayers[player].charAt(0);
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

    void calculateAndAssignScore(double min, int tokenCount,ArrayList<Player> PlayerList, String playerName){
        
        int length = PlayerList.getLength();
        double playerScore;
        
        for(int i = 0; i < length; i++){
            
            if(PlayerList.getEntry(i).getName().equals(playerName)){
                playerScore = PlayerList.getEntry(i).getScore();
                
                 if(playerScore == 0){
                     
                        double score = (double) min/tokenCount;
                        
                        PlayerList.getEntry(i).setScore(score);
                 }
            }
        }
    
    }
    
   
}
