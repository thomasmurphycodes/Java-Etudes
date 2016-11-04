import java.io.*;
import java.util.*;

public class PartialNonDivisibleSubset {
    private static ArrayList<Integer> data = new ArrayList();
    private static ArrayList<Integer> combinations = new ArrayList(0);
    private static int k;
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String lineOne[] = s.nextLine().split(" ");
        int n = Integer.parseInt(lineOne[0]);
        k = Integer.parseInt(lineOne[1]);
        String[] lineTwo = s.nextLine().split(" ");
        int[] moduloCounts = new int[k];
        
        for (String entry : lineTwo)
            moduloCounts[Integer.parseInt(entry) % k]++;
        int solution = 0;
        //Special case: if there are no evenly divisible elements, add 0 to sum. Otherwise they won't all match up, so         add 1
        solution += Math.min(moduloCounts[0], 1); 
        // Loop through the modulo counts table
        for(int i = 1; i < k; i++)
            // Sentinel for value k = 1
            if(i != (Math.floor(k / 2) + 1)) 
                // two points moving from opposite ends of modulo array making pairs that sum to k, take the max
                solution += Math.max(moduloCounts[i], moduloCounts[k-i]);
        if(k % 2 == 0)
            // There will be one more set member if k % 2 = 0
            solution += 1;
        System.out.println(solution);
    }
}