package frutas;
public class Laranja extends Frutas{
	public Laranja(int x, int y, boolean bichada) {
		super(x,y, 0, bichada);
	}
	
	@Override
	public String getTipo() {
		return "Laranja";
	}
}
