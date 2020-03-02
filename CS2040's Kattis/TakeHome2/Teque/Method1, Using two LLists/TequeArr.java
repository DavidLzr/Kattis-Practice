import java.util.*;

// This implementation uses solution 2 to resolve full/empty state
class TequeArr implements TequeADT {
	public int[] arr;
	public int front, back;
	public int size;
	public int capacity;
	public final int INITSIZE = 1;

	public TequeArr() {
		arr = new int[INITSIZE]; // create array of integers
		front = 0; // the queue is empty
		back = 0;
		size = 0;
		capacity = INITSIZE;
	}

	//((size of teque)+1)/2
	public void offerBack(Integer item) {
		if (((back+1)%capacity) == front) // array is full
		  enlargeArr();
		arr[back] = item;
		back = (back + 1) % capacity;
		size++;
	}

	public void offerFront (Integer item) {
		if (((back+1)%capacity) == front) // array is full
		  enlargeArr();
		front = front - 1 >= 0 ? front - 1 : capacity - 1;
		arr[front] = item; 
		size++;
	}

	public void offerMiddle (Integer item) {
		if (((back+1)%capacity) == front) // array is full
		  enlargeArr();
        int middle = (size + 1)/2;
        middle = (front + middle)%capacity;
        int curr = back;
        
		while (curr != middle) {
			int prev = curr - 1 >= 0 ? curr - 1 : capacity - 1;
			arr[curr] = arr[prev];
			curr = prev;
		}
		arr[middle] = item;
		size++; 
		back = (back + 1) % capacity;
	}

	public int getItem(Integer index) {
		return arr[(front + index)%capacity];
	} 


	public boolean enlargeArr() {
		int newSize = capacity * 2;
		int[] temp = new int[newSize];
		for (int j=0; j < capacity; j++) {
			// copy the front (1st) element, 2nd element, ...,  in the 
			// original array to the 1st (index 0), 2nd (index 1), ...,
			// position in the enlarged array
			temp[j] = arr[(front+j) % capacity];
		}
		front = 0; 
		back = capacity - 1;
		arr = temp;
		capacity = newSize;
		return true;
	}


	@Override
	public void balanceTeque() {
		int a = 0;
	}
}
