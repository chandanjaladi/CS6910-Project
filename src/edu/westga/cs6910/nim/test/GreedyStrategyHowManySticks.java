package edu.westga.cs6910.nim.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.GreedyStrategy;

class GreedyStrategyHowManySticks {

	@Test
	public void testWhenPileIsFull() {
		GreedyStrategy cautious = new GreedyStrategy();
		assertEquals(3,cautious.howManySticks(10));
	}
	
	@Test
	public void testWhenPileIsOne() {
		GreedyStrategy cautious = new GreedyStrategy();
		assertEquals(0,cautious.howManySticks(1));
	}
	
	@Test
	public void testWhenPileIsTwo() {
		GreedyStrategy cautious = new GreedyStrategy();
		assertEquals(1,cautious.howManySticks(2));
	}
	
	@Test
	public void testWhenPileIsThree() {
		GreedyStrategy cautious = new GreedyStrategy();
		assertEquals(2,cautious.howManySticks(3));
	}
	
	@Test
	public void testWhenPileIsZero() {
		GreedyStrategy cautious = new GreedyStrategy();
		assertThrows(IllegalArgumentException.class, () -> {
			cautious.howManySticks(0);
	    });
	}

}
