package edu.westga.cs6910.nim.view;

import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Defines a GUI for the 1-pile Nim game.
 * This class was started by CS6910
 * 
 */
public class NimPane extends BorderPane {
	private Game theGame;
	private BorderPane pnContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private Pane pnChooseFirstPlayer;
	
	/**
	 * Creates a pane object to provide the view for the specified
	 * Game model object.
	 * 
	 * @param theGame	the domain model object representing the Nim game
	 * 
	 * @requires theGame != null
	 * @ensures	 the pane is displayed properly
	 */
	public NimPane(Game theGame) {
		this.theGame = theGame;
		
		this.pnContent = new BorderPane();
		
		this.addFirstPlayerChooserPane(theGame);		
		
		// TODO: 1. Using the 'first player chooser pane' as a guide
		//			Create an HBox with the appropriate style, then
		//			make a human player pane and add it to the HBox.
		//			Finally add the HBox to the content pane
		HBox humanBox = new HBox();
		humanBox.getStyleClass().add("pane-border");
		this.pnHumanPlayer = new HumanPane(this.theGame);
		humanBox.getChildren().addAll(this.pnHumanPlayer);
		this.pnContent.setLeft(humanBox);
		
		// TODO: 2. Using the other panes as a guide, create
		//			and add a status pane	
		
		HBox statusBox = new HBox();
		statusBox.getStyleClass().add("pane-border");
		this.pnGameInfo = new StatusPane(this.theGame);
		statusBox.getChildren().addAll(this.pnGameInfo);
		this.pnContent.setCenter(statusBox);
		// TODO: 3. Using the other panes as a guide, create
		//			and add a computer pane

		HBox computerBox = new HBox();
		computerBox.getStyleClass().add("pane-border");
		this.pnComputerPlayer = new ComputerPane(this.theGame);
		computerBox.getChildren().addAll(this.pnComputerPlayer);
		this.pnContent.setRight(computerBox);
		this.setCenter(this.pnContent);
		
	}

	private void addFirstPlayerChooserPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");	
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		this.pnContent.setTop(topBox);
		
	}

	/*
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePane extends GridPane {
		private RadioButton radHumanPlayer;
		private RadioButton radComputerPlayer;
		
		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePane(Game theGame) {
			this.theGame = theGame;
			
			this.theHuman = this.theGame.getHumanPlayer();
			this.theComputer = this.theGame.getComputerPlayer();
			
			this.buildPane();
			
		}
		
		private void buildPane() {
			this.setHgap(20);
			
			this.radHumanPlayer = new RadioButton(this.theHuman.getName() + " first");	
			this.radHumanPlayer.setOnAction(new HumanFirstListener());
			
			// TODO: Instantiate the computer player button and set 
			//		its action listener.
			this.radComputerPlayer = new RadioButton(this.theComputer.getName() + " first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());
			
			// TODO: Create a ToggleGroup and add the 2 radio buttons to it.
			ToggleGroup group = new ToggleGroup();

			this.radHumanPlayer.setToggleGroup(group);
			this.radComputerPlayer.setToggleGroup(group);
			//this.radHumanPlayer.setSelected(true);
			
			// TODO: Add the 2 radio buttons to this pane.
			this.add(this.radHumanPlayer, 3, 3);
			this.add(this.radComputerPlayer, 3, 4);

		}
		
		/* 
		 * Defines the listener for computer player first button.
		 */		
		private class ComputerFirstListener implements EventHandler<ActionEvent> {
			@Override
			/** 
			 * Enables the ComputerPlayerPanel and starts a new game. 
			 * Event handler for a click in the computerPlayerButton.
			 */
			public void handle(ActionEvent arg0) {
				NimPane.this.pnComputerPlayer.setDisable(false);
				NimPane.this.pnChooseFirstPlayer.setDisable(true);
				NimPane.this.theGame.startNewGame(NewGamePane.this.theComputer);
			}
		}

		/* 
		 * Defines the listener for human player first button.
		 */	
		private class HumanFirstListener implements EventHandler<ActionEvent> {
			/* 
			 * Sets up user interface and starts a new game. 
			 * Event handler for a click in the human player button.
			 */
			@Override
			public void handle(ActionEvent event) {
				NimPane.this.pnChooseFirstPlayer.setDisable(true);
				// TODO: Enable the human player pane and start a game
				//		 with the human playing first.
				NimPane.this.theGame.startNewGame(NewGamePane.this.theHuman);

			}
		}
	}
}
