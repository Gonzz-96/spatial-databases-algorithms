package mx.unam.fi.bde.geometria.cgzg.pruebas;

import mx.unam.fi.bde.geometria.cgzg.*;
import org.junit.*;

public class UbicacionPuntoTestCase {
	
	@Test
	public void ubicacionPunto() {
	
		Punto a, b, p1, p2, p3;
	
		a = new Punto(1, 1);
		b = new Punto(4, 4);
		p1 = new Punto(0, 5);
		p2 = new Punto(5, 0);
		p3 = new Punto(2, 2);
		
		// punto a la izquierda
		Assert.assertTrue(AlgoritmosBasicos.ubicacionPunto(a, b, p1) < 0);
		
		// punto a la derecha
		Assert.assertTrue(AlgoritmosBasicos.ubicacionPunto(a, b, p2) > 0);
		
		// colineales
		Assert.assertTrue(AlgoritmosBasicos.ubicacionPunto(a, b, p3) == 0);
		
	}
}
