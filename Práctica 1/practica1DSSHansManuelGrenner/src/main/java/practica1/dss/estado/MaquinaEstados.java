package practica1.dss.estado;

/**
 * Clase de la máquina de estados
 * @author jmgn
 *
 */
public class MaquinaEstados {
	
	private Estado estado;
	
	/**
	 * Constructor de la máquina de estados que la inicializa con un estado dado.
	 * @param nuevoEstado Estado con el que se inicializa el objeto
	 */
	public MaquinaEstados(Estado nuevoEstado){
		estado = nuevoEstado;
	}

	/**
	 * Función para modificar el estado actual de la máquina de estados.
	 * @param nuevoEstado Nuevo estado sustituto
	 */
	public void cambiarEstado(Estado nuevoEstado){
		estado = nuevoEstado;
	}
	
	/**
	 * Función que devuelve el estado actual de la máquina de estados.
	 * @return Estado actual
	 */
	public Estado getEstado(){
		return estado;
	}
	
	/**
	 * Función que se encarga de transmitir la señal recibida al estado. En función de la respuesta
	 * dada por el estado se actualiza hacia uno nuevo.
	 * @param senial
	 * @return
	 */
	public boolean enviarSenial(int senial){
		
		if(estado == EstadoApagado.getInstance() ){
			if(estado.procesarSenial(this, senial)){
				cambiarEstado(EstadoEncendido.getInstance());
			}
		}
		else if(estado == EstadoEncendido.getInstance()){
			if(estado.procesarSenial(this, senial)){
				cambiarEstado(EstadoApagado.getInstance());
			}
			else
				cambiarEstado(EstadoAcelerar.getInstance());
		}
		else{
			if(estado.procesarSenial(this, senial)){
				cambiarEstado(EstadoApagado.getInstance());
			}
		}
		
		return true;
	}

}
