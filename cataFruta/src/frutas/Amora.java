package frutas;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Amora extends Frutas{
	private Image imagem;
	public Amora(int x, int y, boolean bichada) {
		super(x,y,0, bichada);
		imagem = new ImageIcon("/home/marco/git/fruti_ninja2.0/cataFruta/sprites/amora.png").getImage();
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
