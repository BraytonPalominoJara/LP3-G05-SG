package Marco_Teorico;

//Frutas class (parent class)
public class Frutas {
private String nombre;

public Frutas(String nombre) {
   this.nombre = nombre;
}

public String getNombre() {
   return nombre;
}

@Override
public String toString() {
   return "Fruta: " + nombre;
}
}
