package mx.unam.fi.bde.geometria.cgzg;

import java.util.List;

//import mx.unam.fi.bde.geometria.*;

public class AlgoritmosBasicos {
	/**
	 * 
	 * @param a Punto inicial de la l�nea.
	 * @param b Punto final de la l�nea.
	 * @param p Punto del cual se desea saber su ubicaci�n
	 * @return Un n�mero > 0 si est� a la derecha de la l�nea (el producto
	 * 		   cruz de los 3 puntos es mayor que cero); un n�mero < 0 (el
	 * 		   producto cruz es menor que cero) si est� a la izquierda; 
	 *         y 0 (el producto cruz es 0 ) si son colineales.
	 */
	public static int ubicacionPunto(Punto a, Punto b, Punto p) {
		
		double det = 0;
		
		det += a.x * (p.y - b.y);
		det -= a.y * (p.x - b.x);
		det += 1 * (p.x*b.y - b.x*p.y);
		
		if(det > 0) {
			return 1;
		} else if(det < 0) {
			return -1;
		}
		
		return 0;
		
	}
	
	
	/**
	 * 
	 * @param pol
	 * @param p
	 * @return Regresa > 0 si el punto est� adentro; < 0 si est� afuera,
	 * 		   y 0 si coincide con el l�mite.
	 */
	public static int puntoEnPoligonoConvexo(Poligono pol, Punto p) {

		List<Punto> puntos = pol.getPuntos();
		Punto a, b;
		int siguiente, signo = ubicacionPunto(puntos.get(0), puntos.get(1), p);
		
		for(int i = 0; i < (puntos.size() - 1); i++) {
			
			a = puntos.get(i);
			b = puntos.get(i+1);
			
			siguiente = ubicacionPunto(a, b, p);
			
			if(siguiente*signo < 0) {
				return -1;
			} else if(siguiente*signo == 0) {
				return 0;
			}
			
			signo = siguiente;
			
		}
		
		return 1;
	}
	
	
}
