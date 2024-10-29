package frutas;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Laranja extends Frutas {
	private Image imagem;

	public Laranja(int x, int y, boolean bichada) {
		super(x, y, 0, bichada);
		try {
			this.imagem = ImageIO.read(getClass().getResource("/sprites/laranja.png"));
		} catch (IOException e) {

		}
	}

	/**
	 * Retorna o tipo da frutas
	 */
	@Override
	public String getTipo() {
		return "Laranja";
	}

	/**
	 * Mostra Imagem {@link Image}
	 * return {@link Image}
	 */
	@Override
	public Image getImg() {
		return imagem;
	}
}
