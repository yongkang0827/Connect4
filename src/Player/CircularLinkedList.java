/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import java.util.Scanner;

/**
 *
 * @author Joan Hau RSF2G5
 * @param <T>
 */
 class CircularLinkedList<T> implements CircularLinkedListInterface<T> {
    
    private Node nEw;
    private Node head;
    private Node tail;
    private Node temp;
    private Node last;
    
    private int size = 0;
    
    public CircularLinkedList(){
        clear();
    }
    
    /**
   * Task: Removes all entries from the list.
   */
    @Override
    public final void clear(){
        head = null;
        size = 0;
    }
    
   /**
   * Task: Adds a new entry to the end of the list. Entries currently in the
   * list are unaffected. The list's size is increased by 1.
   *
   * @param newEntry the object to be added as a new entry
   * @return true if the addition is successful, or false if the list is full
   */
    @Override //DONE!
    public boolean add(T newEntry){
      
        nEw = new Node(newEntry);
    
       //since there are no value inside the list
        //head and rear will be point to the new entry value
      if(isEmpty()){
          
          head = nEw;
          tail = nEw;
      }
      //if size != 0
      //the new entry will be as a tail of the list
      // the tail will be point to the address of the ned entry
      else{
          tail.next = nEw;
          nEw.next = head;
          tail = nEw;
      }
       
      size++;
    return true;
       
    }
    
   /**
   * Task: Adds a new entry to the start of the list. Entries currently in the
   * list are unaffected. The list's size is increased by 1.
   *
   * @param newEntry the object to be added as a new entry
   * @return true if the addition is successful, or false if the list is full
   */
    @Override //DONE!
    public boolean addFirst(T newEntry){
        
       
        //point to the entry
        nEw = new Node(newEntry);
        
        //since there are no value inside the list
        //head and rear will be point to the new entry value
        if(size == 0){
            head = nEw;
            tail = nEw;
        }
        //if size != 0
        //the new entry will be as a head of the list
        // the tail will be point to the address of the ned entry
        else{
            nEw.data = newEntry;
            nEw.next = head;
            tail.next = nEw;
            head = nEw;
        }
    
        size++;
        return true;
    }
    
   /**
   * Task: Adds a new entry to the end of the list. Entries currently in the
   * list are unaffected. The list's size is increased by 1.
   *
   * @param newEntry the object to be added as a new entry
   * @return true if the addition is successful, or false if the list is full
   */
    @Override //DONE!
    public boolean addLast(T newEntry){
      	
      
      nEw = new Node(newEntry);
    
       //since there are no value inside the list
        //head and rear will be point to the new entry value
      if(isEmpty()){
          
          head = nEw;
          tail = nEw;
      }
      //if size != 0
      //the new entry will be as a tail of the list
      // the tail will be point to the address of the ned entry
      else{
        
         tail.next = nEw;
         nEw.next = head;
         tail = nEw;
        
      }
       
      size++;
    return true;
    }
    
   /**
   * Task: Adds a new entry at a specified position within the list. Entries
   * originally at and above the specified position are at the next higher
   * position within the list. The list's size is increased by 1.
   *
   * @param newPosition an integer that specifies the desired position of the
   * new entry
   * @param newEntry the object to be added as a new entry
   * @return true if the addition is successful, or false if either the list is
   * full, newPosition < 1, or
   *          newPosition > getLength()+1
   */
    @Override //DONE!
  public boolean add(int newPosition, T newEntry) { 
      

    if ((newPosition >= 0) && (newPosition <= size + 1)) {
        
        nEw = new Node(newEntry);

       if(isEmpty()){
          
          head = nEw;
          tail = nEw;
          
       } 
       else {
           
            temp = head;
            for (int i = 0; i < newPosition - 1; i++) {
                temp = temp.next;		
            }

            nEw.next = temp.next;
            temp.next = nEw;		
        }

      size++;
    } else {
     return false;
    }

    return true;
  }
    
   /**
   * Task: Removes the entry at the beginning from the list. And the list's size is decreased by 1.
   *
   *
   * @return true if the deletion is successful
   */
    @Override //DONE!
    public boolean removeFirst(){
        
        temp = head;
        
        head = head.next;
        
        tail.next = head;
        
        temp.next = null;
        
        size--;
        
        return true;
    }
    
 
            
   /**
   * Task: Removes the entry at a given position from the list. Entries
   * originally at positions higher than the given position are at the next
   * lower position within the list, and the list's size is decreased by 1.
   *
   * @param givenPosition an integer that indicates the position of the entry to
   * be removed
   * @return true if the deletion is successful, or false if the deletion list is fail
   */
    @Override //DONE!
    public boolean remove(int givenPosition){
      
        temp = head;
        
        if(givenPosition >= 0 && givenPosition <= size + 1) {
           
            for(int i = 0; i < givenPosition - 1; i ++){
                temp = temp.next;
            }
            
            temp.next = temp.next.next;
        }
      
            
           
		size--;
                return true;
        }
        
    
    
    /**
    * Task: Retrieves the entry at a given position in the list.
    *
    * @param givenPosition an integer that indicates the position of the desired
    * entry
    * @return a reference to the indicated entry or null, if either the list is
    * empty, givenPosition < 1, or givenPosition > getLength()
    */
    @Override //DONE!
    public T getEntry(int givenPosition){
      
        
        if (givenPosition >= 1 && givenPosition <= size) {
			
		Node temp = head;
		for (int i = 0; i < givenPosition - 1; ++i) {
			temp = temp.next;
		}
		return temp.data;
        }else{
            return null;
        }
        
    }
    
    /**
    * Task: Retrieves the entry at a given position in the list.
    *
    * @param entry
    * @return the list
    */
    @Override //DONE!
    public T getEntryByValue(T entry){
        
        temp = head;
        
        while (null != temp && temp.data != entry) {
			temp = temp.next;
		}
		if (temp.data == entry) {
			return temp.data;
		}
		return null;
    }
    
   /**
   * Task: Sees whether the list contains a given entry.
   *
   * @param anEntry the object that is the desired entry
   * @return true if the list contains anEntry, or false if not
   */
    @Override //DONE!
    public boolean contains(T anEntry){
        Node currentNode = head;
        
        if(head == null){
            return false;
        }
        else{
            do{
                if(currentNode == anEntry){
                    return true;
                }
                currentNode = currentNode.next;
            }while(currentNode != head);
            
            return true;
        }
    }
    
    
     /**
   * Task: Replaces the entry at a given position in the list.
   *
   * @param givenPosition an integer that indicates the position of the entry to
   * be replaced
   * @param newEntry the object that will replace the entry at the position
   * givenPosition
   * @return true if the replacement occurs, or false if either the list is
   * empty, givenPosition < 1, or givenPosition > getLength()
   */
   @Override
  public boolean replace(int givenPosition, T newEntry) {
    
        
      if ((givenPosition >= 1) && (givenPosition <= size)) {
        
            temp = head;
            
            for (int i = 0; i < givenPosition - 1; ++i) {
                temp = temp.next;		
            }

            temp.data = newEntry;
    
        }

      return true;

  }
    
    @Override
    public String toString() {
        
        String str = "";
        Node currentNode = head;
        while (currentNode != null) {
            str += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        return str;
    }
    
    @Override
    public int getLength() {
        return size;
    }
     @Override
    public boolean isEmpty(){
        
        boolean result;
        
        result = size == 0;
        
        return result;
    }
    
    @Override
    public boolean isFull(){
        return false;
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
    
    public static void main(String[] args){
        
        CircularLinkedList<token> tokenList = new CircularLinkedList<>();
      
        System.out.println("Testing");
       
      
        token t1 =new token("1");
        token t2 = new token("2");
        token t3 = new token("3");
        token t4 = new token("4");
        token t5 = new token("5");
        
        tokenList.add(t1);
        tokenList.add(t2);
        tokenList.add(t3);
        tokenList.add(t4);
        tokenList.add(t5);
        
        System.out.println(tokenList.contains(t5));
        tokenList.replace(1, t5);
        System.out.println(tokenList.getLength());
        for(int i = 1; i < tokenList.getLength()+1; i ++){
            System.out.println(tokenList.getEntry(i).toString());
        }
        
    }
    
}
