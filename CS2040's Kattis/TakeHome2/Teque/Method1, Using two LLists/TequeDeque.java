import java.util.ArrayDeque;
import java.util.Deque;


class TequeDeque implements TequeADT {
    private Deque<Integer> firstPart, secondPart;

    public TequeDeque() {
        firstPart = new ArrayDeque<>();
        secondPart = new ArrayDeque<>();
    }
    public void offerBack(Integer item) {
        secondPart.addLast(item);
        balanceTeque();
    }

    public void offerFront(Integer item) {
        firstPart.addFirst(item);
        balanceTeque();
    }

    public void offerMiddle(Integer item) {
        if (secondPart.size() > firstPart.size()) {
            balanceTeque();
            secondPart.addFirst(item);
        }
        else
            secondPart.addFirst(item);
    }

    public int getItem(Integer index) {
        if (index < firstPart.size()) {
            int count = 0;
            for (Integer item : firstPart) {
                if (count == index)
                    return item;
                count++;
            }
        }
        else {
            int count = 0;
            for (Integer item : secondPart) {
                if (count == index - firstPart.size())
                    return item;
                count++;
            }
        }
        return 0;
    }

    public void balanceTeque() {
        if (firstPart.size() > secondPart.size())       
            secondPart.addFirst(firstPart.removeLast());
        
        else if (firstPart.size() < secondPart.size())
            firstPart.addLast(secondPart.removeFirst());
    }
    
}