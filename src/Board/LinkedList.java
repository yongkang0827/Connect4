/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 * @author Cheong Yin Lam
 */
public class LinkedList<T> implements ListInterface<T> {

    private Node node; // based on col
    private int length; // row
 
    public LinkedList() {
        clear();
    }
    
    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);	// create the new node

       if (isEmpty()) {
         node = newNode;
       } else {                        // add to end of nonempty list
         Node currentNode = node;	// traverse linked list with p pointing to the current node
         while (currentNode.next != null) { // while have not reached the last node
           currentNode = currentNode.next;
         }
         currentNode.next = newNode; // make last node reference new node
       }

       length++;
       return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        

        if ((newPosition >= 1) && (newPosition <= length + 1)) {
          Node newNode = new Node(newEntry);

          if (isEmpty() || (newPosition == 1)) { // case 1: add to beginning of list
            newNode.next = node;
            node = newNode;
          } else {								// case 2: list is not empty and newPosition > 1
            Node nodeBefore = node;
            for (int i = 1; i < newPosition - 1; ++i) {
              nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
            }

            newNode.next = nodeBefore.next;	// make new node point to current node at newPosition
            nodeBefore.next = newNode;		// make the node before point to the new node
          }

          length++;
          
        } else {
          return false;
        }

        return true;
    }

    
    @Override
    public T remove(int givenPosition) {
        T result = null;                

        if ((givenPosition >= 1) && (givenPosition <= length)) {
          if (givenPosition == 1) {      // case 1: remove first entry
            result = (T) node.data;     // save entry to be removed
            node = node.next;
          } else {                         // case 2: givenPosition > 1
            Node nodeBefore = node;
            for (int i = 1; i < givenPosition - 1; ++i) {
              nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
            }
            result = (T) nodeBefore.next.data;  // save entry to be removed
            nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the
          } 																// one to be deleted (to disconnect node from chain)

          length--;
        }

        return result; 
    }


    @Override
    public final void clear() {   
     node = null;
     length = 0;
    }

    
    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= length)) {
          Node currentNode = node;
          for (int i = 0; i < givenPosition - 1; ++i) {
            currentNode = currentNode.next;		// advance currentNode to next node
          }
          currentNode.data = newEntry;	// currentNode is pointing to the node at givenPosition
        } else {
          isSuccessful = false;
        }

        return isSuccessful;
    }

    
    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= length)) {
          Node currentNode = node;
          for (int i = 0; i < givenPosition - 1; ++i) {
            currentNode = currentNode.next;		// advance currentNode to next node
          }
          result = (T) currentNode.data;	// currentNode is pointing to the node at givenPosition
        }

        return result; 
    }

    
    @Override
    public boolean contains(T anEntry) {
         boolean found = false;
        Node currentNode = node;

        while (!found && (currentNode != null)) {
          if (anEntry.equals(currentNode.data)) {
            found = true;
          } else {
            currentNode = currentNode.next;
          }
        }
        return found;
    }

    
    @Override
    public int getLength() {
        return length;
    }

    
    @Override
    public boolean isEmpty() { // check if the specific col empty
       
        return length == 0;
    }

    
    @Override
    public boolean isFull() {  
         
      return false;
    }
    
    
    
    //---------- Node ----------//
     public class Node<T> {

        private T data; // entry in list
        private Node next; // link to next node

        private Node(T data) {
          this.data = data;
          next = null;
        }
        
        private Node(T data, Node next) {
          this.data = data;
          this.next = next;
        }
        
    }
}
