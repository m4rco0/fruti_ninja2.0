package estruturas;

import java.awt.Image;

import javax.swing.ImageIcon;

import frutas.Laranja;

/**
 * Classe que cria uma arvore dotipo Laranja
 */
public class ArvoreLaranja extends Arvore{
	private Image imagem;
	public ArvoreLaranja(int x, int y, String tipoArvore, Laranja laranja) {
		super(x, y, tipoArvore, laranja);
		imagem = new ImageIcon("/home/marco/git/fruti_ninja/cataFruta/sprites/laranjeira.png").getImage();
	}
	/**
	 * Metodo que retorna o tipo da Arvore
	 */
	public String getTipo() {
		return "ArvoreLaranja";
	}
	@Override
	public Image getImg() {
		return imagem;
	}
}
