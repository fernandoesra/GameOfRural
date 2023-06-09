package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import base.Man;
import jobs.Marshal;
import jobs.Mayor;
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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

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

public class GraphicLauncher extends JFrame implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Attributes
	
	/**
	 * Height of the board. Set on the constructor.
	 */
	int height;
	/**
	 * Width of the board. Set on the constructor.
	 */
	int width;
	/**
	 * Time on ms between turns. Set on the constructor.
	 */
	int timeBetweenTurns;
	
	/**
	 * Store the map and all the objects of the game.
	 */
	Board board;
	/**
	 * Used to store the citizens of the map.
	 */
	CitizenList citizenList;
	/**
	 * Used to store the resources of the map.
	 */
	ResourcesList resourcesList;
	/**
	 * Used to store the animals of the map.
	 */
	AnimalList animalList;
	/**
	 * Set to 1 at the start of the game.
	 */
	int actualCitizenID;
	/**
	 * Its used to show the actualCitizen info on the log.
	 */
	Man actualCitizen;
	/**
	 * Used to store all the actions and later show the text on the logTextArea.
	 */
	ActionsLog log;
	/**
	 * Used on the initialize() method to generate new biomes.
	 */
	BiomeGenerator biomeGenerator;
	/**
	 * The variable programInUse is used on generateXturns() to prevent the player
	 * use other buttons during the performance of the method.
	 */
	AtomicBoolean programInUse;
	
	/**
	 * Used on the SwingWorkerGenerateTurns class to know how much turns are have
	 * been requested to generate.
	 */
	QuantityTurns turnX;
	/**
	 * This variable is used to write the actual turn on the log.
	 */
	QuantityTurns actualTurn;
	/**
	 * Used on the SwingWorkerGenerateTurns class to know how much turns remain.
	 */
	AtomicBoolean generatingTurns;
	/**
	 * Used on the generateOneTurn() method each 200 turns to know if its time to
	 * pay or collect taxes.
	 */
	AtomicBoolean payOrTax;
	
	/**
	 * Used on the controlMusic() method to know the song to wich change the volume.
	 */
	FloatControl musicController;
	/**
	 * Used on the controlMusic() method to know if its time to mute or unmute the
	 * audio.
	 */
	boolean controlMusicChanger;
	
	/**
	 * The main frame of the program window
	 */
	public JPanel mainContentPane;
	/**
	 * The JTextArea where to draw the map
	 */
	public JTextArea textCentralArea;
	/**
	 * The JTextArea where to show the selected citizen info
	 */
	public JTextArea actualCitizenInfoText;
	/**
	 * The JTextArea where to show the log String
	 */
	public JTextArea logTextArea;
	/**
	 * The JTextField where write the amount value for a random generated turns
	 */
	private JTextField turnsValueTextField;
	
	// Main
	/**
	 * The main method of the game. Here whe create the interface and initialize
	 * all.
	 * 
	 * @param args Java magic.
	 */
	public static void main(String[] args) {
		// Methods to launch before the interface
		/**
		 * Create the interface
		 */
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					GraphicLauncher frame = new GraphicLauncher();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// Methods to launche after the interface
		
	}
	
	// Constructor
	/**
	 * Empty constructor. Initialize all the attributes for the class.
	 */
	public GraphicLauncher() {
			
		// Set the time to sleep between turns
		timeBetweenTurns = setTimeBetweenTurns("default");
		
		// Initialize the programInUse
		programInUse = new AtomicBoolean();
		programInUse.lazySet(false);
		generatingTurns = new AtomicBoolean();
		generatingTurns.lazySet(false);
		payOrTax = new AtomicBoolean();
		payOrTax.lazySet(true);
		
		// Initialize the biome generator
		biomeGenerator = new BiomeGenerator();
		
		// Initialize the action log
		log = new ActionsLog();
		
		// Initialize and fill the map, set the starting actual Citizen to 1
		this.initialize();		/* Main method of the initialize part */
		actualCitizenID = 1;
		
		// Show the welcome text
				actualTurn = new QuantityTurns(1);
				ActionsLog.registerAction(""
		+ "***********************************************************************************************\r\n"
		+ "                                           WELCOME TO\r\n"
		+ "                                          GAME OF RURAL\r\n"
		+ "-----------------------------------------------------------------------------------------------\r\n"
		+ "You can move the characters using 'W,A,S,D' or the arrow keys.\r\n"
		+ "You can interact using the 'E' key.\r\n"
		+ "You can change your character in the upper right area.\r\n"
		+ "You can generate random turns in the central area.\r\n"
		+ "-----------------------------------------------------------------------------------------------\r\n"
		+ "Thanks for playing! For more information visit: https://github.com/fernandoesra/GameOfRural\r\n"
		+ "***********************************************************************************************\r\n"
		+ "A new day dawns in " + board.getName() + ". Actual turn: " + actualTurn );
		
		/*
		 * From here we create all the graphic objetcs of Java Swing
		 */
		
		// JFrame Container
		setTitle("Game of Rural");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(110, 45, 1700, 950);
		mainContentPane = new JPanel();
		mainContentPane.setBackground(new Color(85, 72, 98));
		mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Center text area and scroll
		textCentralArea = new JTextArea();
		// textCentralArea.setFont(new Font("Consolas", Font.PLAIN, 14));
		textCentralArea.setEditable(false);
		JScrollPane scrollPaneForCentralText = new JScrollPane();
		scrollPaneForCentralText.setBounds(10, 10, 850, 580);
		scrollPaneForCentralText.setViewportView(textCentralArea);
		textCentralArea.setForeground(new Color(0, 0, 0));
		textCentralArea.setBackground(new Color(254, 249, 235));
		
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
				
		// Select Citizens Panel
		JPanel selectCitizensPanel = new JPanel();
		selectCitizensPanel.setBackground(new Color(252, 234, 184));
		selectCitizensPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		selectCitizensPanel.setBounds(1255, 10, 419, 46);
		selectCitizensPanel.setLayout(null);
		
		JButton confirmIDbutton = new JButton("Select");
		confirmIDbutton.setBounds(332, 11, 77, 23);
		
		// Objects for show citizens info
		JLabel actualCitizenLabel = new JLabel("Actual citizen:");
		actualCitizenLabel.setBackground(new Color(240, 240, 240));
		actualCitizenLabel.setBounds(10, 11, 88, 22);
		actualCitizenLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		// Objects for select the citizen to move
		JTextField actualCitizenTextArea = new JTextField();
		actualCitizenTextArea.setBackground(new Color(254, 249, 235));
		// actualCitizenTextArea.setFont(FiraFont11);
		actualCitizenTextArea.setBounds(108, 12, 46, 20);
		actualCitizenTextArea.setHorizontalAlignment(SwingConstants.CENTER);
		actualCitizenTextArea.setEditable(false);
		actualCitizenTextArea.setColumns(10);
		actualCitizenTextArea.setText(String.valueOf(actualCitizenID));
		
		JLabel selectCitizenLabel = new JLabel("Select citizen (ID):");
		selectCitizenLabel.setBounds(164, 11, 102, 22);
		selectCitizenLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JTextField selectIDtextField = new JTextField();
		selectIDtextField.setHorizontalAlignment(SwingConstants.CENTER);
		selectIDtextField.setBackground(new Color(254, 249, 235));
		selectIDtextField.setBounds(276, 12, 46, 20);
		selectIDtextField.setColumns(10);

		// Citizen info panel
		JScrollPane scrollPaneActualCitizen = new JScrollPane();
		scrollPaneActualCitizen.setBounds(10, 41, 399, 284);

		actualCitizenInfoText = new JTextArea();
		scrollPaneActualCitizen.setViewportView(actualCitizenInfoText);
		actualCitizenInfoText.setBackground(new Color(254, 249, 235));
		actualCitizenInfoText.setEditable(false);
		actualCitizenInfoText.setColumns(10);
		actualCitizenInfoText.setText(citizenList.getInfoID(actualCitizenID));
		
		// Set text for actual citizen text info
		try {
			Font font = Font.createFont(Font.PLAIN, new FileInputStream(new File("./assets/FiraCode-Regular.ttf")));
			actualCitizenInfoText.setFont(font.deriveFont(Font.PLAIN, 11f));
		} catch (FontFormatException | IOException e) {
			System.err.println("Font not found");
			e.printStackTrace();
		}

		JPanel citizenInfoPanel = new JPanel();
		citizenInfoPanel.setBackground(new Color(252, 234, 184));
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
		logPanel.setBackground(new Color(252, 234, 184));
		logPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		logPanel.setBounds(870, 414, 804, 267);
		logPanel.setLayout(null);

		JScrollPane scrollPaneLogArea = new JScrollPane();
		scrollPaneLogArea.setBounds(10, 36, 784, 220);

		logTextArea = new JTextArea();
		logTextArea.setBackground(new Color(254, 249, 235));
		logTextArea.setEditable(false);
		scrollPaneLogArea.setViewportView(logTextArea);
		
		// Set text for citizen log
		try {
			Font font = Font.createFont(Font.PLAIN, new FileInputStream(new File("./assets/FiraCode-Regular.ttf")));
			logTextArea.setFont(font.deriveFont(Font.PLAIN, 13f));
		} catch (FontFormatException | IOException e) {
			System.err.println("Font not found");
			e.printStackTrace();
		}

		JLabel logLabel = new JLabel("Log:");
		logLabel.setBounds(10, 11, 157, 14);
		
		// Banner image
		JLabel bannerLabel = new JLabel("");
		bannerLabel.setIcon(new ImageIcon("./assets/bannerGoR.png"));
		bannerLabel.setBounds(10, 693, 1664, 207);
		
		// Map Legend panel:
		JPanel mapLegendPanel = new JPanel();
		mapLegendPanel.setBackground(new Color(252, 234, 184));
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
		
		// Start background music
		try {
			this.musicController = backgroundMusic();
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
		
		// this.controlMusic(musicController, "pause" / "continue");
		
		// Button panel
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(252, 234, 184));
		buttonsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonsPanel.setBounds(10, 601, 850, 81);
		buttonsPanel.setLayout(null);
		JButton stopButton = new JButton("");
		stopButton.setForeground(new Color(240, 240, 240));
		stopButton.setBounds(579, 22, 36, 36);
		stopButton.setIcon(new ImageIcon("./assets/stopButton.png"));
		JButton musicButton = new JButton("");
		musicButton.setForeground(SystemColor.menu);
		musicButton.setBounds(533, 22, 36, 36);
		musicButton.setIcon(new ImageIcon("./assets/musicOFF.png"));
		controlMusicChanger = true;
		
		// Music button
		musicButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlMusic(musicController, musicButton);
			}
		});
		
		// Stop button
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stopTurns();
			}
		});

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
		turnsValueTextField.setBackground(new Color(254, 249, 235));
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
		buttonsPanel.add(stopButton);
		buttonsPanel.add(musicButton);
		
		citizenInfoPanel.add(actualCitizenInfoLabel);
		citizenInfoPanel.add(scrollPaneActualCitizen);
		logPanel.add(scrollPaneLogArea);
		logPanel.add(logLabel);
		
		mapLegendPanel.add(mapLegendLabel);
		mapLegendPanel.add(mapLegendImage);
		
		// Show the map when the game start
		showMapButton(textCentralArea);
		
		// Show the log when the game start
		logTextArea.setText(log.toString());
		
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
		turnIndicatedRandom.addKeyListener(this);
		turnsValueTextField.addKeyListener(this);
		stopButton.addKeyListener(this);
		musicButton.addKeyListener(this);
	}
	
	/**
	 * This method initialize the background music and generate a new FloatControl
	 * to change the volume on the controlMusic() method.
	 * 
	 * @return A FloatControl object to control the volume.
	 * @throws UnsupportedAudioFileException Error generated for the audio.
	 * @throws IOException                   Error generated for the audio.
	 * @throws LineUnavailableException      Error generated for the audio.
	 */
	public FloatControl backgroundMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {	
		File medievalMusic = new File("./assets/medieval01.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(medievalMusic);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-35.0f);
		clip.start();
		return gainControl;
	}
	
	/**
	 * This method mute or unmute the background volume also change the icon for the
	 * music button.
	 * 
	 * @param gainControl A FloatControl object to change the volume.
	 * @param musicButton The JButton to change the image.
	 */
	public void controlMusic(FloatControl gainControl, JButton musicButton) {
		if (this.controlMusicChanger) {
			gainControl.setValue(-80.0f);
			musicButton.setIcon(new ImageIcon("./assets/musicON.png"));
			this.controlMusicChanger = false;
		} else {
			gainControl.setValue(-35.0f);
			musicButton.setIcon(new ImageIcon("./assets/musicOFF.png"));
			this.controlMusicChanger = true;
		}
	}
	
	/**
	 * This method is used on the GraphicLauncher constructor to change the sleep
	 * time between turns.<br>
	 * The returned value will be interpreted in millisecods.
	 * 
	 * @param keyword "default" for 100, "slow" for 1000 and "fast" for 1
	 * @return 100 for "default", 100 for "slow" and 1 for "fast"
	 */
	public int setTimeBetweenTurns(String keyword) {
		int speed = 100;
		switch (keyword) {
		case "default":
			speed = 100;
			break;
		case "slow":
			speed = 1000;
			break;
		case "fast":
			speed = 1;
			break;
		default:
			break;
		}
		return speed;
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
				case 'Y':
					// Mayor
					high.addHighlight(i+1, i+2, setColor(16));
					break;
				case 'A':
					// Marshal
					high.addHighlight(i+1, i+2, setColor(17));
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
				case (char)8670:
					// Grass carp Fish
					high.addHighlight(i+1, i+2, setColor(2));
					break;
				case (char)993:
					// Chicken animal
				case (char)958:
					// Pig animal
				case (char)1065:
					// Cow animal
				case (char)1020:
					// Goat animal
					high.addHighlight(i+1, i+2, setColor(15));
					break;
				default:
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
	 * <b>1 : </b>Fire Brick.        R: 255, G: 102, B: 102<br>
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
	 * <b>15: </b>Salmon.            R: 180, G: 55, B: 87<br>
	 * <b>16: </b>Dark Orange.       R: 205, G: 85, B: 30<br>
	 * <b>17: </b>Pink.              R: 255, G: 51, B: 153<br>
	 * 
	 * @param index A number between 1 and 17
	 * @return A HighlightPainter objetc with one color asigned. If the number of
	 *         the param its not on the list return white
	 */
	public HighlightPainter setColor(int index) {

		Color actualColor = new Color(255, 255, 255);
		
		switch (index) {
		case 1:
			actualColor = new Color(178, 34, 34);
			break;
		case 2:
			actualColor = new Color(51, 190, 255);
			break;
		case 3:
			actualColor = new Color(102, 255, 102);
			break;
		case 4:
			actualColor = new Color(255, 240, 120);
			break;
		case 5:
			actualColor = new Color(204, 204, 204);
			break;
		case 6:
			actualColor = new Color(153, 102, 0);
			break;
		case 7:
			actualColor = new Color(102, 80, 200);
			break;
		case 8:
			actualColor = new Color(90, 90, 90);
			break;
		case 9:
			actualColor = new Color(155, 153, 0);
			break;
		case 10:
			actualColor = new Color(51, 130, 255);
			break;
		case 11:
			actualColor = new Color(30, 230, 255);
			break;
		case 12:
			actualColor = new Color(84, 168, 51);
			break;
		case 13:
			actualColor = new Color(255, 215, 0);
			break;
		case 14:
			actualColor = new Color(223, 254, 0);
			break;
		case 15:
			actualColor = new Color(250, 128, 114);
			break;
		case 16:
			actualColor = new Color(205, 85, 30);
			break;
		case 17:
			actualColor = new Color(255, 51, 153);
			break;
		default:
			break;
		}
		HighlightPainter selectedColor = new DefaultHighlighter.DefaultHighlightPainter(actualColor);

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
		logTextArea.setText(log.toString());
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
		logTextArea.setText(log.toString());
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
		logTextArea.setText(log.toString());
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
		logTextArea.setText(log.toString());
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
	 * <p>
	 * 
	 * This method also control the movement of the animals each 5 turns. And the
	 * collect or distribute taxes methods each 200 turns.
	 */
	public void generateOneTurn() {
		this.passOneTurn();
				
		// Each 5 turns move the animals
		if (this.actualTurn.getQuantity() % 5 == 0) {
			this.animalList.moveAllAnimals(board);
		}

		// Each 200 turns its time to collect or distribute taxes
		if (this.actualTurn.getQuantity() % 200 == 0) {
			/*
			 * True   for collect taxes
			 * False  for distriute taxes 
			 */
			
			if (payOrTax.get()) {
				mayorCollectTaxes();
				payOrTax.lazySet(false);
				
			} else {				
				marshalDistributeTaxes();
				payOrTax.lazySet(true);
			}
		}
		
		// Update the text areas
		MoveController.moveAllCitizens(board, citizenList);
		InteractController.interactAll(board, citizenList);
		textCentralArea.setText("\n" + board.toString());
		highlightMainMap(textCentralArea);
		logTextArea.setText(log.toString());
		actualCitizenInfoText.setText(citizenList.getInfoID(actualCitizenID));
	}
	
	/**
	 * Search for the marshal of the town and distribute the taxes.
	 */
	public void marshalDistributeTaxes() {
		Marshal actualMarshal = (Marshal) citizenList.searchForCitizen("Marshal");
		
		double toEachCitizen = actualMarshal.distributeTaxes(citizenList);
		ActionsLog.registerAction(""
			+ "-----------------------------------------------------------------------------------------------\n"
			+ "It's payday in " + board.getName() + "! " + actualMarshal.getName()
			+ " delivers " + (Math.floor(toEachCitizen*100.0d) / 100.0d) + " ruralcoins to each citizen.\n"
			+ "-----------------------------------------------------------------------------------------------");
		
		logTextArea.setText(log.toString());
	}
	
	/**
	 * Search for the mayor of the town and collect the taxes.
	 */
	public void mayorCollectTaxes() {
		Mayor actualMayor = (Mayor) citizenList.searchForCitizen("Mayor");
		
		double totalCollected = actualMayor.collectTaxes(citizenList);
		ActionsLog.registerAction(""
			+ "-----------------------------------------------------------------------------------------------\n"
			+ "It's tax day in " + board.getName() + "! " + actualMayor.getName()
			+ " has collected " + (Math.floor(totalCollected*100.0d) / 100.0d) + " ruralcoins in taxes.\n"
			+ "-----------------------------------------------------------------------------------------------");
		
		logTextArea.setText(log.toString());
	}
	
	/**
	 * A SwingWorker object used to control what to do on each of the consucitive
	 * random turns.
	 * 
	 * @author Miguel Angel Croche Munoz (MichValwin)
	 * @see javax.swing.SwingConstants;
	 * @see javax.swing.SwingWorker;
	 *
	 */
	private class SwingWorkerDoTurn extends SwingWorker<Void, Void> {
		// Attributes
		private AtomicBoolean runningProccess;
		private final int msToWaitBetweenTurns;
		private final int remainingTurns;
		
		// Constructor, set quantity
		public SwingWorkerDoTurn(AtomicBoolean runningProccess, int msToWaitBetweenTurns, int remainingTurns) {
			this.runningProccess = runningProccess;
			this.msToWaitBetweenTurns = msToWaitBetweenTurns;
			this.remainingTurns = remainingTurns;
		}
		
		// Method for Background operations
		protected Void doInBackground() {
			if(msToWaitBetweenTurns > 0){
				try {
					Thread.sleep(msToWaitBetweenTurns);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
		
		protected void done() {
			// Actions for Game of Rural
			generateOneTurn();
			
			if (remainingTurns>0) {
				ActionsLog.registerAction("Remaining turns: " + remainingTurns + "/" + turnX.getQuantity());
			}
			runningProccess.set(false);
		}
	}

	/**
	 * A SwingWorker object used to control multiple random turns.
	 * 
	 * @author Miguel Angel Croche Munoz (MichValwin)
	 * @see javax.swing.SwingConstants;
	 * @see javax.swing.SwingWorker;
	 *
	 */
	private class SwingWorkerGenerateTurns extends SwingWorker<Void, Void> {
		// Attributes
		private int remainingTurns;
		private AtomicBoolean isbackgroundProccessRunning;
		private SwingWorkerDoTurn swingWorkerDoTurn;
		private int SetTimeBetweenTurns;
		
		// Constructor, set quantity
		public SwingWorkerGenerateTurns(int turnsToExecute) {
			this.remainingTurns = turnsToExecute;
			this.isbackgroundProccessRunning = new AtomicBoolean(false);
			this.SetTimeBetweenTurns = timeBetweenTurns;	/* Set in the GraphicLauncher constructor */
		}
		
		// Method for Background operations
		protected Void doInBackground() {
			do{
				if(!isbackgroundProccessRunning.get()){
					remainingTurns--;
					// Start wait proccess
					isbackgroundProccessRunning.set(true);
					swingWorkerDoTurn = new SwingWorkerDoTurn(isbackgroundProccessRunning,SetTimeBetweenTurns,remainingTurns);
					swingWorkerDoTurn.execute();
				}
			}while(remainingTurns > 0 && generatingTurns.get());

			return null;
		}
		
		protected void done() {
			// Final action
			
			if (!generatingTurns.get()) {
				ActionsLog.registerAction("TURNS HAVE BEEN STOPPED");
			} else {
				ActionsLog.registerAction("ALL TURNS HAVE BEEN COMPLETED");
			}
			
			generatingTurns.lazySet(false);
			logTextArea.setText(log.toString());
			programInUse.set(false);
		}
	}

	/**
	 * This method calls 'x' times the generateOneTurn() method with a 0.1 seconds
	 * of waiting in between using a SwingWorker object.
	 * 
	 * @param quantity The amount of turns to generate.
	 */
	public void generateXturns(int quantity) {
		
		if (quantity >= 1 && quantity <= 9999) {
			if (!programInUse.get()) {
				programInUse.lazySet(true);
				generatingTurns.lazySet(true);
				turnX = new QuantityTurns(quantity);
				SwingWorkerGenerateTurns worker = new SwingWorkerGenerateTurns(quantity);
				//SwingWorkerRercursive worker = new SwingWorkerRercursive(quantity);
				worker.execute();
			}
		} else {
			ActionsLog.registerAction("\"Generate turns\" value must be between 1 and 9999.");
			logTextArea.setText(log.toString());
		}
	}
	
	/**
	 * Set the generatingTurns variable to false to stop the generateXturns()
	 * method.
	 */
	public void stopTurns() {
		generatingTurns.lazySet(false);
	}

	/**
	 * This object is used to store the total turns to generate on generateXturns()
	 * and show a message like "Actual turn: 3/100" on the SwingWorker object.
	 * <p>
	 * It is also used by the variable <b<actualTurn</b>.
	 * 
	 * @author Fernando Tarrino del Pozo (FernandoEsra)
	 *
	 */
	private class QuantityTurns {
		
		int quantity;
		
		/**
		 * 
		 * @param quantity Amount of turns.
		 */
		public QuantityTurns(int quantity) {
			this.quantity = quantity;
		}
		
		/**
		 * 
		 * @return The quantity value.
		 */
		protected int getQuantity() {
			return this.quantity;
		}
		
		/**
		 * Add 1 to the quantity original value.
		 * 
		 * @return The quantity value plus 1.
		 */
		protected int oneTurn() {
			this.quantity++;
			return this.quantity;
		}
		
		@Override
		public String toString() {
			return "" + this.getQuantity();
		}
		
	}

	/**
	 * Used to controll the actual turn on the log text area adding one turn.
	 */
	public void passOneTurn() {
		if (actualTurn.getQuantity() != 1) {
			ActionsLog.registerAction("Actual turn: " + actualTurn);
		}
		actualTurn.oneTurn();
	}

	/**
	 * This method initialize the map with a length of 50x100. Then create a new
	 * resourcesList and a new citizenList. Then, in order, create the rivers, the
	 * forest, add the minerals, the animals and the citizens to the board.
	 */
	public void initialize() {
		// Map dimensions
		this.height = 27;		/* 27 to fully fill the map area witouth scroll bar */
		this.width = 46;		/* 46 to fully fill the map area witouth scroll bar */
		board = new Board(height, width);
		
		int citizenAmount = 1;	/* Change to add 'x' of each citizen */
		
		// Initialize the lists
		resourcesList = new ResourcesList();
		citizenList = new CitizenList();
		animalList = new AnimalList();
		
		// Create biomes in order. First rivers, then forests
		int totalRivers = ((int) ((height) / 10) / 2);
		biomeGenerator.createRiver(board, totalRivers);
		
		int totalForest = (int) ((height * width) / 100) / 5;
		biomeGenerator.createCircularForest(board, totalForest, 10);
		biomeGenerator.createNonCircularForest(board, totalForest, 15);
		
		// Fill the 4% of the remaining map with trees
		int totalMap = height * width;
		biomeGenerator.createRandomTrees(board, ((int)(totalMap*0.04)));
		
		// Generate basic resources (minerals and animals)
		resourcesList.addGoldOreMineral((int)(totalMap*0.025));
		resourcesList.addGrain((int)(totalMap*0.02));
		
		int totalAnimals = (int)((height * width)*0.04);
		animalList.createAnimals(totalAnimals);
		
		int totalFishes = (int)(board.totalWater() * 0.35);
		animalList.addFish(totalFishes);
		
		// Add basic resources to the map
		resourcesList.addResourcesToMap(board);
		animalList.addAnimalsToBoard(board);
		
		// Generate citizens
		for (int i = 0; i < citizenAmount; i++) {
			citizenList.createAll(1);
		}
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
		// Unused
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
		// Unused
	}
}