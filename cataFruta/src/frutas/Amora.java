package frutas;


public class Amora extends Frutas{
	public Amora(int x, int y, boolean bichada) {
		super(x,y,0, bichada);
	}
	
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return "Amora";
	}

}