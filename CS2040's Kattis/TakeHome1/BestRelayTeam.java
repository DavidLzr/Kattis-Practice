import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class BestRelayTeam {
    public static void main(String args[]) {
        ArrayList<Athelte> athelte = readAthelte();
        Collections.sort(athelte);
        double bestTime = athelte.get(athelte.size() - 1).other * 5;
        String[] bestTeam = new String[Athelte.groupSize];
        
        for (Athelte firstRun : athelte) {
            double time = 0;
            int numRun = 0;
            String[] team = new String[Athelte.groupSize];
            team[numRun++] = firstRun.name; 
            time += firstRun.first;
            for (Athelte otherRun : athelte) {
                if (otherRun != firstRun && numRun < team.length) {
                    time += otherRun.other;
                    team[numRun++] = otherRun.name;
                }
            }
            if (time < bestTime){
                bestTime = time;
                bestTeam = team;
            }
        }
        System.out.println(bestTime);
        for (int i = 0; i < bestTeam.length; i++) {
            System.out.println(bestTeam[i]);
        }
    }

    public static ArrayList<Athelte> readAthelte() {
        Scanner sc  = new Scanner(System.in);
        ArrayList<Athelte> athelte = new ArrayList<Athelte>();
        int numAthelte = sc.nextInt();
        for (int i = 0; i < numAthelte; i++) {
            athelte.add(new Athelte(sc.next(), sc.nextDouble(), sc.nextDouble()));
        }
        sc.close();
        return athelte;
    }
}

//must use Comparable here, if it is a standalone class then need to use
//Comparator
class Athelte implements Comparable<Athelte>{
    public static int groupSize = 4;
    public String name;
    public double first;
    public double other;
    
    public Athelte (String name, double first, double other) {
        this.name = name;
        this.first = first;
        this.other = other;
    }
    
    @Override
    public int compareTo (Athelte athelte) {
        if (this.other - athelte.other < 0)
            return -1;
        else if (Math.abs(this.other - athelte.other) <= 1e-9)
            return 0;
        else
            return 1;
       
    }
}
