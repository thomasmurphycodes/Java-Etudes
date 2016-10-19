import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;
import java.time.Period;

public class TimeEtudes {
	
	public static void main( String[] args) {
		LocalDate dNow = LocalDate.now();
		LocalTime tNow = LocalTime.now();
		LocalDateTime now = LocalDateTime.now();

		// Sample Formatting
		DateTimeFormatter nTZ = DateTimeFormatter.ofPattern("dd, MMMM, yyyy h:mm a");
		System.out.println(ZonedDateTime.now().format(nTZ));


		// Parse Date from String
		String y2k = "2000-01-01";

		LocalDate yLD = LocalDate.parse(y2k);
		System.out.println(yLD);

		// Get difference between two Date objects
		LocalDate birthday = LocalDate.of(2016, 1, 9);
		LocalDate newNow = LocalDate.now();
		Period diff = Period.between(newNow, birthday);

		System.out.println("the difference between now and my birthday is: " + diff.toString());

	}
}