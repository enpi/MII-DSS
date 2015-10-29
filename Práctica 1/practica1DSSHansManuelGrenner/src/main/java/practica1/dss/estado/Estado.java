package practica1.dss.estado;


/**
 * Interfaz correspondiente al Estado.
 * 
 * @author jmgn
 *
 */
public interface Estado {
	
	static final int SIGNAL_ON_OFF = 0;
	static final int SIGNAL_ACCELERATE = 1;
	
	static final String COLOR_RED = "red";
	static final String COLOR_BLUE = "blue";
	static final String COLOR_GREEN = "green";

	static final String TEXT_OFF = "Apagado";
	static final String TEXT_ON = "Encendido";
	static final String TEXT_ACCELERATING = "Acelerando";
	static final String TEXT_ACCELERATE = "Acelerar";
	static final String TEXT_ACTIVATE = "Encender";
	static final String TEXT_STOP = "Apagar";
	
	/**
	 * Función que devuelve el texto del título.
	 * @return Texto del título
	 */
	public String getTextoTitulo();
	
	/**
	 * Función que devuelve el nombre del color del texto del título.
	 * @return Color del título
	 */
	public String getColorTitulo();
	
	/**
	 * Función que devuelve el texto del boton de 'On/Off'.
	 * @return Texto del boton 'On/Off'
	 */
	public String getTextoBotonOnOff();
	
	/**
	 * Función que devuelve el nombre del color para texto del botón de 'On/Off'.
	 * @return Color del texto para el botón 'On/Off'
	 */
	public String getColorBotonOnOff();
	
	/**
	 * Función que devuelve el nombre del color para el texto del botón de 'Acelerar'.
	 * @return Color del texto para el botón 'Acelerar'
	 */
	public String getColorBotonAcelerar();
	
	/**
	 * Función que procesa la señal de entrada que interviene en la actualización del estado de la máquina de estados que está funcionamiento.
	 * @param m 
	 * @param senial
	 * 
	 * @return 
	 */
	public boolean procesarSenial(MaquinaEstados m, int senial);
}
