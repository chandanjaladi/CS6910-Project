package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.NumberOfSticksStrategy;

/**
 * This is a JUnit test class for the ComputerPlayer constructor
 * 
 * @author Chandan Jaladi
 * @version 06/13/2023
 */
class ComputerPlayerConstructor {

	/**
	 * This test is used to test the computer player constructor
	 */
	@Test
	public void testConstrucotrWtihName() {
		NumberOfSticksStrategy strategy = new CautiousStrategy();
		ComputerPlayer myComputer = new ComputerPlayer(strategy);
		assertEquals("Simple computer", myComputer.getName());
	}
}
