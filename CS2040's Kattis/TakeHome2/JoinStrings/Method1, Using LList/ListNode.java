package JoinStrings;

class ListNode {
	/* attributes */
	public int item;
	public ListNode next;

	/* constructors */
	public ListNode(int val) { this(val, null); }

	public ListNode(int val, ListNode n) { 
		item = val; 
		next = n; 
	}

	/* get the next ListNode */
	public ListNode getNext() { return next; }

	/* get the item of the ListNode */
	public int getItem() { return item; }

  /* set the item of the ListNode */
  public void setItem(int val) { item = val; }

	/* set the next reference */
	public void setNext(ListNode n) { next = n; }
}
