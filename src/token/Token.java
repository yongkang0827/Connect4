/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package token;


//import java.util.logging.Logger;
/**
 *
 * @author Yeu
 */
public class Token{ 
    
    private String name;
    private char token;
    private int count;
    private int allCount;
    
    public Token() {
    }

    public Token(String name) {
        this.name = name;
    }

    public Token(char token) {
        this.token = token;
    }

    public Token(int allCount) {
        this.allCount = allCount;
    }

    public Token(String name, char token, int count) {
        this.name = name;
        this.count = count;
        this.token = token;
    }
    

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setToken(char token) {
        this.token = token;
    }

    public char getToken() {
        return token;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public int getCount() {
        return count;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    
    
    public int getAllCount() {
        return allCount;
    }

    @Override
    public String toString() {
        return "Token{" + "name=" + name + ", token=" + token + ", count=" + count + ", allCount=" + allCount + '}';
    }  
}
  
