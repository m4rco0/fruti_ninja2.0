package estruturas;

import java.awt.Image;

import javax.swing.ImageIcon;

import frutas.Amora;
/**
 * Classe que cria uma arvore do tipo Amora.
 */
public class ArvoreAmora extends Arvore{
	private Image imagem;
	public ArvoreAmora(int x, int y, String tipoArvore, Amora amora) {
		super(x, y, tipoArvore, amora);
		imagem = new ImageIcon("/home/marco/git/fruti_ninja2.0/cataFruta/sprites/pe_amora.png").getImage();
	}
	
	/**
	 * Metodo que retorna o tipo da fruta
	 */
	public String getTipo() {
		return "ArvoreAmora";
	}

	@Override
	public Image getImg() {
		return imagem;
	}
}
