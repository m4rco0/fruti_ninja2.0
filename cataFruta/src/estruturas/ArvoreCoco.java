package estruturas;

import frutas.Coco;
/**
 * Classe que cria uma arvore do tipo Coco.
 */
public class ArvoreCoco extends Arvore{
	public ArvoreCoco(int x, int y, String tipoArvore, Coco coco) {
		super(x, y, tipoArvore, coco);
	}
	
	/**
	 * Metodo que retorna o tipo da Arvore
	 */
	public String getTipo() {
		return "ArvoreCoco";
	}
}
