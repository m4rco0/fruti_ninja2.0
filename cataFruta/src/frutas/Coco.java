package frutas;

import java.awt.Image;

public class Coco  extends Frutas{
	
	public Coco(int x, int y, boolean bichada) {
		super(x,y,0, bichada);
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
		return null;
	}
}
