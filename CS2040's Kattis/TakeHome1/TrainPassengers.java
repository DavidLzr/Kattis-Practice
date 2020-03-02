import java.util.Scanner;
public class TrainPassengers {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int numStations = sc.nextInt();
        int onTrain = 0;
        boolean possible  = true;
        
        for (int i = 0; i < numStations && possible; i++) {
            int left = sc.nextInt();
            int enter = sc.nextInt();
            int stay = sc.nextInt();

            if (i == 0 && left != 0)
                possible = false;
            else if (i == numStations - 1)
                if (stay != 0 || enter != 0 || left > onTrain || left < onTrain)
                    possible = false;
        
            if (left > onTrain)
                possible = false;
            onTrain += enter - left;
            if (onTrain > capacity)
                possible = false;
            if (capacity - onTrain > 0 && stay > 0)
                possible = false;
        }
        if (possible)
            System.out.println("possible");
        else
            System.out.println("impossible");
        sc.close();
    }
}