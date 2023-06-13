package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.HumanPlayer;

/**
 * This JUnit is used to test the human player constructor
 * 
 * @author Chandan Jaladi
 * @version 06/13/2023
 *
 */
class HumanPlayerConstructor {

	/**
	 * This test is used to test the constructor
	 */
	@Test
	public void testConstructorWithName() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		assertEquals("Chandan", myHuman.getName());
	}

	/**
	 * This test is used to test it with another name
	 */
	@Test
	public void testConstructorWithAnotherName() {
		HumanPlayer myHuman = new HumanPlayer("Jaladi");
		assertEquals("Jaladi", myHuman.getName());
	}

	/**
	 * This test is used to test the constructor with different name
	 */
	@Test
	public void testConstructorWithDifferentName() {
		HumanPlayer myHuman = new HumanPlayer("India");
		assertEquals("India", myHuman.getName());
	}

}
