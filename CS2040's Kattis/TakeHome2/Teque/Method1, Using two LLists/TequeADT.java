import java.util.*;

public interface TequeADT {

	// add item to the back of the queue
    public void offerBack(Integer item);// also commonly known as enqueue

    public void offerFront(Integer item);

    public void offerMiddle(Integer item);

    public int getItem(Integer index);

    public void balanceTeque();
}
