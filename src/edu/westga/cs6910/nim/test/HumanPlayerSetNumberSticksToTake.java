package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

class HumanPlayerSetNumberSticksToTake {

	@Test
	public void testWhenHumanPlayedFirstWith3Sticks() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(3);
		myGame.play();
		assertEquals(3, myHuman.getSticksOnThisTurn());
	}

	@Test
	public void testWhenHumanPlayedFirstWith2Sticks() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(2);
		myGame.play();
		assertEquals(2, myHuman.getSticksOnThisTurn());
	}

	@Test
	public void testWhenHumanPlayedFirstWith1Sticks() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(1);
		myGame.play();
		assertEquals(1, myHuman.getSticksOnThisTurn());
	}

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
		myHuman.setNumberSticksToTake(1);
		myGame.play();
		assertEquals(1, myHuman.getSticksOnThisTurn());
	}
}
