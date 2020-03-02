package JoinStrings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import java.util.ArrayList;


public class JoinStrings {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> listStr = new ArrayList<>();
        int numStr = Integer.parseInt(br.readLine());
        List<TailedLinkedList> listIndex = new ArrayList<>();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new 
                                OutputStreamWriter(System.out)));
        
        for (int i = 0; i < numStr; i++) {
            listStr.add(br.readLine());
            TailedLinkedList temp = new TailedLinkedList();
            temp.addBack(i);
            listIndex.add(temp);
            // System.out.println(listIndex.get(i).getFirst());
        }
        int idx1 = 0, idx2 = 0, last = 0;
        for (int i = 0; i < numStr - 1; i++) {
            String[] temp = br.readLine().split(" ");
            idx1 = Integer.parseInt(temp[0]) - 1;
            idx2 = Integer.parseInt(temp[1]) - 1;
            listIndex.get(idx1).listConcatenation(listIndex.get(idx2));
            //System.out.println(listIndex.get(idx1).size());
            last = idx1;
        }
        TailedLinkedList target = listIndex.get(last);
        //System.out.println(target.size());
        //ListNode curr = target.getHead();
        for (ListNode curr = target.getHead(); curr != null ; curr = curr.getNext()) {
            int temp = curr.getItem();
            pw.print(listStr.get(temp));
        }
        /*
        for (int i = 0; i < target.size(); i++) {
            //System.out.println(target.getItemAtIndex(i));
            pw.print(listStr.get(target.getItemAtIndex(i)));
        }*/
        pw.close();
        br.close();        
    }

    
}