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
    public void searchNode(int n);//move root to given position
    public void printNode(int n);//searchnode and display the value of the node at this position
    public boolean isRoot(BinaryTree.Node p);// return the given node is the top root or not
    public boolean isEmpty();
    public void clear();
    public int size();
    public BinaryTree.Node root();// return the top root of the tree
    public int layer(BinaryTree.Node node);//display which is the layer of node given
    public int depth(BinaryTree.Node node);//display the total layer in the tree
    public void displayPost(BinaryTree.Node node); //binary search tree in postorder form
     public void displayPre(BinaryTree.Node node);//binary search tree in preorder form
     public void displayIn(BinaryTree.Node node);//binary search tree in inorder form
}
