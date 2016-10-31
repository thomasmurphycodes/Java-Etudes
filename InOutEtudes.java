import java.io.*;

public class InOutEtudes {

	public static void main(String[] args) throws IOException {
		BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
		String inputLine;

		// while((inputLine = is.readLine()) != null){
		// 	System.out.println(inputLine);
		// }
		// is.close();

		BufferedReader freader = new BufferedReader(new FileReader("files.txt"));
		System.out.println(freader.toString());
	}
}