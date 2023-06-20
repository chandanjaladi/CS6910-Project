package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.NumberOfSticksStrategy;

/**
 * This JUnit is used to test the Take turn method
 * 
 * @author Chandan Jaladi
 * @version 06/13/2023
 *
 */
class ComputerPlayerTakeTurn {

	/**
	 * This test is when the pile is full for computer
	 */
	@Test
	public void testWhenPileIsFull() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		NumberOfSticksStrategy strategy = new CautiousStrategy();
		ComputerPlayer myComputer = new ComputerPlayer(strategy);
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myComputer);
		myComputer.setPileForThisTurn(myGame.getPile());
		myComputer.setNumberSticksToTake();
		myComputer.takeTurn();
		assertEquals(6, myGame.getPile().getSticksLeft());
	}

	/**
	 * This test is when pile is not full for the computer
	 */
	@Test
	public void testWhenPileIsAlreadyPlayed() {
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
		myComputer.takeTurn();
		assertEquals(3, myGame.getPile().getSticksLeft());
	}

}
