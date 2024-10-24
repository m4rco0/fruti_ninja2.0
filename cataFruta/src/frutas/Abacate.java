package frutas;

import java.awt.Image;

import javax.swing.ImageIcon;
public class Abacate extends Frutas{
	private Image imagem;
	public Abacate(int x, int y, boolean bichada) {
		super(x,y, 0, bichada);
		imagem = new ImageIcon("cataFruta/sprites/abacate.png").getImage();
	}

	/**
	 * Retorna o tipo da frutas
	 */
	@Override
	public String getTipo() {
		return "Abacate";
	}
	@Override
	public Image getImg() {
		return imagem;
	}
}