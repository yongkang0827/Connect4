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
    private char token;
    private double score;
    

    public Player() {
    }

    public Player(String name, char token) {
        this.name = name;
        this.token = token;
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

    public char getToken() {
        return token;
    }

    public void setToken(char token) {
        this.token = token;
    }

    public double getScore() {
        return score;
    }
    

    public void setScore(double score) {
        this.score = score;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.token);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.score) ^ (Double.doubleToLongBits(this.score) >>> 32));
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.token, other.token)) {
            return false;
        }
      
        return true;
    }
    
    public static boolean validateName(String name, ListInterface<Player> PlayerList) {
        
       
        
        String currentName = name ;
        String regexName = "^[aA-zZ]\\w{0,29}$";
        int check = 0;
        
        for(int i = 0; i < PlayerList.getLength(); i++){
            if(PlayerList.getEntry(i).getName().equals(name)){
                check = -1;
            }
        }
        return !(name.length() < 0 || !currentName.matches(regexName) || (check == -1)) ;
    }

    @Override
    public String toString() {
        return "name=" + name + ", tokenColour=" + token + ", score=" + score ;
    }
    
    @Override
    public int compareTo(Player player){
        return (int)((this.score - player.score)*100);
    }
    
    public void clone(Player player){
        this.name = player.name;
        this.score = player.score;
        this.token = player.token;
    }
    
    
}
