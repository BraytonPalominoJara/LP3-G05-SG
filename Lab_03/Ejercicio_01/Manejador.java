package Ejercicio_01;

import java.util.Scanner;
public class Manejador {
	public static double area(Rectangulo r) {
		double ancho = Math.abs(r.esquina1.getX() - r.esquina2.getX());
		double alto = Math.abs(r.esquina1.getY() - r.esquina2.getY());
		double area = ancho * alto;
		return area;
	}
	public static double perimetro(Rectangulo r) {
		double ancho = Math.abs(r.esquina1.getX() - r.esquina2.getX());
		double alto = Math.abs(r.esquina1.getY() - r.esquina2.getY());
		double perimetro = 2*ancho + 2*alto;
		return perimetro;
	}
	public static void moverX(Rectangulo r) {
		System.out.println("ingrese cantidad que debe moverse en el eje x");
		Scanner s1 = new Scanner(System.in);
		int nro = s1.nextInt();
		r.esquina1.setX(r.esquina1.getX()+ nro);
		r.esquina2.setX(r.esquina2.getX()+ nro);
	}
	public static void moverY(Rectangulo r) {
		System.out.println("ingrese cantidad que debe moverse en el eje y");
		Scanner s1 = new Scanner(System.in);
		int nro = s1.nextInt();
		r.esquina1.setY(r.esquina1.getY()+ nro);
		r.esquina2.setY(r.esquina2.getY()+ nro);
	}
}
