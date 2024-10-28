package frutas;

import java.awt.Image;

import cataFruta.ElemDinamico;

/**
 * A class abstract frutas categoriza todos os tipos de frutas. Com o tipo da
 * fruta e se ela e comestivel ou nao.
 */
public abstract class Frutas extends ElemDinamico {
	private boolean bichada;
	private int pontos;

	/**
	 * Constructor das Frutas
	 *
	 * @param x       A posicao inicial x da fruta
	 * @param y       A posicao inicial y da fruta
	 * @param pontos  Os pontos que esta fruta vale
	 * @param bichada Se a fruta e comestivel ou nao
	 */
	public Frutas(int x, int y, int pontos, boolean bichada) {
		super(x, y);
		this.bichada = bichada;
		this.pontos = pontos;
	}

	/**
	 * Obtém a quantidade de pontos que esta fruta vale.
	 *
	 * @return A quantida de pontos
	 */
	public int getPontos() {
		return this.pontos;
	}

	@Override
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Fala se a fruta é bichada ou não
	 *
	 * @return
	 */
	public boolean isBichada() {
		return this.bichada;
	}

	/**
	 * Método abstrato que deve ser implementado pelas subclasses para retornar o
	 * tipo da fruta.
	 *
	 * @return Uma strisng indicando o tipo da fruta.
	 */

	public abstract Image getImg();

	@Override
	public abstract String getTipo();
}