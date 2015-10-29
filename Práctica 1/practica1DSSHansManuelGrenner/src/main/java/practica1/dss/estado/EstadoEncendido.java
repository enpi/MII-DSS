package practica1.dss.estado;

public class EstadoEncendido implements Estado {
	
	private static EstadoEncendido instance;

	private EstadoEncendido(){
	}
	
	public static EstadoEncendido getInstance(){
		if(instance == null) {
	         instance = new EstadoEncendido();
	      }
	      return instance;
	}

	public String getTextoTitulo() {
		return Estado.TEXT_ON;
	}

	public String getColorTitulo() {
		return Estado.COLOR_GREEN;
	}

	public String getTextoBotonOnOff() {
		return Estado.TEXT_STOP;
	}

	public String getColorBotonOnOff() {
		return Estado.COLOR_RED;
	}

	public String getColorBotonAcelerar() {
		return Estado.COLOR_BLUE;
	}

	public boolean procesarSenial(MaquinaEstados m, int senial) {
		if( senial == Estado.SIGNAL_ON_OFF)
			return true;
		else
			return false;
		
	}

}
