package lt.giedrius.playgroundmanager;

import lt.giedrius.playsites.PlaySites;

public class Main {

	public static void main(String[] args) {

		Playground playground = new Playground(2, 3, 3, 2);

		Kid ramunas = new Kid("ramunas", 9);
		Kid darius = new Kid("darius", 5);
		Kid mantas = new Kid("mantas", 7);
		Kid karolis = new Kid("karolis", 8);
		Kid vaidas = new Kid("vaidas", 10);
		Kid saulius = new Kid("saulius", 10);
		Kid donatas = new Kid("donatas", 13);

		mantas.makeVIP();
		donatas.makeVIP();

		playground.addKid(ramunas, PlaySites.ballPit, 0);
		playground.addKid(darius, PlaySites.ballPit, 0);
		playground.addKid(mantas, PlaySites.ballPit, 0);
		playground.addKid(karolis, PlaySites.ballPit, 0);
		playground.addKid(vaidas, PlaySites.ballPit, 0);
		playground.addKid(saulius, PlaySites.doubleSwings, 0);
		playground.addKid(donatas, PlaySites.ballPit, 0);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
			System.out.println("...");
		}

		playground.removeKid(ramunas, PlaySites.ballPit, 0);
		playground.removeKid(mantas, PlaySites.ballPit, 0);

		playground.totalVisited();

	}

}
