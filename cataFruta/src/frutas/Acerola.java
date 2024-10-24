package frutas;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Acerola extends Frutas{
	private Image imagem;
	public Acerola(int x, int y, boolean bichada) {
		super(x,y,0, bichada);
		imagem = new ImageIcon("cataFruta/sprites/acerola.png").getImage();
	}
	/**
	 * Retorna o tipo da frutas
	 */
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Acerola";
	}
	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return imagem;
	}
}
