package Actividad_1;

import java.util.Objects;

//Clase Estudiante que hereda de Persona
public class Estudiante extends Persona {
private String especialidad;
private Procedencia procedencia;

// Constructor, getters y setters

@Override
public boolean equals(Object obj) {
   if (this == obj) return true;
   if (obj == null || getClass() != obj.getClass()) return false;
   Estudiante estudiante = (Estudiante) obj;
   return Objects.equals(getNombre(), estudiante.getNombre()) &&
           Objects.equals(procedencia, estudiante.procedencia);
}

public Estudiante(String nombre, String direccion, String telefono, String especialidad, Procedencia procedencia) {
	super(nombre, direccion, telefono);
	this.especialidad = especialidad;
	this.procedencia = procedencia;
}

public String getEspecialidad() {
	return especialidad;
}

public void setEspecialidad(String especialidad) {
	this.especialidad = especialidad;
}

public Procedencia getProcedencia() {
	return procedencia;
}

public void setProcedencia(Procedencia procedencia) {
	this.procedencia = procedencia;
}
}