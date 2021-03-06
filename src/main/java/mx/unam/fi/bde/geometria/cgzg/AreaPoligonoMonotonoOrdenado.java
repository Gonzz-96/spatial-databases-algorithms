package mx.unam.fi.bde.geometria.cgzg;

import java.util.LinkedList;
import java.util.List;

public class AreaPoligonoMonotonoOrdenado {
	
	private PuntoCadena[] puntos;
	private LinkedList<Punto> lista;
	private double sumaDet;
	private int signoDet;
	
	/**
	* Constructor, inicializa la el arreglo <code>puntos </code> para guardar el �ndice original de
	* cada punto antes de invocar el ordenamiento.
	* @param pl
	*/
	public AreaPoligonoMonotonoOrdenado(Poligono pl) {
		construyeCadenaPuntos(pl);
		lista = new LinkedList<>();
	}
	
	/**
	* Construye la lista de puntos del tipo {@link PuntoCadena} en donde se guarda la posici�n
	* original del punto. Esto permitir� saber en cu�l de las 2 cadenas mon�tonas se
	* localiza. Se debe guardar ya que al realizar el ordenamiento en X, su posici�n puede cambiar.
	* @param pl
	* @return
	*/
	private void construyeCadenaPuntos(Poligono pl) {
		
		List<Punto> pList;
		int size;
		
		pList = pl.getPuntos();
		size = pList.size() - 1;
		puntos = new PuntoCadena[size];
		
		for (int i = 0; i < size; i++) {
			puntos[i] = new PuntoCadena(pList.get(i), i);
		}
		
	}
	
	
	/**
	* Calcula el �rea del pol�gono empleando la t�cnica de triangulaci�n de pol�gonos
	* mon�tonos.
	* @returns con un solo elemento.
	* @param punto
	*/
	public double area() {
		boolean opuesto;
		
		QuickSortSimplePuntos.sort(puntos);
		
		// inicializa lista
		lista.add(puntos[0]);
		lista.add(puntos[1]);
		
		for (int i = 2; i < puntos.length; i++) {
			opuesto = esPuntoOpuesto(i);
			if (opuesto) {
				triangulaPuntoOpuesto(puntos[i]);
			} else {
				triangulaPoligonoConvexo(puntos[i]);
			}
		}
		
		//System.out.println(sumaDet/2);
		return sumaDet / 2;
		
	}
	
	
	/**
	* Al encontrarse un punto que pertenece a la cadena mon�tona opuesta, se generan tri�ngulos hasta
	* dejar a la lista de puntos con un solo elemento.
	* @param punto
	*/
	private void triangulaPuntoOpuesto(Punto punto) {
		
		double det = 0;;
		
		while (lista.size() >= 2) {
			
			det += determinante(lista.get(0), lista.get(1), punto);			
			lista.removeFirst();
			
		}
		
		if (det < 0) {
			signoDet = -1;
		} else {
			signoDet = 1;
		}
		
		sumaDet += Math.abs(det);
		
		// se agrega p a la lista
		lista.add(punto);
	}
	
	
	/**
	* En caso de que el punto que se est� procesando pertenezca a la misma cadena mon�tona,
	* se valida si es posible formar un tri�ngulo. Este debe ser convexo, es decir, el
	* Signo del determinante no debe variar con respecto al signo del �ltimo determinante
	* calculado. Para ello se emplea el atributo <code>signoDet</code>
	* Al final se agrega el punto a la lista.
	* @param punto
	*/
	private void triangulaPoligonoConvexo(Punto punto) {
		
		double det = 0, acum = 0;
		int size;
		Punto ultimo, penultimo;
		
		while ((size = lista.size()) >= 2) {
			
				ultimo = lista.get(size-1);
				penultimo = lista.get(size-2);				
				det = determinante(ultimo, penultimo, punto);
				
				if (det*signoDet <= 0) { // Si no es v�lido...					
					break;
				} 
				
				det = Math.abs(det);
				
				acum += det;
				lista.removeLast();				
		}
		
		sumaDet += Math.abs(acum);
		
		// se agrega p a la lista
		lista.add(punto);
		
	}
	
	
	/**
	* Verifica si un punto con posici�n indexP se encuentra en la misma cadena mon�tona con
	* respecto a su punto anterior. Para ellos emplea el atributo <code>index</code> del
	* objeto {@link PuntoCadena} Para validar, se calcula la diferencia entre los �ndices.
	* Si son consecutivos, el resultado ser� 1, lo que implica que se se encuentran en la
	* misma cadena mon�tona. si es >1 el punto est� en la cadena contraria.
	* @param indexP
	* @return
	*/
	private boolean esPuntoOpuesto(int indexP) {
	
		PuntoCadena p_act, p_ant;
		int difference;
		
		p_act = puntos[indexP];
		p_ant = puntos[indexP-1];
		
		difference = p_act.index - p_ant.index;
		
		if (difference == 1 || difference == -1) {
			return false;
		} else {
			return true;
		}
		
	}
	
	
	/**
	* Calcula el determinante de 3 puntos. Si el resultado es positivo, el sentido
	* es antihorario; si es negativo, el sentido ser� horario.
	* @param a
	* @param b
	* @param c
	* @return
	*/
	private static double determinante(Punto a, Punto b, Punto c) {
	
		double det = 0;
		
		det += a.x * (c.y - b.y);
		det -= a.y * (c.x - b.x);
		det += 1 * ((c.x*b.y) - (c.y*b.x));
		
		return det;
	}
}