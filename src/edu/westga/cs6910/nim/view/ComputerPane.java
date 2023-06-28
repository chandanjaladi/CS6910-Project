package edu.westga.cs6910.nim.view;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Defines the panel that lets the user tell the computer player to take its
 * turn and that displays the number of sticks the computer player took on its
 * turn. This class was started by CS6910
 * 
 * @author Chandan Jaladi
 * @version 06/06/2023
 */
public class ComputerPane extends GridPane implements InvalidationListener {
	private Game theGame;
	private Label lblNumberTaken;
	private ComputerPlayer theComputer;

	/**
	 * Creates a new ComputerPane that observes the specified game.
	 * 
	 * @param theGame the model object from which this pane gets its data
	 * 
	 * @requires theGame != null
	 */
	public ComputerPane(Game theGame) {
		this.theGame = theGame;
		this.lblNumberTaken = new Label();
		this.add(this.lblNumberTaken, 0, 3);
		this.theGame.addListener(this);
		this.theComputer = this.theGame.getComputerPlayer();
		this.buildPane();
	}

	private void buildPane() {
		this.add(new Label("~~ " + this.theComputer.getName() + " ~~"), 0, 0);
		this.setDisable(true);
	}

	@Override
	public void invalidated(Observable arg0) {

		if (this.theGame.isGameOver()) {
			this.setDisable(true);
			return;
		}

		boolean myTurn = this.theGame.getCurrentPlayer() == this.theComputer;
		if (!myTurn) {
			this.refreshPane();
		} else {

			this.refreshPane();
			this.setDisable(false);
			this.takeComputerTurn();
		}

	}

	/**
	 * This method is used to take turn of the computer
	 */
	public void takeComputerTurn() {
		this.lblNumberTaken.setVisible(true);
		if (!this.theGame.isGameOver()) {
			this.theComputer.setPileForThisTurn(this.theGame.getPile());
			this.theComputer.setNumberSticksToTake();
			this.theGame.play();
			this.refreshPane();
		}
	}

	/**
	 * This method is used to hide the label of how many sticks the computer took
	 * for the user
	 */
	public void hideSticksTakenLabel() {
		this.lblNumberTaken.setVisible(false);
	}

	private void refreshPane() {
		this.lblNumberTaken.setText("Sticks taken by computer: "
				+ String.valueOf(this.theComputer.getSticksOnThisTurn()) + "\nPlease take sticks!");
	}

}
