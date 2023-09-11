package Ejercicios;

import java.util.Random;


public class ResumenVentas {
    public static void main(String[] args) {
       
        double[][] ventas = new double[5][4];


       
        Random random = new Random();
        for (int mes = 1; mes <= 30; mes++) {
            for (int vendedor = 1; vendedor <= 4; vendedor++) {
                for (int producto = 1; producto <= 5; producto++) {
                    double valorVenta = random.nextDouble() * 1000;
                    ventas[producto - 1][vendedor - 1] += valorVenta;
                }
            }
        }


       
        double[] totalPorProducto = new double[5];
        double[] totalPorVendedor = new double[4];


        for (int producto = 0; producto < 5; producto++) {
            for (int vendedor = 0; vendedor < 4; vendedor++) {
                totalPorProducto[producto] += ventas[producto][vendedor];
                totalPorVendedor[vendedor] += ventas[producto][vendedor];
            }
        }


       
        System.out.println("Resumen de Ventas del Último Mes");
        System.out.println("---------------------------------");
        System.out.print("Producto/Vendedor\t");
        for (int vendedor = 1; vendedor <= 4; vendedor++) {
            System.out.print("Vendedor " + vendedor + "\t");
        }
        System.out.println("Total por Producto");


        for (int producto = 0; producto < 5; producto++) {
            System.out.print("Producto " + (producto + 1) + "\t\t\t");
            for (int vendedor = 0; vendedor < 4; vendedor++) {
                System.out.printf("$%.2f\t\t", ventas[producto][vendedor]);
            }
            System.out.printf("$%.2f\n", totalPorProducto[producto]);
        }


        System.out.println("---------------------------------");
        System.out.print("Total por Vendedor\t");
        for (int vendedor = 0; vendedor < 4; vendedor++) {
            System.out.printf("$%.2f\t", totalPorVendedor[vendedor]);
        }
    }
}
