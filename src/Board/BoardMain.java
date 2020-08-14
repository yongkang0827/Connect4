/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 *
 * @author CYL
 */
public class BoardMain {

    
    
    public static void main(String args[]) {
        
        int rows = 9; 
        int cols = 8;
        boolean insertSuccess, assignSuccess;
        ConnectFourBoard mainBoard = new ConnectFourBoard();
        double startTime, timeTaken;
        
        mainBoard.createNewBoard(rows, cols);
        mainBoard.setTime();
        startTime = mainBoard.getTime();
        
        do{
            mainBoard.displayBoard();
            
            do{
                insertSuccess = mainBoard.insertToken();
                
            }while(!insertSuccess);

            mainBoard.assignToken();
            
        }while(insertSuccess);
        
        
        
        
        
        //while winner appear :
        mainBoard.setTime();
        timeTaken = mainBoard.totalTimeTaken(startTime);
        System.out.println(" min: "+ timeTaken);
           
        
    }
}
