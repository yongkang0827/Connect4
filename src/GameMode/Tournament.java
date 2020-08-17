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
        static   BinaryTree tree=new BinaryTree();
    /*public static void main(String[] args) {
        GameMode simpleMode=new GameMode(1,"simpleMode");
ArrayList<Player> player = new ArrayList<>();
ListInterface<Player> winnerList = new ArrayList<>();
PlayerConnectFour play = new PlayerConnectFour();
 int round = 1;
        Player p1 = new Player("J",'L');
        Player p2 = new Player("o",'A');
        Player p3 = new Player("a",'Z');
        Player p4 = new Player("n",'X');
        Player p5 = new Player("H",'C');
        Player p6 = new Player("t",'V');
        Player p7 = new Player("y",'B');
        Player p8 = new Player("u",'N');
        
        player.add(p1);
        player.add(p2);
        player.add(p3);
        player.add(p4);
        player.add(p5);
        player.add(p6);
        player.add(p7);
        player.add(p8);

initialize(player);
//if(third().getData()=="-")
//System.out.print("|  |\n"+tree.getLeft().getData());
//tree.topRoot();
tree.displayPost(tree.topRoot());
System.out.print("|  |\n");
stepUp(p8);
tree.displayPost(tree.topRoot());
//group(3);
//tree.searchNode(tree.topRoot(), 7);
//System.out.print(" "+tree.getRoot().getPosition()+"\n_|_\n");
//System.out.print(" "+tree.topRoot().getPosition()+"\n_|_\n");
    System.out.print("|  |\n"+tree.getLeft().getData());
    System.out.print("  "+tree.getRight().getData()+"\n");
//System.out.print("\n_|_\n");
//tree.displayPre(tree.topRoot());
//System.out.print("\n_|_\n");
//tree.displayIn(tree.topRoot());
//play.retrievePlayerForEachRound(player,winnerList,round);
//tree.topRoot();
//    System.out.print(" "+tree.getRoot().getData()+"\n_|_\n");
//    System.out.print("|  |\n"+tree.getLeft().getData());
//    System.out.print("  "+tree.getRight().getData()+"\n");
//    tree.nextLeft();
////     System.out.print(tree.getRoot().getData());
// System.out.print(tree.getRoot().getData());
//    System.out.print(tree.getLeft().getData());
//    System.out.print(tree.getRight().getData()+"\n");
//    tree.beside();
//     System.out.print(tree.getRoot().getData());
//    System.out.print(tree.getLeft().getData());
//    System.out.print(tree.getRight().getData()+"\n");
//     tree.besidel();   
//    tree.nextLeft();
////     System.out.print(tree.getRoot().getData());
//    System.out.print(tree.getRoot().getData());
//    System.out.print(tree.getLeft().getData());
//    System.out.print(tree.getRight().getData()+"\n");
//    tree.beside();
//    System.out.print(tree.getRoot().getData());
//    System.out.print(tree.getLeft().getData());
//    System.out.print(tree.getRight().getData()+"\n");
//
//tree.topRoot();
//    tree.nextRight();
//        System.out.print(tree.getRoot().getData());
//    System.out.print(tree.getLeft().getData());
//    System.out.print(tree.getRight().getData()+"\n");
//    tree.nextLeft();
//    System.out.print(tree.getRoot().getData());
//    System.out.print(tree.getLeft().getData());
//    System.out.print(tree.getRight().getData()+"\n");
//    tree.beside();
//    System.out.print(tree.getRoot().getData());
//    System.out.print(tree.getLeft().getData());
//    System.out.print(tree.getRight().getData()+"\n");
//    tree.bottomLeft();
//    System.out.print(tree.getRoot().getData());
//    tree.previous();
//    System.out.print(tree.getRoot().getData());
//    tree.previous();
//    System.out.print(tree.getRoot().getData());
//    tree.nextRight();
//           System.out.print(tree.getLeft().getData());
//    System.out.print(tree.getRight().getData()+"\n");
//    tree.bottomLeft();
//System.out.print(tree.getRoot().getData());
  //  tree.previous();
  //  System.out.print(tree.getRoot().getData());
 //  tree.beside();
 //  System.out.print(tree.getRoot().getData());

//    System.out.print(tree.getLeft().getData());
//    System.out.print(tree.getRight().getData()+"\n");
}

//    public static void display(BinaryTree.Node node){
//            if(tree.getRoot().getData()==null)
//            return;
//
//            display(tree.nextLeft());
//
//             display(tree.nextRight());
//              System.out.print(tree.getRoot().getData());           
//        }*/
    
    public Tournament(){
    }
    
 
        public static void initialize(ListInterface<Player> player){//should be Player[]


         //tree.addChild(null, null);
//            int length=player.length;
            int i=0;
//       while(i<player.length){
//           length=length/2;
//           if(length==0){
////            if(tree.getLeft().getData()=="-"&&tree.getRight().getData()=="-"){
//            //if(player[i]==null){
//            tree.addChild(player[i],player[i+1]); 
//            tree.beside();
//            tree.addChild(player[i+2],player[i+3]); 
////            //player[i]=null;
//           i+=3;
//            tree.topRoot();
////            tree.nextRight();
////            tree.addChild(player[i],player[i+1]); 
////            tree.beside();
////            tree.addChild(player[i+2],player[i+3]); 
//            i+=3;
//            System.out.print(i);
//                System.out.print(player.length);
//            i=player.length;
//            }    
////            }
//        else{
//               tree.topRoot();
//               tree.addChild(null, null);
//            tree.bottomLeft();
//            if(tree.getRoot().getData()==null)
//            tree.nextLeft();
//            else tree.nextRight();
//           }
//            
//        }
//       }
//       
 //       while(length>1){
            tree.addRoot(null);
 //           System.out.print(length);
            tree.addChild(null, null);
//            tree.bottomLeft();
//            tree.previous();
//            if(tree.getRoot().getData()==null)
            tree.nextLeft();
            tree.addChild(null, null);
            tree.beside();
            tree.addChild(null, null);
            first();
            tree.addChild(player.getEntry(i),player.getEntry(i+1));
            i+=2;
            second();
            tree.addChild(player.getEntry(i),player.getEntry(i+1));
            i+=2;
            //tree.bottomRight();
            third();
            tree.addChild(player.getEntry(i),player.getEntry(i+1));
            i+=2;
            fourth();
            tree.addChild(player.getEntry(i),player.getEntry(i+1));
            i+=2;

//    System.out.print(tree.getLeft().getData());
//    System.out.print(tree.getRight().getData()+"\n");
//    System.out.print(tree.getLeft().getData());
 //   System.out.print(tree.getRight().getData()+"\n");
//            else tree.nextRight();
//            length=length/2;
        //}
   }
//}
        public void display(){
            tree.displayPost(tree.topRoot());
        }
        static int current=7;
        static int currentWin=0;
        public String[] retrievePlayerForEachRound(){
        tree.searchNode(tree.topRoot(), current);
        String [] playerName = new String[2];

            playerName[0] = ((Player)tree.getRoot().getLeft().getData()).getName();
            playerName[1] = ((Player)tree.getRoot().getRight().getData()).getName();
            current-=1;
   
        return playerName;
    }
        public static void stepUp(Player player){
            tree.searchNode(tree.topRoot(), current+1);
            if(player.getName()==((Player)tree.getRoot().getRight().getData()).getName())
                tree.getRoot().setData(tree.getRoot().getRight().getData());
            else tree.getRoot().setData(tree.getRoot().getLeft().getData());
        }
        
    public static BinaryTree.Node group(int n){
        
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
        
    public static BinaryTree.Node first(){
        return tree.travelLeft(2);
    }

        public static BinaryTree.Node second(){
            tree.travelLeft(2);
        return tree.beside();
    }

        public static BinaryTree.Node third(){
            tree.travelRight(2);
            return tree.besidel();
        }
        
        public static BinaryTree.Node fourth(){
            return tree.travelRight(2);
        }
}
