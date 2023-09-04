package Ejercicios_02;

public class PerfilMedico {

	public static void main(String[] args) {

		Persona p1 = new Persona("Adrian","Benavides","M",29,9,2002,180,73);
		/*System.out.println(p1);*/
		int edad = p1.cal_edad(p1.B_año);
		p1.Fnaci(p1.B_dia, p1.B_mes, p1.B_año);
		p1.IMC(p1.altura, p1.peso);
		p1.mFMC(edad);
	}

}
