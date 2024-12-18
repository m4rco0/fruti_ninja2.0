package frutas;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Abacate extends Frutas {
	private Image imagem;

	public Abacate(int x, int y, boolean bichada) {
		super(x, y, 0, bichada);
		try {
			this.imagem = ImageIO.read(getClass().getResource("/sprites/abacate.png"));
		} catch (IOException e) {

		}
	}

	/**
	 * Retorna o tipo da frutas
	 */
	@Override
	public String getTipo() {
		return "Abacate";
	}

	/**
	 * Retorna sprite
	 * @return  {@link Image}
	 */
	@Override
	public Image getImg() {
		return imagem;
	}
}