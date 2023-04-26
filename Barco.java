import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class Barco {
	//Atributos
	private String matricula;
	private String nombre;
	private float tamanyo;
	
	//Constructores
	public Barco (String matricula, String nombre, float tamanyo) {
		this.setMatricula(matricula);
		this.setNombre(nombre);
		this.setTamanyo(tamanyo);
	}
	
	
	//Metodos
	public static String mayorTamanyo(ArrayList<Barco> barcosEntrantes) {
		String matricula="No hay barcos en la lista";
		float maxTamanyo=0;
		
		for (int i=0;i<barcosEntrantes.size();i++) {
			if (barcosEntrantes.get(i).getTamanyo()>maxTamanyo) {
				maxTamanyo=barcosEntrantes.get(i).getTamanyo();
				matricula=barcosEntrantes.get(i).getMatricula();
			}
		}
		return matricula;
	}
	
	
	public boolean encajaTipo(Pantalan pantalan) {
		boolean encaja;
		
		if (this instanceof Comercial && pantalan.getTipo().equals("Comercial")) {
			encaja=true;
		}else if(this instanceof Recreo && pantalan.getTipo().equals("Recreo")) {
			encaja=true;
		}else {
			encaja=false;
		}
		
		return encaja;
	}
	
	
	public float encajaTamanyo(Amarre amarre) {
		return amarre.getTamanyo()-this.getTamanyo();
	}

	
	public static void cargarBarcosEntrantes(ArrayList<Barco> barcosEntrantes) {
		try {
			File file = new File("barcos.txt");
			BufferedReader buffer = new BufferedReader (new FileReader(file));
			
			boolean eof = false;
			String lineaLeida = "";
			String[] broken_text = null;
			
			while (!eof) {
				lineaLeida = buffer.readLine();
				if (lineaLeida != null) {
					broken_text=lineaLeida.split(";");
					
					if (broken_text[0].equals("Comercial")) {
						Comercial barco = new Comercial(broken_text[1],broken_text[2],Float.parseFloat(broken_text[3]));
						barcosEntrantes.add(barco);
						System.out.println(barco);
					}else {
						Recreo barco = new Recreo(broken_text[1],broken_text[2],Float.parseFloat(broken_text[3]));
						barcosEntrantes.add(barco);
						System.out.println(barco);
					}					
				}else {
					eof=true;
				}
			}
			buffer.close();
		} catch (Exception e) {
			System.out.println("Error en cargarBarcosEntrantes: "+e.getMessage());
		}
	}
	
	
	
	@Override
	public String toString() {
		return "Barco [matricula=" + matricula + ", nombre=" + nombre + ", tamanyo=" + tamanyo + "]";
	}


	//Getters y Setters
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getTamanyo() {
		return tamanyo;
	}

	public void setTamanyo(float tamanyo) {
		this.tamanyo = tamanyo;
	}

}
