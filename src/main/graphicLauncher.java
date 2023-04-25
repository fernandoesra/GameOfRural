package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.Man;
import logs.ActionsLog;
import map.Board;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.JTextField;

import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.DefaultCaret;
import javax.swing.text.DefaultHighlighter;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

/**
 * The graphicLauncher its the main class of the project.
 * Here we create the graphic interface and create the
 * interaction for the buttons.
 * Also here we instance the attributes like the board or
 * the list of citizens and register the action log.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 * @author Miguel Angel Croche Munoz (MichValwin)
 * @see map.Board
 * @see main.CitizenList
 * @see logs.ActionsLog
 * @see main.ResourcesList
 * @see base.Man
 * @see main.BiomeGenerator
 * 
 */

public class graphicLauncher extends JFrame implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int height; 					/* Height of the board */
	int width; 						/* Width of the board */
	Board board;
	CitizenList citizenList;
	ResourcesList resourcesList;
	int actualCitizenID;			/* 1 at the program start */
	Man actualCitizen;
	ActionsLog log;
	BiomeGenerator biomeGenerator;
	/**
	 * This variable programInUse is used on generateXturns() to prevent the player
	 * use other buttons during the performance of the method.
	 */
	AtomicBoolean programInUse;
	QuantityTurns turnX;
	
	public JPanel mainContentPane;
	public JTextArea textCentralArea;
	public JTextArea actualCitizenInfoText;
	public JTextArea logTextArea;
	private JTextField turnsValueTextField;
	
	// Main
	public static void main(String[] args) {
		// Methods to launch before the interface
		/**
		 * Create the interface
		 */
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					graphicLauncher frame = new graphicLauncher();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// Methods to launche after the interface
		
	}

	/**
	 * Empty constructor. Initialize all the attributes for the class.
	 */
	public graphicLauncher() {
		// Initialize the programInUse
		programInUse = new AtomicBoolean();
		programInUse.lazySet(false);
		
		// Initialize the biome generator
		biomeGenerator = new BiomeGenerator();
		
		// Initialize the action log
		log = new ActionsLog();
		
		// Initialize and fill the map, set the starting actual Citizen to 1
		this.initialize();
		actualCitizenID = 1;
		
		/*
		 * From here we create all the graphic objetcs of Java Swing
		 */
		
		// JFrame Container
		setTitle("Game of Rural");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(110, 45, 1700, 950);
		mainContentPane = new JPanel();
		mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Center text area and scroll
		textCentralArea = new JTextArea();
		// textCentralArea.setFont(new Font("Consolas", Font.PLAIN, 14));
		textCentralArea.setEditable(false);
		JScrollPane scrollPaneForCentralText = new JScrollPane();
		scrollPaneForCentralText.setBounds(10, 10, 850, 580);
		scrollPaneForCentralText.setViewportView(textCentralArea);
		textCentralArea.setForeground(new Color(0, 0, 0));
		textCentralArea.setBackground(new Color(255, 255, 255));
		
		// Create a Caret for the scrollPane, that prevents the auto-scroll
		DefaultCaret caret = (DefaultCaret)textCentralArea.getCaret();
	    caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		
		try {
			Font font = Font.createFont(Font.PLAIN, new FileInputStream(new File("./assets/FiraCode-Regular.ttf")));
			textCentralArea.setFont(font.deriveFont(Font.PLAIN, 14f));
		} catch (FontFormatException | IOException e) {
			System.err.println("Font not found");
			e.printStackTrace();
		}
		
		// Create Font:
		Font FiraFont = new Font("./assets/FiraCode-Regular.ttf", Font.PLAIN, 11);
		
		// Select Citizens Panel
		JPanel selectCitizensPanel = new JPanel();
		selectCitizensPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		selectCitizensPanel.setBounds(1255, 10, 419, 46);
		selectCitizensPanel.setLayout(null);
		
		JButton confirmIDbutton = new JButton("Select");
		confirmIDbutton.setBounds(332, 11, 77, 23);
		
		// Objects for show citizens info
		JLabel actualCitizenLabel = new JLabel("Actual citizen:");
		actualCitizenLabel.setBounds(10, 11, 88, 22);
		actualCitizenLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		// Objects for select the citizen to move
		JTextField actualCitizenTextArea = new JTextField();
		actualCitizenTextArea.setFont(FiraFont);
		actualCitizenTextArea.setBounds(108, 12, 46, 20);
		actualCitizenTextArea.setHorizontalAlignment(SwingConstants.CENTER);
		actualCitizenTextArea.setEditable(false);
		actualCitizenTextArea.setColumns(10);
		actualCitizenTextArea.setText(String.valueOf(actualCitizenID));
		
		JLabel selectCitizenLabel = new JLabel("Select citizen (ID):");
		selectCitizenLabel.setBounds(164, 11, 102, 22);
		selectCitizenLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JTextField selectIDtextField = new JTextField();
		selectIDtextField.setBounds(276, 12, 46, 20);
		selectIDtextField.setColumns(10);

		// Citizen info panel
		JScrollPane scrollPaneActualCitizen = new JScrollPane();
		scrollPaneActualCitizen.setBounds(10, 41, 399, 284);

		actualCitizenInfoText = new JTextArea();
		scrollPaneActualCitizen.setViewportView(actualCitizenInfoText);
		actualCitizenInfoText.setBackground(new Color(255, 255, 255));
		actualCitizenInfoText.setFont(new Font("Fira Code", Font.PLAIN, 11));
		actualCitizenInfoText.setEditable(false);
		actualCitizenInfoText.setColumns(10);
		actualCitizenInfoText.setText(citizenList.getInfoID(actualCitizenID));

		JPanel citizenInfoPanel = new JPanel();
		citizenInfoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		citizenInfoPanel.setBounds(1255, 67, 419, 336);
		citizenInfoPanel.setLayout(null);

		JLabel actualCitizenInfoLabel = new JLabel("Actual citizen info:");
		actualCitizenInfoLabel.setBounds(10, 16, 158, 14);

		confirmIDbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectCitizenButton(actualCitizenTextArea, selectIDtextField, actualCitizenInfoText);
			}
		});
		
		// Log panel
		JPanel logPanel = new JPanel();
		logPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		logPanel.setBounds(870, 414, 804, 267);
		logPanel.setLayout(null);

		JScrollPane scrollPaneLogArea = new JScrollPane();
		scrollPaneLogArea.setBounds(10, 44, 784, 212);

		logTextArea = new JTextArea();
		logTextArea.setFont(new Font("Fira Code", Font.PLAIN, 13));
		scrollPaneLogArea.setViewportView(logTextArea);
		logTextArea.setEditable(false);

		JLabel logLabel = new JLabel("Log:");
		logLabel.setBounds(10, 22, 157, 14);
		
		// Banner image
		JLabel bannerLabel = new JLabel("");
		bannerLabel.setIcon(new ImageIcon("./assets/bannerGoR.png"));
		bannerLabel.setBounds(10, 693, 1664, 207);
		
		// Map Legend panel:
		JPanel mapLegendPanel = new JPanel();
		mapLegendPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		mapLegendPanel.setBounds(870, 10, 375, 393);
		mapLegendPanel.setLayout(null);

		JLabel mapLegendLabel = new JLabel("Map Legend");
		mapLegendLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		mapLegendLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mapLegendLabel.setBounds(10, 11, 355, 23);
		
		JLabel mapLegendImage = new JLabel("");
		mapLegendImage.setBounds(10, 45, 355, 337);
		mapLegendImage.setIcon(new ImageIcon("./assets/legendImage.png"));
		
		// Button panel
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonsPanel.setBounds(10, 601, 850, 81);
		buttonsPanel.setLayout(null);

		// Show actual map button
		JButton showMapButton = new JButton("Show actual map");
		showMapButton.setBounds(10, 22, 153, 36);
		
		showMapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!programInUse.get()) {
					showMapButton(textCentralArea);
				}
			}
		});

		// Show all citizens button
		JButton buttonShowAllCitizens = new JButton("Show all citizens");
		buttonShowAllCitizens.setBounds(173, 22, 153, 36);

		buttonShowAllCitizens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!programInUse.get()) {
					showAllCitizensButton(textCentralArea);
				}
			}
		});
		
		// Generate one random turn button
		JButton turnOneRandom = new JButton("1 turn");
		turnOneRandom.setBounds(336, 22, 153, 36);
		
		turnOneRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!programInUse.get()) {
					generateOneTurn();
				}
			}
		});
		
		// JTextFild for turns value
		turnsValueTextField = new JTextField();
		turnsValueTextField.setHorizontalAlignment(SwingConstants.CENTER);
		turnsValueTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		turnsValueTextField.setText("5");
		turnsValueTextField.setBounds(788, 22, 52, 36);
		turnsValueTextField.setColumns(10);
		
		//Generate X random turns button
		JButton turnIndicatedRandom = new JButton("Generate turns:");
		turnIndicatedRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!programInUse.get()) {
					String amount = turnsValueTextField.getText();
					int quantity = Integer.parseInt(amount);
					generateXturns(quantity);
				}
			}
		});
		turnIndicatedRandom.setBounds(625, 22, 153, 36);
		
		// Add all to the containers
		setContentPane(mainContentPane);
		mainContentPane.setLayout(null);
		mainContentPane.add(scrollPaneForCentralText);
		mainContentPane.add(selectCitizensPanel);
		mainContentPane.add(buttonsPanel);
		mainContentPane.add(citizenInfoPanel);
		mainContentPane.add(logPanel);
		mainContentPane.add(bannerLabel);
		mainContentPane.add(mapLegendPanel);

		selectCitizensPanel.add(actualCitizenLabel);
		selectCitizensPanel.add(actualCitizenTextArea);
		selectCitizensPanel.add(selectCitizenLabel);
		selectCitizensPanel.add(selectIDtextField);
		selectCitizensPanel.add(confirmIDbutton);
		
		buttonsPanel.add(buttonShowAllCitizens);
		buttonsPanel.add(showMapButton);
		buttonsPanel.add(turnOneRandom);
		buttonsPanel.add(turnIndicatedRandom);
		buttonsPanel.add(turnsValueTextField);
		
		citizenInfoPanel.add(actualCitizenInfoLabel);
		citizenInfoPanel.add(scrollPaneActualCitizen);
		logPanel.add(scrollPaneLogArea);
		logPanel.add(logLabel);
		
		mapLegendPanel.add(mapLegendLabel);
		mapLegendPanel.add(mapLegendImage);
		
		// Show the map when the game start
		showMapButton(textCentralArea);
		
		// Select the first citizen to start the game
		this.actualCitizen = (Man) citizenList.searchForCitizen(1);
		textCentralArea.getHighlighter();	/* At start always select the citizen with ID 1 */
		
		// Add KeyListeners
		textCentralArea.addKeyListener(this);
		actualCitizenInfoText.addKeyListener(this);
		logTextArea.addKeyListener(this);
		confirmIDbutton.addKeyListener(this);
		buttonShowAllCitizens.addKeyListener(this);
		showMapButton.addKeyListener(this);
		actualCitizenTextArea.addKeyListener(this);
		turnOneRandom.addKeyListener(this);
		turnsValueTextField.addKeyListener(this);
		
	}
	
	/**
	 * This method search on the text on the JTextArea of the map for the characters
	 * of the different jobs ands resources. Then highlight every character on a
	 * different color
	 * 
	 * @param txtDisplay JTextArea where we want to change the color of the citizens
	 */
	public void highlightMainMap(JTextArea txtDisplay) {
		try {
			Highlighter high = txtDisplay.getHighlighter();
			high.removeAllHighlights();
			// Paint all map (For test and range)
			// high.addHighlight(158, 3014, DefaultHighlighter.DefaultPainter);
			
			// The map start at index 135-150 aprox, its depend on the length of the town name
			// high.addHighlight(coordinateX, coordinateX+total_range, color);
			
			char mapOnText[] = board.toString().toCharArray();
			
			for (int i = 135; i < mapOnText.length; i++) {
				switch (mapOnText[i]) {
				
				// People:
				case 'F':
					// Farmer
					high.addHighlight(i+1, i+2, setColor(3));
					break;
				case 'K':
					// Butcher
					high.addHighlight(i+1, i+2, setColor(1));
					break;
				case 'I':
					// Carpenter
					high.addHighlight(i+1, i+2, setColor(4));
					break;
				case 'H':
					// Blackmisth
					high.addHighlight(i+1, i+2, setColor(5));
					break;
				case 'L':
					// Lumberjack
					high.addHighlight(i+1, i+2, setColor(6));
					break;
				case 'M':
					// Miner
					high.addHighlight(i+1, i+2, setColor(8));
					break;
				case 'B':
					// Baker
					high.addHighlight(i+1, i+2, setColor(7));
					break;
				case 'S':
					// Shepherd
					high.addHighlight(i+1, i+2, setColor(9));
					break;
				case 'G':
					// Fishmonger
					high.addHighlight(i+1, i+2, setColor(10));
					break;
				case 'J':
					// Fisherman
					high.addHighlight(i+1, i+2, setColor(2));
					break;
					
				// Resources:
				case (char)9540:
					// Tree
					high.addHighlight(i+1, i+2, setColor(12));
					break;
				case (char)8776:
					// Water
					high.addHighlight(i+1, i+2, setColor(11));
					break;
				case (char)937:
					// Gold Ore
					high.addHighlight(i+1, i+2, setColor(13));
					break;
				case (char)968:
					// Grain
					high.addHighlight(i+1, i+2, setColor(14));
					break;
				}
			}
		} catch (Exception ex) {
			System.err.println("Error "+ex.getMessage());
		}
	}
	
	/**
	 * This method retunr a HighlightPainter object configured just to paint
	 * something on the highlightMainMap method.<br>
	 * The index of the colors are:<p>
	 * <b>Invalid number: </b>White. R: 255, G: 255, B: 255<br>
	 * <b>1 : </b>Very Light Red.    R: 255, G: 102, B: 102<br>
	 * <b>2 : </b>Very light Blue.   R: 51, G: 190, B: 255<br>
	 * <b>3 : </b>Very Light Green.  R: 102, G: 255, B: 102<br>
	 * <b>4 : </b>Very Light Yellow. R: 255, G: 149, B: 120s<br>
	 * <b>5 : </b>Very Light Grey.   R: 204, G: 204, B: 204<br>
	 * <b>6 : </b>Very Light Brown.  R: 153, G: 102, B: 0<br>
	 * <b>7 : </b>Purple.            R: 102, G: 80, B: 200<br>
	 * <b>8 : </b>Light Black.       R: 90, G: 90, B: 90<br>
	 * <b>9 : </b>Light Orange.      R: 155, G: 153, B: 0<br>
	 * <b>10: </b>Light Blue.        R: 51, G: 130, B: 255<br>
	 * <b>11: </b>Water Blue.        R: 30, G: 230, B: 255<br>
	 * <b>12: </b>Tree Green.        R: 84, G: 168, B: 51<br>
	 * <b>13: </b>Ore Gold.          R: 255, G: 215, B: 0<br>
	 * <b>14: </b>Chartreuse.        R: 223, G: 254, B: 0<br>
	 * 
	 * @param index A number between 1 and 13
	 * @return A HighlightPainter objetc with one color asigned. If the number of
	 *         the param its not on the list return white
	 */
	public HighlightPainter setColor(int index) {

		final Color white = new Color(255, 255, 255);
		HighlightPainter selectedColor = new DefaultHighlighter.DefaultHighlightPainter(white);

		if (index == 1) {
			final Color VERY_LIGHT_RED = new Color(255, 102, 102);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(VERY_LIGHT_RED);
		}
		if (index == 2) {
			final Color VERY_LIGHT_BLUE = new Color(51, 190, 255);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(VERY_LIGHT_BLUE);
		}

		if (index == 3) {
			final Color VERY_LIGHT_GREEN = new Color(102, 255, 102);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(VERY_LIGHT_GREEN);
		}

		if (index == 4) {
			final Color VERY_LIGHT_YELLOW = new Color(255, 240, 120);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(VERY_LIGHT_YELLOW);
		}

		if (index == 5) {
			final Color VERY_LIGHT_GREY = new Color(204, 204, 204);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(VERY_LIGHT_GREY);
		}

		if (index == 6) {
			final Color VERY_LIGHT_BROWN = new Color(153, 102, 0);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(VERY_LIGHT_BROWN);
		}

		if (index == 7) {
			final Color PURPLE = new Color(102, 80, 200);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(PURPLE);
		}

		if (index == 8) {
			final Color LIGHT_BLACK = new Color(90, 90, 90);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(LIGHT_BLACK);
		}

		if (index == 9) {
			final Color LIGHT_ORANGE = new Color(155, 153, 0);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(LIGHT_ORANGE);
		}

		if (index == 10) {
			final Color LIGHT_BLUE = new Color(51, 130, 255);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(LIGHT_BLUE);
		}
		
		if (index == 11) {
			final Color WATER_BLUE = new Color(30, 230, 255);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(WATER_BLUE);
		}
		
		if (index == 12) {
			final Color TREE_GREEN = new Color(84, 168, 51);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(TREE_GREEN);
		}
		
		if (index == 13) {
			final Color ORE_GOLD = new Color(255, 215, 0);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(ORE_GOLD);
		}
		
		if (index == 14) {
			final Color CHARTREUSE = new Color(223, 254, 0);
			selectedColor = new DefaultHighlighter.DefaultHighlightPainter(CHARTREUSE);
		}

		return selectedColor;
	}
	
	// Actions of the buttons
	/**
	 * If its possible move the selected citizen up
	 * 
	 * @param textArea JTextArea where draw the map
	 * @param citizenInfo JTextArea where write the actual citizen info
	 */
	public void moveUp(JTextArea textArea, JTextArea citizenInfo) {
		Man toMove = (Man) citizenList.searchForCitizen(actualCitizenID);
		MoveController.moveOneCitizenUp(board, toMove);
		textArea.setText("\n" + board.toString());
		highlightMainMap(textArea);
		citizenInfo.setText(citizenList.getInfoID(actualCitizenID));
	}
	/**
	 * If its possible move the selected citizen down
	 * 
	 * @param textArea JTextArea where draw the map
	 * @param citizenInfo JTextArea where write the actual citizen info
	 */
	public void moveDown(JTextArea textArea, JTextArea citizenInfo) {
		Man toMove = (Man) citizenList.searchForCitizen(actualCitizenID);
		MoveController.moveOneCitizenDown(board, toMove);
		textArea.setText("\n" + board.toString());
		highlightMainMap(textArea);
		citizenInfo.setText(citizenList.getInfoID(actualCitizenID));
	}
	/**
	 * If its possible move the selected citizen to the right
	 * 
	 * @param textArea JTextArea where draw the map
	 * @param citizenInfo JTextArea where write the actual citizen info
	 */
	public void moveRight(JTextArea textArea, JTextArea citizenInfo) {
		Man toMove = (Man) citizenList.searchForCitizen(actualCitizenID);
		MoveController.moveOneCitizenRight(board, toMove);
		textArea.setText("\n" + board.toString());
		highlightMainMap(textArea);
		citizenInfo.setText(citizenList.getInfoID(actualCitizenID));
	}
	/**
	 * If its possible move the selected citizen to the left
	 * 
	 * @param textArea JTextArea where draw the map
	 * @param citizenInfo JTextArea where write the actual citizen info
	 */
	public void moveLeft(JTextArea textArea, JTextArea citizenInfo) {
		Man toMove = (Man) citizenList.searchForCitizen(actualCitizenID);
		MoveController.moveOneCitizenLeft(board, toMove);
		textArea.setText("\n" + board.toString());
		highlightMainMap(textArea);
		citizenInfo.setText(citizenList.getInfoID(actualCitizenID));
	}

	// Interact button
	/**
	 * That method search for the actual citizen on the board, then scan up, down,
	 * left and right and want for interactions. If a interaction exits, then
	 * execute that interaction and update the differents text areas of the game.
	 * 
	 * @param mapTextArea The JTextArea of the map
	 * @param logTextArea The JTextArea of the action log
	 * @param citizenInfo The JTextArea of the actual citizen
	 */
	public void interactAction(JTextArea mapTextArea, JTextArea logTextArea, JTextArea citizenInfo) {
		InteractController.interactSpecific(board, actualCitizen);
		mapTextArea.setText("\n" + board.toString());
		citizenInfo.setText(citizenList.getInfoID(actualCitizenID));
		highlightMainMap(mapTextArea);
		logTextArea.setText(log.toString());
	}

	// Show map button
	/**
	 * Change the text of the param textArea for the board.toString
	 * 
	 * @param textArea JTextArea to draw the map
	 */
	public void showMapButton(JTextArea textArea) {
		textArea.setText("\n" + board.toString());
		highlightMainMap(textArea);
	}
	
	// Show all citizens button
	/**
	 * Change the text of the param textArea for the citizenList.toString
	 * 
	 * @param textArea JTextArea to write all the info about the citizens
	 */
	public void showAllCitizensButton(JTextArea textArea) {
		textArea.setText(citizenList.toString());
	}
	
	// Select one citizen button
	/**
	 * Change the actual citizen to move or interact
	 * 
	 * @param textArea    Show the ID number of the actual citizen
	 * @param selectedID  The JTetField where the user write a ID and try to change
	 *                    the actual citizen to that citizen
	 * @param citizenInfo JTextArea to write refresh the info of the actual citizen
	 */
	public void selectCitizenButton(JTextField textArea, JTextField selectedID, JTextArea citizenInfo) {
		
		String selected = selectedID.getText();
		int selectedIDnumber = Integer.parseInt(selected);
		
		if (citizenList.searchForCitizen(selectedIDnumber) != null ) {
			this.actualCitizen = (Man) citizenList.searchForCitizen(selectedIDnumber);
			this.actualCitizenID = this.actualCitizen.getID();
			selectedID.setText("");
			textArea.setText(String.valueOf(actualCitizenID));
			citizenInfo.setText(citizenList.getInfoID(actualCitizenID));
		}
	}
	
	/**
	 * This method move all the citizens on the citizenList and then performs a
	 * action for each citizen.
	 */
	public void generateOneTurn() {
		MoveController.moveAllCitizens(board, citizenList);
		InteractController.interactAll(board, citizenList);
		textCentralArea.setText("\n" + board.toString());
		highlightMainMap(textCentralArea);
		logTextArea.setText(log.toString());
		actualCitizenInfoText.setText(citizenList.getInfoID(actualCitizenID));
		
	}
	
	/**
	 * A SwingWorker object used to control multiple random turns.
	 * 
	 * @author Miguel Angel Croche Munoz (MichValwin)
	 * @see javax.swing.SwingConstants;
	 * @see javax.swing.SwingWorker;
	 *
	 */
	private class SwingWorkerRercursive extends SwingWorker<Void, Void> {
		
		// Attribute
		private int actualExecute;
		
		// Constructor, set quantity
		public SwingWorkerRercursive(int quantityExecute) {
			this.actualExecute = quantityExecute;
		}
		
		// Method for Background operations
		protected Void doInBackground() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		// Recursive method
		protected void done() {
			// Actions
			ActionsLog.registerAction("Actual turn: " + actualExecute + "/" + turnX.getQuantity());
			generateOneTurn();
			
			// Recursive control
			actualExecute--;
			if (actualExecute > 0) {
				SwingWorkerRercursive worker = new SwingWorkerRercursive(actualExecute);
				worker.execute(); 	/* Recursive */
			} else {
				// Final action
				ActionsLog.registerAction("ALL TURNS HAVE BEEN COMPLETED");
				logTextArea.setText(log.toString());
				programInUse.set(false);
			}

		}
	}

	/**
	 * This method calls 'x' times the generateOneTurn() method with a half second
	 * of waiting in between using a SwingWorker object.
	 * 
	 * @param quantity The amount of turns to generate.
	 */
	public void generateXturns(int quantity) {
		programInUse.set(true);
		turnX = new QuantityTurns(quantity);
		SwingWorkerRercursive worker = new SwingWorkerRercursive(quantity);
		worker.execute();
	}

	/**
	 * This object is used to store the total turns to generate on generateXturns()
	 * and show a message like "Actual turn: 3/100" on the SwingWorker object.
	 * 
	 * @author Fernando Tarrino del Pozo (FernandoEsra)
	 *
	 */
	private class QuantityTurns {
		
		int quantity;
		
		public QuantityTurns(int quantity) {
			this.quantity = quantity;
		}
		
		protected int getQuantity() {
			return this.quantity;
		}
		
	}

	/**
	 * This method initialize the map with a length of 50x100. Then create a new
	 * resourcesList and a new citizenList. Then, in order, create the rivers, the
	 * forest, add the minerals, the animals and the citizens to the board.
	 */
	public void initialize() {
		// Map dimensions
		this.height = 27;
		this.width = 46;
		board = new Board(height, width);
		
		// Initialize the lists
		resourcesList = new ResourcesList();
		citizenList = new CitizenList();
		
		// Create biomes in order. First rivers, then forests
		int totalRivers = ((int) ((height) / 10) / 2);
		biomeGenerator.createRiver(board, totalRivers);
		
		int totalForest = (int) ((height * width) / 100) / 6;
		biomeGenerator.createCircularForest(board, totalForest, 10);
		biomeGenerator.createNonCircularForest(board, totalForest, 15);
		
		// Fill the 4% of the remaining map with trees
		int totalMap = height * width;
		biomeGenerator.createRandomTrees(board, ((int)(totalMap*0.04)));
		
		// Generate minerals and animals
		resourcesList.addGoldOreMineral((int)(totalMap*0.03));
		resourcesList.addGrain((int)(totalMap*0.02));
		resourcesList.addResourcesToMap(board);
		
		// Generate citizens
		citizenList.createAll(1);
		citizenList.addAllCitizensToMap(board);
		
		
	}

	/**
	 * Test method to initialize the map with just X citizens of just a selected
	 * jobs types.<p>
	 * 
	 * <b>DO NOT USE. JUST FOR TESTING</b>
	 * 
	 * @param quantity The amount of citizens to create and add to the map.
	 */
	@SuppressWarnings("unused")
	@Deprecated
	public void initialize(int quantity) {
		int height = 28;
		int width = 52;
		board = new Board(height, width);
		
		resourcesList = new ResourcesList();
		
		biomeGenerator.createRiver(board, 2);
		biomeGenerator.createNonCircularForest(board, 4, 15);
		
		resourcesList.addGoldOreMineral(20);
		resourcesList.addResourcesToMap(board);
		
		
		citizenList = new CitizenList();
		citizenList.createMiner(quantity);
		citizenList.createBlackmisth(quantity);
		citizenList.createFisherman(quantity);
		citizenList.createFishmonger(quantity);
		citizenList.createFarmer(quantity);
		citizenList.addAllCitizensToMap(board);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		/**
		 * Controll the movement with the arrow keys or W,A,S,D and the interact action
		 * with the 'e' key
		 */
		if (!programInUse.get()) {
			switch (e.getKeyCode()) {
			case 68:
				this.moveRight(textCentralArea, actualCitizenInfoText);
				break;
			case 65:
				this.moveLeft(textCentralArea, actualCitizenInfoText);
				break;
			case 87:
				this.moveUp(textCentralArea, actualCitizenInfoText);
				break;
			case 83:
				this.moveDown(textCentralArea, actualCitizenInfoText);
				break;
			case 69:
				this.interactAction(textCentralArea, logTextArea, actualCitizenInfoText);
				break;
			case 39:
				this.moveRight(textCentralArea, actualCitizenInfoText);
				break;
			case 37:
				this.moveLeft(textCentralArea, actualCitizenInfoText);
				break;
			case 38:
				this.moveUp(textCentralArea, actualCitizenInfoText);
				break;
			case 40:
				this.moveDown(textCentralArea, actualCitizenInfoText);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}