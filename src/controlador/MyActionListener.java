package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import vista.TresNRayaUI;

public class MyActionListener implements ActionListener {

	TresNRaya control=new TresNRaya();
	ParaTresNRayaUI paraTresNRayaUI;
	JButton[][] botones;
	int posicionActualX,posicionActualY;
	
	public MyActionListener(JButton[][] botones, ParaTresNRayaUI paraTresNRayaUI) {
		this.botones=botones;
		this.paraTresNRayaUI=paraTresNRayaUI;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int [] coordenadas=reconoceBoton(e.getSource());
		comprobarJugada(coordenadas);
		
	}
	
	private void comprobarJugada(int[] coordenadas) {
		paraTresNRayaUI.textField.setText(control.muestraLetrero());
		if (!control.comprobarTresEnRaya()) {
			asociaCoordenada();
			if (!control.realizarJugada()) {
				paraTresNRayaUI.textField.setText(control.indicarAnomalia());
			} else {
				comprobarTablero();
			}
		} else {
			comprobarTablero();
			indicarGanagador();
		}
		
	}

	private void comprobarTablero() {
		colocarSimbolo();
		recorreBotonera();
	}
	
	private void colocarSimbolo() {
		for (int i = 0; i < this.control.tablero.length; i++) {
			for (int j = 0; j < this.control.tablero.length; j++) {
				if (this.control.tablero[i][j] == control.verTurno()) {
					
					String simboloo = String.valueOf(control.retornaSimbolo(this.control.verTurno()));
					paraTresNRayaUI.botonera.botones[i][j].setText(simboloo);
					
				}
			}
		}
		
		if (this.control.comprobarTresEnRaya()) {
			indicarGanagador();
		}
	}
	
	private void recorreBotonera() {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				botones[i][j].setText(String.valueOf(control.retornaSimbolo(control.tablero[i][j])));
			}
		}
	}
	
	private void indicarGanagador() {
		char turno = cambiarTurno();
		paraTresNRayaUI.textField.setText("El jugador " +turno + " ha ganado");
		
	}

	private char cambiarTurno() {
		if (this.control.retornaSimbolo(control.verTurno()) == 'X') {
			return 'O';
		} else {
			return 'X';
		}
	}




	private void asociaCoordenada() {
		control.asignarPosicion(posicionActualX, posicionActualY);
	}

	private int[] reconoceBoton(Object source) {
			
			JButton boton=(JButton)source;
			posicionActualX=Integer.valueOf(Character.toString(boton.getName().charAt(0)));
			posicionActualY=Integer.valueOf(Character.toString(boton.getName().charAt(1)));
			int coordenadas[]={posicionActualX,posicionActualY};
			return coordenadas;
	}

	public int getPosicionActualX() {
		return posicionActualX;
	}

	public int getPosicionActualY() {
		return posicionActualY;
	}

}
