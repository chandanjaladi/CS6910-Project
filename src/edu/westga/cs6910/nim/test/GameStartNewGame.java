package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

class GameStartNewGame {

	@Test
	public void testStartANewGame() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		assertEquals(myHuman,myGame.getCurrentPlayer());
		assertEquals("Chandan",myHuman.getName());
	}
	
	@Test
	public void testStartAnotherNewGame() {
		HumanPlayer myHuman = new HumanPlayer("Jaladi");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myHuman);
		assertEquals(myHuman,myGame.getCurrentPlayer());
		assertEquals("Jaladi",myHuman.getName());
	}
	
	@Test
	public void testStartAnotherNewGameByComputer() {
		HumanPlayer myHuman = new HumanPlayer("Jaladi");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		myGame.startNewGame(myComputer);
		assertEquals(myComputer,myGame.getCurrentPlayer());
		assertEquals("Simple computer",myComputer.getName());
	}

}
