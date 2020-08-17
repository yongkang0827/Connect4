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
    static int nextPosition =0;
    class Node<T>{
    private T data;
    private int position;
    private Node parent;
    private Node left;
    private Node right;
    //private int nextPosition =1;
		
// Constructs a new node to store the given data value.
	private Node(T data) {
		this.data = data;
                this.position=nextPosition;
 		//this.left = null;
 		//this.right = null;
                nextPosition++;
	}

        private Node(T data,Node parent, Node left,Node right){
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
        
        private Node root;
        private Node left;
        private Node right;
        private Node topRoot;
        private Node parent;
        private Node x=new Node("Node not exist ");
       
        public BinaryTree(){
        root=null;
        topRoot=root;

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
       root=new Node(newEntry);
       topRoot=root;
       parent=root;
   } 
    
    public void addChild(T newEntry1,T newEntry2){
       left=new Node(newEntry1,root,null,null);
       root.setLeft(left);
       
       right=new Node(newEntry2,root,null,null);
       root.setRight(right); 
       
   } 
  
    
    public void searchNode(Node node,int n){
        if(node==null){
            return;}
        
        if(n==node.getPosition()){
            root=node;
        System.out.print(node.getData()+"\n"); 
           }
        
        
        searchNode(node.getLeft(),n);
        searchNode(node.getRight(),n);
        
           
            
    }
        public boolean isRoot(Node p) {
        return p == getTopRoot();
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

    /*public Node getLeft() {
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
    }*/
     

    
    
         
         
}
