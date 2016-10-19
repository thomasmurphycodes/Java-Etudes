import java.util.HashMap;
import java.util.Map;

public class MapOps {
	public static void main(String[] args){
		Map<String, Integer> incomes = new HashMap<String, Integer>();

		incomes.put("Thomas", 160000);

		int thomasIncome = incomes.get("Thomas");

		System.out.println("Thomas has an income of: ");
		System.out.println(thomasIncome);
	}
}