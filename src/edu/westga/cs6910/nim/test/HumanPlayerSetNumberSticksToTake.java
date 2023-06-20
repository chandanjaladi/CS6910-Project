package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.NumberOfSticksStrategy;

/**
 * This JUnit is used to test the human player number of sticks to take
 * 
 * @author Chandan Jaladi
 * @version 06/13/2023
 *
 */
class HumanPlayerSetNumberSticksToTake {

	/**
	 * This test is when the humanPlayed with 3 sticks
	 */
	@Test
	public void testWhenHumanPlayedFirstWith3Sticks() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		NumberOfSticksStrategy strategy = new CautiousStrategy();
		ComputerPlayer myComputer = new ComputerPlayer(strategy);
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(3);
		myGame.play();
		assertEquals(3, myHuman.getSticksOnThisTurn());
	}

	/**
	 * This test is when human played with 2 sticks
	 */
	@Test
	public void testWhenHumanPlayedFirstWith2Sticks() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		NumberOfSticksStrategy strategy = new CautiousStrategy();
		ComputerPlayer myComputer = new ComputerPlayer(strategy);
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(2);
		myGame.play();
		assertEquals(2, myHuman.getSticksOnThisTurn());
	}

	/**
	 * This test is when human played with 1 stick
	 */
	@Test
	public void testWhenHumanPlayedFirstWith1Stick() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		NumberOfSticksStrategy strategy = new CautiousStrategy();
		ComputerPlayer myComputer = new ComputerPlayer(strategy);
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(1);
		myGame.play();
		assertEquals(1, myHuman.getSticksOnThisTurn());
	}

	/**
	 * This test is when computer played first
	 */
	@Test
	public void testWhenComputerPlayedFirst() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		NumberOfSticksStrategy strategy = new CautiousStrategy();
		ComputerPlayer myComputer = new ComputerPlayer(strategy);
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myComputer);
		myComputer.setPileForThisTurn(myGame.getPile());
		myComputer.setNumberSticksToTake();
		myGame.play();
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(1);
		myGame.play();
		assertEquals(1, myHuman.getSticksOnThisTurn());
	}
}
