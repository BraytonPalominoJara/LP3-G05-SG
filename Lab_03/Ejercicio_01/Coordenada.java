package Ejercicio_01;

public class Coordenada {
	private int x,y;
	public Coordenada() {
		super();
		this.x = 0;
		this.y = 0;
	}
	public Coordenada(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Coordenada(Coordenada C) {
		this.x = C.x;
		this.y = C.y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double distancia(Coordenada c) { //la otra cc es por defecto 0,0 
		double operacion =(Math.pow((c.x - 0),2) + Math.pow((c.y - 0),2));
		double distancia = Math.sqrt(operacion);
		return distancia;
	};
	public static double distancia(Coordenada c1, Coordenada c2) { //diagonal
		double operacion =(Math.pow((c1.x - c2.x),2) + Math.pow((c1.y - c2.y),2));
		double distancia = Math.sqrt(operacion);
		return distancia;
	}
	@Override
	public String toString() {
		return "Coordenada [x=" + x + ", y=" + y + "]";
	};
}
