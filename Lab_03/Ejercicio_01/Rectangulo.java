package Ejercicio_01;



public class Rectangulo {
	Coordenada esquina1,esquina2;
	String color;
	private static String[] colores = {"verde", "amarillo", "rojo"};
    private static String ultimoColor = null;

	public Rectangulo(Coordenada c1, Coordenada c2) {
		super();
		this.esquina1 = c1;
		this.esquina2 = c2;
		this.color = siguienteColor();
	}
	public Rectangulo(Coordenada c1) {
		super();
		this.esquina1.setX(0); 
		this.esquina1.setY(0); 
		this.esquina2 = c1;
		this.color = siguienteColor();
	}
	public Rectangulo(int base, int altura) {
		super();
		this.esquina1.setX(0); 
		this.esquina1.setY(0); 
		this.esquina2.setX(base);
		this.esquina2.setY(altura);
		this.color = siguienteColor();
	}
	public Coordenada getEsquina1() {
		return esquina1;
	}
	public void setEsquina1(Coordenada c) {
		this.esquina1 = c;
	}
	public Coordenada getEsquina2() {
		return esquina2;
	}
	public void setEsquina2(Coordenada c) {
		this.esquina2 = c;
	}
	@Override
	public String toString() {
		return "Rectangulo [esquina1=" + esquina1 + ", esquina2=" + esquina2 + "]";
	}	
    private static String siguienteColor() {
        if (ultimoColor == null) {
            ultimoColor = colores[0];
        } else {
            int ColorActual = -1;
            for (int i = 0; i < colores.length; i++) {
                if (colores[i].equals(ultimoColor)) {
                    ColorActual = i;
                    break;
                }
            }
            if (ColorActual != -1) {
                int siguienteIndice = (ColorActual + 1) % colores.length;
                ultimoColor = colores[siguienteIndice];
            }
        }
        return ultimoColor;
    }
}
