package Actividad_4;

public class Chocolates extends Goodies {
    // Atributos específicos de Chocolates, si los hay

    public Chocolates(int id, String description, float price) {
        super(id, description, price);
        // Inicialización adicional si es necesario
    }

	@Override
	public String toString() {
		return "Chocolates []";
	}

    // Métodos adicionales para Chocolates
}
