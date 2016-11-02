import java.io.*;
import java.util.Scanner;

public class AngryProfessorSolution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numCases = Integer.parseInt(s.nextLine());
        int i = 0;
        while(i < numCases){
            String[] thresholdInfo = s.nextLine().split(" ");
            int numStudents = Integer.parseInt(thresholdInfo[0]);
            int cancellationThreshold = Integer.parseInt(thresholdInfo[1]);
            String[] arrivalTimes = s.nextLine().split(" ");
            int onTimeArrivals = 0;
            for(int j = 0; j < numStudents; j++){
                if(Integer.parseInt(arrivalTimes[j]) <= 0)
                    onTimeArrivals++;
            }
            if(onTimeArrivals < cancellationThreshold) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            i++;
        }
    }
}