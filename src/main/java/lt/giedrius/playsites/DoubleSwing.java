package lt.giedrius.playsites;

public class DoubleSwing extends PlaySite {

	public DoubleSwing() {
		this.maxAllowed = 2;
		registerUtilizationSnapshots();
	}

	@Override
	public double getUtilization() {

		if (getKidsInPlaysite().size() <= 1) {
			utilizationPercentage = 0;
		}
		if (getKidsInPlaysite().size() == 2) {
			utilizationPercentage = 100;
		}

		return (utilizationPercentage);
	}
}
