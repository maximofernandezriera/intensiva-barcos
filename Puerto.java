import java.util.ArrayList;

public class Puerto {
	//Atributos
	private static ArrayList<Barco> barcosEntrantes;
	private static ArrayList<Pantalan> listPantalan;
	
	
	//Metodos
	public static void buscarAmarre(ArrayList<Barco> barcosEntrantes, ArrayList<Pantalan> listPantalan) {
		//Recorremos el Array de Barcos tantas veces como barcos, aunque puede que no encontremos amarre para todos los barcos
		for(int contador=barcosEntrantes.size();contador>0;contador--) {
			//Buscamos el barco de mayor tamanyo
			String matricula = Barco.mayorTamanyo(barcosEntrantes);
			System.out.println(matricula);
			boolean encontrado = false;	
			int iBarco=0;
			
			while (!encontrado) {
				if (barcosEntrantes.get(iBarco).getMatricula().equals(matricula)) {
					encontrado=true;
				}else {
					iBarco++;
				}
			}
			
		
			Float encaja = null;
			Integer setPantalan = null;
			Integer setAmarre = null;
			//Recorremos todos los pantalanes
			for (int iPantalan=0;iPantalan<listPantalan.size();iPantalan++) {
				//Comprobamos que el tipo de pantalan es el mismo que el tipo del barco
				if (barcosEntrantes.get(iBarco).encajaTipo(listPantalan.get(iPantalan))) {
					//Recorremos todos los amarres de cada pantalan
					for (int iAmarre=0;iAmarre<listPantalan.get(iPantalan).getListAmarre().size();iAmarre++) {
						float diferencia = barcosEntrantes.get(iBarco).encajaTamanyo(listPantalan.get(iPantalan).getListAmarre().get(iAmarre));
						//Si el barco cabe en el amarre y es mas optimo que el anterior guardamos el id del pantalan y del amarre
						if (!listPantalan.get(iPantalan).getListAmarre().get(iAmarre).getOcupado() && ((encaja==null || encaja>diferencia) && diferencia>=0)){
							encaja=diferencia;
							setPantalan=iPantalan;
							setAmarre=iAmarre;
						}
					}
				}
			}
			//Si hemos encontrado un amarre para nuestro barco usamos los id de pantalan y amarre guardados para guardar nuestro barco 
			//en ese amarre y a continuacion sacamos el barco del Array de Barcos Pendientes.
			if (setPantalan!=null) {
				listPantalan.get(setPantalan).getListAmarre().get(setAmarre).setBarco(barcosEntrantes.get(iBarco));
				listPantalan.get(setPantalan).getListAmarre().get(setAmarre).setOcupado(true);
				barcosEntrantes.remove(iBarco);
				System.out.println("Barco amarrado");
			}
		}
	}
	
	public static void verAmarre(ArrayList<Pantalan> listPantalan) {
		for (int i=0;i<listPantalan.size();i++) {
			System.out.println(listPantalan.get(i).toString());
		}
	}
	
	public static void simular(ArrayList<Pantalan> listPantalan) {
		Pantalan p1 = new Pantalan("Comercial");
		Pantalan p2 = new Pantalan("Comercial");
		Pantalan p3 = new Pantalan("Recreo");
		
		Amarre a1 = new Amarre(110);
		Amarre a2 = new Amarre(100);
		Amarre a3 = new Amarre(80);
		Amarre a4 = new Amarre(50);
		Amarre a5 = new Amarre(10);
		Amarre a6 = new Amarre(2);
		Amarre a7 = new Amarre(2);
		Amarre a8 = new Amarre(50);
		Amarre a9 = new Amarre(300);
		
		p1.setAmarre(a1);
		p1.setAmarre(a2);
		p1.setAmarre(a3);
		
		p2.setAmarre(a4);
		p2.setAmarre(a5);
		p2.setAmarre(a6);
		
		p3.setAmarre(a7);
		p3.setAmarre(a8);
		p3.setAmarre(a9);

		
		listPantalan.add(p1);
		listPantalan.add(p2);
		listPantalan.add(p3);
	}
	
	public static void main(String[] args) {
		barcosEntrantes = new ArrayList<Barco>();
		listPantalan = new ArrayList<Pantalan>();
		
		simular(listPantalan);
		Barco.cargarBarcosEntrantes(barcosEntrantes);
		buscarAmarre(barcosEntrantes,listPantalan);
		verAmarre(listPantalan);
	

	}

}
