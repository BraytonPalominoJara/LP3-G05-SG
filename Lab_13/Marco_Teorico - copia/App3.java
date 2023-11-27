package Marco_Teorico;

public class App3 {
	 public static void main(String[] args) throws Exception{
		 
		 Box<Tropicales> boxMaracuya = new Box<>(new Tropicales("Mango"/* constructor arguments here */));
		 Box<Secos> boxNueces = new Box<>(new Secos("Nues"/* constructor arguments here */));
		 Box<Agua> boxSandia = new Box<>(new Agua("Coco"/* constructor arguments here */));

	 Box<String> boxStr = new Box<>("Ministerio de Educacion");
	 
	 System.out.println("Caja de fruta tropical: " + boxMaracuya);
	 System.out.println("Caja de fruto secos: " + boxNueces);
	 System.out.println("Caja de fruta de agua: " + boxSandia);
	 }
	}

