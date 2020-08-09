/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

/**
 *
 * @author Joan
 */
public class token {
    
    private String tokenColour;
    private int assigned = 0;

    public token() {
    }
  
    
    public token(String tokenColour) {
        this.tokenColour = tokenColour;
        this.assigned = 0;
    }
    
    
    public String getTokenColour() {
        return tokenColour;
    }

  
    public void setTokenColour(String tokenColour) {
        this.tokenColour = tokenColour;
    }

    public int getAssigned() {
        return assigned;
    }

    public void setAssigned(int assigned) {
        this.assigned = assigned;
    }

    public void setAssignedPlayer(String tokenColour,int assigned){
        this.tokenColour = tokenColour;
        this.assigned = assigned;
    }
    @Override
    public String toString() {
        return "token{" + "tokenColour=" + tokenColour + ", assigned=" + assigned + '}';
    }

}
