package Marco_Teorico;

public class App4 {
	 public static void main(String[] args) throws Exception{
	 System.out.printf("Maximo de %d, %d y %d es %d%n%n",
	 3, 4, 5, maximo(3,4,5));
	 System.out.printf("Maximo de %.1f, %.1f y %.1f es %.1f%n%n",
	 6.6, 7.7, 8.8, maximo(6.6,7.7,8.8));
	 //Para el caso de los objetos String la comparación se hace alfabéticamente.
	 System.out.printf("Maximo de %s, %s and %s es %s%n%n",
	 "pera", "zanahoria", "uva", maximo("pera","zanahoria","uva"));
	 }
	public static Comparable maximo (Comparable x, Comparable y, Comparable z){
		 Comparable max = x;
		 if(y.compareTo(x) > 0)
		 max = y;
		 if(z.compareTo(y) > 0)
		 max = z;
		 
		 return max;
		}
}
