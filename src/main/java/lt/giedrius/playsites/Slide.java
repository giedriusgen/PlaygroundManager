package lt.giedrius.playsites;

public class Slide extends PlaySite {

	public Slide(int maxAllowed) {
		this.maxAllowed = maxAllowed;
		registerUtilizationSnapshots();

	}

}
