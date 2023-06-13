package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

class GameIsGameOver {

	@Test
	public void testWhenGameIsNotOver() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		assertEquals(false, myGame.isGameOver());
	}

	@Test
	public void testWhenGameIsOverAndHumanWon() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
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

	@Test
	public void testWhenGameIsOverAndComputerWon() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
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
