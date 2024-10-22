package estruturas;

import java.awt.Image;

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
	 * @param imagem2 
	 */
	public Arvore(int x, int y, String tipoArvore, Frutas fruta) {
		super(x,y);
		this.fruta = fruta;
	}
	/**
	 * Seta a posição do jogador
	 * @param x - posição x no mapa
	 * @param y - posição y no mapa
	 */
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
		this.fruta.setPos(x, y);
	}
	/**
	 * Devolve um fruto da arvore
	 * @return fruto da arvores
	 */
	public Frutas pegaFruta() {
		Frutas fruto = this.fruta;
		return fruto;
	}
	public abstract Image getImg();
	/**	
	 * Metodo para o tipo de arvore
	 */
	@Override
	public String getTipo() {
		return "Arvore";
	}
}
