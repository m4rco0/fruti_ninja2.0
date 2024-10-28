package estruturas;

import java.awt.Image;

import javax.swing.ImageIcon;

import frutas.Acerola;

/**
 * Classe para criar um tipo de arvore de acerola
 */
public class ArvoreAcerola extends Arvore{
	private Image imagem;
	public ArvoreAcerola(int x, int y, String tipoArvore, Acerola acerola) {
		super(x, y, tipoArvore, acerola);
		imagem = new ImageIcon("catafruta/sprites/pe_acerola.png").getImage();
	}
	
	/**
	 * Metodo que retorna o tipo da Arvore
	 */
	public String getTipo() {
		return "ArvoreAmora";
	}

	public Image getImg() {
		return imagem;
	}
}
