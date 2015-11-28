package dss.practica3.modelo;

import java.util.HashMap;
import java.util.Map;

public enum TodoDao {
	
	INSTANCE;
	private Map<String, Todo> proveedorContenidos = new HashMap<String, Todo>();
	
	private TodoDao() {
		Todo todo = new Todo("1", "La vida es bella");
		todo.setAnio("1997");
		todo.setGenero("Comeia, Drama");
		todo.setDirector("Roberto Benigni");
		todo.setActores("Roboerto Benigni,  Nicoletta Braschi, Giorgio Cantarini");
		todo.setSinopsis("En 1939, a punto de estallar la Segunda Guerra Mundial (1939-1945), el extravagante Guido llega a Arezzo (Toscana) con la intención de abrir una librería. Allí conoce a Dora y, a pesar de que es la prometida del fascista Ferruccio, se casa con ella y tiene un hijo. Al estallar la guerra, los tres son internados en un campo de exterminio, donde Guido hará lo imposible para hacer creer a su hijo que la terrible situación que están padeciendo es tan sólo un juego.");
		proveedorContenidos.put("1", todo);
	}
	
	public Map<String, Todo> getModelo(){
		return proveedorContenidos; 
	}
}
