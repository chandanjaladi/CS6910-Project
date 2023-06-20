package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;

class CautiousStrategyHowManySticks {

	@Test
	public void testWhenPileIsFull() {
		CautiousStrategy cautious = new CautiousStrategy();
		assertEquals(1,cautious.howManySticks(10));
	}
	
	@Test
	public void testWhenPileIsOne() {
		CautiousStrategy cautious = new CautiousStrategy();
		assertEquals(1,cautious.howManySticks(1));
	}
	
	@Test
	public void testWhenPileIsZero() {
		CautiousStrategy cautious = new CautiousStrategy();
		assertThrows(IllegalArgumentException.class, () -> {
			cautious.howManySticks(0);
	    });
	}
}
