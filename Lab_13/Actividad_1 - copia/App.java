package Actividad_1;

public class App {
public static void main(String[] args) {
   Persona[] personas = {new Persona("Juan", "Dirección1", "123456"),
                         new Persona("Maria", "Dirección2", "789012")};

   Goodies[] goodies = {new Goodies(1, "Descripción1", 10.5f),
                       new Goodies(2, "Descripción2", 20.5f)};

   Estudiante[] estudiantes = {new Estudiante("Pedro", "Dirección3", "345678", "Especialidad1", new Procedencia("Dep1", "Prov1")),
                               new Estudiante("Ana", "Dirección4", "901234", "Especialidad2", new Procedencia("Dep2", "Prov2"))};

   Verificadora<Persona> verPersonas = new Verificadora<>(personas);
   Verificadora<Goodies> verGoodies = new Verificadora<>(goodies);
   Verificadora<Estudiante> verEstudiantes = new Verificadora<>(estudiantes);

   System.out.println(verPersonas.contiene(new Persona("Maria", "", ""))); 
   System.out.println(verGoodies.contiene(new Goodies(1, "", 0))); 
   System.out.println(verEstudiantes.contiene(new Estudiante("Ana", "", "", "", new Procedencia("Dep2", "Prov2")))); 
}
}
