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
        boolean pass = false;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.printf("\n" + nam + ", please enter token of your symbol(between a to z) : ");
        
        do{          
            symbol = scan.next().charAt(0);
            
        }while(!validate(symbol));
        
        Token tokName = new Token(nam, symbol, zero);

        cirStr.add(tokName);
    }
    
    public boolean validate(char symbol){
        if(symbol >= 'a' && symbol <= 'z'){
            return true;
        }
        System.out.printf("\nPlease enter symbol (between a - z) : ");
        return false;
    }
        
    /*public void addAllRoundToken(String nam, CircularLinkedList<Token> cirStr){       
        for(int i = 1; i < cirStr.getLength() + 1; i++){  
            if(cirStr.getEntry(i).getName().equals(nam)){                
                cirStr.getEntry(i).setAllCount(cirStr.getEntry(i).getAllCount() + cirStr.getEntry(i).getCount());
            }
        }    
    }*/
       
    public void addEachRoundToken(String nam, CircularLinkedList<Token> cirStr){    
       for(int i = 1; i < cirStr.getLength() + 1; i++){          
           if(cirStr.getEntry(i).getName().equals(nam)){  
               cirStr.getEntry(i).setCount(cirStr.getEntry(i).getCount() + 1);          
           }
       }
    }
    
    public void finishEachRound(CircularLinkedList<Token> cirStr){
        System.out.printf("\n\n==============================================\n");
        System.out.printf("||            Total Token Used              ||\n");
        System.out.printf("==============================================\n");
        
        for(int i = 1; i < cirStr.getLength() + 1; i++){          
           if(cirStr.getEntry(i).getCount() != 0){  
               System.out.printf("|| %s : %d token\n", cirStr.getEntry(i).getName(), cirStr.getEntry(i).getCount());
               
               //addAllRoundToken(cirStr.getEntry(i).getName(), cirStr);
               
               //cirStr.getEntry(i).setCount(0);
           }
       }
       System.out.printf("==============================================\n");
    }
    
    /*public void finishAllRound(CircularLinkedList<Token> cirStr){
        System.out.println("\n\nTotal token of each player used\n");
        
        for(int i = 1; i < cirStr.getLength() + 1; i++){          
           if(cirStr.getEntry(i).getAllCount() != 0){  
               System.out.println(cirStr.getEntry(i).getName() + " : " + cirStr.getEntry(i).getToken() + " = " + cirStr.getEntry(i).getAllCount());
                
               cirStr.getEntry(i).setAllCount(0);
           }
       }
    }*/
    
    
    public char retrieveToken(String nam, CircularLinkedList<Token> cirStr){
        char a = '0';
        for(int i = 1; i < cirStr.getLength() + 1; i++){  
            if(cirStr.getEntry(i).getName().equals(nam)){                
                return cirStr.getEntry(i).getToken();
            }
        } 
        return a;
    }
}
