
package lt.giedrius.playsites;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.javatuples.Pair;

import lt.giedrius.playgroundmanager.Kid;

public abstract class PlaySite {
	private LinkedList<Kid> kidsInPlaysite = new LinkedList<Kid>();
	private LinkedList<Kid> kidQueue = new LinkedList<Kid>();
	private HashMap<Kid, Pair<String, String>> histories = new HashMap<Kid, Pair<String, String>>();
	
	private int playingNow = 0;
	private int ticketNum = 0;
	private int VIPIndex = 0;
	protected double utilizationPercentage;
	protected int maxAllowed;
	private String playSiteName;
	
	private String startTime;
	private String endTime;

	

	long delay = 60 * 1000;
	LoopTask task = new LoopTask();
	Timer timer = new Timer("TaskName");
	private List<Double> ballPitUtilizationSnapshots = new ArrayList<Double>();

	public class LoopTask extends TimerTask {
		public void run() {
			ballPitUtilizationSnapshots.add(getUtilization());
		}
	}

	// utilization snapshots are registered every 60 seconds
	public void registerUtilizationSnapshots() {

		timer.cancel();
		timer = new Timer("TaskName");
		Date executionDate = new Date();
		timer.scheduleAtFixedRate(task, executionDate, delay);
	}

	public String addPlaySiteName(String name) {
		this.playSiteName = name;
		return name;
	}

	public String registerStartTime(Kid kid) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		startTime = dateFormat.format(date);
		return startTime;

	}

	public String registerEndTime(Kid kid) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		endTime = dateFormat.format(date);
		return endTime;
	}

	public String calculateDiference(Kid kid) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(startTime);
		Date date2 = format.parse(endTime);
		long difference = date2.getTime() - date1.getTime();

		long diffSeconds = difference / 1000 % 60;
		long diffMinutes = difference / (60 * 1000) % 60;
		long diffHours = difference / (60 * 60 * 1000) % 24;

		String diff = diffHours + ": hours " + diffMinutes + ": minutes " + diffSeconds + ": seconds";

		return diff;

	}

	public boolean addToSite(Kid kid) {

		if (playingNow >= maxAllowed) {
			if (!kid.kidAcceptsWaiting()) {
				return false;
			}
			if (kid.isVIP()) {
				kidQueue.add(VIPIndex, kid);
				VIPIndex += 3;
			} else {
				kidQueue.addLast(kid);
			}

		} else {
			ticketNum++;
			kid.setTicketNumber(ticketNum);
			kidsInPlaysite.add(kid);
			playingNow++;

			registerStartTime(kid); 
		}
		return true;
	}

	public boolean removeFromSite(Kid kid) {
		kidsInPlaysite.remove(kid);
		playingNow--;
		registerEndTime(kid); 
		try {
			calculateDiference(kid);
			Pair<String, String> playSitesAndDuration = new Pair<String, String>(addPlaySiteName(playSiteName),
					calculateDiference(kid));
			histories.put(kid, playSitesAndDuration);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (playingNow < maxAllowed && !kidQueue.isEmpty()) {
			ticketNum++;
			kidQueue.getFirst().setTicketNumber(ticketNum);
			kidsInPlaysite.add(kidQueue.getFirst());
			kidQueue.removeFirst();
			playingNow++;

			if (VIPIndex > 0) {
				VIPIndex--;
			}
		}
		return true;
	}

	public double getUtilization() {
		utilizationPercentage = (kidsInPlaysite.size() / (double) maxAllowed) * 100;
		return (utilizationPercentage);
	}

	public LinkedList<Kid> getKidsInPlaysite() {
		return kidsInPlaysite;
	}

	

}
