package estruturas;

import cataFruta.ElemEstaticos;
/**
 * Classe que cria uma grama como elemento Estatico
 */
public class Grama extends ElemEstaticos{
	/**
	 * Construtor da grama
	 * @param x - cordenada x da grama
	 * @param y - cordeanada y da gramas
	 */
	public Grama(int x, int y) {
		super(x,y);
	}
	
	/**
	 * Tipo de elemento Estatico
	 */
	public String getTipo() {
		return "Grama";
	}
}
