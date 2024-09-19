package estruturas;

import cataFruta.ElemEstaticos;
/**
 * Classe que cria um elemento estatico do tipo Pedra.
 */
public class Pedra  extends ElemEstaticos{
	public Pedra(int x, int y) {
		super(x,y);
	}
	
	public String getTipo() {
		return "Pedra";
	}
}
