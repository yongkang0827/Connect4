/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameMode;
/**
 *
 * @author Tan Yong Kang (RSF2G5)
 */

public class BinaryTree <T> implements BinaryTreeInterface<T>{
        private Node root;
        private Node left;
        private Node right;
        private Node topRoot;
        private Node parent;
        private Node x=new Node("Node not exist ");
       static int nextPosition;
        public BinaryTree(){
        clear();
        nextPosition =1;
        root=null;
        topRoot=root;
        }
    
    class Node<T>{
    private T data;
    private int position;
    private Node parent;
    private Node left;
    private Node right;

		
// Constructs a new node to store the given data value.     

        private Node(T data) {
            this.data = data;
            this.position=nextPosition;
            this.left = null;
            this.right = null;
            nextPosition++;
        }

        private Node(T data,Node parent,Node left,Node right){
            this.data = data;
            this.parent=parent;
            this.left = left;
            this.right = right;
            this.position=nextPosition;
            nextPosition++;
        }
        
        

        public T getData() {
            if(data==null)
                return (T)"-";
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getPosition() {
            return position;
        }
    }
        
        

    public Node getX() {
        return x;
    }

    public Node getTopRoot() {
        return topRoot;
    }

    public void setTopRoot(Node topRoot) {
        this.topRoot = topRoot;
    }

    public Node getRoot() {
        if(root==null)
            return x;
        else return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


        
      public void addRoot(T newEntry){
       if(root==null){
       root=new Node(newEntry);
       topRoot=root;
       parent=root;
       } else System.out.print("Node already exist\n");
   } 
    
    public void addChild(T newEntry1,T newEntry2){
        if(root!=null){
        
            if(root.getLeft()==null){
                left=new Node(newEntry1,root,null,null);
                root.setLeft(left);
                
            }
            else{ System.out.print("Node already exist");
            System.out.print(root.getLeft().getData());
            }
       
            if(root.getRight()==null){
                right=new Node(newEntry2,root,null,null);
                root.setRight(right);
                
            }else System.out.print("Node already exist");
        
        }else System.out.print("Please add root first");
   } 
    
  
    
    public void searchNode(int n){
        searchNodeRecursive(topRoot,n);
    }
    
    public void searchNodeRecursive(Node node,int n){
        if(node==null){
            return;}
        
        if(n==node.getPosition()){
            root=node;
           }
        searchNodeRecursive(node.getLeft(),n);
        searchNodeRecursive(node.getRight(),n);     
    }
    
    public void printNode(int n){
        searchNodeRecursive(topRoot,n);
        System.out.print(root.getData()+"\n"); 
    }
    
        public boolean isRoot(Node p) {
        return p == getTopRoot();
        }
        
        public void clear(){
//                clearNode(topRoot);
            topRoot=null;
        }
        
         public boolean isEmpty() {
        return nextPosition == 1;
    }
         public int size(){
             return nextPosition-1;
         }
         
         public Node root(){
             return topRoot;
         }
         
         public int layer(Node node){
             
             if (node == topRoot) 
            return 1; 
             
         return 1+layer(node.parent);
         }
        
        public int depth(Node node){
             
             if (node == null) 
            return 0; 
             
         return 1+depth(node.left);
         }
 
        
        public void displayPost(Node node){
            if(node==null){
            return;}
           
            displayPost(node.getLeft());
            displayPost(node.getRight());  
        System.out.print(node.getData()+"\n");           
        }
        

        
        public void displayPre(Node node){
            if(node==null){
            return;}
           System.out.print(node.getData()+"\n");  
            displayPre(node.getLeft());
            displayPre(node.getRight());        
        }
    
        public void displayIn(Node node){
            if(node==null){
            return;}
            
            displayIn(node.getLeft());
            System.out.print(node.getData()+"\n"); 
            displayIn(node.getRight());        
        }
        
        public Node travelLeft(int n){
            topRoot();
            for(int i=0;i<n;i++){
                nextLeft();
            }
            return root;
        }
        
        public Node travelRight(int n){
            topRoot();
            for(int i=0;i<n;i++){
                nextRight();
            }
            return root;
        }
        
        public Node nextLeft(){
        parent=root;
        root=getRoot().getLeft();
        return root;
    }
    
    public Node nextRight(){
        parent=root;
        root=getRoot().getRight();
        return root;
    }
    
    public Node beside(){
        previous();
        nextRight();
    return root;
    }
    
        public Node besidel(){
        previous();
        nextLeft();
    return root;
        }

    public Node previous(){
        root=parent;
        return root;
    }
        
        public Node topRoot(){
        root=topRoot;
        return root;
    }
        
        /*public Node bottomLeft(){
            bottomLeftRecursive(topRoot);
            previous();
            previous();
            return root;
        }
        public void bottomLeftRecursive(Node node){
           if(node==null){
               //root=parent;
            return ;}
           
            bottomLeftRecursive(nextLeft());
            //displayPost(node.getRight());  
 

        }
        
        /*public void bottomRight(){
            topRoot();
            while(root!=null){
                nextRight();
            }
            previous();
        }*/

    public Node getLeft() {
        if(root.getLeft()==null)
            return x;
        else return root.getLeft();
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        if(root.getRight()==null)
            return x;
        else return root.getRight();
    }

    public void setRight(Node right) {
        this.right = right;
    }
     

    
    
         
         
}
