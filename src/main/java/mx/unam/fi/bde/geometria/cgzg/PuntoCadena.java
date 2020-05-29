package mx.unam.fi.bde.geometria.cgzg;

public class PuntoCadena extends Punto {

	
	/**
	 * 
	 */
	public int index;
	
	
	/**
	 * 
	 * @param p
	 * @param index
	 */
	public PuntoCadena(Punto p, int index) {
		super(p.x, p.y);
		this.index = index;		
	}
	
	
	/**
	 * 
	 */
	public String toString() {
		return "(" + this.x + ", " + this.y + ", i=" + this.index + ")";
	}
	
}
