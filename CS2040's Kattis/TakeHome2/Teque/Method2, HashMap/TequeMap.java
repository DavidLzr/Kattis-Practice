import java.util.HashMap;

class TequeMap implements TequeADT {
    public HashMap<Integer, Integer> first = new HashMap<>();
    public HashMap<Integer, Integer> second = new HashMap<>();
    public int firstMin = 0;
    public int firstMaitem = 0;
    public int secondMin = 0;
    public int secondMaitem = 0;

    public void balanceTeque() {
        if (second.size() > first.size()+1) {
            first.put(firstMaitem, second.get(secondMin));
            firstMaitem += 1;
            secondMin += 1;
            second.remove(secondMin-1);
            return;
        }
        else if (first.size() > second.size()) {
            firstMaitem -= 1;
            secondMin -= 1;
            second.put(secondMin, first.get(firstMaitem));
            first.remove(firstMaitem);
            return;
        }
        
    }
    public void offerFront(Integer item) {
        firstMin -= 1;
        first.put(firstMin, item);
        balanceTeque();
    }

    public void offerBack(Integer item) {
        second.put(secondMaitem, item);
        secondMaitem += 1;
        balanceTeque();
    }

    public void offerMiddle(Integer item) {
        if (first.size() == second.size()) {
            secondMin -= 1;
            second.put(secondMin, item);
        }
        else {
            first.put(firstMaitem, second.get(secondMin));
            firstMaitem += 1;
            second.put(secondMin, item);
        }
    }

    public int getItem(Integer indeitem) {
        if (indeitem < firstMaitem - firstMin)
            return first.get(firstMin + indeitem);
        indeitem -= (firstMaitem - firstMin);
        return second.get(secondMin + indeitem);
    }





}