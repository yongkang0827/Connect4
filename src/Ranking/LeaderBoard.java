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
   
    public LeaderBoard(Ranking ranking){
        ranking.displayRanking();
    }
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Player p1 = new Player("Player1","0");
        Player p2 = new Player("Player2","1");
        Player p3 = new Player("Player3","2");
        Player p4 = new Player("Player4","3");
        Player p5 = new Player("Player5","4");
        
        ArrayList<Player> playerList = new ArrayList<>();
        SortedLinkedList<Player> sortedPlayerList = new SortedLinkedList<>();
        
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);
        playerList.add(p5);
        p1.setScore(20.0);
        p2.setScore(15.0);
        p3.setScore(25.0);
        p4.setScore(10.0);
        p5.setScore(10.0);
        
        
        
        for(int i = 0; i < playerList.getLength(); i++){
            Player temp = new Player();
            temp.clone(playerList.getEntry(i));
            sortedPlayerList.add(temp);
            //System.out.println(sortedPlayerList.getEntry(i).getName());
        }
        
        Ranking ranking = new Ranking(sortedPlayerList);
       // System.out.println(sortedPlayerList.getEntry(0).getName());
      /*  for(int i = 0; i < sortedPlayerList.getLength(); i++){
            System.out.println(sortedPlayerList.getEntry(i).getName());
        }*/
        
        
        new LeaderBoard(ranking);
        

    }
}
