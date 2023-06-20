package edu.westga.cs6910.nim.model;

import edu.westga.cs6910.nim.model.strategy.NumberOfSticksStrategy;

/**
 * ComputerPlayer represents a very simple automated player in the game Nim. It
 * removes 1 stick at a time. This class was started by CS6910
 * 
 * @author Chandan Jaladi
 * @version 06/06/2023
 */
public class ComputerPlayer extends AbstractPlayer {
	private static final String NAME = "Simple computer";
	private NumberOfSticksStrategy strategy;

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 */
	public ComputerPlayer(NumberOfSticksStrategy strategy) {
		super(NAME);
		this.strategy = strategy;
	}

	@Override
	public void setNumberSticksToTake() {
		// TODO Auto-generated method stub
		this.setNumberSticksToTake(this.strategy.howManySticks(this.getPileForThisTurn().getSticksLeft()));
	}
	
	public void setStrategy(NumberOfSticksStrategy strategy) {
		this.strategy = strategy;
	}
	
}
