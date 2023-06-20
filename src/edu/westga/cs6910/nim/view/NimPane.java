package edu.westga.cs6910.nim.view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Defines a GUI for the 1-pile Nim game. This class was started by CS6910
 * 
 * @author Chandan Jaladi
 * @version 06/06/2023
 */
public class NimPane extends BorderPane {
	private Game theGame;
	private BorderPane pnContent;
	private BorderPane anotherContent;
	private HumanPane pnHumanPlayer;
	private ComputerPane pnComputerPlayer;
	private StatusPane pnGameInfo;
	private Pane pnChooseFirstPlayer;
	private MenuBar menuBar;
	private Menu gameMenu;
	private Menu strategyMenu;
	private MenuItem exitMenuItem;
	private MenuItem cautiousMenuItem;
	private MenuItem greedyMenuItem;
	private MenuItem randomMenuItem;

	/**
	 * Creates a pane object to provide the view for the specified Game model
	 * object.
	 * 
	 * @param theGame the domain model object representing the Nim game
	 * 
	 * @requires theGame != null
	 * @ensures the pane is displayed properly
	 */
	public NimPane(Game theGame) {
		this.theGame = theGame;
		this.pnContent = new BorderPane();
		this.anotherContent = new BorderPane();
		this.menuAndMenuBarCreation();
		this.exitMenuItem();
		this.cautiousMenuItem();
		this.greedyMenuItem();
		this.randomMenuItem();
		this.strategyMenu.getItems().addAll(this.cautiousMenuItem,this.greedyMenuItem,this.randomMenuItem);
		
		this.gameMenu.getItems().addAll(this.exitMenuItem);
		this.menuBar.getMenus().addAll(this.gameMenu,this.strategyMenu);
	    
		
		this.addFirstPlayerChooserPane(theGame);
		
		this.humanBox();
		
		this.statusBox();
		
		this.computerBox();
		this.setCenter(this.pnContent);
		this.anotherContent.setTop(this.menuBar);
		this.pnContent.setTop(this.anotherContent);
	}

	private void menuAndMenuBarCreation() {
		this.menuBar = new MenuBar();
		this.gameMenu = new Menu("Game");
		this.strategyMenu = new Menu("Strategy");
	}

	private void randomMenuItem() {
		this.randomMenuItem = new MenuItem("Random");
		this.randomMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
		this.randomMenuItem.setMnemonicParsing(true);
		this.randomMenuItem.setText("_Random");
	}

	private void greedyMenuItem() {
		this.greedyMenuItem = new MenuItem("Greedy");
		this.greedyMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
		this.greedyMenuItem.setMnemonicParsing(true);
		this.greedyMenuItem.setText("Gr_eedy");
	}

	private void cautiousMenuItem() {
		this.cautiousMenuItem = new MenuItem("Cautious");
		this.cautiousMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
		this.cautiousMenuItem.setMnemonicParsing(true);
		this.cautiousMenuItem.setText("_Cautious");
	}

	private void exitMenuItem() {
		this.exitMenuItem = new MenuItem("Exit");
		this.exitMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
		this.exitMenuItem.setMnemonicParsing(true);
		this.exitMenuItem.setText("E_xit");
		this.exitMenuItem.setOnAction(event -> {
            System.exit(0);
        });
	}

	private void computerBox() {
		HBox computerBox = new HBox();
		computerBox.getStyleClass().add("pane-border");
		this.pnComputerPlayer = new ComputerPane(this.theGame);
		computerBox.getChildren().addAll(this.pnComputerPlayer);
		this.pnContent.setRight(computerBox);
	}

	private void statusBox() {
		HBox statusBox = new HBox();
		statusBox.getStyleClass().add("pane-border");
		this.pnGameInfo = new StatusPane(this.theGame);
		statusBox.getChildren().addAll(this.pnGameInfo);
		this.pnContent.setCenter(statusBox);
	}

	private void humanBox() {
		HBox humanBox = new HBox();
		humanBox.getStyleClass().add("pane-border");
		this.pnHumanPlayer = new HumanPane(this.theGame);
		humanBox.getChildren().addAll(this.pnHumanPlayer);
		this.pnContent.setLeft(humanBox);
	}

	private void addFirstPlayerChooserPane(Game theGame) {
		HBox topBox = new HBox();
		topBox.getStyleClass().add("pane-border");
		this.pnChooseFirstPlayer = new NewGamePane(theGame);
		topBox.getChildren().add(this.pnChooseFirstPlayer);
		this.anotherContent.setBottom(topBox);

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
			this.radComputerPlayer = new RadioButton(this.theComputer.getName() + " first");
			this.radComputerPlayer.setOnAction(new ComputerFirstListener());
			ToggleGroup group = new ToggleGroup();
			this.radHumanPlayer.setToggleGroup(group);
			this.radComputerPlayer.setToggleGroup(group);
			this.add(this.radHumanPlayer, 3, 3);
			this.add(this.radComputerPlayer, 3, 4);
		}

		/*
		 * Defines the listener for computer player first button.
		 */
		private class ComputerFirstListener implements EventHandler<ActionEvent> {
			@Override
			/**
			 * Enables the ComputerPlayerPanel and starts a new game. Event handler for a
			 * click in the computerPlayerButton.
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
			 * Sets up user interface and starts a new game. Event handler for a click in
			 * the human player button.
			 */
			@Override
			public void handle(ActionEvent event) {
				NimPane.this.pnChooseFirstPlayer.setDisable(true);
				NimPane.this.theGame.startNewGame(NewGamePane.this.theHuman);
			}
		}
	}
}
