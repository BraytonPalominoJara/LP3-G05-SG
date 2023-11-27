package Actividad_1;

//Implementación de la interfaz Contenedora para cada tipo
public class Verificadora<T> implements Contenedora<T> {
private T[] datos;

public Verificadora(T[] datos) {
   this.datos = datos;
}

@Override
public boolean contiene(T valor) {
   for (T ele : datos) {
       if (valor.equals(ele)) {
           return true;
       }
   }
   return false;
}
}