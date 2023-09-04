package Ejercicio_01;

public class Principal {
	public static void main(String[] args) {
		
		
		Coordenada c1 = new Coordenada(0,0);
		Coordenada c2 = new Coordenada(4,6);
		Rectangulo r1 = new Rectangulo(c1,c2);
		System.out.println(Manejador.area(r1));
		System.out.println(r1.color);
		
		
	}
}