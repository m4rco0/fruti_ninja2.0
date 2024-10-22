package estruturas;

import java.awt.Image;

import frutas.Abacate;
	/**
	 * Classe para criar um tipo de arvore de abacate.
	 */
	public class ArvoreAbacate extends Arvore{
		public ArvoreAbacate(int x, int y, String tipoArvore, Abacate abacate) {
			super(x, y, tipoArvore, abacate);
		}
		
		/**
		 * Metodo que retorna o tipo da Arvore
		 */
		public String getTipo() {
			return "ArvoreAbacate";
		}

		@Override
		public Image getImg() {
			// TODO Auto-generated method stub
			return null;
		}
	}
