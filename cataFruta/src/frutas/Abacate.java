package frutas;

public class Abacate extends Frutas{
	public Abacate(int x, int y, boolean bichada) {
		super(x,y, 0, bichada);
	}

	@Override
	public String getTipo() {
		return "Abacate";
	}
}