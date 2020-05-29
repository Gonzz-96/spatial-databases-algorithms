package mx.unam.fi.bde.geometria.cgzg;

import java.util.List;
import java.util.ArrayList;
import mx.unam.fi.bde.geometria.cgzg.AlgoritmosBasicos;
import mx.unam.fi.bde.geometria.cgzg.Punto;

public class EnvolventeConvexaAlgoritmoAristas {

	
	/**
	* Realiza el cálculo de la envolvente convexa empleando el algoritmo de las aristas.
	* @param puntos La lista de puntos a considerar
	* @return Un arreglo de puntos que forman a la envolvente convexa.
	*/
	public static Punto[] envolventeConvexa(Punto[] puntos) {

		Punto p_pivote, p_final;
		List<Punto> componente = new ArrayList<>();
		boolean del_mismo_lado;
		
		for (int i = 0; i < puntos.length; i++) {
			
			p_pivote = puntos[i];
			for (int j = 0; j < puntos.length; j++) {
				
				if (i != j) { // Si es el mismo punto, se omite y se pasa al siguiente
					p_final = puntos[j];
				} else {
					continue;
				}
				
				//System.out.println("Arista: " + p_pivote.toString() + " - " + p_final.toString());
				
				del_mismo_lado = validaPuntos(i, j, puntos);
				
				//System.out.println("Valido: " + del_mismo_lado + "\n");
				
				if (del_mismo_lado) {
				
					if(!componente.contains(p_pivote)) {
						componente.add(p_pivote);
					}
					
					if(!componente.contains(p_final)) {
						componente.add(p_final);
					}
					
					
				}
				
			}
	
		}
		
		Punto[] arreglo = new Punto[componente.size()];
		
		componente.toArray(arreglo);
		/*System.out.println(componente.size());
		for (Punto a: arreglo) {
			System.out.println("DEPURACION: " + a.toString());
		}*/
		
		return arreglo;
		
	}
	
	
	/**
	* Este método se encarga de verificar que los N-2 puntos estén todos a la derecha o a la
	* izquierda del segmento que se forma con los puntos cuyos índices son i,j.
	* @param i El índice del punto 1
	* @param j El índice del punto 2 a verificar.
	* @param puntos La lista completa de puntos
	* @return true si los puntos i,j forman una arista de la envolvente convexa con respecto
	* a los N-2 puntos.
	*/
	private static boolean validaPuntos(int i, int j, Punto[] puntos) {
		
		// Esta variable es una bandera que indica que se obtendrá
		// la primera ubicación del primer punto, con la que se comparará
		// el resto de los puntos
		int lado = 0, lado_aux;
		
		for (int k = 0; k < puntos.length; k++) {
			if (k != i && k != j) {
				
				// Si lado = 0, quiere decir que no se ha determinado el lado con el que se
				// harán todas las comparaciones. Por ende, hasta que no sea distinto, el ciclo
				// no avanzará
				if (lado == 0) {
					lado = AlgoritmosBasicos.ubicacionPunto(puntos[i], puntos[j], puntos[k]);
					continue;
				}
					
				lado_aux = AlgoritmosBasicos.ubicacionPunto(puntos[i], puntos[j], puntos[k]);
								
				// Si el resultado es negativo, el determinante es 
				// de distinto signo, por tanto es diferente lado
				if (lado_aux*lado < 0) { 
					return false;
				}
				
			}
			
		}
		
		return true;
	}
}