import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;


public class CameraSearchPredicate{
	private List<Camera> privateListofCameras = new ArrayList<>();

	public List<Camera> search(Predicate<Camera> tester){
		List<Camera> results = new ArrayList<>();
		privateListofCameras.forEach(c -> {
			if (tester.test(c))
				results.add(c);
		});
		return results;
	}
}