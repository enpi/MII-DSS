package practica1.dss.controlador;

import practica1.dss.estado.Estado;
import practica1.dss.estado.EstadoApagado;
import practica1.dss.estado.EstadoEncendido;
import practica1.dss.estado.MaquinaEstados;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 * 
 * @author jmgn
 *
 */

@ManagedBean(name="controladorMotor", eager = true)
@SessionScoped
public class controladorMotor{
	
	private MaquinaEstados estadoMotor;
	
	/**
	 * Constructor de la clase que inicializa la máquina de estados con el estado apagado.
	 */
	public controladorMotor(){
		estadoMotor = new MaquinaEstados(EstadoApagado.getInstance());
	}

	/**
	 * Función que recibe el evento de la acción de pulsar el botón de On/Off de la aplicación. 
	 * Se encarga de actualizar el estado con la señal dada.
	 * @param event El evento de pulsar el botón
	 */
	public void actualizarBotonOnOff(ActionEvent event){
		estadoMotor.enviarSenial(Estado.SIGNAL_ON_OFF);
	}
	
	/**
	 * Función que recibe el evento de la acción de pulsar el botón de acelerar de la aplicación.
	 * Se encarga de actualizar el estado con la señal dada.
	 * @param event El evento de pulsar el botón
	 */
	public void actualizarBotonAcelerar(ActionEvent event){
		estadoMotor.enviarSenial(Estado.SIGNAL_ACCELERATE);
	}
	
	/**
	 * Función que devuelve el texto del título en función del estado activo.
	 * @return Texto del título
	 */
	public String getTextoTitulo(){
		return estadoMotor.getEstado().getTextoTitulo();
	}
	
	/**
	 * Función que devuelve el color del texto del título en función del estado activo.
	 * @return Color del título
	 */
	public String getColorTitulo(){
		return estadoMotor.getEstado().getColorTitulo();
	}

	/**
	 * Función que devuelve el color del texto para el botón de 'Acelerar' en función del estado activo.
	 * @return Color del texto para el botón 'acelerar'
	 */
	public String getColorBotonAcelerar() {
		return estadoMotor.getEstado().getColorBotonAcelerar();
	}

	/**
	 * Función que devuelve el color del texto para el botón de 'On/Off' en función del estado activo.
	 * @return Color del texto para el botón 'On/Off'
	 */
	public String getColorBotonOnOff() {
		return estadoMotor.getEstado().getColorBotonOnOff();
	}

	/**
	 * Función que devuelve el texto del botón 'On/Off' en función del estado activo.
	 * @return Texto del botón 'On/Off'
	 */
	public String getTextoBotonOnOff() {
		return estadoMotor.getEstado().getTextoBotonOnOff();
	}

	
}
