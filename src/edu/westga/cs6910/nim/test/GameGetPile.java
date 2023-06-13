package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * This JUnit is used to get the pile
 * 
 * @author Chandan Jaladi
 * @version 06/13/2023
 *
 */
class GameGetPile {

	/**
	 * This test is when pile is full
	 */
	@Test
	public void testWhenPileIsFull() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		assertEquals(7, myGame.getPile().getSticksLeft());
	}

	/**
	 * This test is when humna played
	 */
	@Test
	public void testWhenHumanPlayed() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(3);
		myGame.play();
		assertEquals(4, myGame.getPile().getSticksLeft());
	}

	/**
	 * This test is when computer played
	 */
	@Test
	public void testWhenComputerPlayed() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myComputer);
		myComputer.setPileForThisTurn(myGame.getPile());
		myComputer.setNumberSticksToTake();
		myGame.play();
		assertEquals(6, myGame.getPile().getSticksLeft());
	}
}
