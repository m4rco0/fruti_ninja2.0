package frutas;

import java.awt.Image;

public class Goiaba extends Frutas{
	public Goiaba(int x, int y, boolean bichada) {
		super(x,y,0, bichada);
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
		return null;
	}
}
