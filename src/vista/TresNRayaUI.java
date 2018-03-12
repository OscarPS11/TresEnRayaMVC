package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Principal;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TresNRayaUI extends JFrame {

	private JPanel contentPane;
	public Botonera botonera;
	public int numero=0;
	public JTextField textField;
	private JMenuBar menuBar;
	/**
	 * Create the frame.
	 */
	public TresNRayaUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		botonera=new Botonera(100, 0);
		botonera.setBounds(153, 45, 150, 150);
		contentPane.add(botonera);
		
		JLabel lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setBounds(33, 211, 53, 16);
		contentPane.add(lblMensaje);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(100, 208, 295, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		contentPane.setBackground(new Color(0, 128, 128));
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 432, 26);
		contentPane.add(menuBar);
		
		JMenu mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);
		
		JMenuItem mntmReiniciar = new JMenuItem("Reiniciar");
		mntmReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal.main(null);
			}
		});
		mnJuego.add(mntmReiniciar);
	}
}
