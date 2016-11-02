import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileOps{
	public static void main(String[] args) throws IOException {
		if (args.length == 0){
			System.out.println("You have to provide a file name.");
			System.exit(0);
		}
		for(String a : args){
			status(a);
		}

		// List Directory
		String[] directory = new File(".").list();
		for (String file : directory) {
			System.out.println(file);
		}
	}

	public static void status(String fileName) throws IOException{
		System.out.println("------" + fileName + "------");

		// New file object
		File f = new File(fileName);

		if(!f.exists()) {
			System.out.println("File not found");
			System.out.println();
			return;
		}

		// Print full name
		System.out.println("Canonical name " + f.getCanonicalPath());

		// Print parent if there is one
		String p = f.getParent();
		if (p != null) {
			System.out.println("Parent directory: " + p);
		}

		if (f.canRead()) {
			System.out.println("File is readable.");
		}

		if (f.canWrite()) {
			System.out.println("File is writable");
		}

		// Report modified time
		Date d = new Date(f.lastModified());
		System.out.println("Last modified " + d);

		// See if a file or directory, if a file, print size
		if (f.isFile()){
			System.out.println("File size is " + f.length() + " bytes.");
		} else if (f.isDirectory()) {
			System.out.println("It is a directory");
		} else {
			System.out.println("Who knows??? Neither a file or a directory");
		}

		System.out.println();
	}
}