package estruturas;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import cataFruta.ElemEstaticos;

/**
 * Classe que cria um elemento estatico do tipo Pedra.
 */
public class Pedra extends ElemEstaticos {
	private Image imagem;

	public Pedra(int x, int y) {
		super(x, y);
		try { 
			this.imagem = ImageIO.read(getClass().getResource("/sprites/pedra.png"));
		} catch (IOException e) {
			
		}
	}

	public Image getImg() {
		return imagem;
	}

	/**
	 * Retorna o tipo de pedra
	 * 
	 * @return "Pedra"
	 */
	public String getTipo() {
		return "Pedra";
	}
}
