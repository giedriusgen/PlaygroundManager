package lt.giedrius.playsites;

public class BallPit extends PlaySite {

	public BallPit(int maxAllowed) {
		this.maxAllowed = maxAllowed;
		registerUtilizationSnapshots();
	}

}
