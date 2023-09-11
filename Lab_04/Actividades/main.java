package Actividades;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		 // TODO code application logic here
		 Scanner sn = new Scanner(System.in);
		 //Matriz cuadrada de 4x4
		 int matriz[][] = new int[4][4];
		 //Variables utilizadas
		 boolean salir = false;
		 int opcion, fila;
		 //Utilizado para indicar si hemos entrado en la 1ª opcion
		 boolean rellenado = false;
		//Menu
		 do {
		 //Mensajes del menu
		 System.out.println("\nMenu");
		 System.out.println("1. Rellenar Matriz");
		 System.out.println("2. Sumar fila");
		 System.out.println("3. Sumar columna");
		 System.out.println("4. Sumar diagonal");
		 System.out.println("5. Sumar diagonal a la inversa");
		 System.out.println("6. Media de toda la matriz");
		 System.out.println("7. Mostrar los valores");
		 System.out.println("8. Salir");
		 System.out.println("Elije una opcion");
		 opcion = sn.nextInt();
		 switch (opcion) {
		 case 1:
		 rellenarMatriz(sn, matriz);
		 //Ahora si podemos acceder al resto de opciones
		 rellenado = true;
		 break;
		 case 2:
		 if (rellenado) {
		 //Validamos la fila
		 do {
		 System.out.println("Elige una fila");
		 fila = sn.nextInt();
		 } while (!(fila >= 0 && fila < matriz.length));
		 System.out.println("La suma de los valores de la fila " + fila
		 + " es: " + sumaFila(matriz, fila));
		 } else {
			 System.out.println("Debes rellenar la matriz primero");
		 }
		 break;
		 case 3:
			 if (rellenado) {
			        // Validamos la columna
			        int columna;
			        do {
			            System.out.println("Elige una columna");
			            columna = sn.nextInt();
			        } while (!(columna >= 0 && columna < matriz[0].length));
			        int sumaColumna = sumaColumna(matriz, columna);
			        if (sumaColumna != -1) {
			            System.out.println("La suma de los valores de la columna " + columna + " es: " + sumaColumna);
			        }
			    } else {
			        System.out.println("Debes rellenar la matriz primero");
			    }
			    break;
		 case 4:
			 if (rellenado) {
			        int sumaDiagonal = sumaDiagonalPrincipal(matriz);
			        System.out.println("La suma de la diagonal principal es: " + sumaDiagonal);
			    } else {
			        System.out.println("Debes rellenar la matriz primero");
			    }
			    break;
		 case 5:
			    if (rellenado) {
			        int sumaDiagonalInversa = sumaDiagonalInversa(matriz);
			        System.out.println("La suma de la diagonal inversa es: " + sumaDiagonalInversa);
			    } else {
			        System.out.println("Debes rellenar la matriz primero");
			    }
			    break;
		 case 6:
			    if (rellenado) {
			        double media = mediaMatriz(matriz);
			        System.out.println("La media de todos los valores de la matriz es: " + media);
			    } else {
			        System.out.println("Debes rellenar la matriz primero");
			    }
			    break;

		 case 7:
			 if (rellenado) {
			     mostrarMatriz(matriz);
			      
			    } else {
			        System.out.println("Debes rellenar la matriz primero");
			    }
			    break;
			 
		 case 8:
		 salir = true;
		 break;
		 default:
		 System.out.println("Tienes que meter un valor entre 1 y 8");
		 }
		 } while (!salir);
		 System.out.println("FIN");
		 }
	
		 /**
		 * Rellena la matriz con valores insertados por el usuario
		 *
		 * @param sn
		 * @param matriz
		 */
		 public static void rellenarMatriz(Scanner sn, int[][] matriz) {
		 for (int i = 0; i < matriz.length; i++) {
		 for (int j = 0; j < matriz[0].length; j++) {
		 System.out.println("Escribe un numero en la posicion " + i + " " + j);
		 matriz[i][j] = sn.nextInt();
		 }
		 }
		 }
		 public static int sumaColumna(int[][] matriz, int columna) {
			    int suma = 0;
			    if (columna >= 0 && columna < matriz[0].length) {
			        for (int i = 0; i < matriz.length; i++) {
			            suma += matriz[i][columna];
			        }
			    } else {
			        System.out.println("Columna incorrecta. Debe ser un valor entre 0 y " + (matriz[0].length - 1));
			        return -1; // Valor de error
			    }
			    return suma;
			}

			public static int sumaDiagonalPrincipal(int[][] matriz) {
			    int suma = 0;
			    int n = Math.min(matriz.length, matriz[0].length); // Tamaño de la diagonal
			    for (int i = 0; i < n; i++) {
			        suma += matriz[i][i];
			    }
			    return suma;
			}

			public static int sumaDiagonalInversa(int[][] matriz) {
			    int suma = 0;
			    int n = Math.min(matriz.length, matriz[0].length); // Tamaño de la diagonal
			    for (int i = 0; i < n; i++) {
			        suma += matriz[matriz.length - 1 - i][i];
			       			    }
			    return  suma;
			}
			public static double mediaMatriz(int[][] matriz) {
			    int suma = 0;
			    int totalElementos = matriz.length * matriz[0].length;
			    for (int i = 0; i < matriz.length; i++) {
			        for (int j = 0; j < matriz[0].length; j++) {
			            suma += matriz[i][j];
			        }
			    }
			    return (double) suma / totalElementos;
			}

	
		 public static int sumaFila(int[][] matriz, int fila) {
		 int suma = 0;
		 for (int j = 0; j < matriz.length; j++) {
		 suma += matriz[fila][j];
		 }
		 return suma;
		 }
		 public static void mostrarMatriz(int[][] matriz) {
		    for (int i = 0; i < matriz.length; i++) {
		    	System.out.println(" ");
		        for (int j = 0; j < matriz[0].length; j++) {
		            System.out.print(" "+matriz[i][j]+" |");
		            	
		        }
		        }
		
		    }
		 }
	
		 

