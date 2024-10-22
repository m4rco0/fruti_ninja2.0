package frutas;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Laranja extends Frutas{
	private Image imagem;
	public Laranja(int x, int y, boolean bichada) {
		super(x,y, 0, bichada);
		imagem = new ImageIcon("/home/marco/git/fruti_ninja/cataFruta/sprites/laranja.png").getImage();
	}
	/**
	 * Retorna o tipo da frutas
	 */
	@Override
	public String getTipo() {
		return "Laranja";
	}
	@Override
	public Image getImg() {
		return imagem;
	}
}
