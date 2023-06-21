package edu.westga.cs6910.nim.model.strategy;

/**
 * This class is used to implement Greedy strategy of the computer player
 * 
 * @author Chandan Jaladi
 * @version 06/20/2023
 *
 */
public class GreedyStrategy implements NumberOfSticksStrategy {

	@Override
	public int howManySticks(int sizeOfPile) {
		if (sizeOfPile <= 0) {
			throw new IllegalArgumentException("Size of Pile cannot be less than or equal to zero");
		}

		if (sizeOfPile > 3) {
			return 3;
		}

		return sizeOfPile - 1;
	}

}
