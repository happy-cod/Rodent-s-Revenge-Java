package model;

import view.PrototypeIO;

/**
 * The PlayerStats is responsible for maintaining the 
 * player's score and the number of lives remaining.
 * 
 * @author ChaTeam
 *
 */
public class PlayerStats {
	private int score;
	private int lives;
	
	public PlayerStats(int lives) {
		score = 0;
		this.lives = lives;
	}
	
	/**
	 * Increases the number of points the player has by
	 * the input parameter.
	 * 
	 * @param points the number of points the player's score
	 * 			score should increase by.
	 */
	public void addPoints(int points) {
		PrototypeIO.printScore(score, score + points);
		this.score += points;
	}
	
	/**
	 * Decrements the number of lives remaining of the 
	 * player by one.
	 */
	public void loseLife() {
		PrototypeIO.printLives(lives, lives - 1);
		lives -= 1;
	}
	
	/**
	 * Returns a boolean value based on whether the player
	 * has enough lives to continue playing
	 * @return true if lives is greater than or equal to zero.
	 */
	public boolean canContinue() {
		return (lives > 0);
	}
	
	/** 
	 * Returns the players current score.
	 * 
	 * @return The players current score
	 */
	public int getScore() {
		return score;
	}
	
	
}
