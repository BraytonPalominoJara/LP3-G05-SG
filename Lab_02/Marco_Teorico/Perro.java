package Marco_Teorico;

public class Perro {
	 private String raza;
	 private String color;
	 private double temp;
	 private int edad;
	 public double peso;
	 
	 public Perro() {
		 raza = "pitbull";
		 color = "naranja";
		 temp = 10.5;
		 edad = 8;
		 peso = 9.5;
	 }
	 

	public Perro(String raza, String color) {
		super();
		this.raza = raza;
		this.color = color;
	}


	public Perro(String raza, String color, double temp, int edad, double peso) {
		super();
		this.raza = raza;
		this.color = color;
		this.temp = temp;
		this.edad = edad;
		this.peso = peso;
	}


	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	@Override
	public String toString() {
		return "Perro [raza=" + raza + ", color=" + color + ", temp=" + temp + ", edad=" + edad + ", peso=" + peso
				+ "]";
	}
	public void ladrar() {
		System.out.println("Guau Guau!!");
	}
	public void increEdad(int anios) {
		this.edad = this.edad + anios;
		/*cambiarPeso(anios);*/
	}
	public void camPeso(double peso) {
		this.peso = peso;
	}
	public void camEdad(int edad) {
		this.edad = edad;
	}
	public void camTemp(double temp) {
		this.temp = temp;
	}
	private void cambiarPeso(int anios) {
		this.peso = this.peso + (anios*0.5);
	}
	public void Dormir() {
		System.out.println("El perro esta durmierdo");
	}
	public void Comer() {
		System.out.println("El perro esta Comiendo");
	}
}
