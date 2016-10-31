import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
public class ComboTest{
	private static ArrayList<int[]> combos = new ArrayList<int[]>();

	private static int[] input = {4, 7, 9, 3, 12, 6, 43, 23, 96, 42, 33, 12};
	private static ArrayList<Integer> test = new ArrayList<>();
	private static ArrayList<Integer> PriceList = new ArrayList<Integer>(); //Type Specific Lists


	public static void comboGenerator(int begin){
		System.out.println("begin is: " + begin);
		int length = input.length;
		System.out.println("input length: " +  length);
		for(int i = begin + 1; i < input.length; i++){
			int[] tmpComb = {input[begin], input[i]};
			combos.add(tmpComb);
		}
	}

	public static void main(String[] args){

		for(int i = 0; i < input.length; i++){
			comboGenerator(i);
		}

		// I LOVE LAMBDAS
		combos.forEach(c -> System.out.println("The value of this output is: " + Arrays.toString(c)));
	}
}