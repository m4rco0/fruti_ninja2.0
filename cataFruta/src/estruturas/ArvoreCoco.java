package estruturas;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import frutas.Coco;

/**
 * Classe que cria uma arvore do tipo Coco.
 */
public class ArvoreCoco extends Arvore {
	private Image imagem;

	public ArvoreCoco(int x, int y, String tipoArvore, Coco coco) {
		super(x, y, tipoArvore, coco);
		try {
			this.imagem = ImageIO.read(getClass().getResource("/sprites/coqueiro.png"));
		} catch (IOException e) {
			
		}
	}

	/**
	 * Metodo que retorna o tipo da Arvore
	 */
	public String getTipo() {
		return "ArvoreCoco";
	}

	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return imagem;
	}
}
