package edu.westga.cs6910.nim.model;

public abstract class AbstractPlayer implements Player{
	private String name;
	private int sticksToTake;
	private Pile thePile;
	
	@Override
	/**
	 * @see Player#takeTurn(Pile)
	 */
	public void takeTurn() {

		this.thePile.removeSticks(this.sticksToTake);
	}
	
	@Override	
	/**
	 * @see Player#setPileForThisTurn(Pile)
	 */

	public void setPileForThisTurn(Pile aPile) {
		this.thePile = aPile;

	}
}
