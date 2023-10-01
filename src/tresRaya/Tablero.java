package tresRaya;

import java.util.Scanner;

public class Tablero {
	
	static int cGanadoras[][] = {
			{0, 1, 2},
			{3, 4, 5},
			{6, 7, 8},
			{0, 3, 6},
			{1, 4, 7},
			{2, 5, 8},
			{0, 4, 8},
			{2, 4, 6}
	};
	
	static final int numeroCasillas = 9;
	CasillaX_O[] arrayBoard = new CasillaX_O[numeroCasillas];
	
	private int contador_jugadas = 0;
	private boolean turno = true;
	
	// CONSTRUCTOR ------------------------------------------------
	public Tablero() {
		// super();
		this.contador_jugadas = contador_jugadas;
		this.turno = turno;
		
		for (int i = 0; i < numeroCasillas; i ++) {
			arrayBoard[i] = new CasillaX_O(i);
			// System.out.print(" " + arrayBoard[i].getValor());
		}
		
		bucle_principal();
	}
	
	// --------------------------------------------------------------------------
	public void bucle_principal() {
		
		Scanner sc = new Scanner(System.in);
		boolean tresRaya = false;
		
		do {
			contador_jugadas ++;
			String quienJuega = (turno) ? " X (Jugador)" : "  O (CPU)";
			
			for (int i = 0; i < numeroCasillas; i ++) {
				
				if (i == 2) {
					System.out.print("   " + arrayBoard[i].getValor() + "   Turno:" + quienJuega);
					System.out.println("\n");
					
				} else if (i == 5) {
					System.out.print("   " + arrayBoard[i].getValor());
					System.out.println("\n");
					
				} else {
					System.out.print("   " + arrayBoard[i].getValor());
				}
			}
			
			tresRaya = jugar(turno, sc, contador_jugadas, arrayBoard);
			
			if (contador_jugadas < 9) {
				System.out.println("\n\n\n");
			}
			
			turno = (turno) ? false : true;
			
		} while (contador_jugadas < 9 && !tresRaya);
		
		System.out.println("Juego Terminado");
	}
	
	// -------------------------------------------------------------------------
	public static boolean jugar(boolean turno, Scanner sc, int contador_jugadas, CasillaX_O[] arrayBoard) {
		
		boolean tresRaya = false;
		double rnd;
		int tirada_cpu;
		int tirada_jugador;
		
		char casilla_vacia = CasillaX_O.getCasillaVacia();
		char casilla_fichaX = CasillaX_O.getCasillaFichax();
		char casilla_fichaO = CasillaX_O.getCasillaFichao();
		
		if (!turno) {
			
			do {
				rnd = Math.floor(Math.random() * 9);
				tirada_cpu = (int) rnd;
				// System.out.print(tirada_cpu);
				
			} while (arrayBoard[tirada_cpu].getValor() != casilla_vacia);
			
			arrayBoard[tirada_cpu].setValor(casilla_fichaO);
			arrayBoard[tirada_cpu].setOcupada(true);
			tresRaya = check_siHayGanador(casilla_fichaO, arrayBoard);
			
		} else {
			
			do {
				tirada_jugador = sc.nextInt();
				
			} while (arrayBoard[tirada_jugador].getValor() != casilla_vacia);
			
			arrayBoard[tirada_jugador].setValor(casilla_fichaX);
			arrayBoard[tirada_jugador].setOcupada(true);
			tresRaya = check_siHayGanador(casilla_fichaX, arrayBoard);
		}
		
		return tresRaya;
	}
	
	// --------------------------------------------------------------------------
	public static boolean check_siHayGanador(char xo, CasillaX_O[] arrayBoard) {
		
		boolean tresRaya = false;
		
		for (int i = 0; i < cGanadoras.length; i ++) {
			int check1 = cGanadoras[i][0];
			int check2 = cGanadoras[i][1];
			int check3 = cGanadoras[i][2];
			
			// System.out.print(check1);
			
			if (arrayBoard[check1].getValor() == xo && arrayBoard[check2].getValor() == xo && arrayBoard[check3].getValor() == xo) {
				System.out.println(" 3 en Raya! ");
				tresRaya = true;
			}
		}
		
		return tresRaya;
	}
}
