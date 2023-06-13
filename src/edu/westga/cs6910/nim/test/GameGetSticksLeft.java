package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

class GameGetSticksLeft {

	@Test
	public void testWhenAllSticksAreLeft() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		assertEquals(7, myGame.getSticksLeft());
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
		assertEquals(6, myGame.getSticksLeft());
	}

	@Test
	public void testWhenHumanPlayedFirst() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(3);
		myGame.play();
		assertEquals(4, myGame.getSticksLeft());
	}
}
