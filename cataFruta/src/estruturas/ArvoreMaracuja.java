package estruturas;

import java.awt.Image;

import frutas.Maracuja;
/**
 * CLasse que cria uma arvore do tipo Maracuja.
 */
public class ArvoreMaracuja extends Arvore{
	public ArvoreMaracuja(int x, int y, String tipoArvore, Maracuja maracuja) {
		super(x, y, tipoArvore, maracuja);
	}
	/**
	 * Metodo que retorna o tipo da Arvore
	 */
	public String getTipo() {
		return "ArvoreMaracuja";
	}
	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return null;
	}
}
