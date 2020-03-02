import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class JoinStringsRecurr {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> listStr = new ArrayList<>();
        int numStr = Integer.parseInt(br.readLine());
        List<ArrayList<Integer>> listIndex = new ArrayList<>();
        
        for (int i = 0; i < numStr; i++) {
            listStr.add(br.readLine());
            listIndex.add(new ArrayList<>());
        }
        int idx1 = 0, idx2 = 0, last = 0;
        for (int i = 0; i < numStr - 1; i++) {
            String[] temp = br.readLine().split(" ");
            idx1 = Integer.parseInt(temp[0]) - 1;
            idx2 = Integer.parseInt(temp[1]) - 1;
            listIndex.get(idx1).add(idx2);
            last = idx1;
        }
        
        JoinRecur(listStr, listIndex, last);
        br.close();
               
    }

    public static void JoinRecur(List<String> listStr, List<ArrayList<Integer>> listIndex, int idx) {
        
        // System.out.println(idx);
        System.out.print(listStr.get(idx));
        for (int i = 0; i < listIndex.get(idx).size(); i++) {
            //System.out.println("in");
            JoinRecur(listStr, listIndex, listIndex.get(idx).get(i));
        }
    }
}