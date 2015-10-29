package practica1.dss.estado;

public class EstadoAcelerar implements Estado{

	private static EstadoAcelerar instance;

	private EstadoAcelerar(){
	}
	
	public static EstadoAcelerar getInstance(){
		if(instance == null) {
	         instance = new EstadoAcelerar();
	      }
	      return instance;
	}
	
	public String getTextoTitulo() {
		return Estado.TEXT_ACCELERATING;
	}

	public String getColorTitulo() {
		return Estado.COLOR_BLUE;
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
		
		return false;
	}
	
}
