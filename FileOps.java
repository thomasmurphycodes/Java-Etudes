import java.io.File;
import java.io.IOException;

public class FileOps{
	public static void main(String[] args) throws IOException {
		if (args.length == 0){
			System.out.println("You have to provide a file name.");
			System.exit(0);
		}
		for(String a : args){
			status(a);
		}
	}

	public static void status(String fileName) throws IOException{

	}
}