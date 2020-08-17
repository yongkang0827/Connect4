/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

/**
 *
 * @author Joan Hau
 */
public class ArrayList<T> implements ListInterface<T> {
    
    private T[] arr;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity = 0;
    
    //Creates Empty ArrayList with Default Capacity = 10
    public ArrayList(){
       capacity = DEFAULT_CAPACITY;
       arr = (T[]) new Object[capacity];
    }
    
    //Creates Empty ArrayList with Specified initial Capacity
    public ArrayList(int initialCapacity){
        size = 0;
        arr = (T[]) new Object[initialCapacity];
    }
    
    @Override
    public boolean add(T newEntry){
        
       if(size < capacity){
           arr[size] = newEntry;
           size++;
           return true;
       }
       else{
           reallocate();
           arr[size] = newEntry;
           size++;
           return true;
       }
       
    }
    
    @Override
    public boolean add(int newPosition, T newEntry){
        
        if(newPosition < 0 || newPosition > size){
            return false;
        }
       
        
        if(isArrayFull()) {
            reallocate();
        }
        
        addGap(newPosition);
        
        arr[newPosition] = newEntry;
        size++;
        
        return true;
    }
    
    @Override
    public T getEntry(int givenPosition){
       
     if(!isEmpty()){
          if(givenPosition < 0 || givenPosition >= size){
           return null;
       }
       else{
           return arr[givenPosition];
       }
     }
      
     return null;
   }
  
    @Override
    public T remove(int givenPosition){
       
        if(!isEmpty()){
             if(givenPosition < 0 || givenPosition >= size){
           return null;
       }
      
         T returnEntry = arr[givenPosition];
       
         removeGap(givenPosition);
       
         size--;
         return returnEntry;
        }
      
       return null;
       
   }
   
    @Override
    public int getLength(){
       return this.size;
   }
   
    @Override
    public boolean replace(int givenPosition, T newEntry){
       
        if(!isEmpty()){
            if(givenPosition < 0 || givenPosition >= size){
                return false;
            }
            else{
                arr[givenPosition] = newEntry;
                return true;
            }
        }
        return false;
       
   }
   
    @Override
    public String subList(int start, int end){
        
        if(isEmpty()){
            return null;
        }
        
        if(start < 0 || start >= size || end < 0 || end >= size || end < start){
            return null;
        }
        String str = "";
        
        for(int i = start; i <= end; i++){
            
          str += arr[i] + "\n";
        }
        
        return str;
    }
    
    @Override
    public boolean contains(T anEntry){
        
        
        boolean found = false;
        for (int index = 0; !found && (index < size); index++) {
            if (anEntry.equals(arr[index])) {
                found = true;
            }
        }

        return found;
  
       // if(anEntry != null){
           
          // for(int i = 0; i < size; i++){
          //     if(arr[i] == anEntry){
          //         return true;
          //     }
         //  }
     //  }
      //  return false;
   }
   
    @Override
    public boolean isEmpty() {
       return size == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    
    @Override
    public void clear(){
        size = 0;
    }
    
    @Override
    public String toString(){
        String str = "";
        
        for(int index = 0; index < size; ++index){
            str += arr[index] + "\n";
        }
        
        return str;
    }
    
    private boolean isArrayFull(){
        return size == arr.length;
    }
    
    private void reallocate(){
        T[] tempArray = arr;
        capacity *= 2;
        
        arr = (T[]) new Object[capacity];
        
        for(int i = 0; i < size; i ++){
            arr[i] = tempArray[i];
        }
    }
    
    public int indexOf(T anEntry){
       
       if(anEntry != null){
           
           for(int i = 0; i < size; i++){
               if(arr[i] == anEntry){
                   return i;
               }
           }
       }
       else{
           return -1;
       }
       
       return -1;
   }
    
    private void removeGap(int givenPosition){
       
       for(int i = givenPosition + 1; i < size; i++){
           arr[i - 1] = arr[i];
       }
   }
    
    private void addGap(int newPosition){
         for(int i = size; i > newPosition; i--){
            arr[i] = arr[i - 1];
        }
    }
    
}
