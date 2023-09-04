package Pruebas;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int vida,rp;
		boolean fl = false;
		vida = 0;
		Scanner sc = new Scanner(System.in);
		do {
			vida++;
			System.out.println("Vida: "+ vida + "\t¿Cual es el numero secreto? ");
			rp = sc.nextInt();
			if (rp == 1234)
				fl = true;
			
		}while(vida < 3 && !fl);
		if (fl == true) {
			System.out.println("Adivinaste!!!!!");
			Regalo n1 = new Regalo();
			Regalo.elegir(vida);
			String gift = Regalo.elegir(vida);
			System.out.println("Tu premio es: "+gift);
		}
		else {
			System.out.println("ups, perdiste...");}
		
		
	}

}
