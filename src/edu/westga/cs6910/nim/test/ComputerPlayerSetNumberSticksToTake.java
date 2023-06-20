package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.NumberOfSticksStrategy;

/**
 * This JUnit is used to test the number of sticks to take setter method
 * 
 * @author Chandan Jaladi
 * @version 06/13/2023
 *
 */
class ComputerPlayerSetNumberSticksToTake {

	/**
	 * This test is when the computer played first
	 */
	@Test
	public void testWhenComputerTakesFirst() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		NumberOfSticksStrategy strategy = new CautiousStrategy();
		ComputerPlayer myComputer = new ComputerPlayer(strategy);
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myComputer);
		myComputer.setPileForThisTurn(myGame.getPile());
		myComputer.setNumberSticksToTake();
		myGame.play();
		assertEquals(1, myComputer.getSticksOnThisTurn());
	}

	/**
	 * This test is when the human played first
	 */
	@Test
	public void testWhenHumanPlayedFirst() {
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
		assertEquals(1, myComputer.getSticksOnThisTurn());
	}

}
