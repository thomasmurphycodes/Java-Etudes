import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

public class Crime {
	private int dcDist;
	private int psa;
	private LocalDateTime dispatchDateTime;
	private LocalDate dispatchDate;
	private LocalTime dispatchTime;
	private int hour;
	private int dcKey;
	private String locationBlock;
	private int ucrGeneral;
	private String textGeneralCode;
	private int policeDistricts;
	private float longitude;
	private float latitude;

	@Override
	public String toString(){
		return "The crime occurred in district " + this.dcDist;
	}

	public Crime(int _dcDist, int _psa){
		this.dcDist = _dcDist;
		this.psa = _psa;
		// this.dispatchDateTime = _dispatchDateTime;
	}
}