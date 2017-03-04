package model;

/**
 * The CatSpawner is responsible for spawning a new Cat
 * every 60 ticks of the Clock.
 * 
 * @author ChaTeam
 *
 */
public class CatSpawner extends Thread {
	private Initializer init;
	private int startTime;
	private volatile boolean canContinue = true;
	
	private final int SPAWN_TIME = 60;
	/**
	 * This constructor creates a new CatSpawner associated with
	 * the input parameter.
	 * 
	 * @param init	The Initializer with which the CatSpawner should be associated.
	 */
	public CatSpawner(Initializer init) {
		this.init = init;
	}
	
	/**
	 * Creates a new Cat (and CatController) using the 
	 * associated Initializer when the Clock advances by
	 * more than SPAWN_TIME ticks.
	 */
	public void run() {
		startTime = Clock.getTime();
		while (canContinue) {
			if (Clock.getTime() - startTime >= SPAWN_TIME) {
				// Wait for time to elapse
				init.spawnNewCat();
				startTime = Clock.getTime();
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				canContinue = false;
			}
		}
	}
	
	/**
	 * Stops the CatSpawner thread.
	 */
	public void cancel() {
		canContinue = false;
	}
}
