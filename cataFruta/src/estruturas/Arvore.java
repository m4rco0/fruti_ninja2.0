package estruturas;

import cataFruta.ElemEstaticos;
import frutas.Frutas;

/**
 * Classe abstrata de uma Arvore onde pega o tipo da arvore e a fruta que vai entregar.
 * @author marcola
 */
public abstract class Arvore extends ElemEstaticos{
	private Frutas fruta;
	
	/**
	 * Construtor de uma arvore 
	 * @param x posição x no mapa;
	 * @param y posição y no mapa;
	 * @param tipoArvore qual o tipo de arvore e qual fruto vai dar.
	 * @param fruta	tipo da fruta que vai entregar ao jogador.
	 */
	public Arvore(int x, int y, String tipoArvore, Frutas fruta) {
		super(x,y);
		this.fruta = fruta;
	}
	
	/**
	 * Pega o tipo da arvore
	 * @return tipoArvore
	 */
	

	/**
	 * Metodo para pegar o fruto da arvore e entregar para o Jogador isso faz com que a arvore fique sem fruto 
	 * mudando para null, fazer para alterar em 5 rodada apos
	 * @param competidor O competidor que vai receber a fruta.
	 * @return true se recebeu.
	 * @return false se nao recebeu.
	 */
	
	public Frutas pegaFruta() {
		Frutas fruto = this.fruta;
		this.fruta = null;
		return fruto;
	}
	
	/**	
	 * Metodo para o tipo de arvore
	 */
	@Override
	public String getTipo() {
		return "Arvore";
	}
}
