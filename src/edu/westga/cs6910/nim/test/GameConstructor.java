package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.HumanPlayer;

class GameConstructor {

	@Test
	public void testWhenGameIsCreated() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		assertEquals(" Pile size: 7",myGame.toString());
	}
	
	@Test
	public void testWhenAnotherGameIsCreated() {
		HumanPlayer myHuman = new HumanPlayer("Jaladi");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		assertEquals(" Pile size: 7",myGame.toString());
	}
	
	@Test
	public void testWhenDifferentGameIsCreated() {
		HumanPlayer myHuman = new HumanPlayer("India");
		ComputerPlayer myComputer = new ComputerPlayer();
		Game myGame = new Game(myHuman, myComputer);
		assertEquals(" Pile size: 7",myGame.toString());
	}

}
