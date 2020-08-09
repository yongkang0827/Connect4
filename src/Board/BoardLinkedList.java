/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 * @author Cheong Yin Lam
 */
public class BoardLinkedList<T> implements LinkedListInterface<T> {

    Node node[]; // based on col
    double time; //long startTime1 = System.currentTimeMillis();
    int totalRows; 
    int insertCol;
    char originEntry;
    
    public BoardLinkedList(int totalCols, int totalRows) {
        this.node = new Node[totalCols];
        this.totalRows = totalRows;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double minutes) {
        this.time = minutes; //= System.currentTimeMillis();
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getInsertCol() {
        return this.insertCol;
    }

    public void setInsertCol(int colInsert) {
        this.insertCol = colInsert;
    }
    
    
    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        originEntry = (char)newEntry;
        
        if(isFull()){
            return false;
        }else if(isEmpty()){
            node[insertCol] = newNode;
        }else{
            newNode.next = node[insertCol];
            node[insertCol] = newNode;
        }
        
        return true;
    }

    @Override
    public boolean add(int newPosition, T newTokenEntry) {
        
        Node newNode = new Node(newTokenEntry);
        this.insertCol = newPosition;
        if(isFull()){
            return false;
        }else if(isEmpty()){
            node[newPosition] = newNode;
        }else{
            newNode.next = node[newPosition];
            node[newPosition] = newNode;
        }
        
        return true;
    }

    /*************************************/
    @Override
    public T remove(int givenPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void clear() {   /** clear before going next play board */
       
      for(int i = 0; i < node.length; i++){
          node[i] = null;
      }
      
    }

    /************ NOT SURE ***************/
    @Override
    public boolean replace(int givenPosition, T newEntry) {
        
        if(isFull()){
          return false;  
        }
        
        if((char) node[givenPosition].data == originEntry){
             node[givenPosition] =  node[givenPosition].next;
             node[givenPosition].data = newEntry;
        }
        return true;
    }

    
    @Override
    public T getEntry(int givenPosition) {
        Node node1 = node[givenPosition];
        T specificNode = null;

        if(!isEmpty()){
          for (int i = 0 ; i > totalRows - givenPosition; ++i) {
            node1 = node1.next;		
          }
          specificNode = (T) node1.data;	

        }
        return specificNode; 
    }

    
    @Override
    public boolean contains(T tokenEntry) {
        if(!isEmpty()){
          do{
              if(node[insertCol].data == tokenEntry){
                  return true;
              }
          }while(node[insertCol].next != null);
        }
     
        return false;
    }

    @Override
    public int getLength() {
        return this.totalRows;
    }

    
    @Override
    public boolean isEmpty() { // check if the specific col empty
       
        return node[insertCol] == null;
    }

    
    @Override
    public boolean isFull() {  // check if the specific col full
        Node backUpNode = node[insertCol];
      
        for(int i = 0; i < totalRows; i++){
          if(isEmpty()){
              return false;
          }else{
              node[insertCol] = node[insertCol].next;
          }
      }
      
      //assign back
      node[insertCol] = backUpNode;
              
      return true;
    }
    
     public double calTimeTaken(double anotherTime){  //return min
      double timeTaken;
      
      if(time > anotherTime){
           timeTaken = time - anotherTime;
      }else{
          timeTaken = anotherTime - time;
      }
      return (timeTaken / 60000 );  // (/1000/60)
      
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
