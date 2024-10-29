package frutas;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Acerola extends Frutas {
	private Image imagem;

	public Acerola(int x, int y, boolean bichada) {
		super(x, y, 0, bichada);
		try {
			this.imagem = ImageIO.read(getClass().getResource("/sprites/acerola.png"));
		} catch (IOException e) {

		}
	}

	/**
	 * Retorna o tipo da frutas
	 */
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Acerola";
	}
	
	/**
	 * Mostra Imagem {@link Image}
	 * return {@link Image}
	 */
	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return imagem;
	}
}
