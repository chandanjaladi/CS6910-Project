package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.Pile;

class PileWhenRemoveSticks {

	@Test
	public void testShouldRemoveGivenNumberOfSticks() {
		Pile myPile = new Pile(10);
		myPile.removeSticks(2);
		assertEquals(8,myPile.getSticksLeft());
	}
	
	@Test
	public void testShouldRemoveGivenAnotherNumberOfSticks() {
		Pile myPile = new Pile(10);
		myPile.removeSticks(8);
		assertEquals(2,myPile.getSticksLeft());
	}
	
	@Test
	public void testShouldRemoveGivenOtherNumberOfSticks() {
		Pile myPile = new Pile(10);
		myPile.removeSticks(5);
		assertEquals(5,myPile.getSticksLeft());
	}

}
