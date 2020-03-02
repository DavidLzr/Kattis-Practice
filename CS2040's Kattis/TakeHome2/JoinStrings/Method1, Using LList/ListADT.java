package JoinStrings;

// list interface for a list of integers
// Note: 1st item is at index 0, last item at index N-1 (where N is number of items in the list)
public interface ListADT {
	public boolean isEmpty(); // Return true if list is empty; otherwise return false.
	public int     size(); // Return number of items in the list

  //  access items in the list
  public int     indexOf(int item); // return index of item if item is found in the list, otherwise return -1
	public boolean contains(int item); // return true if item is in the list false otherwise
	public int     getItemAtIndex(int index); // get item at index
	public int     getFirst(); // get first item
	public int     getLast(); //get last item
    
  // add items to the list
  public void    addAtIndex(int index, int item); // add item at position index, 
                                                  // shifting all current items from index onwards to the right by 1 
                                                  // add item to the back if index == size() 
	public void    addFront(int item); // add item to front of list
	public void    addBack(int item); // add item to back of list

	// remove items from the list
	public int     removeAtIndex(int index); // remove item at index and return it                              
	public int     removeFront(); // remove 1st item and return it
	public int     removeBack(); // remove last item and return it

	// print out the list from index 0 to index N-1
	//public void listConcatenation(ListADT list);
	public void    print();
}
