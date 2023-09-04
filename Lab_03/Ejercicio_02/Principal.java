package Ejercicio_02;

public class Principal {

	public static void main(String[] args) {
		Fecha f1 = new Fecha();
		System.out.println(f1.corta());
		System.out.println(f1.larga());
		System.out.println("_________________________");
		Fecha f2 = new Fecha(10,5,2023);
		System.out.println(f2.larga());
		System.out.println(f2.diasEntre(f2));
		System.out.println(f2.diaSemana());
		System.out.println(f2.igualQue(f1, f2));
		
	}

}
