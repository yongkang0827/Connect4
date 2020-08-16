/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package token;

import java.util.Scanner;
/**
 *
 * @author Yeu
 */
public class TokenCount {
    
    public void addPlayer(String nam, char symbol1, CircularLinkedList<Token> cirStr){
        char symbol;
        int zero = 0;
        
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println(nam + ", please enter token of your symbol(between a to z) : ");
            symbol = scan.next().charAt(0);
            
        }while(symbol < 'a' && symbol > 'z');
        
        Token tokName = new Token(nam, symbol, zero);

        cirStr.add(tokName);
    }
        
    public void addAllRoundToken(String nam, CircularLinkedList<Token> cirStr){       
        for(int i = 1; i < cirStr.getLength() + 1; i++){  
            if(cirStr.getEntry(i).getName().equals(nam)){                
                cirStr.getEntry(i).setAllCount(cirStr.getEntry(i).getAllCount() + cirStr.getEntry(i).getCount());
            }
        }    
    }
       
    public boolean addEachRoundToken(String nam, CircularLinkedList<Token> cirStr){    
       for(int i = 1; i < cirStr.getLength() + 1; i++){          
           if(cirStr.getEntry(i).getName().equals(nam)){  
               cirStr.getEntry(i).setCount(cirStr.getEntry(i).getCount() + 1);  
               return true;
           }
       }
       return false;
    }
    
    public void finishEachRound(CircularLinkedList<Token> cirStr){
        for(int i = 1; i < cirStr.getLength() + 1; i++){          
           if(cirStr.getEntry(i).getCount() != 0){  
               System.out.println(cirStr.getEntry(i).getName() + " : " + cirStr.getEntry(i).getCount());
               
               addAllRoundToken(cirStr.getEntry(i).getName(), cirStr);
               
               cirStr.getEntry(i).setCount(0);
           }
       }
    }
    
    public void finishAllRound(CircularLinkedList<Token> cirStr){
        System.out.println("\n\nTotal token of each player used\n");
        
        for(int i = 1; i < cirStr.getLength() + 1; i++){          
           if(cirStr.getEntry(i).getAllCount() != 0){  
               System.out.println(cirStr.getEntry(i).getName() + " : " + cirStr.getEntry(i).getToken() + " = " + cirStr.getEntry(i).getAllCount());
                
               cirStr.getEntry(i).setAllCount(0);
           }
       }
    }
    
    public static void main(String args[]){
       
        CircularLinkedList<Token> cirStr = new CircularLinkedList<>();   

        TokenCount to = new TokenCount();
        char symbol = 'a';
        
        to.addPlayer("LIM", symbol, cirStr);
        to.addPlayer("MING", symbol, cirStr);
                
        to.addEachRoundToken("LIM", cirStr);
        to.addEachRoundToken("MING", cirStr);
                
                
        to.finishEachRound(cirStr);

        to.finishAllRound(cirStr);
    }  
}
