
public class Recreo extends Barco{
	//Atributos
	private String permiso;
	
	//Constructores
	public Recreo (String matricula, String nombre, float tamanyo) {
		super(matricula, nombre, tamanyo);
	}

	@Override
	public String toString() {
		return super.toString()+"Recreo [permiso=" + permiso + "]";
	}
	
	
}
