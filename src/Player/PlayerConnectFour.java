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
    

    
    public int addPlayer(Player player, ListInterface<Player> PlayerList, CircularLinkedList<Token> CirStr,int gamemode){
        
        int numOfPlayer;
        int check = 0;
        String playerName = "";
        
        Scanner scan = new Scanner(System.in);
        System.out.printf("         ==========================\n");
        System.out.printf("             Player Registration\n");
        System.out.printf("         ==========================\n");
        
        boolean validSelection;
        char select = 4;
        
        if(gamemode==1){
        do{
            
            System.out.printf("Please Enter The Number Of Player For This Round:   ");
            String selection =  scan.nextLine();
            
        if(selection.compareTo("") == 0){
                System.out.println("Please Enter Number Of Player");
               validSelection = false;
               
            }else{
                select = selection.charAt(0);
            
                if(!Character.isDigit(select)){
                    System.out.println("\nNOT A NUMBER ! ");
                    validSelection = false;
                }else if( Character.getNumericValue(select) < 2 || Character.getNumericValue(select) > 9){
                    System.out.println("\nInvalid Selection ! Must between 2 to 10 player  ... ");
                    validSelection = false;
                }else{
                    validSelection = true;
                }
            }}while(!validSelection);
        
        switch(Character.getNumericValue(select)){
            case 2:
                numOfPlayer=2;
                break;
            case 3:
                numOfPlayer=3;
                break;
            case 4:
                numOfPlayer=4;
                break;
            case 5:
                numOfPlayer=5;
                break;
            case 6:
                numOfPlayer=6;
                break;
            case 7:
                numOfPlayer=7;
                break;
            case 8:
                numOfPlayer=8;
                break;
            case 9:
                numOfPlayer=9;
                break;

            default:
                numOfPlayer=10;
        }
        }
        else {
            
            do{
            
            System.out.printf("Please Enter The Number Of Player For Tournament （Only 4/8 player allowed) :   ");
            String selection =  scan.nextLine();

            if(selection.compareTo("") == 0){
                System.out.println("Please Enter Number Of Player");
               validSelection = false;
               
            }else{
                select = selection.charAt(0);
            
                if(!Character.isDigit(select)){
                    System.out.println("\nNOT A NUMBER ! ");
                    validSelection = false;
                }else if( Character.getNumericValue(select) != 4 && Character.getNumericValue(select) != 8){
                    System.out.println("\nInvalid Selection ! Must 4 / 8  ... ");
                    validSelection = false;
                }else{
                    validSelection = true;
                }
            }}while(!validSelection);
                if(Character.getNumericValue(select)==4)
                numOfPlayer= 4;
            else
                numOfPlayer= 8;
        }
     
        do{
            System.out.printf("\nPlease Enter The Player Name:    \n");
            //if(gamemode==1)
            //scan.nextLine();
        
            for(int i = 0; i < numOfPlayer; i++){
           
                System.out.printf("\nPlayer%2d Name:    ", i+1);
            
                playerName = scan.nextLine();
       
                if(validateName(playerName,PlayerList)){
                
            
                    player = new Player(playerName);
          
                    PlayerList.add(player);
                
                    TokenCount tok = new TokenCount();
                    char symbol = 'a';
                    tok.addPlayer(playerName, symbol, CirStr);   
                
                    for(int j = 0; j < PlayerList.getLength(); j++){
                   
                        if(PlayerList.getEntry(j).equals(player)){
                            PlayerList.getEntry(j).setToken(CirStr.getEntry(j + 1).getToken());
                        }
                    }
                    
                }
                else if (-1 == check || !validateName(playerName,PlayerList)){
                    i--;
                    System.out.println("\nError Detected! Please Enter Again");
                }
            
                
            }  
        }while("".equals(playerName));  
        
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
           
             System.out.println(String.format("||%12d %-18s %-31s %c\t||",
                    (i+1), 
                    " ",
                    PlayerList.getEntry(i).getName(), 
                    PlayerList.getEntry(i).getToken()));
            //System.out.printf("||\tPlayer %d\t\t    %s\t\t\t %c\t||\n",i+1,PlayerList.getEntry(i).getName(),PlayerList.getEntry(i).getToken());  
        }
        System.out.printf("=========================================================================\n");
    }
    
    public  boolean validateName(String name, ListInterface<Player> PlayerList) {
        
       
        
        String currentName = name ;
        String regexName = "^[aA-zZ]\\w{0,29}$";
        int check = 0;
        
        for(int i = 0; i < PlayerList.getLength(); i++){
            if(PlayerList.getEntry(i).getName().equals(name)){
                check = -1;
            }
        }
        return !(name.length() < 0 || !currentName.matches(regexName) || (check == -1)) ;
    }
}
