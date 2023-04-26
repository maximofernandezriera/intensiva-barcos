
public class Comercial extends Barco {

	private String carga;
	
	public Comercial (String matricula, String nombre, float tamanyo) {
		super(matricula, nombre, tamanyo);
	}

	@Override
	public String toString() {
		return super.toString()+"Comercial [carga=" + carga + "]";
	}
	
	
}
