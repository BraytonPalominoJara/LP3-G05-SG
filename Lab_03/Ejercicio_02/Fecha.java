package Ejercicio_02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Fecha {
    private int dia;
    private int mes;
    private int año;

    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.año = 1900;
    }

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        valida();
    }

    public void leer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Día (1-31): ");
        this.dia = scanner.nextInt();
        System.out.print("Mes (1-12): ");
        this.mes = scanner.nextInt();
        System.out.print("Año (1900-2050): ");
        this.año = scanner.nextInt();
        valida();
    }

    public boolean bisiesto() {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    public int diasMes(int mes) {
        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (mes == 2 && bisiesto()) {
            return 29;
        }
        return diasPorMes[mes];
    }

    private void valida() {
        if (año < 1900 || año > 2050) {
            año = 1900;
        }
        if (mes < 1 || mes > 12) {
            mes = 1;
        }
        int maxDia = diasMes(mes);
        if (dia < 1 || dia > maxDia) {
            dia = 1;
        }
    }

    public String corta() {
        return String.format("%02d/%02d/%d", dia, mes, año);
    }

    public int diasTranscurridos() {
        Calendar cal1 = new GregorianCalendar(1900, 0, 1);
        Calendar cal2 = new GregorianCalendar(año, mes - 1, dia);
        long millis1 = cal1.getTimeInMillis();
        long millis2 = cal2.getTimeInMillis();
        long diferencia = millis2 - millis1;
        return (int) (diferencia / (24 * 60 * 60 * 1000));
    }

    public int diaSemana() {
        Calendar cal = new GregorianCalendar(año, mes - 1, dia);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        // Ajustamos para que domingo sea 0 en lugar de 1
        return (dayOfWeek + 5) % 7;
    }

    public String larga() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy");
        Calendar cal = new GregorianCalendar(año, mes - 1, dia);
        Date date = cal.getTime();
        return sdf.format(date);
    }

    public void fechaTras(long dias) {
        Calendar cal = new GregorianCalendar(1900, 0, 1);
        cal.add(Calendar.DAY_OF_YEAR, (int) dias);
        this.año = cal.get(Calendar.YEAR);
        this.mes = cal.get(Calendar.MONTH) + 1;
        this.dia = cal.get(Calendar.DAY_OF_MONTH);
    }

    public int diasEntre(Fecha otraFecha) {
        Calendar cal1 = new GregorianCalendar(año, mes - 1, dia);
        Calendar cal2 = new GregorianCalendar(otraFecha.año, otraFecha.mes - 1, otraFecha.dia);
        long millis1 = cal1.getTimeInMillis();
        long millis2 = cal2.getTimeInMillis();
        long diferencia = millis2 - millis1;
        return (int) (diferencia / (24 * 60 * 60 * 1000));
    }

    public void siguiente() {
        Calendar cal = new GregorianCalendar(año, mes - 1, dia);
        cal.add(Calendar.DAY_OF_YEAR, 1);
        this.año = cal.get(Calendar.YEAR);
        this.mes = cal.get(Calendar.MONTH) + 1;
        this.dia = cal.get(Calendar.DAY_OF_MONTH);
    }

    public void anterior() {
        Calendar cal = new GregorianCalendar(año, mes - 1, dia);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        this.año = cal.get(Calendar.YEAR);
        this.mes = cal.get(Calendar.MONTH) + 1;
        this.dia = cal.get(Calendar.DAY_OF_MONTH);
    }

    public void fechaFutura(long dias) {
        Calendar cal = new GregorianCalendar(año, mes - 1, dia);
        cal.add(Calendar.DAY_OF_YEAR, (int) dias);
        this.año = cal.get(Calendar.YEAR);
        this.mes = cal.get(Calendar.MONTH) + 1;
        this.dia = cal.get(Calendar.DAY_OF_MONTH);
    }

    public Fecha copia() {
        return new Fecha(this.dia, this.mes, this.año);
    }

    public static boolean igualQue(Fecha fecha1, Fecha fecha2) {
        return fecha1.dia == fecha2.dia && fecha1.mes == fecha2.mes && fecha1.año == fecha2.año;
    }

    public static boolean menorQue(Fecha fecha1, Fecha fecha2) {
        if (fecha1.año < fecha2.año) {
            return true;
        } else if (fecha1.año > fecha2.año) {
            return false;
        } else {
            if (fecha1.mes < fecha2.mes) {
                return true;
            } else if (fecha1.mes > fecha2.mes) {
                return false;
            } else {
                return fecha1.dia < fecha2.dia;
            }
        }
    }

    public static boolean mayorQue(Fecha fecha1, Fecha fecha2) {
        return !igualQue(fecha1, fecha2) && !menorQue(fecha1, fecha2);
    }
}
