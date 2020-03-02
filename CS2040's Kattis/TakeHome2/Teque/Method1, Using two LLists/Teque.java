
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Teque {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter(new BufferedWriter(new 
                                OutputStreamWriter(System.out)));
        TequeADT teque = new TequeMap();

        int numCommands = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < numCommands; i++) {
            
            String[] commands = br.readLine().split(" ");
            //System.out.println("loop"+i+commands[1]);
            switch(commands[0]) {
                case "push_front":
                    //System.out.println("front");
                    teque.offerFront(Integer.parseInt(commands[1]));
                    break;
                case "push_back":
                    teque.offerBack(Integer.parseInt(commands[1]));
                    break;
                case "push_middle":
                    teque.offerMiddle(Integer.parseInt(commands[1]));
                    break;
                case "get":
                //System.out.println("get");
                    pw.println(teque.getItem(Integer.parseInt(commands[1])));
                    break;
            }
        }
        br.close();
        pw.close();
    }
}