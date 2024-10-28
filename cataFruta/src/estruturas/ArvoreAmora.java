package estruturas;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import frutas.Amora;

/**
 * Classe que cria uma arvore do tipo Amora.
 */
public class ArvoreAmora extends Arvore {
	private Image imagem;

	public ArvoreAmora(int x, int y, String tipoArvore, Amora amora) {
		super(x, y, tipoArvore, amora);
		try {
			this.imagem = ImageIO.read(getClass().getResource("/sprites/pe_amora.png"));
		} catch (IOException e) {

		}
	}

	/**
	 * Metodo que retorna o tipo da fruta
	 */
	@Override
	public String getTipo() {
		return "ArvoreAmora";
	}

	@Override
	public Image getImg() {
		return imagem;
	}
}
