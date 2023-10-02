package tresRaya;

public class CasillaX_O {
	
	// Casilla (por defecto: vacia y desocupada) (indice por parametro)
	private char valor;
	private int indice;
	private boolean ocupada;
	
	// CONSTRUCTOR ---------------------------------
	public CasillaX_O(char valor, int indice, boolean ocupada) {
		// super();
		this.valor = valor;
		this.indice = indice;
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
}
