package Actividad_1;

public class Goodies {
	 private int id;
	 private String description;
	 private float price;

	 // Constructor, getters y setters

	 @Override
	 public boolean equals(Object obj) {
	     if (this == obj) return true;
	     if (obj == null || getClass() != obj.getClass()) return false;
	     Goodies goodies = (Goodies) obj;
	     return id == goodies.id;
	 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public Goodies(int id, String description, float price) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	}