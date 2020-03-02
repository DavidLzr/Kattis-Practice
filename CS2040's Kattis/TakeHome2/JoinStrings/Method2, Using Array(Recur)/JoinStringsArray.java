import java.util.List;
import java.util.ArrayList;
import java.io.*;

class joinstrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new 
                                OutputStreamWriter(System.out)));
        List<String> listStr = new ArrayList<>();
        List<Integer> newconcate = new ArrayList<>();
        List<Integer> combined = new ArrayList<>();
        
        int numStr = Integer.parseInt(br.readLine());
        listStr.add("");
        newconcate.add(0);
        combined.add(0);
        for (int i = 0; i < numStr; i++) {
            listStr.add(br.readLine());
            newconcate.add(0);
            combined.add(0);
        }
        
        int a = 1, b = 1;
        for (int i = 0; i < numStr - 1; i++) {
            String[] temp = br.readLine().split(" ");
            a = Integer.parseInt(temp[0]);
            b = Integer.parseInt(temp[1]);
            if (newconcate.get(a) == 0) {
                newconcate.set(a,b);
                combined.set(a,b);
                continue;
            }
    
            int x = newconcate.get(a);
            while (newconcate.get(x) > 0) {
                x = newconcate.get(x);
            }
            newconcate.set(a, b);
            combined.set(x, b);
        }

        while (combined.get(a) > 0) {
            pw.print(listStr.get(a));
            a = combined.get(a);
        }
        pw.print(listStr.get(a));
        
        br.close();
        pw.close();
    }
}