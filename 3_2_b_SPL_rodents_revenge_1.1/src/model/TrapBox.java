package model;

/**
 * The TrapBox is responsible for disposing a Cat that has
 * been trapped for five ticks.
 * 
 * @author ChaTeam
 *
 */
public class TrapBox extends Thread {
	private Rules rules;
	private Cat cat;
	private int startTime;
	private volatile Boolean canContinue = true;
	private Boolean started = false;
	
	private final int TRAP_TIME = 5;
	
	/**
	 * This constructor creates a new TrapBox associated with
	 * the input parameters.
	 * 
	 * @param rules	The Rules with which the TrapBox should be associated.
	 * @param cat	The Cat with which the TrapBox should be associated.
	 */
	public TrapBox(Rules rules, Cat cat) {
		this.rules = rules;
		this.cat = cat;
	}
	
	/**
	 * This method is called when the thread of the TrapBox
	 * is started. It checks to see if 5 ticks have elapsed
	 * since it started, if so it disposes the associated
	 * Cat.
	 */
	public void run() {
		started = true;
		startTime = Clock.getTime();
		while (canContinue) {
			try {
				Thread.sleep(1);
				if (Clock.getTime() >= startTime + TRAP_TIME) {
					rules.disposeOfBody(this.cat);
					canContinue = false;
				}
			} catch (InterruptedException e) {
				canContinue = false;
			}	
		}
	}

	/**
	 * Stops the TrapBox thread.
	 */
	public void cancel() {
		canContinue = false;
	}
	
	/**
	 * Check to see if the TrapBox thread has been started.
	 * 
	 * @return	True if started.
	 */
	public boolean isRunning() {
		return canContinue;
	}

	public boolean getStarted() {
		return started;
	}
}
