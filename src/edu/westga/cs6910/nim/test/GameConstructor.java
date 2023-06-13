package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * This JUnit is used to test the Game class constructor
 * 
 * @author Chandan Jaladi
 * @version 06/13/2023
 *
 */
class GameConstructor {

	/**
	 * This test is when the game is created
	 */
	@Test
	public void testWhenGameIsCreated() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		assertEquals(" Pile size: 7", myGame.toString());
	}

	/**
	 * This test when another game is created
	 */
	@Test
	public void testWhenAnotherGameIsCreated() {
		HumanPlayer myHuman = new HumanPlayer("Jaladi");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		assertEquals(" Pile size: 7", myGame.toString());
	}

	/**
	 * This test is when other game is created
	 */
	@Test
	public void testWhenDifferentGameIsCreated() {
		HumanPlayer myHuman = new HumanPlayer("India");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		assertEquals(" Pile size: 7", myGame.toString());
	}

}
