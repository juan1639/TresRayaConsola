package tresRaya;

public class CasillaX_O {
	
	public static final char casilla_vacia = 95; // Codigo ASCii   "_"
	public static final char casilla_fichaX = 120; // Codigo ASCii "X"
	public static final char casilla_fichaO = 111; // Codigo ASCii "O"
	
	// Casilla (por defecto: vacia y desocupada) (indice por parametro)
	private char valor = casilla_vacia;
	private int indice;
	private boolean ocupada = false;
	
	// CONSTRUCTOR ---------------------------------
	public CasillaX_O(int indice) {
		// super();
		this.indice = indice;
		this.valor = valor;
		this.ocupada = ocupada;
	}
	
	// GETers / SETers -----------------------------
	public char getValor() {
		return valor;
	}

	public void setValor(char valor) {
		this.valor = valor;
	}
	
	public int getIndice() {
		return indice;
	}
	
	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	public boolean isOcupada() {
		return ocupada;
	}
	
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	// GETers / SETTers de las CONSTANTES ---------
	public static char getCasillaVacia() {
		return casilla_vacia;
	}
	
	public static char getCasillaFichax() {
		return casilla_fichaX;
	}

	public static char getCasillaFichao() {
		return casilla_fichaO;
	}
}
