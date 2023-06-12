package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.Pile;

class PileWhenCreatePile {

	@Test
	public void testShouldProducePileWith1Stick() {
		Pile oneStickPile = new Pile(1);
		assertEquals("Pile size: 1",oneStickPile.toString());
	}
	
	@Test
	public void testShouldProducePileWith7Sticks() {
		Pile sevenStickPile = new Pile(7);
		assertEquals("Pile size: 7",sevenStickPile.toString());
	}
	
	@Test
	public void testShouldProducePileWith10Sticks() {
		Pile tenStickPile = new Pile(10);
		assertEquals("Pile size: 10",tenStickPile.toString());
	}

}
