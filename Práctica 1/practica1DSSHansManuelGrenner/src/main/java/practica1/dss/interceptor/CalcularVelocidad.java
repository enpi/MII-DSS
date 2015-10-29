package practica1.dss.interceptor;

public class CalcularVelocidad implements Filtro{

	private final int INTERVALO = 10;
	private double revolAnt;
	private static double revoluciones;
		

	
	/**
	 * Función que modifica la variable 'revoluciones'.
	 * @param revoluciones2
	 */
	public static void setRevoluciones(double revoluciones2){
		revoluciones = revoluciones2;
	}


	public double ejecutar(Object o) {
			double distancia = new Double(o.toString());
			double velocidad = distancia*3600/INTERVALO;
			revolAnt = revoluciones;
			return velocidad;
	}

}
