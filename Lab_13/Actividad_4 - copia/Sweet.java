package Actividad_4;

public class Sweet extends Biscuits {
    // Atributos específicos de Sweet, si los hay

    public Sweet(int id, String description, float price) {
        super(id, description, price);
        // Inicialización adicional si es necesario
    }

	@Override
	public String toString() {
		return "Sweet []";
	}

    // Métodos adicionales para Sweet
}