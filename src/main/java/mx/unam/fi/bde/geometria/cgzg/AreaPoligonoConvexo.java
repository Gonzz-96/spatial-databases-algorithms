package mx.unam.fi.bde.geometria.cgzg;


public class AreaPoligonoConvexo {
	/**
	* Calcula el área de un polígono convexo empleando la técnica de triangulación de polígonos,
	* tomando como punto inicial del abanico, al punto P0
	* @param poligono
	* @return
	*/
	public static double areaTriangulo(Punto p0, Punto p1, Punto p2) {
		double det = Math.abs(p0.x*(p2.y-p1.y) - p0.y*(p2.x-p1.x) +((p2.x*p1.y)-(p2.y*p1.x)));
		return 0.5*det;
	}
	
	public static double area(Poligono poligono) {
		Punto p0= poligono.puntos.get(0);
		double area=0;
		
		for(int i=1;i<poligono.puntos.size()-2;i++) {
			Punto p1=poligono.puntos.get(i);
			Punto p2=poligono.puntos.get(i+1);
			
			area+=areaTriangulo(p0,p1,p2);
		}
		
		return area;
	}
	
	
	
	
	
}
