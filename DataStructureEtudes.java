import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class DataStructureEtudes {
	@SuppressWarnings("unused")
	public static void main( String[] args) {
		int[] monthLen1; //Declare with type
		monthLen1 = new int[12]; //Construct
		int[] monthLen2 = new int[12]; //One liner construction
		int[] monthLen3 = { 43, 42, 41, 45, 39, 40, 41, 42, 43};
		final int MAX = 47;

		Calendar[] days = new Calendar[MAX]; //initialize arrays against a constant
		for (int i = 0; i < MAX; i++) {
			days[i] = Calendar.getInstance();
		}

		// n * m array
		int[][] matrix = new int[12][20];


		// Array resizing
		final int INIT_SIZE = 10, GROW_FACTOR = 2;
		int[] smallArray = new int[INIT_SIZE];1
		if(smallArray.length > INIT_SIZE  - 2) {
			int[] tmp = new int[INIT_SIZE * GROW_FACTOR];
			System.arraycopy(smallArray, 0, tmp, 0, smallArray.length);
		}

		ArrayList<String> menu = new ArrayList<>();
		menu.add("Hamburgers");
		menu.add("Hot Dogs");
		menu.add(1, "Cheese Fries"); // Note that this "pushes" the element at the specified index (and all elements afterwards one forward)
		System.out.println(menu.toString());

		System.out.println(menu.get(0)); // Retrieve by idx

		List<Integer> PriceList = new ArrayList<Integer>(); //Type Specific Lists
		PriceList.add(33);
		PriceList.add(42);
		PriceList.add(93);
		PriceList.add(42);

		PriceList.forEach(num -> System.out.println(num)); // Note arrow notation on the forEach

		Map<String, Integer> dailyPrices = new HashMap<String, Integer>();
		dailyPrices.put("IBM", 83);
		//getKey() is method when iterating i.e. in lambda(mapItem -> mapitem.getKey())
		System.out.println("Price of IBM is: " + dailyPrices.get("IBM"));

		GenericEtude<String> stringStack = new GenericEtude<String>(20); // Initialize a generic stack with String

		stringStack.push("FOO!");
		System.out.println(stringStack.pop());

		// Lambda style
		Collection<String> myLanguages = Arrays.asList("Python", "Java", "C++", "Node.js");
		myLanguages.forEach(lang -> System.out.println("A favorite language is: " + lang));

		// Java 5 style
		ArrayList<String> TechStocks = new ArrayList<>();
		TechStocks.add("Google");
		TechStocks.add("Microsoft");
		TechStocks.add("Apple");

		for(String org : TechStocks) {
			System.out.println("A tech company is: " + org);
		}

		Set<String> uniqueDrugs = new HashSet<>();
		uniqueDrugs.add("Ibuprofen");
		uniqueDrugs.add("Tylenol");
		uniqueDrugs.add("Zoloft");
		uniqueDrugs.add("Tylenol");

		uniqueDrugs.forEach(drug -> System.out.println("The drug is: " + drug));

		// Specifying sort key on a TreeSet
		TreeSet<String> artistSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

		artistSet.add("Francis Bacon");
		artistSet.add("Andy Warhol");
		artistSet.add("Jeff Koons");

		artistSet.forEach(artist -> System.out.println("The sorted artist is: " + artist));

		System.out.println(artistSet.tailSet("c").toArray().length); // Get head or tail
	}
}