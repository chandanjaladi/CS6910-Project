package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.Pile;

/**
 * This JUnit is used to test the remove sticks method
 * 
 * @author Chandan Jaladi
 * @version 06/13/2023
 *
 */
class PileWhenRemoveSticks {

	/**
	 * This test is used to remove the given number of sticks
	 */
	@Test
	public void testShouldRemoveGivenNumberOfSticks() {
		Pile myPile = new Pile(10);
		myPile.removeSticks(2);
		assertEquals(8, myPile.getSticksLeft());
	}

	/**
	 * This test is used to remove the given number of sticks
	 */
	@Test
	public void testShouldRemoveGivenAnotherNumberOfSticks() {
		Pile myPile = new Pile(10);
		myPile.removeSticks(8);
		assertEquals(2, myPile.getSticksLeft());
	}

	/**
	 * This test is used to remove the given number of sticks
	 */
	@Test
	public void testShouldRemoveGivenOtherNumberOfSticks() {
		Pile myPile = new Pile(10);
		myPile.removeSticks(5);
		assertEquals(5, myPile.getSticksLeft());
	}

}