/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import java.util.Scanner;

/**
 *
 * @author CYL
 */
public class BoardMain {

    
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int rows = 9; 
        int cols = 8;
        int connectNum = 4;
        boolean insertSuccess, assignSuccess;
        int checkResult; // win will get turn else 0
        
        double startTime, timeTaken;
        char newRound;
        String currentPlayer[] = {"Choo", "Ong"};
        String winner;
        
        do{
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
                   }else{
                       winner = currentPlayer[1];
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
           
        
        
        //prompt to start a new round and get new board
         System.out.println("Start another round? >> ");
         String startNewRound = scan.nextLine();
         newRound = startNewRound.toLowerCase().charAt(0);
         
        }while(newRound == 'y');
    }
}
