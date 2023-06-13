package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * This JUnit is used to test the set pile for the turn
 * 
 * @author Chandan Jaladi
 * @version 06/13/2023
 *
 */
class HumanPlayerSetPileForThisTurn {

	/**
	 * This test is when human starts playing
	 */
	@Test
	public void testHumanStartsPlaying() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		myHuman.setPileForThisTurn(myGame.getPile());
		assertEquals(7, myHuman.getPileForThisTurn().getSticksLeft());
	}

	/**
	 * This test is when computer starts playing first
	 */
	@Test
	public void testWhenComputerPlayedFirst() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myComputer);
		myComputer.setPileForThisTurn(myGame.getPile());
		myComputer.setNumberSticksToTake();
		myGame.play();
		myHuman.setPileForThisTurn(myGame.getPile());
		assertEquals(6, myHuman.getPileForThisTurn().getSticksLeft());
	}
}
