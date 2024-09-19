package estruturas;

import frutas.Acerola;

/**
 * Classe para criar um tipo de arvore de acerola
 */
public class ArvoreAcerola extends Arvore{
	public ArvoreAcerola(int x, int y, String tipoArvore, Acerola acerola) {
		super(x, y, tipoArvore, acerola);
	}
	
	public String getTipo() {
		return "ArvoreAmora";
	}
}
