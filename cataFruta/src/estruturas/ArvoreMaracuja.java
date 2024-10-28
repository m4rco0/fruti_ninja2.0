package estruturas;

import java.awt.Image;

import javax.swing.ImageIcon;

import frutas.Maracuja;
/**
 * CLasse que cria uma arvore do tipo Maracuja.
 */
public class ArvoreMaracuja extends Arvore{
	private Image imagem;
	public ArvoreMaracuja(int x, int y, String tipoArvore, Maracuja maracuja) {
		super(x, y, tipoArvore, maracuja);
		imagem = new  ImageIcon("catafruta/sprites/peMaracuja.png").getImage();
	}
	/**
	 * Metodo que retorna o tipo da Arvore
	 */
	public String getTipo() {
		return "ArvoreMaracuja";
	}
	@Override
	public Image getImg() {
		return imagem;
	}
}
