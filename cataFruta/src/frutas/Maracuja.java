package frutas;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Maracuja extends Frutas {
	private Image imagem;

	public Maracuja(int x, int y, boolean bichada) {
		super(x, y, 1, bichada);
		try {
			this.imagem = ImageIO.read(getClass().getResource("/sprites/maracuja.png"));
		} catch (IOException e) {
			
		}
	}

	/**
	 * Retorna o tipo da frutas
	 */
	@Override
	public String getTipo() {
		return "Maracujá";
	}

	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return imagem;
	}
}
