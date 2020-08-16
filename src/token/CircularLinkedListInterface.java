/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package token;

/**
 *
 * @author Yeu
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public interface CircularLinkedListInterface<T> {
    
     /**
   * Task: Adds a new entry to the end of the list. Entries currently in the
   * list are unaffected. The list's size is increased by 1.
   *
   * @param newEntry the object to be added as a new entry
   * @return true if the addition is successful, or false if the list is full
   */
  public boolean add(T newEntry); //done

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
  public boolean add(int newPosition, T newEntry); //
  
  /**
   * Task: Adds a new entry to the start of the list. Entries currently in the
   * list are unaffected. The list's size is increased by 1.
   *
   * @param newEntry the object to be added as a new entry
   * @return true if the addition is successful, or false if the list is full
   */
   public boolean addFirst(T newEntry);
    
   /**
   * Task: Adds a new entry to the end of the list. Entries currently in the
   * list are unaffected. The list's size is increased by 1.
   *
   * @param newEntry the object to be added as a new entry
   * @return true if the addition is successful, or false if the list is full
   */
    public boolean addLast(T newEntry);
    
  /**
   * Task: Removes the entry at a given position from the list. Entries
   * originally at positions higher than the given position are at the next
   * lower position within the list, and the list's size is decreased by 1.
   *
   * @param givenPosition an integer that indicates the position of the entry to
   * be removed
   * @return true if the deletion is successful, or false if the deletion list is fail
   */
  public boolean remove(int givenPosition);

   /**
   * Task: Removes the entry at the beginning from the list. And the list's size is decreased by 1.
   *
   *
   * @return true if the deletion is successful
   */
   public boolean removeFirst();

    
  /**
   * Task: Removes all entries from the list.
   */
  public void clear();

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
  public boolean replace(int givenPosition, T newEntry);
    
  /**
   * Task: Retrieves the entry at a given position in the list.
   *
   * @param givenPosition an integer that indicates the position of the desired
   * entry
   * @return a reference to the indicated entry or null, if either the list is
   * empty, givenPosition < 1, or givenPosition > getLength()
   */
  public T getEntry(int givenPosition);

  /**
    * Task: Retrieves the entry at a given position in the list.
    *
    * @param entry
    * @return the list
    */
  public T getEntryByValue(T entry);
  
  /**
   * Task: Sees whether the list contains a given entry.
   *
   * @param anEntry the object that is the desired entry
   * @return true if the list contains anEntry, or false if not
   */
  public boolean contains(T anEntry);

  /**
   * Task: Gets the number of entries in the list.
   *
   * @return the integer number of entries currently in the list
   */
  public int getLength();

  /**
   * Task: Sees whether the list is empty.
   *
   * @return true if the list is empty, or false if not
   */
  public boolean isEmpty();

  /**
   * Task: Sees whether the list is full.
   *
   * @return true if the list is full, or false if not
   */
  public boolean isFull();
  
}

