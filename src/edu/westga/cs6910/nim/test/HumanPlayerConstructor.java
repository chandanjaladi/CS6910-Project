package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.HumanPlayer;

class HumanPlayerConstructor {

	@Test
	public void testConstructorWithName() {
		HumanPlayer myHuman = new HumanPlayer("Chandan");
		assertEquals("Chandan", myHuman.getName());
	}
	
	@Test
	public void testConstructorWithAnotherName() {
		HumanPlayer myHuman = new HumanPlayer("Jaladi");
		assertEquals("Jaladi", myHuman.getName());
	}
	
	@Test
	public void testConstructorWithDifferentName() {
		HumanPlayer myHuman = new HumanPlayer("India");
		assertEquals("India", myHuman.getName());
	}

}
