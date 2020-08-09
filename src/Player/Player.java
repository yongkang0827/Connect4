/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.util.Objects;

/**
 *
 * @author Joan
 */
public class Player {
    
    private String name;
    private static int nextID = 1000;
    private static int number = 0;
    private int ID;
    private String tokenColour;
    private double score;
    token token = new token();
    
    public Player(int ID, String name, String tokenColour) {
        this.ID = ID;
        this.name = name;
        this.tokenColour = tokenColour;
        
        token.setAssignedPlayer(tokenColour, 1);
        this.ID = nextID++;
    }

    public Player() {
    }

    public Player(String name) {
        this.ID = nextID++;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static int getNextID() {
        return nextID;
    }
    
    public static void setNextID(int nextID) {
        Player.nextID = nextID;
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

    @Override
    public String toString() {
        number++;
        return "No. "+ " " + number + " " + name + " " + ID + " " + tokenColour + " " + score + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + this.ID;
        hash = 41 * hash + Objects.hashCode(this.tokenColour);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.score) ^ (Double.doubleToLongBits(this.score) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.token);
        return hash;
    }


    public static boolean validateName(String name) {
        
        String currentName = name ;
        String regexName = "^[aA-zZ]\\w{3,29}$";
        
        return !(name.length() < 4 || !currentName.matches(regexName));
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (!Objects.equals(this.tokenColour, other.tokenColour)) {
            return false;
        }
        if (!Objects.equals(this.score, other.score)) {
            return false;
        }
        return true;
    }
    
}
