package estruturas;

import frutas.Amora;
/**
 * Classe que cria uma arvore do tipo Amora.
 */
public class ArvoreAmora extends Arvore{

	public ArvoreAmora(int x, int y, String tipoArvore, Amora amora) {
		super(x, y, tipoArvore, amora);
	}
	
	/**
	 * Metodo que retorna o tipo da fruta
	 */
	public String getTipo() {
		return "ArvoreAmora";
	}
}
