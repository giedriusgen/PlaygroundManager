package lt.giedrius.playgroundmanager;

import java.util.ArrayList;
import java.util.List;

import lt.giedrius.playsites.BallPit;
import lt.giedrius.playsites.Carousel;
import lt.giedrius.playsites.DoubleSwing;
import lt.giedrius.playsites.PlaySites;
import lt.giedrius.playsites.Slide;

public class Playground {

	private int totalVisitors = 0;

	private List<BallPit> ballPits = new ArrayList<BallPit>();
	private List<Carousel> carousels = new ArrayList<Carousel>();
	private List<DoubleSwing> doubleSwings = new ArrayList<DoubleSwing>();
	private List<Slide> slides = new ArrayList<Slide>();

	public Playground(int doubleSwing, int carousel, int slide, int ballPit) {
		for (int i = 0; i < ballPit; i++) {
			ballPits.add(new BallPit(4));
		}
		for (int i = 0; i < doubleSwing; i++) {
			doubleSwings.add(new DoubleSwing());
		}
		for (int i = 0; i < carousel; i++) {
			carousels.add(new Carousel(8));
		}
		for (int i = 0; i < slide; i++) {
			slides.add(new Slide(10));
		}

	}

	public boolean addKid(Kid kid, PlaySites playsite, int index) {
		switch (playsite) {
		case ballPit:

			if (ballPits.get(index).addToSite(kid)) {
				ballPits.get(index).addPlaySiteName("BallPit");
				totalVisitors++;
				return true;
			}
			break;
		case carousel:
			if (carousels.get(index).addToSite(kid)) {
				carousels.get(index).addPlaySiteName("Carousel");
				totalVisitors++;
				return true;
			}
			break;
		case slide:
			if (slides.get(index).addToSite(kid)) {
				slides.get(index).addPlaySiteName("Slide");
				totalVisitors++;
				return true;
			}
			break;
		case doubleSwings:
			if (doubleSwings.get(index).addToSite(kid)) {
				doubleSwings.get(index).addPlaySiteName("DoubleSwings");
				totalVisitors++;
				return true;
			}
			break;
		}
		return false;
	}

	public boolean removeKid(Kid kid, PlaySites playsite, int index) {
		switch (playsite) {
		case ballPit:
			if (ballPits.get(index).removeFromSite(kid)) {
				return true;
			}
			break;
		case carousel:
			if (carousels.get(index).removeFromSite(kid)) {
				return true;
			}
			break;
		case slide:
			if (slides.get(index).removeFromSite(kid)) {
				return true;
			}
			break;
		case doubleSwings:
			if (doubleSwings.get(index).removeFromSite(kid)) {
				return true;
			}
			break;
		}
		return false;
	}

	public double showUtilization(PlaySites playsite, int index) {
		double utilization = 0;
		switch (playsite) {
		case ballPit:
			utilization = ballPits.get(index).getUtilization();
			break;

		case carousel:
			utilization = carousels.get(index).getUtilization();
			break;

		case slide:
			utilization = slides.get(index).getUtilization();
			break;

		case doubleSwings:
			utilization = doubleSwings.get(index).getUtilization();
			break;

		}
		return utilization;

	}

	public int totalVisited() {
		System.out.println("Total visitors: " + totalVisitors);
		return totalVisitors;
	}

}