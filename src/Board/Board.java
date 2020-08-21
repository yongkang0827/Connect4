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

public class Board {
    Scanner scan = new Scanner(System.in);
    
    double time; 
    int rows;
    int cols;
    
    LinkedList<Character> boardCol[] = new LinkedList[cols];
    
    int insertTokenPosition = 0;
    int turn = 1;
    
    String currentPlayer[] = new String[2];
    char currentToken[] = new char[2]; 
    
    public Board(String player[], char tokenChar[]) {
        this.currentPlayer = player;
        this.currentToken = tokenChar;
    }

    public double getTime() {
        return time;
    }

    public void setTime() {
        this.time = System.currentTimeMillis();
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getInsertTokenPosition() {
        return insertTokenPosition;
    }

    public void setInsertTokenPosition(int insertTokenPosition) {
        this.insertTokenPosition = insertTokenPosition;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public String[] getCurrentPlayer() {
        return currentPlayer;
    }

    public char[] getCurrentToken() {
        return currentToken;
    }
    
    public void setCurrentPlayer(String[] currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setCurrentToken(char[] currentToken) {
        this.currentToken = currentToken;
    }

    
    public void createNewBoard(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        boardCol = new LinkedList[cols];
         
         for(int j = 0; j < cols; j++){
             boardCol[j] = new LinkedList();
            for(int i = 0; i < rows; i++){
                boardCol[j].add('-');
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
                System.out.print(boardCol[j].getEntry(i)+" ");
                
            }
        }
        
    }
    
    public boolean insertToken(){
        
        if(turn % 2 == 1){
            System.out.print("\n\n"+currentPlayer[0] +"'s turn: ");
        }else{
            System.out.print("\n\n"+currentPlayer[1] +"'s turn: ");
        }

        String selectCol = scan.nextLine();
        
         if(selectCol.compareTo("") == 0){
            System.out.println("Pls enter a column number ...");
            return false;
        }
        char selectedCol = selectCol.charAt(0);
        
        if(Character.isDigit(selectedCol)){
            insertTokenPosition = Character.getNumericValue(selectedCol);
        }else{
            System.out.println("Invalid NUMBER ! \n\nPls try again...");
            return false;
        }

        
        //check selected column for insert token
        if(insertTokenPosition <= 0 || insertTokenPosition> cols){
            System.out.println("Invalid column number! Pls try again...");
            return false;
        }else{
            // check if col full
            int isColFull = rows;
            for(int i = 0; i < rows; i++){
                Character entry = boardCol[insertTokenPosition-1].getEntry(rows - 1 - i);
                if(entry == '-'){
                    break;
                }else{
                    isColFull--;
                }
            } 
            if(isColFull == 0){
                System.out.println("Col " +insertTokenPosition+" is full ! Pls proceed to another row ! ");
                return false;
            }
        }
       return true;
    }
   
    //--- save the token inserted position into linked list ----//
    public void assignToken(){
        boolean assignSuccess;
        int replaceRow = rows; 
        Character entry;
        do{
            replaceRow--;
            entry = boardCol[insertTokenPosition-1].getEntry(replaceRow);
        
        }while(entry != '-');
       
            
        if(turn % 2 == 1){
            assignSuccess = boardCol[insertTokenPosition-1].replace( replaceRow, currentToken[0]);
                 
        }else{
            assignSuccess = boardCol[insertTokenPosition-1].replace( replaceRow, currentToken[1]);
        }

        if(assignSuccess){
            turn++;
        }
    }

    
    //-----check win------//
    public int checkResult(int connectNum){
        Character entry;
        switch (connectNum) {
                case 3:
                    //check for horizontal win
                    for(int i = rows - 1 ; i > 0; i--){
                        for(int j = 0; j < cols - 2; j++){
                            entry = boardCol[j].getEntry(i);
                            
                            if( !(entry.equals('-')) && boardCol[j+1].getEntry(i).equals(entry) 
                                    && boardCol[j+2].getEntry(i).equals(entry)){
                                return turn;
                            }
                        }
                    }
                    
                    //check for vertical win
                    for(int j = 0; j < cols; j++){
                        for(int i = 0; i < rows - 2; i++){
                            entry = boardCol[j].getEntry(i);
                            
                            if( !(entry.equals('-')) && boardCol[j].getEntry(i+1).equals(entry) 
                                    && boardCol[j].getEntry(i+2).equals(entry)){
                                return turn;
                            }
                        }
                    }   
                   
                    //check for diagonal win (+ve slope)
                    for(int i = rows - 1 ; i > 2; i--){
                        for(int j = 0; j < cols - 2; j++){
                            entry = boardCol[j].getEntry(i);
                            
                            if( !(entry.equals('-')) && boardCol[j+1].getEntry(i-1).equals(entry) 
                                    && boardCol[j+2].getEntry(i-2).equals(entry)){
                                return turn;
                            }
                        }
                    }
                    
                    //check for diagonal win (-ve slope)
                    for(int i = rows - 1 ; i > 0; i--){
                        for(int j = cols - 1; j > 1; j--){
                            entry = boardCol[j].getEntry(i);
                            
                            if( !(entry.equals('-')) && boardCol[j-1].getEntry(i-1).equals(entry) 
                                    && boardCol[j-2].getEntry(i-2).equals(entry)){
                                return turn;
                            }
                        }
                    } 
                    
                    break;
                case 5:
                    //check for horizontal win
                     for(int i = rows - 1 ; i > 0; i--){
                        for(int j = 0; j < cols - 4; j++){
                            entry = boardCol[j].getEntry(i);
                            
                            if( !(entry.equals('-')) && boardCol[j+1].getEntry(i).equals(entry) 
                                    && boardCol[j+2].getEntry(i).equals(entry) && boardCol[j+3].getEntry(i).equals(entry)
                                    && boardCol[j+4].getEntry(i).equals(entry)){
                                return turn;
                            }
                        }
                    }
                    
                    //check for vertical win
                      for(int j = 0; j < cols; j++){
                        for(int i = 0; i < rows - 4; i++){
                            entry = boardCol[j].getEntry(i);
                            
                            if( !(entry.equals('-')) && boardCol[j].getEntry(i+1).equals(entry) 
                                    && boardCol[j].getEntry(i+2).equals(entry) && boardCol[j].getEntry(i+3).equals(entry)
                                    && boardCol[j].getEntry(i+4).equals(entry)){
                                return turn;
                            }
                        }
                    }   
                      
                    //check for diagonal win (+ve slope)
                    for(int i = rows - 1 ; i > 3; i--){
                        for(int j = 0; j < cols - 4; j++){
                            entry = boardCol[j].getEntry(i);
                            
                            if( !(entry.equals('-')) && boardCol[j+1].getEntry(i-1).equals(entry) 
                                    && boardCol[j+2].getEntry(i-2).equals(entry) && boardCol[j+3].getEntry(i-3).equals(entry)
                                    && boardCol[j+4].getEntry(i-4).equals(entry)){
                                return turn;
                            }
                        }
                    }
                      
                    //check for diagonal win (-ve slope)
                     for(int i = rows - 1 ; i > 3; i--){
                        for(int j = cols - 1; j > 3; j--){
                            entry = boardCol[j].getEntry(i);
                            
                            if( !(entry.equals('-')) && boardCol[j-1].getEntry(i-1).equals(entry) 
                                    && boardCol[j-2].getEntry(i-2).equals(entry) && boardCol[j-3].getEntry(i-3).equals(entry)
                                     && boardCol[j-4].getEntry(i-4).equals(entry)){
                                return turn;
                            }
                        }
                    } 
                    
                    break;
                default: // connect 4
                    
                    //check for horizontal win
                    for(int i = rows - 1 ; i >= 0; i--){
                        for(int j = 0; j < cols - 3; j++){
                            entry = boardCol[j].getEntry(i);
                            
                            if( !(entry.equals('-')) && boardCol[j+1].getEntry(i).equals(entry) 
                                    && boardCol[j+2].getEntry(i).equals(entry) && boardCol[j+3].getEntry(i).equals(entry)){
                                return turn;
                            }
                        }
                    }
                    
                    //check for vertical win
                    for(int j = 0; j < cols; j++){
                        for(int i = 0; i <= rows - 4; i++){
                            entry = boardCol[j].getEntry(i);
                            
                            if( !(entry.equals('-')) && boardCol[j].getEntry(i+1).equals(entry) 
                                    && boardCol[j].getEntry(i+2).equals(entry) && boardCol[j].getEntry(i+3).equals(entry)){
                                return turn;
                            }
                        }
                    }  
                    
                    //check for diagonal win (+ve slope)
                    for(int i = rows - 1 ; i > 2; i--){
                        for(int j = 0; j < cols - 3; j++){
                            entry = boardCol[j].getEntry(i);
                            
                            if( !(entry.equals('-')) && boardCol[j+1].getEntry(i-1).equals(entry) 
                                    && boardCol[j+2].getEntry(i-2).equals(entry) && boardCol[j+3].getEntry(i-3).equals(entry)){
                                return turn;
                            }
                        }
                    }
                    //check for diagonal win (-ve slope)
                    for(int i = rows - 1 ; i > 2; i--){
                        for(int j = cols - 1; j > 2; j--){
                            entry = boardCol[j].getEntry(i);
                            
                            if( !(entry.equals('-')) && boardCol[j-1].getEntry(i-1).equals(entry) 
                                    && boardCol[j-2].getEntry(i-2).equals(entry) && boardCol[j-3].getEntry(i-3).equals(entry)){
                                return turn;
                            }
                        }
                    } 
                    
                    break;
            }
        
            return 0;
    }
    
    
    //---- check if all col full ---//
    public boolean isAllColFull(){
        
        for(int j = 0; j < cols; j++){
            for(int i = 0; i < rows; i++){
                if( boardCol[j].getEntry(i) == '-'){
                    return false;
            } 
         }
        }
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
