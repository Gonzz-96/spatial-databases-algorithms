package mx.unam.fi.bde.geometria.cgzg.pruebas;

import mx.unam.fi.bde.geometria.cgzg.Punto;
import mx.unam.fi.bde.geometria.cgzg.EnvolventeConvexaAlgoritmoAristas;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
* Esta clase verifica el correcto funcionamiento del algoritmo de las aristas de la envolvente
* convexa.
* @author Jorge A. Rodríguez Campos (jorgerdc@gmail.com)
* @version 1.0
* @since 1.0
*/

// No fue un error de dedo, en el PDF viene escrito así.
// Eso pasa cuando sólo copias y pegas. :( 
public class EnvontenteConvexaAlgoritmoAristasTestCase {
	private List<Punto> lista;
	private List<Punto> envolventeConvexa;
	/**
	 * Inicializa la lista de puntos a mostrar
	 */
	@Before
	public void iniciaLista() {
		lista = new ArrayList<>();
		lista.add(new Punto(1, 5));
		lista.add(new Punto(3, 5));
		lista.add(new Punto(3, 3));
		lista.add(new Punto(5, 3));
		lista.add(new Punto(5, 1));
		lista.add(new Punto(9, 2));
		lista.add(new Punto(7, 3));
		lista.add(new Punto(9, 4));
		lista.add(new Punto(6, 5));
		lista.add(new Punto(9, 5));
		lista.add(new Punto(12, 4));
		lista.add(new Punto(12, 6));
		lista.add(new Punto(10, 7));
		lista.add(new Punto(7, 7));
		lista.add(new Punto(4, 7));
		lista.add(new Punto(2, 7));
		lista.add(new Punto(5, 8));
		lista.add(new Punto(4, 9));
		lista.add(new Punto(8, 10));
		lista.add(new Punto(1, 9));
		
		// 	puntos que integran a la envolvente convexa (respuesta para comparar)
		envolventeConvexa = new ArrayList<>();
		envolventeConvexa.add(new Punto(1, 5));
		envolventeConvexa.add(new Punto(1, 9));
		envolventeConvexa.add(new Punto(8, 10));
		envolventeConvexa.add(new Punto(12, 6));
		envolventeConvexa.add(new Punto(12, 4));
		envolventeConvexa.add(new Punto(9, 2));
		envolventeConvexa.add(new Punto(5, 1));
		envolventeConvexa.add(new Punto(3, 3));
	}
	
	/**
	* Test Case
	*/
	@Test
	public void calculaEnvolvente() {
		
		Punto[] envolventeObtenida;
		Punto[] puntos;
		boolean encontrado;
		
		//realiza 3 pruebas
		for (int i = 0; i < 3; i++) {
			
			// aplica un random a la lista de puntos.
			Collections.shuffle(lista);

			System.out.println("Puntos a considerar");
			System.out.println(lista);
			
			puntos = new Punto[lista.size()];
			envolventeObtenida =
					EnvolventeConvexaAlgoritmoAristas.envolventeConvexa(lista.toArray(puntos));
			Assert.assertEquals("El numero de puntos obtenido es incorrecto", envolventeConvexa.size(),
					envolventeObtenida.length);
			
			// verifica que los puntos son los esperados.
			for (Punto a : envolventeConvexa) {
				encontrado = false;
				for (Punto b : envolventeObtenida) {
					if (a.getX() == b.getX() && a.getY() == b.getY()) {
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
}