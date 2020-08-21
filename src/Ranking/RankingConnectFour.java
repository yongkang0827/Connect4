/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ranking;

import Player.ArrayList;
import Player.Player;
import Board.BoardMain;

/**
 *
 * @author Lee Ling
 */
public class RankingConnectFour {
    BoardMain board = new BoardMain();
    
    public void leaderBoard(SortedLinkedList<Ranking> rankingList){
        board.drawLine(12,28);
        System.out.println(String.format("%40s","Leader Board"));
        board.drawLine(12,28);
        
        board.drawLine2(52,9);
        System.out.println(String.format("%13s %16s %28s","Rank","Player Name","Score"));
        System.out.println(String.format("%14s %14s %30s","-----","----------","------"));
        
        if(rankingList.getLength() <= 10){
            int j = 1;
            for(int i = rankingList.getLength() - 1; i >= 0 ; i-- ){
                System.out.println(String.format("%12d %-8s %-31s %.2f",
                        (j), 
                        " ",
                        rankingList.getEntry(i).getWinner(), 
                        rankingList.getEntry(i).getHighestScore()
                        //rankingList.getEntry(i).getTotalTime()
                ));
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
        board.drawLine2(52,9);
        
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
}
