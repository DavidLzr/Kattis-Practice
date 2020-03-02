import java.io.*;
import java.util.StringTokenizer;

//import javax.lang.model.util.ElementScanner6;

import java.util.HashMap;
//import java.util.StringTokenizer;

//import sun.util.locale.StringTokenIterator;

public class JoinStringsFail {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(new BufferedWriter(new 
                                OutputStreamWriter(System.out)));
        String concate = "";
        int size = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= size; i++) {
            map.put(i, br.readLine());
        }
        if (size == 1)
            pw.println(map.get(1));
        for (int i = 1; i < size; i++) {
            int first = 0, second = 0;
            String[] temp = br.readLine().split(" ");
            first = Integer.parseInt(temp[0]);
            second = Integer.parseInt(temp[1]);
            // int first = Integer.parseInt(st.nextToken());
            // int second = Integer.parseInt(st.nextToken());
            map.put(first,map.get(first) + map.get(second));
            map.put(second, "");
            if (i == size - 1) {
                concate = map.get(first);
                pw.println(concate);
            }
        }
        br.close();
        pw.close();
    }

    /*
    public static HashMap<Integer, String> Reader() throws IOException {
        HashMap<Integer, String> map = new HashMap<>();
        BufferedRearder br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= size; i++) {

        }
    }
    */

}