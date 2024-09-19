package frutas;
public class Acerola extends Frutas{
	public Acerola(int x, int y, boolean bichada) {
		super(x,y,0, bichada);
	}
	
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Acerola";
	}
}
