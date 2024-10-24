package frutas;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Maracuja extends Frutas{
	private Image imagem;
	public Maracuja(int x, int y, boolean bichada) {
		super(x, y, 1, bichada);
		imagem = new ImageIcon("/home/marco/git/fruti_ninja2.0/cataFruta/sprites/maracuja.png").getImage();
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
