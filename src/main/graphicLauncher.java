package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import base.CitizenList;
import base.Sujeto;
import map.Board;
import utils.MoveController;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.DefaultHighlighter;
import javax.swing.border.BevelBorder;

public class graphicLauncher extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int height;
	int width;
	Board board;
	CitizenList citizenList;
	int actualCitizenID;
	Sujeto actualCitizen;
	
	private JPanel mainContentPane;
	private JTextField actualCitizenInfoText;

	// Main
	public static void main(String[] args) {
		// Methods to launch before the interface

		// JFrame method
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					graphicLauncher frame = new graphicLauncher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// Methods to launche after the interface

	}

	// Graphic constructor
	public graphicLauncher() {

		// Initialize and fill the map
		this.initialize();
		actualCitizenID = 1;

		// JFrame Container
		setTitle("Game of Rural");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(110, 45, 1700, 950);
		mainContentPane = new JPanel();
		mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Center text area and scroll
		JTextArea textCentralArea = new JTextArea();
		textCentralArea.setEditable(false);
		JScrollPane scrollPaneForCentralText = new JScrollPane();
		scrollPaneForCentralText.setBounds(10, 10, 850, 570);
		scrollPaneForCentralText.setViewportView(textCentralArea);
		textCentralArea.setForeground(new Color(0, 0, 0));
		textCentralArea.setBackground(new Color(255, 255, 255));
		textCentralArea.setFont(new Font("Consolas", Font.PLAIN, 14));
		textCentralArea.getHighlighter();/* At start always select the citizen with ID 1 */
		
		// Select Citizens Panel
		
		JPanel selectCitizensPanel = new JPanel();
		selectCitizensPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		selectCitizensPanel.setBounds(883, 27, 213, 166);
		selectCitizensPanel.setLayout(null);
		
		JButton confirmIDbutton = new JButton("Select");
		confirmIDbutton.setBounds(64, 120, 77, 23);
		
		// Objects for show citizens info
		JLabel actualCitizenLabel = new JLabel("Actual citizen:");
		actualCitizenLabel.setBounds(35, 29, 100, 22);
		actualCitizenLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		// Objects for select the citizen to move
		
		JTextField actualCitizenTextArea = new JTextField();
		actualCitizenTextArea.setBounds(141, 30, 46, 20);
		actualCitizenTextArea.setHorizontalAlignment(SwingConstants.CENTER);
		actualCitizenTextArea.setEditable(false);
		actualCitizenTextArea.setColumns(10);
		actualCitizenTextArea.setText(String.valueOf(actualCitizenID));
		
		JLabel selectCitizenLabel = new JLabel("Select citizen (ID):");
		selectCitizenLabel.setBounds(35, 77, 112, 22);
		selectCitizenLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JTextField selectIDtextField = new JTextField();
		selectIDtextField.setBounds(141, 78, 46, 20);
		selectIDtextField.setColumns(10);

		// Citizen info panel

		JPanel citizenInfoPanel = new JPanel();
		citizenInfoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		citizenInfoPanel.setBounds(1124, 27, 503, 376);
		citizenInfoPanel.setLayout(null);

		JTextArea actualCitizenInfoText = new JTextArea();
		actualCitizenInfoText.setBackground(new Color(255, 255, 255));
		actualCitizenInfoText.setFont(new Font("Consolas", Font.PLAIN, 11));
		actualCitizenInfoText.setEditable(false);
		actualCitizenInfoText.setBounds(10, 41, 483, 324);
		actualCitizenInfoText.setColumns(10);
		actualCitizenInfoText.setText("\n" + citizenList.getInfoID(actualCitizenID));

		JLabel actualCitizenInfoLabel = new JLabel("Actual citizen info:");
		actualCitizenInfoLabel.setBounds(10, 16, 158, 14);

		confirmIDbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectCitizenButton(actualCitizenTextArea, selectIDtextField, actualCitizenInfoText);
			}
		});
		
		// Button panel
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonsPanel.setBounds(10, 601, 850, 81);
		buttonsPanel.setLayout(null);
		
		// Show actual map button
		JButton showMapButton = new JButton("Show actual map");
		showMapButton.setBounds(10, 22, 153, 36);

		// Show all citizens button

		JButton buttonShowAllCitizens = new JButton("Show all citizens");
		buttonShowAllCitizens.setBounds(173, 22, 153, 36);

		buttonShowAllCitizens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAllCitizensButton(textCentralArea);
			}
		});
		showMapButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				showMapButton(textCentralArea);
			}
		});
		
		// Movement Panel
		
		JPanel movementButtonsPane = new JPanel();
		movementButtonsPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		movementButtonsPane.setBounds(870, 204, 244, 199);
		movementButtonsPane.setLayout(null);

		// Interact button
		JButton buttonInteract = new JButton("Interact");
		buttonInteract.setBounds(70, 157, 100, 30);
		
		// Movement buttons
		
		JButton buttonDown = new JButton("Down");
		buttonDown.setBounds(70, 91, 100, 30);

		JButton buttonLeft = new JButton("Left");
		buttonLeft.setBounds(10, 51, 100, 30);

		JButton buttonUp = new JButton("Up");
		buttonUp.setBounds(70, 11, 100, 30);

		JButton buttonRight = new JButton("Right");
		buttonRight.setBounds(130, 51, 100, 30);

		buttonRight.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				moveRightButton(textCentralArea,actualCitizenInfoText);
			}
		});

		buttonUp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				moveUpButton(textCentralArea,actualCitizenInfoText);
			}
		});

		buttonLeft.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				moveLeftButton(textCentralArea,actualCitizenInfoText);
			}
		});

		buttonDown.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				moveDownButton(textCentralArea,actualCitizenInfoText);
			}
		});

		buttonInteract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interactButton(textCentralArea);
			}
		});
		
		// Log panel
		
		JPanel logPanel = new JPanel();
		logPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		logPanel.setBounds(870, 414, 757, 267);
		logPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 737, 212);
		
		JTextArea logTextArea = new JTextArea();
		scrollPane.setViewportView(logTextArea);
		logTextArea.setEditable(false);
		
		JLabel logLabel = new JLabel("Log:");
		logLabel.setBounds(10, 22, 157, 14);
		
		// Add all to the containers
		setContentPane(mainContentPane);
		mainContentPane.setLayout(null);
		mainContentPane.add(scrollPaneForCentralText);
		mainContentPane.add(selectCitizensPanel);
		mainContentPane.add(buttonsPanel);
		mainContentPane.add(movementButtonsPane);
		mainContentPane.add(citizenInfoPanel);
		mainContentPane.add(logPanel);

		selectCitizensPanel.add(actualCitizenLabel);
		selectCitizensPanel.add(actualCitizenTextArea);
		selectCitizensPanel.add(selectCitizenLabel);
		selectCitizensPanel.add(selectIDtextField);
		selectCitizensPanel.add(confirmIDbutton);
		
		buttonsPanel.add(buttonShowAllCitizens);
		buttonsPanel.add(showMapButton);
		
		movementButtonsPane.add(buttonInteract);
		movementButtonsPane.add(buttonDown);
		movementButtonsPane.add(buttonLeft);
		movementButtonsPane.add(buttonUp);
		movementButtonsPane.add(buttonRight);
		
		citizenInfoPanel.add(actualCitizenInfoText);
		citizenInfoPanel.add(actualCitizenInfoLabel);
		
		logPanel.add(scrollPane);
		logPanel.add(logLabel);

	}
	
	// Highlight action
	
	public void Highlight(JTextArea txtDisplay) {
		try {
			String text = txtDisplay.getText();
			Highlighter high = txtDisplay.getHighlighter();
			high.removeAllHighlights();
			
			// Colors
			final Color VERY_LIGHT_RED = new Color(255,102,102);
			HighlightPainter light_red = new DefaultHighlighter.DefaultHighlightPainter(VERY_LIGHT_RED);
			
			final Color VERY_LIGHT_BLUE = new Color(51,224,255);
			HighlightPainter very_light_blue = new DefaultHighlighter.DefaultHighlightPainter(VERY_LIGHT_BLUE);
			
			final Color VERY_LIGHT_GREEN = new Color(102,255,102);
			HighlightPainter light_green = new DefaultHighlighter.DefaultHighlightPainter(VERY_LIGHT_GREEN);
			
			final Color VERY_LIGHT_YELLOW = new Color(255,204,0);
			HighlightPainter light_yellow = new DefaultHighlighter.DefaultHighlightPainter(VERY_LIGHT_YELLOW);
			
			final Color VERY_LIGHT_GREY = new Color(204,204,204);
			HighlightPainter light_grey = new DefaultHighlighter.DefaultHighlightPainter(VERY_LIGHT_GREY);
			
			final Color VERY_LIGHT_BROWN = new Color(153,102,0);
			HighlightPainter light_brown = new DefaultHighlighter.DefaultHighlightPainter(VERY_LIGHT_BROWN);
			
			final Color PURPLE= new Color(102,80,200);
			HighlightPainter purple = new DefaultHighlighter.DefaultHighlightPainter(PURPLE);
			
			final Color LIGHT_BLACK = new Color(90,90,90);
			HighlightPainter light_black = new DefaultHighlighter.DefaultHighlightPainter(LIGHT_BLACK);
			
			final Color LIGHT_ORANGE = new Color(155,153,0);
			HighlightPainter light_orange = new DefaultHighlighter.DefaultHighlightPainter(LIGHT_ORANGE);
			
			final Color LIGHT_BLUE = new Color(51,153,255);
			HighlightPainter light_blue = new DefaultHighlighter.DefaultHighlightPainter(LIGHT_BLUE);
			
			// Paint all map
			// high.addHighlight(158, 3014, DefaultHighlighter.DefaultPainter);
			
			// The map start at index 140
			char mapText[] = board.toString().toCharArray();
			
			for (int i = 140; i < mapText.length; i++) {
				switch (mapText[i]) {
				case 'A':
					// Agricultor
					high.addHighlight(i+1, i+2, light_green);
					break;
				case 'C':
					// Carnicero
					high.addHighlight(i+1, i+2, light_red);
					break;
				case 'I':
					// Carpintero
					high.addHighlight(i+1, i+2, light_yellow);
					break;
				case 'H':
					// Herrero
					high.addHighlight(i+1, i+2, light_grey);
					break;
				case 'M':
					// Maderero
					high.addHighlight(i+1, i+2, light_brown);
					break;
				case 'R':
					// Minero
					high.addHighlight(i+1, i+2, light_black);
					break;
				case 'B':
					// Panadero
					high.addHighlight(i+1, i+2, purple);
					break;
				case 'O':
					// Pastor
					high.addHighlight(i+1, i+2, light_orange);
					break;
				case 'S':
					// Pescadero
					high.addHighlight(i+1, i+2, light_blue);
					break;
				case 'J':
					// Pescador
					high.addHighlight(i+1, i+2, very_light_blue);
					break;
				}
			}
			
			// high.addHighlight(1, 2, orange);
			
		} catch (Exception ex) {
			System.err.println("Error "+ex.getMessage());
		}
	}
	
	// Actions buttons
	
	public void moveUpButton(JTextArea textArea, JTextArea citizenInfo) {
		Sujeto toMove = (Sujeto) citizenList.searchForCitizen(actualCitizenID);
		MoveController.moveOneCitizenUp(board, toMove);
		textArea.setText("\n" + board.toString());
		Highlight(textArea);
		citizenInfo.setText("\n" + citizenList.getInfoID(actualCitizenID));
	}

	public void moveDownButton(JTextArea textArea, JTextArea citizenInfo) {
		Sujeto toMove = (Sujeto) citizenList.searchForCitizen(actualCitizenID);
		MoveController.moveOneCitizenDown(board, toMove);
		textArea.setText("\n" + board.toString());
		Highlight(textArea);
		citizenInfo.setText("\n" + citizenList.getInfoID(actualCitizenID));
	}

	public void moveRightButton(JTextArea textArea, JTextArea citizenInfo) {
		Sujeto toMove = (Sujeto) citizenList.searchForCitizen(actualCitizenID);
		MoveController.moveOneCitizenRight(board, toMove);
		textArea.setText("\n" + board.toString());
		Highlight(textArea);
		citizenInfo.setText("\n" + citizenList.getInfoID(actualCitizenID));
	}

	public void moveLeftButton(JTextArea textArea, JTextArea citizenInfo) {
		Sujeto toMove = (Sujeto) citizenList.searchForCitizen(actualCitizenID);
		MoveController.moveOneCitizenLeft(board, toMove);
		textArea.setText("\n" + board.toString());
		Highlight(textArea);
		citizenInfo.setText("\n" + citizenList.getInfoID(actualCitizenID));
	}

	// Interact button
	public void interactButton(JTextArea textArea) {

	}

	// Show map button
	public void showMapButton(JTextArea textArea) {
		textArea.setText("\n" + board.toString());
		Highlight(textArea);
	}
	
	// Show all citizens button
	public void showAllCitizensButton(JTextArea textArea) {
		textArea.setText(citizenList.toString());
	}
	
	// Select one citizen button
	public void selectCitizenButton(JTextField textArea, JTextField selectedID, JTextArea citizenInfo) {
		
		String selected = selectedID.getText();
		int selectedIDnumber = Integer.parseInt(selected);
		
		if (citizenList.searchForCitizen(selectedIDnumber) != null ) {
			this.actualCitizen = (Sujeto) citizenList.searchForCitizen(selectedIDnumber);
			this.actualCitizenID = this.actualCitizen.getID();
			selectedID.setText("");
			textArea.setText(String.valueOf(actualCitizenID));
			citizenInfo.setText("\n" + citizenList.getInfoID(actualCitizenID));
		}
	}

	// Initialize variables
	public void initialize() {
		int height = 28;
		int width = 50;
		board = new Board(height, width);
		citizenList = new CitizenList();
		citizenList.createAll(2);
		citizenList.addCitizensToMap(board);
	}
	// Initialize variables with just 1 Sujeto (for test)
	public void initialize(int cantidad) {
		int height = 28;
		int width = 50;
		board = new Board(height, width);
		citizenList = new CitizenList();
		citizenList.createAgricultor(cantidad);
		citizenList.addCitizensToMap(board);
	}
}