package mx.unam.fi.bde.geometria.cgzg;

import java.util.List;
//import java.util.ArrayList;

public class Poligono {

	public List<Punto> puntos;
	
	/**
	 * Constructor por defecto.
	 */
	public Poligono() {}
	
	
	/**
	 * Método que regresa la lista de puntos del polígono.
	 * @return
	 */
	public List<Punto> getPuntos() {
		return this.puntos;
	}
	
	
	/**
	 * Método que 'setea' la lista de puntos del polígono.
	 * @param x
	 */
	public void setPuntos(List<Punto> x) {
		this.puntos = x;
	}
	
	
	/**
	 * Versión cadena del polígono.
	 */
	public String toString() {
		
		String cad = "POLYGON((";
		
		for(int i = 0; i < this.puntos.size(); i++) {
				cad += this.puntos.get(i).x + " " + this.puntos.get(i).y + ", ";
		}
		
		return cad += this.puntos.get(0).x + " " + this.puntos.get(0).y + "))";

	}
}