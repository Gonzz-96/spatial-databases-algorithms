package mx.unam.fi.bde.geometria.cgzg.pruebas;

import mx.unam.fi.bde.geometria.cgzg.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

public class AreaPoligonoMonotonoTestCase {

	Poligono pl1, pl2, pl3;
	
	@Before
	public void setup() {
		// poligono 1
		pl1 = new Poligono();
		List<Punto> puntos;
		puntos = new ArrayList<>();
		puntos.add(new Punto(1, 4));
		puntos.add(new Punto(3, 1));
		puntos.add(new Punto(5, 4));
		puntos.add(new Punto(7, 4));
		puntos.add(new Punto(9, 2));
		puntos.add(new Punto(15, 5));
		puntos.add(new Punto(17, 2));
		puntos.add(new Punto(18, 2));
		puntos.add(new Punto(20, 8));
		puntos.add(new Punto(16, 11));
		puntos.add(new Punto(13, 9));
		puntos.add(new Punto(9, 11));
		puntos.add(new Punto(5, 8));
		puntos.add(new Punto(3, 8)); // 14 puntos, 13 triangulos
		puntos.add(new Punto(1, 4));
		pl1.setPuntos(puntos);
		
		// poligono 2
		pl2 = new Poligono();
		puntos = new ArrayList<>();
		puntos.add(new Punto(12, 3));
		puntos.add(new Punto(13, 1));
		puntos.add(new Punto(16, 4));
		puntos.add(new Punto(14, 6));
		puntos.add(new Punto(10, 5));
		puntos.add(new Punto(8, 6));
		puntos.add(new Punto(1, 4));
		puntos.add(new Punto(3, 2));
		puntos.add(new Punto(5, 4));
		puntos.add(new Punto(7, 3));
		puntos.add(new Punto(8, 1)); // 11 puntos, 9 rectángulos
		puntos.add(new Punto(12, 3));
		pl2.setPuntos(puntos);
		
		// poligono 3
		pl3 = new Poligono();
		puntos = new ArrayList<>();
		puntos.add(new Punto(16, 1));
		puntos.add(new Punto(14, 7));
		puntos.add(new Punto(13, 7));
		puntos.add(new Punto(12, 4));
		puntos.add(new Punto(11, 3));
		puntos.add(new Punto(9, 2));
		puntos.add(new Punto(7, 7));
		puntos.add(new Punto(5, 7));
		puntos.add(new Punto(3, 6));
		puntos.add(new Punto(1, 4));
		puntos.add(new Punto(3, 5));
		puntos.add(new Punto(5, 5));
		puntos.add(new Punto(7, 3));
		puntos.add(new Punto(8, 1)); // 15, 13
		puntos.add(new Punto(16, 1));
		pl3.setPuntos(puntos);
		
	}
	
	
	@Test
	public void areaPoligono() {
		
		AreaPoligonoMonotonoOrdenado ap;
		double area;
		
		// poligono 1
		ap = new AreaPoligonoMonotonoOrdenado(pl1);
		area = ap.area();
		Assert.assertEquals(new Double(110), new Double(area));
		
		// poligono 2
		ap = new AreaPoligonoMonotonoOrdenado(pl2);
		area = ap.area();
		Assert.assertEquals(new Double(39.5), new Double(area));	
		
		// poligono 3
		ap = new AreaPoligonoMonotonoOrdenado(pl3);
		area = ap.area();
		Assert.assertEquals(new Double(38), new Double(area)); 
		
	}
	
}
