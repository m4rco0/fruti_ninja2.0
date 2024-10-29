package frutas;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Goiaba extends Frutas {
	private Image imagem;

	public Goiaba(int x, int y, boolean bichada) {
		super(x, y, 0, bichada);
		try {
			this.imagem = ImageIO.read(getClass().getResource("/sprites/goiaba.png"));
		} catch (IOException e) {

		}
	}

	/**
	 * Retorna o tipo da frutas
	 */
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Goiaba";
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
