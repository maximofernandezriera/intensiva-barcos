
public class Amarre {
	private int id;
	private float tamanyo;
	private boolean ocupado;
	private Barco barco;
	private static int contador=0;
	
	
	//Constructores
	public Amarre(float tamanyo) {
		this.setID();
		this.setTamanyo(tamanyo);
	}
	
	//Metodos
	@Override
	public String toString() {
		return "\nAmarre"
				+ "[id=" + id + ", tamanyo=" + tamanyo + ", ocupado=" + ocupado + ", barco=" + barco + "]";
	}
	
	//Getters y setters
	public void setID() {
		this.id=contador;
		contador++;
	}

	public void setTamanyo(float tamanyo) {
		this.tamanyo=tamanyo;
	}
	
	public float getTamanyo() {
		return tamanyo;
	}
	
	public void setOcupado(boolean ocupado) {
		this.ocupado=ocupado;
	}
	
	public boolean getOcupado () {
		return this.ocupado;
	}
	
	public void setBarco(Barco barco) {
		this.barco=barco;
	}
}
