package tresRaya;

import java.util.Scanner;

public class Tablero {
	
	public static final char casilla_vacia = 95; // Codigo ASCii   "_"
	public static final char casilla_fichaX = 120; // Codigo ASCii "X"
	public static final char casilla_fichaO = 111; // Codigo ASCii "O"
	
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
	private static String ganador;
	private boolean turno = true;
	
	// CONSTRUCTOR ------------------------------------------------
	public Tablero() {
		// super();
		this.contador_jugadas = contador_jugadas;
		this.turno = turno;
		
		// Instanciamos las 9 casillas (vacias por defecto) -----
		for (int i = 0; i < numeroCasillas; i ++) {
			arrayBoard[i] = new CasillaX_O(casilla_vacia, i, false);
			// System.out.print(" " + arrayBoard[i].getValor());
		}
		
		bucle_principal();
	}
	
	// --------------------------------------------------------------------------
	public void bucle_principal() {
		
		Scanner sc = new Scanner(System.in);
		boolean tresRaya = false;
		boolean empate = false;
		
		do {
			contador_jugadas ++;
			String quienJuega = (turno) ? " X (Jugador)" : "  O (CPU)";
			
			imprime_areaDeJuego(quienJuega);
			
			tresRaya = jugar(turno, sc, contador_jugadas, arrayBoard);
			
			System.out.println("\n\n\n");
			turno = (turno) ? false : true;
			
			empate = check_siHayEmpate(arrayBoard);
			
		} while (!tresRaya && !empate);
		
		if (!tresRaya) {
			imprime_areaDeJuego("  EMPATE!");
			
		} else {
			imprime_areaDeJuego("  3 en RAYA!  " + ganador);
		}
	}
	
	// -------------------------------------------------------------------------
	public static boolean jugar(boolean turno, Scanner sc, int contador_jugadas, CasillaX_O[] arrayBoard) {
		
		boolean tresRaya = false;
		double rnd;
		int tirada_cpu;
		int tirada_jugador;
		
		if (!turno) {
			
			do {
				rnd = Math.floor(Math.random() * 9);
				tirada_cpu = (int) rnd;
				// System.out.print(tirada_cpu);
				
			} while (arrayBoard[tirada_cpu].getValor() != casilla_vacia);
			
			arrayBoard[tirada_cpu].setValor(casilla_fichaO);
			arrayBoard[tirada_cpu].setOcupada(true);
			tresRaya = check_siHayGanador(casilla_fichaO, arrayBoard);
			ganador = "Gana la CPU!";
			
		} else {
			
			do {
				tirada_jugador = sc.nextInt();
				
			} while (arrayBoard[tirada_jugador].getValor() != casilla_vacia);
			
			arrayBoard[tirada_jugador].setValor(casilla_fichaX);
			arrayBoard[tirada_jugador].setOcupada(true);
			tresRaya = check_siHayGanador(casilla_fichaX, arrayBoard);
			ganador = "GANASTE!!!";
		}
		
		return tresRaya;
	}
	
	// --------------------------------------------------------------------------
	public void imprime_areaDeJuego(String quienJuega) {
		
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
				// System.out.println(" 3 en Raya! ");
				tresRaya = true;
			}
		}
		
		return tresRaya;
	}
	
	// --------------------------------------------------------------------------
	public static boolean check_siHayEmpate(CasillaX_O[] arrayBoard) {
		
		boolean empate = true;
		
		for (CasillaX_O casilla: arrayBoard) {
			if (!casilla.isOcupada()) {
				return false;
			}
		}
		
		return empate;
	}
}
