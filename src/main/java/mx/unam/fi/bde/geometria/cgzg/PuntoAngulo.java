package mx.unam.fi.bde.geometria.cgzg;

public class PuntoAngulo extends Punto {
public double senoAngulo;
/**
* @param angulo
* @param index
*/
public PuntoAngulo(Punto p, double senoAngulo) {
	super(p.x, p.y);
	this.senoAngulo = senoAngulo;
}
/* (non-Javadoc)
* @see java.lang.Object#toString()
*/
@Override
public String toString() {
	return "(" + x + "," + y + ",s=" + senoAngulo + ")";
}

/* (non-Javadoc)
* @see mx.unam.fi.bde.geometria.Punto#compareTo(mx.unam.fi.bde.geometria.Punto)
*/
@Override
	public int compareTo(Punto o) {
		PuntoAngulo pa = (PuntoAngulo) o;
	
		if (this.senoAngulo > pa.senoAngulo) {
			return 1;
		} else if (this.senoAngulo < pa.senoAngulo) {
			return -1;
		} else {
		if (this.y > pa.y) {
			return 1;
		} else if (this.y < pa.y) {
			return -1;
		} else {
			if (this.x > pa.x) {
			return 1;
		} else if (this.x < pa.x) {
			return -1;
		} else {
			return 0;
		}
	  }
    }
  }
}