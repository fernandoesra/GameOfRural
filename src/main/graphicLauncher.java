package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import base.CitizenList;
import base.MoveController;
import base.Sujeto;
import map.Board;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;

public class graphicLauncher extends JFrame {
	
	int height;
	int width;
	Board board;
	CitizenList listaCiudadanos;
	private JPanel contentPane;

	//Main
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
		
		// Iniciar el mapa y generar su contenido
		this.initialize();
		
		// Crear el contenedor JFrame
		setTitle("Game of Rural");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(110, 45, 1700, 950);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		// Crear el area de texto central y su scroll
		JTextArea textCentralArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1400, 800);
		scrollPane.setViewportView(textCentralArea);
		textCentralArea.setEditable(false);
		textCentralArea.setForeground(new Color(255, 255, 255));
		textCentralArea.setBackground(new Color(0, 0, 0));
		textCentralArea.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		// Botón para ver el mapa y su acción
		JButton showMapButton = new JButton("Ver mapa");
		showMapButton.setBounds(20, 835, 189, 50);
		showMapButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				showMap(textCentralArea);
			}
		});
		
		// Botones de movimiento
		JButton buttonUp = new JButton("Arriba");
		buttonUp.setBounds(1499, 634, 100, 30);
		
		JButton buttonDown = new JButton("Abajo");
		buttonDown.setBounds(1499, 714, 100, 30);
		
		JButton buttonRight = new JButton("Derecha");
		buttonRight.setBounds(1559, 674, 100, 30);
		
		JButton buttonLeft = new JButton("Izquierda");
		buttonLeft.setBounds(1439, 674, 100, 30);
		
		buttonUp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				botonMoverArriba(textCentralArea);
			}
		});
		
		buttonDown.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				botonMoverAbajo(textCentralArea);
			}
		});
		
		buttonRight.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				botonMoverDerecha(textCentralArea);
			}
		});
		
		buttonLeft.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				botonMoverIzquierda(textCentralArea);
			}
		});
		
		// Boton de interactuar
		JButton btnNewButton = new JButton("Interactuar");
		btnNewButton.setBounds(1499, 780, 100, 30);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interactuar(textCentralArea);
			}
		});
		
		// Añadir todo al contenedor
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		contentPane.add(showMapButton);
		contentPane.add(buttonUp);
		contentPane.add(buttonDown);
		contentPane.add(buttonRight);
		contentPane.add(buttonLeft);
		contentPane.add(btnNewButton);
		
		JButton btnVerCiudadanos = new JButton("Ver ciudadanos");
		btnVerCiudadanos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerCiudadanos.setBounds(1476, 26, 137, 30);
		contentPane.add(btnVerCiudadanos);
				
	}

	// Botton actions
	
	public void botonMoverArriba(JTextArea textArea) {
		Sujeto toMove = (Sujeto) listaCiudadanos.searchForCitizen(1);
		MoveController.moveOneCitizenUp(board, toMove);
		textArea.setText("\n"+board.toString());
	}
	
	public void botonMoverAbajo(JTextArea textArea) {
		Sujeto toMove = (Sujeto) listaCiudadanos.searchForCitizen(1);
		MoveController.moveOneCitizenDown(board, toMove);
		textArea.setText("\n"+board.toString());
	}
	
	public void botonMoverDerecha(JTextArea textArea) {
		Sujeto toMove = (Sujeto) listaCiudadanos.searchForCitizen(1);
		MoveController.moveOneCitizenRight(board, toMove);
		textArea.setText("\n"+board.toString());
	}
	
	public void botonMoverIzquierda(JTextArea textArea) {
		Sujeto toMove = (Sujeto) listaCiudadanos.searchForCitizen(1);
		MoveController.moveOneCitizenLeft(board, toMove);
		textArea.setText("\n"+board.toString());
	}
	
	// Boton interactuar
	public void interactuar(JTextArea textArea) {
		
	}
	
	// Boton ver mapa
	public void showMap(JTextArea textArea) {
		textArea.setText("\n"+board.toString());
	}
	
	// Initialize variables
	public void initialize() {
		int height = 28;
		int width = 50;
		board = new Board(height,width);
		listaCiudadanos = new CitizenList();
		listaCiudadanos.createAll(5);
		listaCiudadanos.addCitizensToMap(board);
	}
	
	public void initialize(int cantidad) {
		int height = 28;
		int width = 50;
		board = new Board(height,width);
		listaCiudadanos = new CitizenList();
		listaCiudadanos.createAgricultor(cantidad);
		listaCiudadanos.addCitizensToMap(board);
	}
}
