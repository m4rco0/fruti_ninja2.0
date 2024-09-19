package frutas;

public class Maracuja extends Frutas{
	public Maracuja(int x, int y, boolean bichada) {
		super(x, y, 1, bichada);
	}
	
	@Override
	public String getTipo() {
		return "Maracujá";
	}
	
}
