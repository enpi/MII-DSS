package practica1.dss.interceptor;

public class CalcularDistancia implements Filtro{

	private GestorFiltros gestor;
	private int revolAnt;
	private final int RADIO = 10;
	
	/**
	 * Constructor de CalcularDistancia que se inicializa con el
	 * valor entero del número de revoluciones.
	 * @param revolAnt
	 */
	public CalcularDistancia(int revolAnt){
		this.revolAnt = revolAnt;
	}
	
	public double ejecutar(Object o) {
		double revoluciones = new Double(o.toString());
		CalcularVelocidad.setRevoluciones(revoluciones);
		double distancia = (revoluciones - revolAnt) *2*RADIO*3.1416;
		return distancia;
	}

}
