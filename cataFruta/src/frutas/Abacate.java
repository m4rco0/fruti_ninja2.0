package frutas;

public class Abacate extends Frutas{
	public Abacate(int x, int y, boolean bichada) {
		super(x,y, 0, bichada);
	}

	/**
	 * Retorna o tipo da frutas
	 */
	@Override
	public String getTipo() {
		return "Abacate";
	}
}