/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.util.Scanner;
import token.CircularLinkedList;
import token.Token;
import token.TokenCount;

/**
 *
 * @author User
 */
public class PlayerConnectFour {
    
    //public static int round = 1;
    //for testing purpose
    public String addtoken(String playerName, int numOfPlayer){
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
    
    public int addPlayer(Player player, ListInterface<Player> PlayerList, CircularLinkedList<Token> CirStr){
        
        int numOfPlayer;
        int check = 0;
       
        
        Scanner scan = new Scanner(System.in);
        System.out.printf("         ==========================\n");
        System.out.printf("             Player Registration\n");
        System.out.printf("         ==========================\n");
        
        do{
            
            System.out.printf("Please Enter The Number Of Player For This Round:   ");
            numOfPlayer = scan.nextInt();
            
        }while(numOfPlayer < 2);
     
        System.out.printf("\nPlease Enter The Player Name:    \n");
        scan.nextLine();
        
        for(int i = 0; i < numOfPlayer; i++){
           
            System.out.printf("\nPlayer%2d Name:    ", i+1);
            
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
          
                TokenCount tok = new TokenCount();
                char symbol = 'a';
                tok.addPlayer(playerName, symbol, CirStr);           
            }
            else if (-1 == check || !Player.validateName(playerName)){
                i--;
                System.out.println("\nError Detected! Please Enter Again");
            }
           
        }
      return numOfPlayer;
    }
    
    public String[] assignedPlayer(Player player,ListInterface<Player> PlayerList,int numOfPlayer){
        
      
        int length = PlayerList.getLength();
        int x = 0;
        
        
        String[] playerName = new String[numOfPlayer];
        
        for(int i = 0; i < length; i ++){
            
            playerName[x] = PlayerList.getEntry(i).getName();
            x++;
        }
        
        return playerName;
    }
    
    public String[] retrievePlayerForEachRound(ListInterface<Player> PlayerList,ListInterface<Player> winnerList,int round){
        
        String [] playerName = new String[2];
        int length = winnerList.getLength();
        
      
       
      
        if(length == 0 && round == 1){
            
            playerName[0] = PlayerList.getEntry(0).getName();
            playerName[1] = PlayerList.getEntry(1).getName();
            
        }
        else if (length > 0 && round > 1){
           
            playerName[0] = winnerList.getEntry(length - 1).getName();
            playerName[1] = PlayerList.getEntry(length + 1).getName();
 
        }
        
        return playerName;
    }
    
    public int getNumberofRoundInAGame(int numOfPlayer){
        
        int round = numOfPlayer - 1;
        
        return round;
    }
    
    public void calculateAndAssignScore(double min, int tokenCount,ListInterface<Player> PlayerList, String playerName){
        
        int length = PlayerList.getLength();
        double playerScore;
        
        for(int i = 0; i < length; i++){
            
            if(PlayerList.getEntry(i).getName().equals(playerName)){
                playerScore = PlayerList.getEntry(i).getScore();
                double score = (double) min/tokenCount;
                
                 if(playerScore == 0){
                        PlayerList.getEntry(i).setScore(score);
                 }else{
                        score += PlayerList.getEntry(i).getScore();
                        PlayerList.getEntry(i).setScore(score);
                 }
            }
        }
    
    }
    
    public void displayPlayerDetails(ListInterface<Player> PlayerList, CircularLinkedList<Token> CirStr){
        
        System.out.printf("\t\t\t============================\n");
        System.out.printf("\t\t\t     Player Details\n");
        System.out.printf("\t\t\t============================\n");
        
        System.out.printf("=========================================================================\n");
        System.out.printf("||\t Player\t\t\tPlayer Name\t\t\tToken\t||\n");
        for(int i = 0; i < PlayerList.getLength(); i++){
           
            
            System.out.printf("||\tPlayer %d\t\t    %s\t\t\t %c\t||\n",i,PlayerList.getEntry(i).getName(),CirStr.getEntry(i + 1).getToken());  
        }
        System.out.printf("=========================================================================\n");
    }
}
