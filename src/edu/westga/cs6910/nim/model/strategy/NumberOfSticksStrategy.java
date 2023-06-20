package edu.westga.cs6910.nim.model.strategy;

public interface NumberOfSticksStrategy {
	/**
	 * 
	 * @param sizeOfPile
	 * @return numberOsSticks to take out from pile
	 */
	int howManySticks(int sizeOfPile);
}
