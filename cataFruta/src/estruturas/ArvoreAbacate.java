package estruturas;

import java.awt.Image;

import javax.swing.ImageIcon;

import frutas.Abacate;
	/**
	 * Classe para criar um tipo de arvore de abacate.
	 */
	public class ArvoreAbacate extends Arvore{
		private Image imagem;
		public ArvoreAbacate(int x, int y, String tipoArvore, Abacate abacate) {
			super(x, y, tipoArvore, abacate);
			imagem = new ImageIcon("sprites/arvoreAbCATE.png").getImage();
		}
		
		/**
		 * Metodo que retorna o tipo da Arvore
		 */
		public String getTipo() {
			return "ArvoreAbacate";
		}

		@Override
		public Image getImg() {
			
			return imagem;
		}
	}
