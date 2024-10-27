package frutas;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Coco  extends Frutas{
	private Image imagem;
	public Coco(int x, int y, boolean bichada) {
		super(x,y,0, bichada);
		imagem = new ImageIcon("/home/marco/git/fruti_ninja2.0/cataFruta/sprites/coco.png").getImage();
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
