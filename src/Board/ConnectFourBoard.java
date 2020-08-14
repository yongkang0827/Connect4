/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 *
 * @author Cheong Yin Lam
 */

import java.util.Scanner;

public class ConnectFourBoard {
    Scanner scan = new Scanner(System.in);
    
    double time; //(calculate startime and end time)
    int rows;
    int cols;
    Character board[][];
    LinkedList<Character> boardCol[] = new LinkedList[cols];
    int insertTokenPosition = 0;
    int turn = 1;
    boolean assignSuccess;
    String[] player = {"Choo", "Ong"};
    
    public ConnectFourBoard() {
        
    }

    public double getTime() {
        return time;
    }

    public void setTime() {
        this.time = System.currentTimeMillis();
    }
    
    public void createNewBoard(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        board = new Character[rows][cols];
        boardCol = new LinkedList[cols];
         
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                boardCol[j] = new LinkedList();
                board[i][j] = '-'; 
            }
        }
    }
    
    public void displayBoard(){
        
        // display column number
        System.out.print("\n");
        for(int j = 0; j < cols; j++){
            System.out.print((j+1) +" ");
        } 

        //display board
        for(int i = 0; i < rows; i++){
            System.out.print("\n");
            for(int j = 0; j < cols; j++){
                System.out.print(board[i][j]+" ");
            }
        }
        
    }
    
    public boolean insertToken(){
        
        if(turn % 2 == 1){
            System.out.print("\n\n"+player[0] +"'s turn: ");
        }else{
            System.out.print("\n\n"+player[1] +"'s turn: ");
        }

        insertTokenPosition = scan.nextInt();

        if(insertTokenPosition <= 0 || insertTokenPosition> cols){
            System.out.println("Invalid column number! Pls try again...");
            return false;
        }
        else if(boardCol[insertTokenPosition-1].getLength() == rows){
            System.out.println("Col " +insertTokenPosition+" is full ! Pls proceed to another row ! ");
            return false;
        }
       return true;
    }

    //--- save the token inserted position into linked list ----//
    public void assignToken(){
        
        if(turn % 2 == 1){
            assignSuccess = boardCol[insertTokenPosition-1].add('1');
                 
        }else{
            assignSuccess = boardCol[insertTokenPosition-1].add('2');

        }

        if(assignSuccess){
            for(int j = 0; j < cols; j++){
               for(int i = rows - 1; i >= 0; i--){   
                    Character entry = boardCol[j].getEntry(rows - i);
                    if((entry != null) && (Character.compare(board[i][j], '-') == 0)){
                        board[i][j] = entry;
                    }
                }
            }
            turn++;
        }
    }

    
    //-----check win------//
    public boolean checkResult(){
        
        return true;
    }
    
    //----- cal total time----//
    public double totalTimeTaken(double anotherTime){  //return min
      double timeTaken;
      
      if(time > anotherTime){
           timeTaken = time - anotherTime;
      }else{
          timeTaken = anotherTime - time;
      }
      return (timeTaken / 60000 );  // (/1000/60)
      
     }
   

}
