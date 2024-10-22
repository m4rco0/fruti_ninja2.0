package frutas;

import java.awt.Image;

public class Maracuja extends Frutas{
	public Maracuja(int x, int y, boolean bichada) {
		super(x, y, 1, bichada);
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
		return null;
	}
	
}
