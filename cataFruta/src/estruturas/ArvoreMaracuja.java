package estruturas;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import frutas.Maracuja;

/**
 * CLasse que cria uma arvore do tipo Maracuja.
 */
public class ArvoreMaracuja extends Arvore {
	private Image imagem;

	public ArvoreMaracuja(int x, int y, String tipoArvore, Maracuja maracuja) {
		super(x, y, tipoArvore, maracuja);
		try {
			this.imagem = ImageIO.read(getClass().getResource("/sprites/peMaracuja.png"));
		} catch (IOException e) {
			
		}
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
