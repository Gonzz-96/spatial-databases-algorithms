package mx.unam.fi.bde.geometria.cgzg.pruebas;
import mx.unam.fi.bde.geometria.cgzg.EnvolventeConvexaScanGraham;
import mx.unam.fi.bde.geometria.cgzg.Punto;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;


public class EnvolventeConvexaScanGrahamTestCase {
	private List<Punto> lista1, lista2;
	private List<Punto> envolventeConvexa1;
	private List<Punto> envolventeConvexa2;
/**
* Inicializa la lista de puntos a mostrar
*/
@Before
	public void iniciaLista() {
		lista1 = new ArrayList<>();
		lista1.add(new Punto(1, 5));
		lista1.add(new Punto(3, 5));
		lista1.add(new Punto(3, 3));
		lista1.add(new Punto(5, 3));
		lista1.add(new Punto(5, 1));
		lista1.add(new Punto(9, 2));
		lista1.add(new Punto(7, 3));
		lista1.add(new Punto(9, 4));
		lista1.add(new Punto(6, 5));
		lista1.add(new Punto(9, 5));
		lista1.add(new Punto(12, 4));
		lista1.add(new Punto(12, 6));
		lista1.add(new Punto(10, 7));
		lista1.add(new Punto(7, 7));
		lista1.add(new Punto(4, 7));
		lista1.add(new Punto(2, 7));
		lista1.add(new Punto(5, 8));
		lista1.add(new Punto(4, 9));
		lista1.add(new Punto(8, 10));
		lista1.add(new Punto(1, 9));
		lista1.add(new Punto(4, 1));
		lista1.add(new Punto(7, 1));
		lista1.add(new Punto(4, 10));
		// puntos que integran a la envolvente convexa 1
		envolventeConvexa1 = new ArrayList<>();
		envolventeConvexa1.add(new Punto(1, 5));
		envolventeConvexa1.add(new Punto(1, 9));
		envolventeConvexa1.add(new Punto(8, 10));
		envolventeConvexa1.add(new Punto(12, 6));
		envolventeConvexa1.add(new Punto(12, 4));
		envolventeConvexa1.add(new Punto(9, 2));
		envolventeConvexa1.add(new Punto(5, 1));
		envolventeConvexa1.add(new Punto(4, 1));
		envolventeConvexa1.add(new Punto(7, 1));
		envolventeConvexa1.add(new Punto(4, 10));
		// en este algoritmo el resultado incluye el punto inicial
		envolventeConvexa1.add(new Punto(1, 5));
		// puntos que integran a la envolvente convexa 2
		lista2 = new ArrayList<>(lista1);
		lista2.add(new Punto(0, 0));
		envolventeConvexa2 = new ArrayList<>();
		envolventeConvexa2.add(new Punto(0, 0));
		envolventeConvexa2.add(new Punto(7, 1));
		envolventeConvexa2.add(new Punto(9, 2));
		envolventeConvexa2.add(new Punto(12, 4));
		envolventeConvexa2.add(new Punto(12, 6));
		envolventeConvexa2.add(new Punto(8, 10));
		envolventeConvexa2.add(new Punto(4, 10));
		envolventeConvexa2.add(new Punto(1, 9));
		// en este algoritmo el resultado incluye el punto inicial
		envolventeConvexa2.add(new Punto(0, 0));
	}
/**
* TestCase
*/
@Test
public void calculaEnvolventeScanGraham() {
	Punto[] envolventeObtenida;
	Punto[] puntos;
	System.out.println("Puntos a considerar");
	// lista1
	Collections.shuffle(lista1);
	puntos = new Punto[lista1.size()];
	envolventeObtenida = EnvolventeConvexaScanGraham.calculaEnvolvente(lista1
	.toArray(puntos));
	//System.out.println(Arrays.toString(envolventeObtenida));
	validaResultado(envolventeObtenida, envolventeConvexa1);
	// lista2
	puntos = new Punto[lista2.size()];
	Collections.shuffle(lista2);
	envolventeObtenida = EnvolventeConvexaScanGraham.calculaEnvolvente(lista2
	.toArray(puntos));
	//System.out.println(Arrays.toString(envolventeObtenida));
	validaResultado(envolventeObtenida, envolventeConvexa2);
}
	/**
	* @param envolventeEsperada
	* @param puntos
	*/
	public static void validaResultado(Punto[] envolventeObtenida,
				List<Punto> envolventeEsperada) {
		Assert.assertEquals("El numero de puntos obtenido es incorrecto",
				envolventeEsperada.size(), envolventeObtenida.length);
		boolean encontrado;
		// verifica que los puntos son los esperados.
		for (Punto a : envolventeEsperada) {
			encontrado = false;
			for (Punto b : envolventeObtenida) {
				if (a.x == b.x && a.y == b.y) {
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {
				Assert.fail("Punto no encontrado en lista obtenida " + a);
			}
		}
	}
}


