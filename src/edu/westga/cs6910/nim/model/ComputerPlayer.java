package edu.westga.cs6910.nim.model;

/**
 * ComputerPlayer represents a very simple automated player in the game Nim. It
 * removes 1 stick at a time. This class was started by CS6910
 * 
 * @author Chandan Jaladi
 * @version 06/06/2023
 */
public class ComputerPlayer extends AbstractPlayer {
	private static final String NAME = "Simple computer";

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 */
	public ComputerPlayer() {
		super(NAME);
	}
}
