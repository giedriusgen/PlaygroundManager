package lt.giedrius.playsites;

public class Carousel extends PlaySite {

	public Carousel(int maxAllowed) {
		this.maxAllowed = maxAllowed;
		registerUtilizationSnapshots();
	}
}
