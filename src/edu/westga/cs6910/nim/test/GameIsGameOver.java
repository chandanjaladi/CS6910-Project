package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.NumberOfSticksStrategy;

/**
 * This JUnit is used to test the IsGameOver method
 * 
 * @author Chandan Jaladi
 * @version 06/13/2023
 *
 */
class GameIsGameOver {

	/**
	 * This test is when the game is not over
	 */
	@Test
	public void testWhenGameIsNotOver() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		NumberOfSticksStrategy strategy = new CautiousStrategy();
		ComputerPlayer myComputer = new ComputerPlayer(strategy);
		Game myGame = new Game(myHuman, myComputer);
		assertEquals(false, myGame.isGameOver());
	}

	/**
	 * This test is when the game is over and human won
	 */
	@Test
	public void testWhenGameIsOverAndHumanWon() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		NumberOfSticksStrategy strategy = new CautiousStrategy();
		ComputerPlayer myComputer = new ComputerPlayer(strategy);
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(3);
		myGame.play();
		myComputer.setPileForThisTurn(myGame.getPile());
		myComputer.setNumberSticksToTake();
		myGame.play();
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(2);
		myGame.play();
		assertEquals(true, myGame.isGameOver());
	}

	/**
	 * This test when the game is over and computer won
	 */
	@Test
	public void testWhenGameIsOverAndComputerWon() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		NumberOfSticksStrategy strategy = new CautiousStrategy();
		ComputerPlayer myComputer = new ComputerPlayer(strategy);
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(3);
		myGame.play();
		myComputer.setPileForThisTurn(myGame.getPile());
		myComputer.setNumberSticksToTake();
		myGame.play();
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(1);
		myGame.play();
		myComputer.setPileForThisTurn(myGame.getPile());
		myComputer.setNumberSticksToTake();
		myGame.play();
		assertEquals(true, myGame.isGameOver());
	}

}
