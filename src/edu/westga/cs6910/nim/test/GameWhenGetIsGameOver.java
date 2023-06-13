package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * This JUnit is used to test the gameOver
 * 
 * @author Chandan Jaladi
 * @version 06/13/2023
 *
 */
class GameWhenGetIsGameOver {

	/**
	 * This test is when game starts is not over
	 */
	@Test
	public void testBeforeGameStartsIsNotOver() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		assertEquals(false, myGame.isGameOver());
	}

	/**
	 * This is when the game starts is not over and no current player
	 */
	@Test
	public void testBeforeGameStartsIsNotOverAndNoCurrentPlayer() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		assertEquals(null, myGame.getCurrentPlayer());
	}
}
