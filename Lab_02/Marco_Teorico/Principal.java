package Marco_Teorico;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		
		Perro p1 = new Perro();
		Perro p2 = new Perro("pekines","negro",38,5,9);
		
		/*
		p1.ladrar();
		p1.increEdad(5);
		p2.Comer();
		p2.Dormir();
		
		System.out.println(p1.peso);
		System.out.println(p1.getRaza());
		System.out.println(p1);
		System.out.println(p2);
		*/
		
		
		/*
		
		Diagnostico d1 = new Diagnostico();
		
		d1.aptoVacunaA(p2);
		*/
		/*Parte 2*/
		
		/* Parte 1
		Perro Fido = new Perro("Chihuhua","Marron");
		Perro Pelusa = new Perro("Pekines","Blanco");
		
		Fido.increEdad(2);
		Pelusa.increEdad(5);
		
		System.out.println(Fido);
		System.out.println(Pelusa);*/
		
		
		/*
		Scanner s1 = new Scanner(System.in);
		System.out.println("Su perro es: ");
		System.out.println(p1);
		System.out.println("Desea cambiar sus datos? s/n");
		String x = s1.next();
		if (x == "s"||x=="si" ) {
			
			System.out.println("Ingrese la raza de su perro");
		
			String raza = s1.next();
			System.out.println("Ingrese el color de su perro");
			String color = s1.next();
			System.out.println("Ingrese la temperatura de su perro");
			double temp = s1.nextDouble();
			System.out.println("Ingrese la edad de su perro");
			int edad = s1.nextInt();
			System.out.println("Ingrese el peso de su perro");
			double peso = s1.nextDouble();
			
			System.out.println("raza: "+raza+" edad: "+edad+" temperatura: "+temp);
			Perro p3 = new Perro(raza,color, temp,edad, peso);
			
			System.out.println(p3);
			Diagnostico d1 = new Diagnostico();
			d1.aptoVacunaA(p3);
			}
			*/
		
		
		System.out.println("Su perro es: ");
		System.out.println(p2);
		Scanner s1 = new Scanner(System.in);
		System.out.println("Coloque la edad ");
		int edad = s1.nextInt();
		p2.camEdad(edad);
		System.out.println("Coloque el peso ");
		double peso = s1.nextDouble();
		p2.camPeso(peso);
		System.out.println("Coloque la temperatura ");
		double temp = s1.nextDouble();
		p2.camTemp(temp);
		System.out.println("Su perro es: ");
		System.out.println(p2);
		
		Diagnostico d1 = new Diagnostico();
		
		d1.aptoVacunaA(p2);
		d1.aptoVacunaB(edad,peso,temp);
		
		
		
		
		
		
	}

}
