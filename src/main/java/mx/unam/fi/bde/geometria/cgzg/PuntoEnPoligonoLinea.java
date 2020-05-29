package mx.unam.fi.bde.geometria.cgzg;

public class PuntoEnPoligonoLinea {
/**
* Verifica si un punto está en un polígono empleando la técnica de la recta paralela al eje X a
* partir del punto P.
* @param pl
* @param p
* @return 0, si el punto está en el límite, 1 si está fuera, ó -1 si el punto está dentro.
*/
public static int puntoEnPoligono(Poligono pl, Punto p) {
	int intersecciones=0;
	
	for(int i=0;i<pl.puntos.size()-1;i++) {
		Punto p0=pl.puntos.get(i);
		Punto p1=pl.puntos.get(i+1);
		
		if((p0.x==p.x && p0.y==p.y) || (p1.x==p.x && p1.y==p.y)) {
			return 0;
		}
				
		if(AlgoritmosBasicos.ubicacionPunto(p0,p1,p)==0) {
			if(p0.x>p1.x) {
				if(p.x<p0.x && p.x>p1.x) {
					return 0;
					
				}else {
					continue;
					
				}				
			}
			if(p0.x==p1.x)
            {
                if((p0.y>p.y && p1.y<p.y) || (p0.y<p.y && p1.y>p.y))
                    return 0;
                else {
                    continue;
                }
            }
			if(p0.x<p1.x)
            {
                if(p.x>p0.x && p.x<p1.x)
                    return 0;                
                else {
                    continue;
                }
            }	
		}
		
		if(p0.x<=p.x && p1.x <= p.x) {
			continue;		
		}
		if(p0.y==p.y && p1.y==p.y) {
			continue;
		}
		if((p0.y<=p.y && p1.y>p.y) || (p1.y<=p.y&&p0.y>p.y)) {
			intersecciones++;
		}		
	}
	if (intersecciones%2==1) {
		return -1;
	}else {
		return 1;
	}

	}
}