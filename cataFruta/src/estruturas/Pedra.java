package estruturas;

import java.awt.Image;

import javax.swing.ImageIcon;

import cataFruta.ElemEstaticos;
/**
 * Classe que cria um elemento estatico do tipo Pedra.
 */
public class Pedra  extends ElemEstaticos{
	private Image imagem;
	public Pedra(int x, int y) {
		super(x,y);
		imagem = new ImageIcon("/home/marco/git/fruti_ninja2.0/cataFruta/sprites/pedra.png").getImage();
	}
	public Image getImg() {
		return imagem;
	}
	/**
	 * Retorna o tipo de pedra
	 * @return "Pedra"
	 */
	public String getTipo() {
		return "Pedra";
	}
}
