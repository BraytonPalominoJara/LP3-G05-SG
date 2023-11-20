package Marco_Teorico;

public class App2 {
	 public static void main(String[] args) throws Exception{
	 Integer[] intArray = {1,2,3,4,5};
	 Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
	 Character[] charArray = {'H', 'O', 'L', 'A'};
	 System.out.printf("Array integerArray contiene:%n");
	 imprimirArray(intArray);
	 System.out.printf("%nArray doubleArray contiene:%n");
	 imprimirArray(doubleArray);
	 System.out.printf("%nArray charArray contiene:%n");
	imprimirArray(charArray);
	 }
	 
	public static <T> void imprimirArray(T[] inputArray) {
		 for(T elemento : inputArray)
		 System.out.printf("%s ",elemento);
		 System.out.println();
		 }
}

