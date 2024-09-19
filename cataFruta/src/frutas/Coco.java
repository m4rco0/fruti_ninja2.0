package frutas;


public class Coco  extends Frutas{
	
	public Coco(int x, int y, boolean bichada) {
		super(x,y,0, bichada);
	}

	@Override
	public String getTipo() {
		return "Coco";
	}
}
