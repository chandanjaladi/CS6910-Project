package edu.westga.cs6910.nim.view;

import edu.westga.cs6910.nim.model.Game;
import edu.westga.cs6910.nim.model.Player;
import edu.westga.cs6910.nim.model.strategy.CautiousStrategy;
import edu.westga.cs6910.nim.model.strategy.GreedyStrategy;
import edu.westga.cs6910.nim.model.strategy.RandomStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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
	private MenuItem restartMenuItem;
	private Player restartingPlayer;

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
		this.restartMenuItem();
		this.strategyMenu.getItems().addAll(this.cautiousMenuItem, this.greedyMenuItem, this.randomMenuItem);
		this.gameMenu.getItems().addAll(this.restartMenuItem, this.exitMenuItem);
		this.menuBar.getMenus().addAll(this.gameMenu, this.strategyMenu);
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
		this.gameMenu = new Menu("_Game");
		this.gameMenu.setMnemonicParsing(true);
		this.strategyMenu = new Menu("_Strategy");
		this.strategyMenu.setMnemonicParsing(true);
	}

	private void randomMenuItem() {
		this.randomMenuItem = new MenuItem("_Random");
		this.randomMenuItem.setMnemonicParsing(true);
		this.randomMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));

		this.randomMenuItem.setOnAction(event -> {
			this.theGame.getComputerPlayer().setStrategy(new RandomStrategy());
		});
	}

	private void greedyMenuItem() {
		this.greedyMenuItem = new MenuItem("Gr_eedy");
		this.greedyMenuItem.setMnemonicParsing(true);
		this.greedyMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));

		this.greedyMenuItem.setOnAction(event -> {
			this.theGame.getComputerPlayer().setStrategy(new GreedyStrategy());
		});
	}

	private void cautiousMenuItem() {
		this.cautiousMenuItem = new MenuItem("_Cautious");
		this.cautiousMenuItem.setMnemonicParsing(true);
		this.cautiousMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
		this.cautiousMenuItem.setOnAction(event -> {
			this.theGame.getComputerPlayer().setStrategy(new CautiousStrategy());
		});
	}

	private void exitMenuItem() {
		this.exitMenuItem = new MenuItem("E_xit");
		this.exitMenuItem.setMnemonicParsing(true);
		this.exitMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
		this.exitMenuItem.setOnAction(event -> {
			System.exit(0);
		});
	}

	private void restartMenuItem() {
		this.restartMenuItem = new MenuItem("Res_tart");
		this.restartMenuItem.setMnemonicParsing(true);
		this.restartMenuItem.setAccelerator(KeyCombination.keyCombination("Ctrl+T"));
		this.restartMenuItem.setDisable(true);
		this.restartMenuItem.setOnAction(event -> {
			this.restartDecision(this.restartingPlayer);
		});
	}

	private void restartDecision(Player player) {
		this.theGame.startNewGame(this.restartingPlayer);
		this.pnGameInfo.invalidated(theGame);
		this.pnComputerPlayer.hideSticksTakenLabel();
		this.pnComputerPlayer.setRestarted(true);
		this.pnHumanPlayer.setRestarted(true);
		this.pnComputerPlayer.invalidated(theGame);
		this.pnHumanPlayer.invalidated(theGame);
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
		private Button randomButton;

		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePane(Game theGame) {
			this.theGame = theGame;
			this.randomButton = new Button("Select randomly");

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
			this.randomButton.setOnAction(event -> {
				RadioButton selectedRadioButton = this.selectRandomly();
				if(selectedRadioButton != null) {
					selectedRadioButton.fire();
				}
			});
			ToggleGroup group = new ToggleGroup();
			this.radHumanPlayer.setToggleGroup(group);
			this.radComputerPlayer.setToggleGroup(group);
			this.add(this.radHumanPlayer, 3, 3);
			this.add(this.radComputerPlayer, 3, 4);
			this.add(randomButton, 5, 3);
			
		}

		private RadioButton selectRandomly() {
			int random = (int) (Math.random() * 2 + 1);
			if(random == 1) {
				return this.radHumanPlayer;
			}
			else {
				return this.radComputerPlayer;
			}
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
				NimPane.this.restartMenuItem.setDisable(false);
				NimPane.this.restartingPlayer = NewGamePane.this.theComputer;
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
				NimPane.this.restartMenuItem.setDisable(false);
				NimPane.this.restartingPlayer = NewGamePane.this.theHuman;
			}
		}
	}

}
