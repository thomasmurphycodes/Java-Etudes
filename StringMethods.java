
import java.util.StringTokenizer;

public class StringMethods{
	

	public static void main(String[] args){
		String a = "Java is awesome and beautiful and I love it dearly!";
		System.out.println(a);
		String b = a.substring(5);
		System.out.println(b);
		String c = a.substring(5,7);
		System.out.println(c);
		String d = a.substring(5, a.length());
		System.out.println(d);
		String e = a.substring(a.length() - 9, a.length()); // Last 4 characters
		System.out.println(e);

		for (String word : a.split(" ")){
			System.out.println("The next word is " + word);
		}

		StringBuilder sb2 = new StringBuilder();
		sb2.append("oh").append(" yes").append(" that").append(" is correct");
		String stringResult2 = sb2.toString();
		System.out.println(stringResult2);


		String charString = "I love processing characters and strings are made of characters";

		for(int i = 0; i < charString.length(); i++){
			System.out.println("The character at positions: " + i + " is: " + charString.charAt(i));
		}

		String reversible = "The most fun string to reverse is";

		System.out.println(reversible + " : " + new StringBuilder(reversible).reverse());

		String lowerString = "this string is so lowercase";
		System.out.println(lowerString.toUpperCase());

		String upperString = "THIS STRING IS SO UPPERCASE";
		System.out.println(upperString.toLowerCase());

		String needsAShave = "           why is there so much blank space             ";
		System.out.println(needsAShave.trim());
		
	}
}