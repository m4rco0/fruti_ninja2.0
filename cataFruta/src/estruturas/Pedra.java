package estruturas;

import cataFruta.ElemEstaticos;
/**
 * Classe que cria um elemento estatico do tipo Pedra.
 */
public class Pedra  extends ElemEstaticos{
	public Pedra(int x, int y) {
		super(x,y);
	}
	
	/**
	 * Retorna o tipo de pedra
	 * @return "Pedra"
	 */
	public String getTipo() {
		return "Pedra";
	}
}
