import java.io.*;
import java.util.*;

public class BeautifulDay {

    public static int reversed(String forwardString){
        StringBuffer rev = new StringBuffer();
        rev.append(forwardString);
        rev.reverse();
        return Integer.parseInt(rev.toString());
    }
    
    public static int beautifulDifference(int forward, int reverse){
        return forward - reverse;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int i = Integer.parseInt(input[0]);
        int j = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int beautifulSolution = 0;
        
        ArrayList<Integer> testValues = new ArrayList<Integer>();  
        for(int begin = i; begin <= j; begin++){
            int revInput = reversed(Integer.toString(begin));
            int difference = beautifulDifference(begin, revInput);
            testValues.add(difference);
        }
        
        for(Integer val : testValues){
            if(val % k == 0)
                beautifulSolution++;
        }

        System.out.println(beautifulSolution);
    }
}