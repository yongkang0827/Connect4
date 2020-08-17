/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ranking;
import Player.*;

import java.awt.*;


/**
 *
 * @author Lee Ling
 */
public class LeaderBoard {
    
    /**
     * @param args the command line arguments
     */
    
    public static void overallRanking(SortedLinkedList<Ranking> rankingList){
        //title
        drawLine(12,28);
        System.out.println(String.format("%40s","Leader Board"));
        drawLine(12,28);
        
        drawLine2(52,9);
        System.out.println(String.format("%13s %14s %30s","Rank","Winner","Score"));
        System.out.println(String.format("%14s %14s %30s","-----","-------","------"));
        
        for(int i = 0; i < rankingList.getLength(); i++ ){
            System.out.println(String.format("%12d %-8s %-31s %.2f",
                    (i+1), 
                    " ",
                    rankingList.getEntry(i).getWinner(), 
                    rankingList.getEntry(i).getHighestScore()));
        }
        
        System.out.print("\n");
        drawLine2(52,9);
        
       // System.out.println(String.format("%40s %.2f !","The highest score is ",this.highestScore));
       // System.out.println(String.format("%20s %s %s !"," ", "Congratulations ",this.winner));
        
        System.out.print("\n");
        drawLine(52,9);
    }
    
    public static void drawLine(int length, int space){
        String line = "";
        for(int i = 0; i < space; i++){
            line += " ";
        }
        for(int i = 0; i < length; i++){
            line += "=";
        }
        System.out.println(line);
    }
    
    public static void drawLine2(int length, int space){
        String line = "";
        for(int i = 0; i < space; i++){
            line += " ";
        }
        for(int i = 0; i < length; i++){
            line += "-";
        }
        System.out.println(line);
    }
    
    public static void main(String[] args) {
        
        
        Player p1 = new Player("Lee1",'a');
        Player p2 = new Player("Joan2",'b');
        Player p3 = new Player("Rong3",'c');
        Player p4 = new Player("Chong4", 'd');
        Player p5 = new Player("Kang5",'e');
        
        ArrayList<Player> playerList = new ArrayList<>();
        ArrayList<Player> playerList2 = new ArrayList<>();
        ArrayList<Player> playerList3 = new ArrayList<>();
        SortedLinkedList<Player> sortedPlayerList = new SortedLinkedList<>();
        SortedLinkedList<Ranking> rankingList = new SortedLinkedList<>();
        
        //for record 1
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);
        playerList.add(p5);
        p1.setScore(20.0);
        p2.setScore(15.0);
        p3.setScore(16.0);
        p4.setScore(15.1);
        p5.setScore(10.0);
        
        for(int i = 0; i < playerList.getLength(); i++){
            Player temp = new Player();
            temp.clone(playerList.getEntry(i));
            sortedPlayerList.add(temp);
        }
        
        Ranking ranking = new Ranking(sortedPlayerList, 0.5);
        rankingList.add(ranking);
        sortedPlayerList.clear();
        
         //for record 2
        playerList2.add(p1);
        playerList2.add(p2);
        playerList2.add(p3);
        p1.setScore(11.0);
        p2.setScore(12.0);
        p3.setScore(5.0);
        
        for(int i = 0; i < playerList2.getLength(); i++){
            Player temp = new Player();
            temp.clone(playerList2.getEntry(i));
            sortedPlayerList.add(temp);
        }
        
        ranking = new Ranking(sortedPlayerList, 0.5);
        rankingList.add(ranking);
        sortedPlayerList.clear();
        
          //for record 3
        playerList3.add(p1);
        playerList3.add(p2);
        playerList3.add(p3);
        playerList3.add(p4);
        p1.setScore(10.0);
        p2.setScore(19.0);
        p3.setScore(5.0);
        p4.setScore(2.0);
        
        for(int i = 0; i < playerList3.getLength(); i++){
            Player temp = new Player();
            temp.clone(playerList3.getEntry(i));
            sortedPlayerList.add(temp);
        }
        
        ranking = new Ranking(sortedPlayerList, 0.5);
        rankingList.add(ranking);
        sortedPlayerList.clear();
        
        rankingList.desc();
        overallRanking(rankingList);
        
        
        //ranking.displayRanking();
        
        

    }
}
