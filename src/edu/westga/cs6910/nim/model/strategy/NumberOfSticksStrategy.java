package edu.westga.cs6910.nim.model.strategy;

/**
 * This interface is used to know how many sticks to take in each turn
 * 
 * @author Chandan Jaladi
 * @version 06/20/2023
 *
 */
public interface NumberOfSticksStrategy {
	/**
	 * This is the method used to know how many sticks to take out in each turn
	 * according to the strategy selected
	 * 
	 * @param sizeOfPile Is the pile size in each turn
	 * @return numberOsSticks to take out from pile
	 */
	int howManySticks(int sizeOfPile);
}
