package cataFruta;

/**
 * Class que representa um elemento do jogo
 * 
 * @author Marco Antonio da Silva Santos
 * 
 */
public abstract class Elemento {
	protected int x;
	protected int y;

	public Elemento(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Metodo que pega a posição x do elemento.
	 * 
	 * @return int x - Posição x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Metodo que pega a posição y do elemento
	 * 
	 * @return int y - posicao y
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * metodo para proximas classes
	 * 
	 * @return
	 */
	public abstract String getTipo();
}