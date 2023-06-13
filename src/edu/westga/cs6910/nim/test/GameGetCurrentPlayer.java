package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

class GameGetCurrentPlayer {

	@Test
	public void testWhenHumanStartedFirst() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		assertEquals(myHuman, myGame.getCurrentPlayer());
	}

	@Test
	public void testWhenComputerStartedFirst() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myComputer);
		assertEquals(myComputer, myGame.getCurrentPlayer());
	}

	@Test
	public void testWhenHumanPlayedAndSwapped() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(3);
		myGame.play();
		assertEquals(myComputer, myGame.getCurrentPlayer());
	}

	@Test
	public void testWhenComputerPlayedAndSwapped() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myComputer);
		myComputer.setPileForThisTurn(myGame.getPile());
		myComputer.setNumberSticksToTake(1);
		myGame.play();
		assertEquals(myHuman, myGame.getCurrentPlayer());
	}

}
