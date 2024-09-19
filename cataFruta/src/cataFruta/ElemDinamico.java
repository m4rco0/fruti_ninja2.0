package cataFruta;
/**
 *  class abstract de um elemento dinamico que herda elemento
 * @author marco
 */
public abstract class ElemDinamico extends Elemento {
	public ElemDinamico(int x, int y) {
		super(x,y);
	}
	
	/**
	 * Metodo para mudar a posição do elemento dinamico
	 * @param x Number - proxima pos x do elemento
	 * @param y Number - proxima pos y do elemento
	 * @return void
	 */
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
