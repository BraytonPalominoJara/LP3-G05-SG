package Ejercicios;

import java.util.Scanner;

public class Codigo {
	public String Titular;
	public double cantidad= 0;

	
	
	public Codigo(String titular, double cantidad) {
		super();
		Titular = titular;
		this.cantidad = cantidad;
	}
	
	
	
	public Codigo(String titular) {
		super();
		Titular = titular;
	}



	public String getTitular() {
		return Titular;
	}
	public void setTitular(String titular) {
		Titular = titular;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}




	
	public void ingresar (double cantidad) {
		if (cantidad >=0)
			this.cantidad=this.cantidad+cantidad;
		else
			System.out.println("La cantidad es menor a 0");
		
	}
	public void retirar (double cantidad) {
		if (cantidad >=0)
			this.cantidad=this.cantidad-cantidad;
			if (this.cantidad<0)
				this.cantidad=0;
	}
	public void versaldo() {
		System.out.println("Actualmente en tu cuenta hay: "+cantidad);
	}
	
}
