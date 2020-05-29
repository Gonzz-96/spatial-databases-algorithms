package mx.unam.fi.bde.geometria.cgzg;

import java.util.Arrays;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;


public class EnvolventeConvexaScanGraham {
	
	/**
	* Calcula la envolvente convexa empleando el algoritmo Scan de Graham.
	* @param puntos El arreglo de puntos de entrada
	* @return Un arreglo con los puntos que forman a la envolvente.
	*/
	public static Punto[] calculaEnvolvente(Punto[] puntos) {
		int inicio0;
		int det=0;
		int j=2;
		
		List<Punto> lAux= new ArrayList<>();
		PuntoAngulo[] pa=new PuntoAngulo[puntos.length +1];
		inicio0=obtenPuntoInicial(puntos);
		pa=Arrays.copyOf(calculaAngulos(inicio0,puntos), puntos.length +1);
		PuntoAngulo puntoP=pa[j];
		lAux.add(pa[0]);
		lAux.add(pa[1]);
		
		while(!puntoP.equals(pa[0])) {
			det= determinante(lAux.get(lAux.size()-2),lAux.get(lAux.size()-1),puntoP);
			if(det==-1) {
				lAux.add(puntoP);
			}else {
				while(det==1) {
					lAux.remove(lAux.size()-1);
					det=determinante(lAux.get(lAux.size()-2),lAux.get(lAux.size()-1),puntoP);
				}
				lAux.add(puntoP);
			}
			j++;
			puntoP=pa[j];
		}
		lAux.add(puntoP);
		Punto[] envolvente=new Punto[lAux.size()];
		double x=0.0, y=0.0;
		
		for(int i=0;i<lAux.size();i++) {
			x=lAux.get(i).x;
			y=lAux.get(i).y;
			envolvente[i]=new Punto(x,y);
		}
		return envolvente;		
	}
	
	/**
	* Obtiene el ángulo que se forma entre Po y un punto P. El ángulo se forma entre la
	* horizontal y el punto P. Se emplea la formula senX = C.O./Hipotenusa. En realidad no
	* es necesario calcular el ángulo, basta con calcular el valor de senx.
	* En caso que P esté mas a la izquierda que Po, se aplica la operación 2*PI-senX para
	* obtener el valor correcto (ángulos de más de 90°)El método genera un arreglo de
	* objetos {@link PuntoAngulo} en donde se almacena el ángulo calculado. Este valor se
	* empleará por la clase QuickSort para aplicar el ordenamiento.
	* Finalmente, el arreglo contiene 2 veces al punto p0, uno con 0° y otro con 2*PI+1
	* para garantizar que al ordenar quede al final.
	* El algoritmo requiere que Po esté al inicio y al final del arreglo.
	* @param indexP0
	* @param puntos
	* @return
	*/
	private static PuntoAngulo[] calculaAngulos(int indexP0, Punto[] puntos) {
		double sen;
		Punto p0 = puntos[indexP0];
		//List<Punto> listaAux = new ArrayList<>();
		PuntoAngulo[] paOrdenado = new PuntoAngulo[puntos.length + 1];
		for(int i = 0; i < puntos.length; i++){
			if(p0.x>puntos[i].x){
				sen = 360 - calculaSenAngulo(p0, puntos[i]);
			}
			else{
				sen = calculaSenAngulo(p0, puntos[i]);
			}
			if(i == indexP0){
				paOrdenado[i] = new PuntoAngulo(p0,0.0);
			}
			else{
				paOrdenado[i] = new PuntoAngulo(puntos[i],sen);
			}
		}
		paOrdenado[puntos.length] = new PuntoAngulo(p0, 360 + 1);
		QuickSortSimplePuntos.sort(paOrdenado);
		return paOrdenado;
	
	}
	/**
	* Calcula el seno del angulo que existe entre ambos puntos.
	* @param p0
	* @param p1
	* @return El seno del angulo formula : sen A = c.O/hipotenusa
	*/
	private static double calculaSenAngulo(Punto p0, Punto p1) {
		return Math.toDegrees(Math.asin((p1.y - p0.y)/Math.sqrt(Math.pow(p1.x - p0.x,2) + Math.pow(p1.y - p0.y,2))));
	}
	
	/**
	* Obtiene el punto con la Y mínima.
	* @param puntos
	* @return
	*/
	public static int obtenPuntoInicial(Punto[] puntos) {
		double min = puntos[0].y;
		int i;
		int indice = 0;
		for(i=1; i<puntos.length; i++){
			if(puntos[i].y < min){
				min = puntos[i].y;
				indice = i;
			}
		}
		return indice;
	
	}
	/**
	* Calcula el determinante de 3 puntos.
	* @param a
	* @param b
	* @param c
	* @return
	*/
	private static int determinante(Punto a, Punto b, Punto c) {
		double det = a.x*(c.y-b.y) - a.y*(c.x-b.x) + (c.x*b.y-c.y*b.x);
		if(det<=0)
			return -1;
		else 
			return 1;
		
	}

}
