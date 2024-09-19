package estruturas;

import frutas.Maracuja;
/**
 * CLasse que cria uma arvore do tipo Maracuja.
 */
public class ArvoreMaracuja extends Arvore{
	public ArvoreMaracuja(int x, int y, String tipoArvore, Maracuja maracuja) {
		super(x, y, tipoArvore, maracuja);
	}
	
	public String getTipo() {
		return "ArvoreMaracuja";
	}
}
