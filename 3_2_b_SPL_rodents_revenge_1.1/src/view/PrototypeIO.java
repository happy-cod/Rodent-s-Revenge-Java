package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.*;

/**
 * The PrototypeIO implements the input and output functions of
 * the Prototype.
 * 
 * @author ChaTeam
 *
 */
public class PrototypeIO {
	private static BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
	
	public static void setFileReader(FileReader fr) {
		br = new BufferedReader(fr);
	}
	
	public static String getCommand() {
		try {
			String command = br.readLine();
			return command;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void printSwitch(Piece p1, Piece p2) {
		System.out.println(p1.getSymbol() + " " + p1.getPosition() + " switch " +
			p2.getSymbol() + " " + p2.getPosition());
	}
	
	public static void printCatSpawn(Cat cat) {
		System.out.println("spawn cat " + cat.getId() + " " + cat.getPosition());
	}
	
	public static void printRatDies(Rat rat) {
		System.out.println("rat " + rat.getId() + " " + rat.getPosition() + " dies");
	
	}
	
	public static void printCatDies(Cat cat) {
		System.out.println("cat " + cat.getId() + " " + cat.getPosition() + " dies");
	}
	
	public static void printCreatedReplaces(Piece p1, Piece p2) {
		System.out.println(p1.getSymbol() + " " + p1.getPosition() + " created, replaces " +
				p2.getSymbol() + " " + p2.getPosition());
	}
	
	public static void printScore(int oldScore, int newScore) {
		System.out.println("score " + oldScore + " => " + newScore);
	}
	
	public static void printLives(int oldLives, int newLives) {
		System.out.println("lives " + oldLives + " => " + newLives);
	}

	public static void printGameOver() {
		System.out.println("game over");
	}
	
	public static void printInvalidInput(String input) {
		System.out.println("Error: Invalid Input - \"" + input + "\"");
	}
	
	public static void printInvalidFile(String input) {
		System.out.println("Error: Invalid File - \"" + input + "\"");
	}
	
	public static void println(String input) {
		System.out.println(input);
	}
}
