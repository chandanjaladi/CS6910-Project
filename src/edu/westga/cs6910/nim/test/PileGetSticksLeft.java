package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.Pile;

/**
 * This JUnit is used to test the GetSticksLeft
 * 
 * @author Chandan Jaladi
 * @version 06/13/2023
 *
 */
class PileGetSticksLeft {

	/**
	 * This test is used to test with 1 stick
	 */
	@Test
	public void testWith1StickPileShouldHave1StickLeft() {
		Pile oneStickPile = new Pile(1);
		assertEquals(1, oneStickPile.getSticksLeft());
	}

	/**
	 * This test is used to test 5 stick pile
	 */
	@Test
	public void testWith5StickPileShouldHave5SticksLeft() {
		Pile fiveStickPile = new Pile(5);
		assertEquals(5, fiveStickPile.getSticksLeft());
	}

	/**
	 * This test is used to test 10 stick pile
	 */
	@Test
	public void testWith10StickPileShouldHave10SticksLeft() {
		Pile tenStickPile = new Pile(10);
		assertEquals(10, tenStickPile.getSticksLeft());
	}
}
