package Ejercicios_02;

public class Persona {
	public String Fname;
	public String Lname;
	public String Sexo;
	public int B_dia;
	public int B_mes;
	public int B_año;
	public int altura;/*En centimetros*/
	public double peso;/*En kilogramos*/
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public int getB_dia() {
		return B_dia;
	}
	public void setB_dia(int b_dia) {
		B_dia = b_dia;
	}
	public int getB_mes() {
		return B_mes;
	}
	public void setB_mes(int b_mes) {
		B_mes = b_mes;
	}
	public int getB_año() {
		return B_año;
	}
	public void setB_año(int b_año) {
		B_año = b_año;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Persona(String Fname, String Lname, String Sexo, int b_dia, int b_mes, int b_año, int altura, double peso) {
		super();
		this.Fname = Fname;
		this.Lname = Lname;
		this.Sexo = Sexo;
		B_dia = b_dia;
		B_mes = b_mes;
		B_año = b_año;
		this.altura = altura;
		this.peso = peso;
	}
	public Persona() {
		
	}
	
	
	@Override
	public String toString() {
		return "Persona [Fname=" + Fname + ", Lname=" + Lname + ", Sexo=" + Sexo + ", B_dia=" + B_dia + ", B_mes="
				+ B_mes + ", B_año=" + B_año + ", altura=" + altura + ", peso=" + peso + "]";
	}
	public int cal_edad(int B_año) {
		int edad = 2023 - B_año;
		System.out.println("Su edad es: "+edad);
		return edad;
	}
	
	public void mFMC(int edad) {
		double FMC = 208 - (0.7*edad);
		System.out.println("Su FMC es: "+FMC);
		}

	
	public void IMC(int altura,double peso) {
		double IMC = peso/(altura*altura)/100;
		System.out.println("Su IMC es: "+IMC);
		
	}
	public void Fnaci(int dia,int mes,int año) {
		System.out.println("Su fecha de nacimiento es:" +dia+"/"+mes+"/"+año);
	}
	
}
