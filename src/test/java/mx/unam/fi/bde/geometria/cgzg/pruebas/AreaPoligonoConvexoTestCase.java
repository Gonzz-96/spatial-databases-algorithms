package mx.unam.fi.bde.geometria.cgzg.pruebas;
import mx.unam.fi.bde.geometria.cgzg.AreaPoligonoConvexo;
import mx.unam.fi.bde.geometria.cgzg.Punto;
import mx.unam.fi.bde.geometria.cgzg.Poligono;

import java.util.List;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;


public class AreaPoligonoConvexoTestCase {
	@Test
	public void areaPoligono() {
		
		Poligono poligono;
		List<Punto> puntos;
		// poligono 1
		poligono = new Poligono();
		puntos = new ArrayList<>();
		puntos.add(new Punto(1, 4));
		puntos.add(new Punto(3, 1));
		puntos.add(new Punto(5, 0));
		puntos.add(new Punto(9, 0));
		puntos.add(new Punto(20, 2));
		puntos.add(new Punto(20, 8));
		puntos.add(new Punto(16, 11));
		puntos.add(new Punto(13, 12));
		puntos.add(new Punto(9, 11));
		puntos.add(new Punto(3, 8));
		puntos.add(new Punto(1, 4));
		poligono.setPuntos(puntos);
		double area = AreaPoligonoConvexo.area(poligono);
		System.out.println(area);
		Assert.assertEquals(new Double(170.5), new Double(area));
		//poligono 2
		poligono = new Poligono();
		puntos = new ArrayList<>();
		puntos.add(new Punto(1, 1));
		puntos.add(new Punto(12, 1));
		puntos.add(new Punto(12, 3));
		puntos.add(new Punto(8, 8));
		puntos.add(new Punto(5, 11));
		puntos.add(new Punto(1, 6));
		puntos.add(new Punto(1, 1));
		poligono.setPuntos(puntos);
		area = AreaPoligonoConvexo.area(poligono);
		System.out.println(area);
		Assert.assertEquals(new Double(73.5), new Double(area));
	}
}
