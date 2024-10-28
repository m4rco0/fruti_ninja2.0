package estruturas;

import java.awt.Image;

import javax.swing.ImageIcon;

import frutas.Goiaba;
/**
 * Classe que cria uma arvore do tipo Goiaba
 */
public class ArvoreGoiaba extends Arvore{
	private Image imagem;
	public ArvoreGoiaba(int x, int y, String tipoArvore, Goiaba goiaba) {
		super(x,y, tipoArvore, goiaba);
		imagem = new ImageIcon("catafruta/sprites/goiabeira.png").getImage();
	}
	/**
	 * Metodo que retorna o tipo da Arvore
	 */
	public String getTipo() {
		return "ArvoreGoiaba";
	}
	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return imagem;
	}
	
}
