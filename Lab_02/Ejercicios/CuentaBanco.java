package Ejercicios;

import java.util.Scanner;

public class CuentaBanco {

	public static void main(String[] args) {
		
		int exit = 0;
		Scanner s1 = new Scanner(System.in);
		System.out.println("Ingrese su nombre");
		String n = s1.next();
		Codigo c1 = new Codigo(n);
		while (n.length()<3) {
			System.out.println("Ingrese su nombre");
			n = s1.next();
		}
		System.out.println("Desea tener un saldo inicial? s/n");
		String x = s1.next();
		if(x.equals("s")) 
			c1.ingresar(1000);
		do {
		System.out.println("\tMenu\n------------------------\n1.Revisar mi saldo\n2.Ingresar Dinero\n3.Retirar dinero\n4.Salir");
		 exit = s1.nextInt();
		 if(exit == 1)
			 c1.versaldo();
		 if(exit == 2) {
			 System.out.println("A continuacion coloque el saldo que desea ingresar:\n ");
			 int Monto = s1.nextInt();
			 c1.ingresar(Monto);
			 System.out.println("Desea seguir en el menu? s/n");
			 String aux = s1.next();
			 if(aux.equals("n"))
				 exit = 4;
		 }
		 if(exit == 3) {
			 System.out.println("A continuacion coloque el saldo que desea retirar:\n ");
			 int Monto = s1.nextInt();
			 c1.retirar(Monto);
			 System.out.println("Desea seguir en el menu? s/n");
			 String aux = s1.next();
			 if(aux.equals("n"))
				 exit = 4;
		 }
		}while(exit != 4);
		System.out.println("Saliste de la Aplicacion");
	}

}
