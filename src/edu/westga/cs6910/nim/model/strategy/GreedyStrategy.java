package edu.westga.cs6910.nim.model.strategy;

public class GreedyStrategy implements NumberOfSticksStrategy{

	@Override
	public int howManySticks(int sizeOfPile) {
		if(sizeOfPile <= 0) {
			throw new IllegalArgumentException("Size of Pile cannot be less than or equal to zero");
		}
		
		if(sizeOfPile > 3) {
			return 3;
		}
		
		return sizeOfPile - 1;
	}

}
