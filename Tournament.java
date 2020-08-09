/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Tournament<T> implements TreeInterface<T>{
    class Node{
    private T data;
    private Node left;
    private Node right;
		
// Constructs a new node to store the given data value.
	private Node(T data) {
		this.data = data;
 		this.left = null;
 		this.right = null;
	}

        private Node(T data, Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
      
        
}
    private Node root;
    
   private void child(T newEntry){
            Node child=new Node(newEntry);
        }
        


    public Tournament(){
        root=null;
    }
   
    public void add(T newEntry){
       Node newNode=new Node(newEntry);
   } 
    
    public void add(T newEntry,Node left,Node right){
       Node newNode=new Node(newEntry,left,right);
   } 
    
  /*  private Node insert(Node current, T newEntry) {
 
    if (current == null) {
        return new Node(newEntry);
    }
 
    if (newEntry < current.data) {
        current.left= insert(current.left, newEntry);
    } else if (newEntry > current.newEntry) {
        current.right = insert(current.right, newEntry);
    }
 
    return current;
}*/
    public boolean isRoot(Node p) {
        return p == root;
    }
    
   /* public boolean isEmpty() {
        return size() == 0;
    }*/

    //havent done 
        public void initialize(T[] player){//should be Player[]
            int length=player.length;
        if(player.length/2==0){
            root=null;
            root.left=new Node(player[0]);
            root.right=new Node(player[1]);//using hardcode first
           add(null,root.left,root.right);

        }
        else{
            root=null;
            root.left=null;
            root.right=null;
               initialize(player);
        }
       //root=number;
      //left=number/2;
      //right=number%2;
   } 
    

}
