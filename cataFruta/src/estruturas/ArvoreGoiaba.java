package estruturas;

import frutas.Goiaba;
/**
 * Classe que cria uma arvore do tipo Goiaba
 */
public class ArvoreGoiaba extends Arvore{
	public ArvoreGoiaba(int x, int y, String tipoArvore, Goiaba goiaba) {
		super(x,y, tipoArvore, goiaba);
	}
	
	public String getTipo() {
		return "ArvoreGoiaba";
	}
	
}
