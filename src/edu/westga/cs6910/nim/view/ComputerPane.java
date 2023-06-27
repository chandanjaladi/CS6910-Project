package edu.westga.cs6910.nim.view;

import edu.westga.cs6910.nim.model.ComputerPlayer;
import edu.westga.cs6910.nim.model.Game;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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
	private String bgColor;
	private Button btnTakeTurn;
	private boolean isRestarted;

	/**
	 * Creates a new ComputerPane that observes the specified game.
	 * 
	 * @param theGame the model object from which this pane gets its data
	 * 
	 * @requires theGame != null
	 */
	public ComputerPane(Game theGame) {
		this.theGame = theGame;
		this.isRestarted = false;
		this.bgColor = "C0C0C0";
		this.lblNumberTaken = new Label();
		this.add(this.lblNumberTaken, 0, 3);
		this.theGame.addListener(this);
		this.theComputer = this.theGame.getComputerPlayer();
		this.buildPane();
	}
	
	public void setRestarted(boolean condition) {
		this.isRestarted = condition;
	}

	private void buildPane() {
		this.add(new Label("~~ " + this.theComputer.getName() + " ~~"), 0, 0);
		this.btnTakeTurn = new Button("Take Turn");
		this.btnTakeTurn.setOnAction(new TakeTurnListener());
		//this.add(this.btnTakeTurn, 0, 1);
		this.setDisable(true);
	}

	@Override
	public void invalidated(Observable arg0) {
		
		if (this.theGame.isGameOver()) {
			this.setDisable(true);
			return;
		}
		
//		if(this.isRestarted) {
//			this.setDisable(false);
//		}
		
		boolean myTurn = this.theGame.getCurrentPlayer() == this.theComputer;
		if (!myTurn) {
			this.refresh();
		}
		if (this.theGame.getCurrentPlayer() == this.theComputer) {
			this.setDisable(false);
			this.lblNumberTaken.setVisible(true);
			if (!this.theGame.isGameOver()) {
				
				this.theComputer.setPileForThisTurn(this.theGame.getPile());
				this.theComputer.setNumberSticksToTake();
				this.theGame.play();
				this.refresh();
				
				
				
//				if(this.bgColor.equals("C0C0C0")) {
//					this.bgColor = "RED";
//					this.setStyle("-fx-background-color: " + this.bgColor + ";");
//				}
//				else {
//					this.bgColor = "C0C0C0";
//					this.setStyle("-fx-background-color: " + this.bgColor + ";");
//				}
				
			}
		} else {
			this.setDisable(true);
		}

	}
	
	public void hideSticksTakenLabel() {
		this.lblNumberTaken.setVisible(false);
	}

	private void refresh() {
		this.lblNumberTaken.setText("Sticks taken by computer: " + String.valueOf(this.theComputer.getSticksOnThisTurn()) + "\nPlease take sticks!");
	}

	/*
	 * Defines the listener for takeTurnButton.
	 */
	private class TakeTurnListener implements EventHandler<ActionEvent> {

		/*
		 * Tells the Game to have its current player (i.e., the computer player) take
		 * its turn.
		 * 
		 * @see javafx.event.EventHandler#handle(T-extends-javafx.event.Event)
		 */
		@Override
		public void handle(ActionEvent arg0) {
//			ComputerPane.this.lblNumberTaken.setVisible(true);
//			if (!ComputerPane.this.theGame.isGameOver()) {
//				ComputerPane.this.theComputer.setPileForThisTurn(ComputerPane.this.theGame.getPile());
//				ComputerPane.this.theComputer.setNumberSticksToTake();
//				ComputerPane.this.theGame.play();
//				ComputerPane.this.refresh();
//			}

		}
	}
}
