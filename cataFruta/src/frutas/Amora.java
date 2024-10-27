package frutas;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Amora extends Frutas {
	private Image imagem;

	public Amora(int x, int y, boolean bichada) {
		super(x, y, 0, bichada);
		try {
			this.imagem = ImageIO.read(getClass().getResource("/sprites/amora.png"));
		} catch (IOException e) {
			
		}
	}

	/**
	 * Retorna o tipo da frutas
	 */
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Amora";
	}

	@Override
	public Image getImg() {
		return imagem;
	}
}
