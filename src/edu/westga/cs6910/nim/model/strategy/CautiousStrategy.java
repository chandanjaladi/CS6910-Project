package edu.westga.cs6910.nim.model.strategy;

public class CautiousStrategy implements NumberOfSticksStrategy{

	
	@Override
	public int howManySticks(int sizeOfPile) {
		if(sizeOfPile <= 0) {
			throw new IllegalArgumentException("Size of Pile cannot be less than or equal to zero");
		}
		return 1;
	}

}
