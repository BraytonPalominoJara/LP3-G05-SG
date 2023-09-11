package Ejercicios;

import java.util.Random;


public class EvaluacionCrediticia {
    public static void main(String[] args) {
        // Generar datos aleatorios para 8 personas
        Random random = new Random();
        int[] sexo = new int[8];
        int[] trabaja = new int[8];
        int[] sueldo = new int[8];


        for (int i = 0; i < 8; i++) {
            sexo[i] = random.nextInt(2) + 1; // 1 o 2 para sexo
            trabaja[i] = random.nextInt(2) + 1; // 1 o 2 para trabajo
            sueldo[i] = (trabaja[i] == 1) ? random.nextInt(2051) + 950 : 0; // Entre 950 y 3000 si trabaja, 0 si no
        }


        // Calcular porcentajes
        int totalHombres = 0;
        int totalMujeres = 0;
        int hombresTrabajan = 0;
        int mujeresTrabajan = 0;
        int sueldoHombresTrabajan = 0;
        int sueldoMujeresTrabajan = 0;


        for (int i = 0; i < 8; i++) {
            if (sexo[i] == 1) {
                totalHombres++;
                if (trabaja[i] == 1) {
                    hombresTrabajan++;
                    sueldoHombresTrabajan += sueldo[i];
                }
            } else {
                totalMujeres++;
                if (trabaja[i] == 1) {
                    mujeresTrabajan++;
                    sueldoMujeresTrabajan += sueldo[i];
                }
            }
        }


        double porcentajeHombres = (totalHombres / 8.0) * 100;
        double porcentajeMujeres = (totalMujeres / 8.0) * 100;
        double porcentajeHombresTrabajan = (hombresTrabajan / (double) totalHombres) * 100;
        double porcentajeMujeresTrabajan = (mujeresTrabajan / (double) totalMujeres) * 100;
        double sueldoPromedioHombresTrabajan = (hombresTrabajan > 0) ? sueldoHombresTrabajan / (double) hombresTrabajan : 0;
        double sueldoPromedioMujeresTrabajan = (mujeresTrabajan > 0) ? sueldoMujeresTrabajan / (double) mujeresTrabajan : 0;


        // Mostrar resultados
        System.out.println("a) Porcentaje de hombres (tengan o no trabajo): " + porcentajeHombres + "%");
        System.out.println("b) Porcentaje de mujeres (tengan o no trabajo): " + porcentajeMujeres + "%");
        System.out.println("c) Porcentaje de hombres que trabajan: " + porcentajeHombresTrabajan + "%");
        System.out.println("d) Porcentaje de mujeres que trabajan: " + porcentajeMujeresTrabajan + "%");
        System.out.println("e) El sueldo promedio de los hombres que trabajan: " + sueldoPromedioHombresTrabajan);
        System.out.println("f) El sueldo promedio de las mujeres que trabajan: " + sueldoPromedioMujeresTrabajan);
    }
}

