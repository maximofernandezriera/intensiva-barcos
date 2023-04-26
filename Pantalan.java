import java.util.ArrayList;

public class Pantalan {
	//Atributos
	private int id;
	private String tipo;
	private ArrayList<Amarre> listAmarre;
	private static int contador=0;
	
	
	//Constructores
	public Pantalan(String tipo) {
		listAmarre=new ArrayList<Amarre>();
		this.setID();
		this.setTipo(tipo);
	}
	
	//Metodos
	@Override
	public String toString() {
		return "Pantalan \n"
				+ "[id=" + id + ", tipo=" + tipo + "\n"
				+listAmarre + "]\n";
	}

	//Getters y Setters
	public void setID() {
		this.id=contador;
		contador++;
	}
	
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public void setAmarre(Amarre amarre) {
		this.listAmarre.add(amarre);
	}
	
	public ArrayList<Amarre> getListAmarre(){
		return listAmarre;
	}
}
