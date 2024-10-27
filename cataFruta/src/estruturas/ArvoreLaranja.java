package estruturas;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import frutas.Laranja;

/**
 * Classe que cria uma arvore dotipo Laranja
 */
public class ArvoreLaranja extends Arvore {
	private Image imagem;

	public ArvoreLaranja(int x, int y, String tipoArvore, Laranja laranja) {
		super(x, y, tipoArvore, laranja);
		try {
			this.imagem = ImageIO.read(getClass().getResource("/sprites/laranjeira.png"));
		} catch (IOException e) {
			
		}
	}

	/**
	 * Metodo que retorna o tipo da Arvore
	 */
	public String getTipo() {
		return "ArvoreLaranja";
	}

	@Override
	public Image getImg() {
		return imagem;
	}
}
