package frutas;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Coco extends Frutas {
	private Image imagem;

	public Coco(int x, int y, boolean bichada) {
		super(x, y, 0, bichada);
		try {
			this.imagem = ImageIO.read(getClass().getResource("/sprites/coco.png"));
		} catch (IOException e) {
			
		}
	}

	/**
	 * Retorna o tipo da frutas
	 */
	@Override
	public String getTipo() {
		return "Coco";
	}

	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return imagem;
	}
}
