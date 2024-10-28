package cataFruta;

/**
 * Elementos estaticos so aparecem na tela e n se movem, só a arvore que tem
 * função de dropar fruta.
 */
public abstract class ElemEstaticos extends Elemento {
	/**
	 * Construtor de leementos dinamicos
	 *
	 * @param x posição do elemento
	 * @param y posição do elemento
	 */
	public ElemEstaticos(int x, int y) {
		super(x, y);
	}
}
