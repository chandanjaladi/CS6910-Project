package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

class HumanPlayerTakeTurn {

	@Test
	public void testWhenPileIsFull() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(3);
		myHuman.takeTurn();
		assertEquals(4, myGame.getPile().getSticksLeft());
	}
	
	@Test
	public void testWhenPileIsAlreadyPlayed() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myComputer);
		myComputer.setPileForThisTurn(myGame.getPile());
		myComputer.setNumberSticksToTake();
		myGame.play();
		myHuman.setPileForThisTurn(myGame.getPile());
		myHuman.setNumberSticksToTake(3);
		myHuman.takeTurn();
		assertEquals(3, myGame.getPile().getSticksLeft());
	}

}
