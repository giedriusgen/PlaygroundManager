package lt.giedrius.playgroundmanager;

public class Kid {

	private String name;
	private int age;
	private int ticketNumber;
	private boolean VIPFeature = false;
	private boolean acceptsWaiting = true;

	public Kid(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean isVIP() {
		return this.VIPFeature;
	}

	public boolean kidAcceptsWaiting() {
		return this.acceptsWaiting;
	}

	public void makeVIP() {
		this.VIPFeature = true;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public void setVIPFeature(boolean VIPFeature) {
		this.VIPFeature = VIPFeature;
	}

}
