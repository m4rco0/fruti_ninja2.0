package estruturas;

import frutas.Laranja;

/**
 * Classe que cria uma arvore dotipo Laranja
 */
public class ArvoreLaranja extends Arvore{
	public ArvoreLaranja(int x, int y, String tipoArvore, Laranja laranja) {
		super(x, y, tipoArvore, laranja);
	}
	/**
	 * Metodo que retorna o tipo da Arvore
	 */
	public String getTipo() {
		return "ArvoreLaranja";
	}
}
