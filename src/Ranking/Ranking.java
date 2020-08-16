/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ranking;;
import Player.*;

/**
 *
 * @author Lee Ling
 */
public class Ranking implements Comparable<Ranking> {
    private double highestScore;
    private String winner;
    private SortedLinkedList<Player> sortedPlayerList;
    private int playerNum;

    public Ranking(SortedLinkedList<Player> sortedPlayerList) {
        this.sortedPlayerList = sortedPlayerList;
        this.playerNum = sortedPlayerList.getLength();
        sortedPlayerList.desc();
        this.highestScore = sortedPlayerList.getEntry(0).getScore();
        this.winner = sortedPlayerList.getEntry(0).getName();
        
    }

    public SortedLinkedList<Player> getSortedPlayerList() {
        return sortedPlayerList;
    }

    public void setSortedPlayerList(SortedLinkedList<Player> sortedPlayerList) {
        this.sortedPlayerList = sortedPlayerList;
    }
    

    public double getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(double highestScore) {
        this.highestScore = highestScore;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
   

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }
    
    @Override
    public int compareTo(Ranking ranking){
        return (int)(this.highestScore - ranking.highestScore);
    }
    
    public void displayRanking(){
        //title
        drawLine(52,9);
        System.out.println(String.format("%40s","Leader Board"));
        drawLine(52,9);
        System.out.println(String.format("%13s %14s %30s","Rank","Winner","Score"));
        System.out.println(String.format("%14s %14s %30s","-----","-------","------"));
        
        for(int i = 0; i < this.sortedPlayerList.getLength(); i++ ){
            System.out.println(String.format("%12d %16s %29.2f",
                    (i+1), 
                    this.sortedPlayerList.getEntry(i).getName(), 
                    this.sortedPlayerList.getEntry(i).getScore()));
        }
        
        System.out.print("\n");
        drawLine2(52,9);
        
        System.out.println(String.format("%40s %.2f !","The highest score is ",this.highestScore));
        System.out.println(String.format("%20s %s %s !"," ", "Congratulations ",this.winner));
        
        System.out.print("\n");
        drawLine(52,9);
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
    
    
}

