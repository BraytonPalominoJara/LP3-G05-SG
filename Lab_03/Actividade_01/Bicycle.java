package Actividade_01;

public class Bicycle {
	static int count;
	private String ownerName;
	private float distance;
	private String idBicy;
	public Bicycle(String ownerName, int distance) {
		this.ownerName=ownerName;
		this.distance=distance;
		counter();
		String tempId = String.valueOf(1000*count);
		this.idBicy= ownerName.substring(0,2)+tempId.substring(1);
	}
	public String getOwnerName() {
		return ownerName;
	}
	public float getDistance() {
		return distance;
	}
	
	public void distanceTraveled(int meters) {
		this.distance += meters;
	}
	public static void counter() {
		count ++;
	}
	public static Bicycle mostUsed(Bicycle X, Bicycle Y) {
		if(X.distance> Y.distance)
			return X;
		return Y;
	}
	@Override
	public String toString() {
		
		String s = String.format("Bicycle: %s\nOwner : %s\tDistancia en metros:%10.2f\n",this.idBicy,this.ownerName,this.distance);
		return s;
	}
/*Variables de clase:
count es una variable de clase.

Variables de instancia:
ownerName, distance y idBicy son variables de instancia.

Métodos de instancia:
Bicycle (constructor)
getOwnerName
getDistance
distanceTraveled
toString

Métodos de clase:
counter
mostUsed*/
}
