package mx.unam.fi.bde.geometria.cgzg;

public class Punto implements Comparable<Punto> {
	
	public double x;
	public double y;
	
	/**
* 	@param x
* 	@param y
	*/
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public double getX() {
		return this.x;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public double getY() {
		return this.y;
	}
	
	
	/* (non-Javadoc)
* 	@see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Punto) {
			Punto p = (Punto) obj;
			return this.x == p.x && this.y == p.y;
		}
		
		return false;
	}
	
	
	/* (non-Javadoc)
* 	@see java.lang.Comparable#compareTo(java.lang.Object) */
	@Override
	public int compareTo(Punto o) {
		if (this.x > o.x) {
			return 1;
		} else if (this.x < o.x) {
			return -1;
		} else {
			if (this.y > o.y) {
				return 1;
			} else if (this.y < o.y) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	
}