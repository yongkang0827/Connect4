/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class BinaryTree <T> implements BinaryTreeInterface<T>{
    class Node<T>{
    private T data;
    private Node parent;
    private Node left;
    private Node right;
		
// Constructs a new node to store the given data value.
	private Node(T data) {
		this.data = data;
 		//this.left = null;
 		//this.right = null;
	}

        private Node(T data,Node parent, Node left,Node right){
            this.data = data;
            this.parent=parent;
            this.left = left;
            this.right = right;
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
    }
        
        private Node root;
        private Node left;
        private Node right;
        private Node temp;
        private Node parent;
       
        public BinaryTree(){
        root=null;
        temp=root;
        }

    public Node getTemp() {
        return temp;
    }

    public void setTemp(Node temp) {
        this.temp = temp;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


        
      public void addRoot(T newEntry){
       root=new Node(newEntry);
       temp=root;
       parent=root;
   } 
    
    public void addChild(T newEntry1,T newEntry2){
       left=new Node(newEntry1,root,null,null);
       root.setLeft(left);
       
       right=new Node(newEntry2,root,null,null);
       root.setRight(right); 
       
   } 
  
    public void nextLeft(){
        parent=root;
        root=getRoot().getLeft();
    }
    
    public void nextRight(){
        parent=root;
        root=getRoot().getRight();
    }

    public void previous(){
        root=parent;
    }
    
        public void topRoot(){
        root=temp;
    }

    public Node getLeft() {
        return root.getLeft();
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return root.getRight();
    }

    public void setRight(Node right) {
        this.right = right;
    }
     
    public boolean isRoot(Node p) {
        return p == root;
    }
         
         
}
