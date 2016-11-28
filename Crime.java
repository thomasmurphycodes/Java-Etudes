import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;


/** Compile Please */
public class Crime {
	private int dcDist;
	private String psa;
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

	public Crime(int _dcDist){
		this.dcDist = _dcDist;
	}
	
	public Crime(int _dcDist, String _psa){
		this.dcDist = _dcDist;
		this.psa = _psa;
		// this.dispatchDateTime = _dispatchDateTime;
	}

	@Override
	public String toString(){
		return "The crime occurred in district " + this.dcDist;
	}
}