/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import GameMode.GameMode;
import GameMode.Tournament;
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
    
    public BoardMain(){}
   
    public void displayLogo(){
        System.out.println(String.format("\n\n%5s %s", " ", "===================================================="));
        System.out.println(String.format("%5s %s", " ", "AAAA  AAAA  A  A  A  A  AAAA  AAAA AAAAA     A  A"));
        System.out.println(String.format("%5s %s", " ", "A     A  A  A  A  A  A  A     A      A       A  A"));
        System.out.println(String.format("%5s %s", " ", "A     A  A  AA A  AA A  AAAA  A      A       AAAAAA  "));
        System.out.println(String.format("%5s %s", " ", "A     A  A  A AA  A AA  A     A      A          A"));
        System.out.println(String.format("%5s %s", " ", "AAAA  AAAA  A  A  A  A  AAAA  AAAA   A          A"));
        System.out.println(String.format("%5s %s", " ", "===================================================="));
        System.out.println("\n");
        System.out.println(String.format("%20s %s", " ", "(1)  Play Game"));
        System.out.println(String.format("%20s %s", " ", "(2)  Leader Board"));
        System.out.println(String.format("%20s %s", " ", "(3)  Exit"));
        //System.out.println("\n");
        System.out.print(String.format("\n%13s %s", " ", "Your selection (1/2/3): "));
            
    }
    
    public void Game(SortedLinkedList<Ranking> rankingList){
        Player playerN = new Player();
        ListInterface<Player> PlayerList = new ArrayList<>();
        ListInterface<Player> winnerList = new ArrayList<>();
        PlayerConnectFour play = new PlayerConnectFour();
        SortedLinkedList<Player> sortedPlayerList = new SortedLinkedList<>();
        CircularLinkedList<Token> CirStr = new CircularLinkedList<>();
        TokenCount token = new TokenCount();        

        Tournament tour=new Tournament();
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
        
        
        int gamemode=selectGameMode();
        
        numOfPlayer = play.addPlayer(playerN, PlayerList, CirStr,gamemode);
        
        tour.initialize(PlayerList);
        
        if(gamemode==1)
        play.displayPlayerDetails(PlayerList, CirStr);
        else tour.display();
        
        
        connectNum = setConnectNum();
                
        do{
            if(gamemode==1)
        currentPlayer = play.retrievePlayerForEachRound(PlayerList, winnerList,round);
            else currentPlayer=tour.retrievePlayerForEachRound(numOfPlayer);
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
                    playerW.setName(currentPlayer[0]);
                    if(gamemode==1){
                     play.calculateAndAssignScore(timeTaken,CirStr.getEntry(1).getCount(),PlayerList,currentPlayer[0]);
                     winnerList.add(playerW);
                     }else tour.stepUp(playerW,numOfPlayer);
                     round++;

                }else{
                     winner = currentPlayer[1];
                     Player playerW = new Player();
                     mainBoard.setTime();
                     timeTaken = mainBoard.totalTimeTaken(startTime);
                     totalTime += timeTaken;
                     playerW.setName(currentPlayer[1]);
                     if(gamemode==1){
                     play.calculateAndAssignScore(timeTaken,CirStr.getEntry(2).getCount(),PlayerList,currentPlayer[1]);
                     winnerList.add(playerW);
                     }
                     else tour.stepUp(playerW,numOfPlayer);
                     round++;
                }
                
                mainBoard.displayBoard();
                token.finishEachRound(CirStr);
                System.out.println("\nWinner is "+ winner.toUpperCase());
                
                if(gamemode==2)
                tour.display();
                
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
        if(gamemode==1){
        ranking.displayRanking();
        rankingList.add(ranking);
        }else tour.champion();
    }

    public int setConnectNum(){
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
    
    public static int selectGameMode(){
        GameMode[] gamemode={
        new GameMode(1,"Classic Mode","Up to User"),
        new GameMode(2,"Tournament Mode","Must 4 / 8 Players")
        };
        
        Scanner scan = new Scanner(System.in);
         boolean validSelection;
        char selectConnectNum = 2;
        do{
            System.out.println("\n Please select your Game Mode   ");
            System.out.println(" ===================  ");
            for(int i=0;i<gamemode.length;i++){
                System.out.println("("+gamemode[i].getID() +") "+gamemode[i].getName()+"   (Player Allow :" + gamemode[i].getRule()+")");
                
            }
            System.out.print(" Pls enter the mode number (1/2) : ");
            String selection = scan.nextLine();

            if(selection.compareTo("") == 0){
                System.out.println("Pls enter a mode selection ...");
               validSelection = false;
               
            }else{
                selectConnectNum = selection.charAt(0);
            
                if(!Character.isDigit(selectConnectNum)){
                    System.out.println("\nNOT A NUMBER ! ");
                    validSelection = false;
                }else if( Character.getNumericValue(selectConnectNum) < 1 || Character.getNumericValue(selectConnectNum) > 2){
                    System.out.println("\nInvalid Selection ! Must 1 / 2  ... ");
                    validSelection = false;
                }else{
                    validSelection = true;
                }
            }
            
            
            
        }while( !validSelection);
            
            if(Character.getNumericValue(selectConnectNum)==1)
                return 1;
            else
                return 2;

        }

    public void leaderBoard(SortedLinkedList<Ranking> rankingList){
        drawLine(12,28);
        System.out.println(String.format("%40s","Leader Board"));
        drawLine(12,28);
        
        drawLine2(52,9);
        System.out.println(String.format("%13s %16s %28s","Rank","Player Name","Score"));
        System.out.println(String.format("%14s %14s %30s","-----","----------","------"));
        
        if(rankingList.getLength() <= 10){
            int j = 1;
            for(int i = rankingList.getLength() - 1; i >= 0 ; i-- ){
                System.out.println(String.format("%12d %-8s %-31s %.2f",
                        (j), 
                        " ",
                        rankingList.getEntry(i).getWinner(), 
                        rankingList.getEntry(i).getHighestScore()));
                j++;
            }
        }else{
            int j = 1;
            for(int i = 10; i >= 0; i-- ){
                System.out.println(String.format("%12d %-8s %-31s %.2f",
                        (j), 
                        " ",
                        rankingList.getEntry(i).getWinner(), 
                        rankingList.getEntry(i).getHighestScore()));
                j++;
            }
        }
        
        
        System.out.print("\n");
        drawLine2(52,9);
        
       // System.out.println(String.format("%40s %.2f !","The highest score is ",this.highestScore));
       // System.out.println(String.format("%20s %s %s !"," ", "Congratulations ",this.winner));
        
        System.out.print("\n");
        //drawLine(52,9);
    }
    
    public SortedLinkedList<Ranking> prevGameRecord(){
        Player p1 = new Player("Lee",'a');
        Player p2 = new Player("Joan",'b');
        Player p3 = new Player("Yeu",'c');
        Player p4 = new Player("Cheong", 'd');
        Player p5 = new Player("Kang",'e');
        
        ArrayList<Player> playerList = new ArrayList<>();
        SortedLinkedList<Player> sortedPlayerList = new SortedLinkedList<>();
        SortedLinkedList<Ranking> rankingList = new SortedLinkedList<>();
        
        //for record 1
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);
        playerList.add(p5);
        p1.setScore(200);
        p2.setScore(150);
        p3.setScore(160);
        p4.setScore(150);
        p5.setScore(100);
        
        for(int i = 0; i < playerList.getLength(); i++){
            Player temp = new Player();
            temp.clone(playerList.getEntry(i));
            sortedPlayerList.add(temp);
        }
        
        Ranking ranking = new Ranking(sortedPlayerList, 10.3);
        rankingList.add(ranking);
        sortedPlayerList.clear();
        playerList.clear();
        
         //for record 2
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        p1.setScore(110);
        p2.setScore(120);
        p3.setScore(50);
        
        for(int i = 0; i < playerList.getLength(); i++){
            Player temp = new Player();
            temp.clone(playerList.getEntry(i));
            sortedPlayerList.add(temp);
        }
        
        ranking = new Ranking(sortedPlayerList, 5.2);
        rankingList.add(ranking);
        sortedPlayerList.clear();
        playerList.clear();
        
        //for record 3
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);
        p1.setScore(100);
        p2.setScore(110);
        p3.setScore(50);
        p4.setScore(330);
        
        for(int i = 0; i < playerList.getLength(); i++){
            Player temp = new Player();
            temp.clone(playerList.getEntry(i));
            sortedPlayerList.add(temp);
        }
        
        ranking = new Ranking(sortedPlayerList, 10.5);
        rankingList.add(ranking);
        sortedPlayerList.clear();
        playerList.clear();
        
        //for record 4
        playerList.add(p3);
        playerList.add(p5);
        p3.setScore(50);
        p4.setScore(0);
        
        for(int i = 0; i < playerList.getLength(); i++){
            Player temp = new Player();
            temp.clone(playerList.getEntry(i));
            sortedPlayerList.add(temp);
        }
        
        ranking = new Ranking(sortedPlayerList, 2.5);
        rankingList.add(ranking);
        sortedPlayerList.clear();
        playerList.clear();
        
        return rankingList;
    }
    
    public void drawLine(int length, int space){
        String line = "";
        for(int i = 0; i < space; i++){
            line += " ";
        }
        for(int i = 0; i < length; i++){
            line += "=";
        }
        System.out.println(line);
    }
    
    public void drawLine2(int length, int space){
        String line = "";
        for(int i = 0; i < space; i++){
            line += " ";
        }
        for(int i = 0; i < length; i++){
            line += "-";
        }
        System.out.println(line);
    }
    
    public static void main(String args[]) {
        BoardMain boardMain = new BoardMain();
        Scanner scan = new Scanner(System.in);
        SortedLinkedList<Ranking> rankingList = boardMain.prevGameRecord();

        int menuSelection = 0;
        boolean validMenuSelection = false;

        ////// 
        do{
            do{
                validMenuSelection = false;
                
                boardMain.displayLogo();
                String input = scan.nextLine();
                System.out.println(" ");
                
                 if(input.compareTo("") == 0){
                    System.out.println("Pls enter a slection ...");
                    validMenuSelection = false;
                }else{
                     if(Character.isDigit(input.charAt(0))){
                        menuSelection = Integer.parseInt(input);
                        if(menuSelection >= 1 && menuSelection <= 3){
                            validMenuSelection = true;
                        }else{
                            System.out.println(String.format("%s %s", " ", "Invalid selection! Please enter your selection between 1 - 3\n"));
                            validMenuSelection = false;
                        }    
                    }else{
                        System.out.println(String.format("%s %s", " ", "Invalid selection! Please enter digit only\n"));
                        validMenuSelection = false;
                    }
                 }

            }while(validMenuSelection == false);
            
            switch(menuSelection){
                case 1:

                    boardMain.Game(rankingList);
                    break;

                case 2:
                    //Ranking
                    boardMain.leaderBoard(rankingList);
                    break;
                case 3:
                    //Exit
                    System.out.println(String.format("%11s %s", " ", "Hope you have a nice day! Bye!!"));
                    break;
                default:
                    break;
            }
            
        }while(menuSelection != 3);
        
        
        
}
}
