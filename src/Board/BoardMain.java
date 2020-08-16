/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import Player.ArrayList;
import Player.Player;
import Player.PlayerConnectFour;
import java.util.Scanner;
import Player.ListInterface;
import java.io.IOException;

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
       
        
        int rows = 9; 
        int cols = 8;
        int connectNum = 4;
        int numOfPlayer;
        int round = 1;
        boolean insertSuccess, assignSuccess;
        int checkResult; // win will get turn else 0
        
        double startTime, timeTaken;
        String currentPlayer[];
        
        String winner;

        numOfPlayer = play.addPlayer(playerN, PlayerList);

        play.displayPlayerDetails(PlayerList);
        
        do{

        currentPlayer = play.retrievePlayerForEachRound(PlayerList, winnerList,round);
        System.out.println(currentPlayer[0] + " >> "+ currentPlayer[1]);
        ConnectFourBoard mainBoard = new ConnectFourBoard(currentPlayer[0], currentPlayer[1]);
        mainBoard.createNewBoard(rows, cols);
        mainBoard.setTime();
        startTime = mainBoard.getTime();
        
       
            
        do{
            mainBoard.displayBoard();
            
            do{
                insertSuccess = mainBoard.insertToken();
                
            }while(!insertSuccess);

            mainBoard.assignToken();
            
            if(insertSuccess){
               checkResult = mainBoard.checkResult(connectNum);
                
               if(checkResult != 0){
                   if(checkResult %2 == 0){
                        winner = currentPlayer[0];
                        Player playerW = new Player();
                        mainBoard.setTime();
                        timeTaken = mainBoard.totalTimeTaken(startTime);
                        play.calculateAndAssignScore(timeTaken,4,PlayerList,currentPlayer[0]);
                        playerW.setName(currentPlayer[0]);
                        winnerList.add(playerW);
                        round++;
                       
                   }else{
                        winner = currentPlayer[1];
                        Player playerW = new Player();
                        mainBoard.setTime();
                        timeTaken = mainBoard.totalTimeTaken(startTime);
                        play.calculateAndAssignScore(timeTaken,4,PlayerList,currentPlayer[0]);
                        playerW.setName(currentPlayer[1]);
                        winnerList.add(playerW);
                        round++;
                   }
                   mainBoard.displayBoard();
                   System.out.println("\nWinner is "+ winner.toUpperCase());
                   break;
               }
            }
            
        }while(insertSuccess);
        
        
        
        //while winner appear :
        mainBoard.setTime();
        timeTaken = mainBoard.totalTimeTaken(startTime);
        System.out.println("\n min: "+ timeTaken);
           
        
        }while(round <= play.getNumberofRoundInAGame(numOfPlayer));
        
    }
}
