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
	
	private JPanel contentPane;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Center text area and scroll
		JTextArea textCentralArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1400, 800);
		scrollPane.setViewportView(textCentralArea);
		textCentralArea.setEditable(false);
		textCentralArea.setForeground(new Color(255, 255, 255));
		textCentralArea.setBackground(new Color(0, 0, 0));
		textCentralArea.setFont(new Font("Consolas", Font.PLAIN, 14));

		// Show actual map button
		JButton showMapButton = new JButton("Show actual map");
		showMapButton.setBounds(20, 835, 189, 50);
		showMapButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				showMapButton(textCentralArea);
			}
		});

		// Movement buttons
		JButton buttonUp = new JButton("Up");
		buttonUp.setBounds(1499, 634, 100, 30);

		JButton buttonDown = new JButton("Down");
		buttonDown.setBounds(1499, 714, 100, 30);

		JButton buttonRight = new JButton("Right");
		buttonRight.setBounds(1559, 674, 100, 30);

		JButton buttonLeft = new JButton("Left");
		buttonLeft.setBounds(1439, 674, 100, 30);

		buttonUp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				moveUpButton(textCentralArea);
			}
		});

		buttonDown.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				moveDownButton(textCentralArea);
			}
		});

		buttonRight.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				moveRightButton(textCentralArea);
			}
		});

		buttonLeft.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				moveLeftButton(textCentralArea);
			}
		});

		// Interact button
		JButton buttonInteract = new JButton("Interact");
		buttonInteract.setBounds(1499, 780, 100, 30);

		buttonInteract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interactButton(textCentralArea);
			}
		});
		
		// Show all citizens button
		
		JButton buttonShowAllCitizens = new JButton("Show all citizens");
		buttonShowAllCitizens.setBounds(1476, 26, 137, 30);
		
		buttonShowAllCitizens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAllCitizensButton(textCentralArea);
			}
		});
		
		// Objects for show citizens info
		JLabel actualCitizenLabel = new JLabel("Actual citizen:");
		actualCitizenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		actualCitizenLabel.setBounds(1440, 85, 100, 22);

		JTextArea actualCitizenTextArea = new JTextArea();
		actualCitizenTextArea.setBounds(1547, 85, 66, 22);
		actualCitizenTextArea.setEditable(false);
		actualCitizenTextArea.setForeground(new Color(255, 255, 255));
		actualCitizenTextArea.setBackground(new Color(0, 0, 0));
		actualCitizenTextArea.setFont(new Font("Consolas", Font.BOLD, 14));
		actualCitizenTextArea.setText("    " + actualCitizenID); /* At start always select the citizen with ID 1 */
		
		// Objects for select the citizen to move

		JLabel selectCitizenLabel = new JLabel("Select citizen (ID):");
		selectCitizenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectCitizenLabel.setBounds(1487, 128, 112, 22);

		JTextField selectIDtextField = new JTextField();
		selectIDtextField.setBounds(1497, 154, 86, 20);
		selectIDtextField.setColumns(10);

		JButton confirmIDbutton = new JButton("Select");
		confirmIDbutton.setBounds(1495, 185, 89, 23);
		
		confirmIDbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectCitizenButton(actualCitizenTextArea, selectIDtextField);
			}
		});
		
		// Add all to the container
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		contentPane.add(showMapButton);
		contentPane.add(buttonUp);
		contentPane.add(buttonDown);
		contentPane.add(buttonRight);
		contentPane.add(buttonLeft);
		contentPane.add(buttonInteract);
		contentPane.add(buttonShowAllCitizens);
		contentPane.add(actualCitizenLabel);
		contentPane.add(actualCitizenTextArea);
		contentPane.add(selectCitizenLabel);
		contentPane.add(confirmIDbutton);
		contentPane.add(selectIDtextField);

	}

	// Actions buttons

	public void moveUpButton(JTextArea textArea) {
		Sujeto toMove = (Sujeto) citizenList.searchForCitizen(actualCitizenID);
		MoveController.moveOneCitizenUp(board, toMove);
		textArea.setText("\n" + board.toString());
	}

	public void moveDownButton(JTextArea textArea) {
		Sujeto toMove = (Sujeto) citizenList.searchForCitizen(actualCitizenID);
		MoveController.moveOneCitizenDown(board, toMove);
		textArea.setText("\n" + board.toString());
	}

	public void moveRightButton(JTextArea textArea) {
		Sujeto toMove = (Sujeto) citizenList.searchForCitizen(actualCitizenID);
		MoveController.moveOneCitizenRight(board, toMove);
		textArea.setText("\n" + board.toString());
	}

	public void moveLeftButton(JTextArea textArea) {
		Sujeto toMove = (Sujeto) citizenList.searchForCitizen(actualCitizenID);
		MoveController.moveOneCitizenLeft(board, toMove);
		textArea.setText("\n" + board.toString());
	}

	// Interact button
	public void interactButton(JTextArea textArea) {

	}

	// Show map button
	public void showMapButton(JTextArea textArea) {
		textArea.setText("\n" + board.toString());
	}
	
	// Show all citizens button
	public void showAllCitizensButton(JTextArea textArea) {
		textArea.setText(citizenList.toString());
	}
	
	// Select one citizen button
	public void selectCitizenButton(JTextArea textArea, JTextField selectedID) {
		
		String selected = selectedID.getText();
		int selectedIDnumber = Integer.parseInt(selected);
		
		if (citizenList.searchForCitizen(selectedIDnumber) != null ) {
			this.actualCitizen = (Sujeto) citizenList.searchForCitizen(selectedIDnumber);
			this.actualCitizenID = this.actualCitizen.getID();
			selectedID.setText("");
			textArea.setText("    " + String.valueOf(actualCitizenID));
		}
	}

	// Initialize variables
	public void initialize() {
		int height = 28;
		int width = 50;
		board = new Board(height, width);
		citizenList = new CitizenList();
		citizenList.createAll(5);
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