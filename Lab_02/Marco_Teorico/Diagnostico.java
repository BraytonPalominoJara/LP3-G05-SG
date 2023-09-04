package Marco_Teorico;

public class Diagnostico {
	public void aptoVacunaA(Perro p1) {
		double temp = p1.getTemp();
		double peso = p1.peso;
		double edad = p1.getEdad();
		
		if(temp >=37 &&temp <=40 && peso > 5 && edad > 1)
			System.out.print("Perro sano");
		else
			System.out.print("Perro enfermo");
		
	}
	public void aptoVacunaB(int edad,double peso,double temp) {
		
		if(temp >=37 &&temp <=40 && peso > 5 && edad > 1)
			System.out.print("Perro sano");
		else
			System.out.print("Perro enfermo");
	}
}
