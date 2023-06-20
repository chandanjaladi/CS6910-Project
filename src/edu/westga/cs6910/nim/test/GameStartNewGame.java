package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.NumberOfSticksStrategy;

/**
 * This JUnit is used to test the start new game method
 * 
 * @author Chandan Jaladi
 * @version 06/13/2023
 *
 */
class GameStartNewGame {

	/**
	 * This test starts a new game
	 */
	@Test
	public void testStartANewGame() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		NumberOfSticksStrategy strategy = new CautiousStrategy();
		ComputerPlayer myComputer = new ComputerPlayer(strategy);
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		assertEquals(myHuman, myGame.getCurrentPlayer());
		assertEquals(7, myGame.getSticksLeft());
	}

	/**
	 * This test starts another new game
	 */
	@Test
	public void testStartAnotherNewGame() {
		HumanPlayer myHuman = new HumanPlayer("Jaladi");
		NumberOfSticksStrategy strategy = new CautiousStrategy();
		ComputerPlayer myComputer = new ComputerPlayer(strategy);
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		assertEquals(myHuman, myGame.getCurrentPlayer());
		assertEquals(7, myGame.getSticksLeft());
	}

	/**
	 * This test starts another game by computer
	 */
	@Test
	public void testStartAnotherNewGameByComputer() {
		HumanPlayer myHuman = new HumanPlayer("Jaladi");
		NumberOfSticksStrategy strategy = new CautiousStrategy();
		ComputerPlayer myComputer = new ComputerPlayer(strategy);
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myComputer);
		assertEquals(myComputer, myGame.getCurrentPlayer());
		assertEquals(7, myGame.getSticksLeft());
	}

}
