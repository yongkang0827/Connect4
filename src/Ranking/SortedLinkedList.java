/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ranking;

/**
 *
 * @author Lee Ling
 */
public class SortedLinkedList <T extends Comparable<T>> implements SortedListInterface<T>{
    private Node firstNode;
    private int length;

    public SortedLinkedList() {
        firstNode = null;
        length = 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);

        Node currentNode = firstNode; 
        Node previousNode = null; 
          
        while (currentNode != null && newEntry.compareTo(currentNode.data) > 0) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (isEmpty() || (previousNode == null)) { // CASE 1: add at beginning
            newNode.next = firstNode;
            firstNode = newNode;
        } else {	// CASE 2: add in the middle or at the end, i.e. after nodeBefore
            newNode.next = currentNode;
            previousNode.next = newNode;
        }
        length++;
        return true;
    }

    @Override
    public boolean remove(T anEntry) {
        /*if (isEmpty()) {
            throw new RuntimeException("List is empty...");
        }else{
            
        }*/
        throw new UnsupportedOperationException();	// Left as Practical exercise
    }

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node tempNode = firstNode;
        int pos = 1;

        while (!found && (tempNode != null)) {
            if (anEntry.compareTo(tempNode.data) <= 0) {
                found = true;
            } else {
                tempNode = tempNode.next;
                pos++;
            }
        }
        if (tempNode != null && tempNode.data.equals(anEntry)) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public T getEntry(int givenPosition){
       
      T result = null;

        if ((givenPosition >= 0) && (givenPosition < length)) {
          Node currentNode = firstNode;
          for (int i = 0; i < givenPosition; ++i) {
            currentNode = currentNode.next;		// advance currentNode to next node
          }
          result = (T) currentNode.data;	// currentNode is pointing to the node at givenPosition
        }

        return result; 
       
   }
    
   @Override
   public int getPosition(T anEntry){
       boolean found = false;
       Node currentNode = firstNode;
       for(int i = 0; i < length; i++){
           if(currentNode.data.compareTo(anEntry) == 0){
               return i;
           }else{
               currentNode = currentNode.next;
           }
       }
       if(!found)
           return -1;
       
       return -1;
   }
    
   @Override
    public int getLength() {
        return length;
    }

    @Override
    public final void clear() {
        firstNode = null;
        length = 0;
    }

    @Override
    public boolean isEmpty() {
        return (length == 0);
    }

    @Override
    public String toString() {
        String outputStr = "";
        Node currentNode = firstNode;
        while (currentNode != null) {
            outputStr += currentNode.data + "\n";;
            currentNode = currentNode.next;
        }
        return outputStr;
    }
    
    @Override
    public void desc(){
        Node previous = null;
        Node current = this.firstNode;
	Node next;
	while (current != null) {
		next = current.next;
		current.next = previous;
		previous = current;
		current = next;
	}
	this.firstNode = previous;
         
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
