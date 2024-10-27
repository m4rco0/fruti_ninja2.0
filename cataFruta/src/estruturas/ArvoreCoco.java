package estruturas;

import java.awt.Image;

import javax.swing.ImageIcon;

import frutas.Coco;
/**
 * Classe que cria uma arvore do tipo Coco.
 */
public class ArvoreCoco extends Arvore{
	private Image imagem;
	public ArvoreCoco(int x, int y, String tipoArvore, Coco coco) {
		super(x, y, tipoArvore, coco);
		imagem = new ImageIcon("sprites/coqueiro.png").getImage();
	}
	
	/**
	 * Metodo que retorna o tipo da Arvore
	 */
	public String getTipo() {
		return "ArvoreCoco";
	}

	@Override
	public Image getImg() {
		// TODO Auto-generated method stub
		return imagem;
	}
}
