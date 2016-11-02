import java.io.File;
import java.io.IOException;

public class FileCreate {
	
	public static void main(String[] argv) throws IOException {
		if(argv.length == 0) {
			System.err.println("Pass in a file name to create");
			System.exit(1);
		}	

		for (String s : argv){
			// Constructing a new file object doesn't affect the disk, but the method does
			new File(s).createNewFile();
		}
	}
}