package GameMode;
import GameMode.BinaryTree;
import GameMode.GameMode;
import Player.ArrayList;
import Player.ListInterface;
import Player.Player;
import Player.PlayerConnectFour;
import java.util.Scanner;
import token.CircularLinkedList;
import token.Token;
import token.TokenCount;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tan Yong Kang (RSF2G5)
 */
public class Tournament{



    private static BinaryTree tree;
    static int size;
    public Tournament(){
        tree=new BinaryTree();
        size=7;
    }
    
 
        public  static void initialize(ListInterface<Player> player){
            int i=0;
            tree.addRoot(null);
            int length=player.getLength();

            int position=1;
            int check=0;
            if(player.getLength()==4)
                check=2;
            else if (player.getLength()==8)
                check=1;
            while(length>check){
                length=length/2;
                tree.searchNode(position);  
                tree.addChild(null, null);
                position++;
            }
            if(length<=2){
                while(i<=player.getLength()-2){
                    
                    tree.searchNode(position);
                    tree.addChild(player.getEntry(i),player.getEntry(i+1));
                    i+=2;
                    position++;
                }}
   }

        public void display(){

            int currentLayer=0;
            int times=1;
            String display;
            System.out.print(" \nTOURNAMENT TREE  \n");
            for(int i=1;i<=tree.size();i++){
                tree.searchNode(i);
                if(currentLayer!=tree.layer(tree.getRoot())){
                currentLayer=tree.layer(tree.getRoot());
                 System.out.print("\n");
                for(int j=0;j<times;j++){
                if(tree.layer(tree.getRoot())==1)
                System.out.print(String.format("%27s", "|"));
                if(tree.layer(tree.getRoot())==2)
                System.out.print(String.format("%18s", "|"));
                if(tree.layer(tree.getRoot())==3)
                System.out.print(String.format("%11s", "|"));
                if(tree.layer(tree.getRoot())==4)
                System.out.print(String.format("%6s", "|"));
                
                }
                times*=2;
                System.out.print("\n");
                
                }
                //System.out.print("   "+tree.getRoot().getData()+"    ");
                
                if(tree.getRoot().getData().equals("-"))
                display="PENDING";
                else display=((Player)tree.getRoot().getData()).getName();
                if(tree.layer(tree.getRoot())==1)
                System.out.print(String.format("%30s", display));
                if(tree.layer(tree.getRoot())==2)
                System.out.print(String.format("%20s", display));
                if(tree.layer(tree.getRoot())==3)
                System.out.print(String.format("%12s", display));
                if(tree.layer(tree.getRoot())==4)
                System.out.print(String.format("%6s", display));
            }
            System.out.print("\n\n");
        }
        
        public void champion(){
            tree.topRoot();
            System.out.print("Champion of the tournament : "+((Player)tree.getRoot().getData()).getName()+ "\nCongratulations !\n");
        }

        public  String[] retrievePlayerForEachRound(int numPlayer){
            int current=size;
            if(numPlayer==4){
                current=size-4;
            }
        tree.searchNode(current);
        String [] playerName = new String[2];

            playerName[0] = ((Player)tree.getRoot().getLeft().getData()).getName();
            playerName[1] = ((Player)tree.getRoot().getRight().getData()).getName();
            size-=1;
   
        return playerName;
    }
        public  void stepUp(Player player,int numPlayer){
            int current=size;
            if(numPlayer==4){
                current=size-4;
            }
            tree.searchNode(current+1);
            if(player.getName()==((Player)tree.getRoot().getRight().getData()).getName())
                tree.getRoot().setData(tree.getRoot().getRight().getData());
            else tree.getRoot().setData(tree.getRoot().getLeft().getData());
            
            
        }
        
        public void clear(){
            tree.clear();
        }
        
    public  BinaryTree.Node group(int n){
        
        if(n==1)
            return first();
        else if(n==2)
            return second();
        else if(n==3)
            return third();
        else if(n==4)
            return fourth();
        
        return tree.getX();
    }
        
    public  BinaryTree.Node first(){
        return tree.travelLeft(2);
    }

        public  BinaryTree.Node second(){
            tree.travelLeft(2);
        return tree.beside();
    }

        public  BinaryTree.Node third(){
            tree.travelRight(2);
            return tree.besidel();
        }
        
        public  BinaryTree.Node fourth(){
            return tree.travelRight(2);
        }
}
