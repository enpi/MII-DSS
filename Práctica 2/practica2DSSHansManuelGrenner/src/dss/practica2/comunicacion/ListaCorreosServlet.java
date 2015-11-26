package dss.practica2.comunicacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dss.practica2.modelo.BDUsuario;
import dss.practica2.modelo.Usuario;

/**
 * Clase correspondiente al servlet que recibe las peticiones post y get.
 * @author jmgn
 *
 */
public class ListaCorreosServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
		
	/**
	 * 	Función que solicita información a un recurso específico.
	 * 	Se actualizará la lista de usuarios en una llamada get.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Usuario> listaUsuarios = BDUsuario.listarUsuarios();
		
		request.setAttribute("usuarios", listaUsuarios);
		request.setAttribute("buscado", null);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * Función que recibe datos para ser procesados por un recurso específico.
	 * Las funcionalidades incluyen actualizar la lista de usuarios, insertar nuevos usuarios, buscar un usuario y 
	 * eliminarlo.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String accion = request.getParameter("action");
		
		String email = request.getParameter("email");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		request.setAttribute("buscado", null);
		
		if(accion.equals("insertar")){		
			if(!BDUsuario.existeEmail(email)){
				Usuario user = new Usuario(nombre, apellido, email);
				BDUsuario.insertar(user);
			}
		}
		else if(accion.equals("seleccionarUsuario")){
			Usuario user = BDUsuario.seleccionarUsuario(email);
			if(user!=null)
				request.setAttribute("buscado", user);
		}
		else if(accion.equals("actualizar")){
			Usuario user = BDUsuario.seleccionarUsuario(email);
			if(user!=null){
				user.setNombre(nombre);
				user.setApellido(apellido);
				BDUsuario.actualizar(user);
			}
		}
		else if(accion.equals("eliminar")){
			Usuario user = BDUsuario.seleccionarUsuario(email);
			if(user!=null)
				BDUsuario.eliminar(user);
		}
			
		List<Usuario> listaUsuarios = BDUsuario.listarUsuarios();
		request.setAttribute("usuarios", listaUsuarios);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
