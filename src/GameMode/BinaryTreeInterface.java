package GameMode;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tan Yong Kang (RSF2G5)
 */
public interface BinaryTreeInterface<T> {
    public void addRoot(T newEntry);
    public void addChild(T newEntry1,T newEntry2);
    public void searchNode(BinaryTree.Node node,int n);
    public boolean isRoot(BinaryTree.Node p);
    public void displayPost(BinaryTree.Node node); 
     public void displayPre(BinaryTree.Node node);
     public void displayIn(BinaryTree.Node node);
//    public void addRight();
//    public void delete();
 //   public void root();//return root node
 //   public boolean isEmpty();
    //to be continue
}
