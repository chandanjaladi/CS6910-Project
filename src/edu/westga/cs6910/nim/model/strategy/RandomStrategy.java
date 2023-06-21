package edu.westga.cs6910.nim.model.strategy;

/**
 * This is a class which is used to implement random strategy for computer
 * player
 * 
 * @author Chandan Jaladi
 * @version 06/20/2023
 *
 */
public class RandomStrategy implements NumberOfSticksStrategy {

	@Override
	public int howManySticks(int sizeOfPile) {
		if (sizeOfPile <= 0) {
			throw new IllegalArgumentException("Size of Pile cannot be less than or equal to zero");
		}

		if (sizeOfPile == 3) {
			return (int) (Math.random() * 2 + 1);
		} else if (sizeOfPile == 2) {
			return 1;
		} else if (sizeOfPile == 1) {
			return 1;
		}

		return (int) (Math.random() * 3 + 1);
	}

}
