package Marco_Teorico;

public class App2 {
	 public static void main(String[] args) throws Exception{
	 Integer[] x = {0,1,2,3,4};
	 Verificadora<Integer> ver = new Verificadora<Integer>(x);
	 String msg = ver.contiene(2)? "SI tiene 2" : "NO tiene 2";
	 System.out.println(msg);
	 msg = ver.contiene(6)? "SI tiene 6" : "NO tiene 6";
	 System.out.println(msg);
	 /*if(ver.contiene(9.333)){ 
	 System.out.println("Si tiene 9.333");
	 }else{
	 System.out.println("NO tiene 9.333");
	 }*/
	 }
	}

