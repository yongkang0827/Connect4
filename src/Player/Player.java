/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.util.Objects;

/**
 *
 * @author Joan Hau
 */
public class Player implements Comparable<Player>{
    
    private String name;
    private String tokenColour;
    private double score;
    private int winner;
    

    public Player() {
    }

    public Player(String name, String tokenColour) {
        this.name = name;
        this.tokenColour = tokenColour;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTokenColour() {
        return tokenColour;
    }

    public void setTokenColour(String tokenColour) {
        this.tokenColour = tokenColour;
    }

    public double getScore() {
        return score;
    }
    

    public void setScore(double score) {
        this.score = score;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.tokenColour);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.score) ^ (Double.doubleToLongBits(this.score) >>> 32));
        hash = 43 * hash + this.winner;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (Double.doubleToLongBits(this.score) != Double.doubleToLongBits(other.score)) {
            return false;
        }
        if (this.winner != other.winner) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.tokenColour, other.tokenColour)) {
            return false;
        }
      
        return true;
    }
    
    public static boolean validateName(String name) {
        
        String currentName = name ;
        String regexName = "^[aA-zZ]\\w{3,29}$";
        
        return !(name.length() < 4 || !currentName.matches(regexName));
    }

    @Override
    public String toString() {
        return "name=" + name + ", tokenColour=" + tokenColour + ", score=" + score ;
    }
    
    @Override
    public int compareTo(Player player){
        return (int)(this.score - player.score);
    }
    
    public void clone(Player player){
        this.name = player.name;
        this.score = player.score;
        this.tokenColour = player.tokenColour;
        this.winner = player.winner;
    }
    
    
}
