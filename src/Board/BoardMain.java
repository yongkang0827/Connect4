/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import Player.ArrayList;
import Player.Player;
import Player.PlayerConnectFour;
import Player.ListInterface;
import Ranking.Ranking;
import Ranking.SortedLinkedList;
import token.*;
import java.util.Scanner;

/**
 *
 * @author CYL
 */
public class BoardMain {
 
    
    
    public static void main(String args[]) {
     
       
        Player playerN = new Player();
        ListInterface<Player> PlayerList = new ArrayList<>();
        ListInterface<Player> winnerList = new ArrayList<>();
        PlayerConnectFour play = new PlayerConnectFour();
        SortedLinkedList<Player> sortedPlayerList = new SortedLinkedList<>();
        CircularLinkedList<Token> CirStr = new CircularLinkedList<>();
        TokenCount token = new TokenCount();        
       
        
        int rows = 9; 
        int cols = 8;
        int connectNum; 
        int numOfPlayer;
        int round = 1;
        boolean insertSuccess;
        int checkResult; // win will get turn else 0
        int turn = 0;
        
        double startTime, timeTaken;
        double totalTime = 0; // total time for all round
        String currentPlayer[];
        char currentToken[] = {'K', 'T'};
        
        String winner;

        //////
        numOfPlayer = play.addPlayer(playerN, PlayerList, CirStr);
        
        
        play.displayPlayerDetails(PlayerList, CirStr);
        
        connectNum = setConnectNum();
                
        do{

        currentPlayer = play.retrievePlayerForEachRound(PlayerList, winnerList,round);
        currentToken[0] = token.retrieveToken(currentPlayer[0], CirStr);
        currentToken[1] = token.retrieveToken(currentPlayer[1], CirStr);      
        
        System.out.println(currentPlayer[0] + " >> "+ currentPlayer[1]);
        ConnectFourBoard mainBoard = new ConnectFourBoard(currentPlayer, currentToken);
        mainBoard.createNewBoard(rows, cols);
        mainBoard.setTime();
        startTime = mainBoard.getTime();
        
        do{
            mainBoard.displayBoard();
            
            if(mainBoard.isAllColFull()){
                System.out.println("\nTHERE IS NO WINNER !! This round will PLAY AGAIN !");
                insertSuccess = false;
            }else{
                do{
                    insertSuccess = mainBoard.insertToken();
                
                }while(!insertSuccess);
            
                mainBoard.assignToken();

                turn++;

                if(turn % 2 == 1){
                    token.addEachRoundToken(currentPlayer[0], CirStr);
                }
                else
                {
                    token.addEachRoundToken(currentPlayer[1], CirStr);
                }
            }
            checkResult = mainBoard.checkResult(connectNum);

            if(checkResult != 0){
                if(checkResult %2 == 0){
                     winner = currentPlayer[0];
                     Player playerW = new Player();
                     mainBoard.setTime();
                     timeTaken = mainBoard.totalTimeTaken(startTime);
                     totalTime += timeTaken;
                     play.calculateAndAssignScore(timeTaken,CirStr.getEntry(1).getCount(),PlayerList,currentPlayer[0]);
                     playerW.setName(currentPlayer[0]);
                     winnerList.add(playerW);
                     round++;

                }else{
                     winner = currentPlayer[1];
                     Player playerW = new Player();
                     mainBoard.setTime();
                     timeTaken = mainBoard.totalTimeTaken(startTime);
                     totalTime += timeTaken;
                     play.calculateAndAssignScore(timeTaken,CirStr.getEntry(2).getCount(),PlayerList,currentPlayer[1]);
                     playerW.setName(currentPlayer[1]);
                     winnerList.add(playerW);
                     round++;
                }
                
                mainBoard.displayBoard();
                token.finishEachRound(CirStr);
                System.out.println("\nWinner is "+ winner.toUpperCase());
                break;
            }
            
            
        }while(insertSuccess);
        
        
        }while(round <= play.getNumberofRoundInAGame(numOfPlayer));
        
        for(int i = 0; i < PlayerList.getLength(); i++){
            Player temp = new Player();
            temp.clone(PlayerList.getEntry(i));
            sortedPlayerList.add(temp);
        }
        
        Ranking ranking = new Ranking(sortedPlayerList, totalTime);
        ranking.displayRanking();
    }

    public static int setConnectNum(){
        Scanner scan = new Scanner(System.in);
        char selectConnectNum = 2;
        boolean validSelection;
        
        do{
            System.out.println("\n Connect Number Mode   ");
            System.out.println(" ===================  ");
            System.out.println(" (1) Simple Mode - connect 3");
            System.out.println(" (2) Medium Mode - connect 4");
            System.out.println(" (3) Hard Mode - connect 5");
            System.out.print(" Pls enter the mode number (1/2/3) : ");
            String selection = scan.nextLine();

            if(selection.compareTo("") == 0){
                System.out.println("Pls enter a mode slection ...");
               validSelection = false;
               
            }else{
                selectConnectNum = selection.charAt(0);
            
                if(!Character.isDigit(selectConnectNum)){
                    System.out.println("\nNOT A NUMBER ! ");
                    validSelection = false;
                }else if( Character.getNumericValue(selectConnectNum) < 1 || Character.getNumericValue(selectConnectNum) > 3){
                    System.out.println("\nInvalid Selection ! Must 1 / 2 / 3 ... ");
                    validSelection = false;
                }else{
                    validSelection = true;
                }
            }
            
            
            
        }while( !validSelection);
        
        switch(Character.getNumericValue(selectConnectNum)){
            case 1:
                return 3;
            
            case 3:
                return 5;
            case 2:
            default:
                return 4;
        }
        
    }
}
