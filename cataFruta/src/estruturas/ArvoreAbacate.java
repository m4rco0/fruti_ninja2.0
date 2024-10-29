package estruturas;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import frutas.Abacate;

/**
 * Classe para criar um tipo de arvore de abacate.
 */
public class ArvoreAbacate extends Arvore {
	private Image imagem;
	/**
	 * Construtor da ArvoreAbacate
	 * @param x
	 * @param y
	 * @param tipoArvore
	 * @param abacate
	 */
	public ArvoreAbacate(int x, int y, String tipoArvore, Abacate abacate) {
		super(x, y, tipoArvore, abacate);
		try {
			this.imagem = ImageIO.read(getClass().getResource("/sprites/arvoreAbCATE.png"));
		} catch (IOException e) {

		}
	}

	/**
	 * Metodo que retorna o tipo da Arvore
	 */
	@Override
	public String getTipo() {
		return "ArvoreAbacate";
	}

	@Override
	public Image getImg() {

		return imagem;
	}
}
