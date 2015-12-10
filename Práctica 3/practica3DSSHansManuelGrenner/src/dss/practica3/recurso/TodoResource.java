package dss.practica3.recurso;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import dss.practica3.modelo.Todo;
import dss.practica3.modelo.TodoDao;

public class TodoResource {
	@Context
	UriInfo uriInfo;
	
	@Context
	String id;
	Request request;
	
	public TodoResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id; 
	}
	
	@GET //Integracion de aplicaciones
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Todo getTodo() {
		Todo todo = TodoDao.INSTANCE.getModelo().get(id);
		
		if(todo==null)
			throw new RuntimeException("Get: Todo con " + id + " no se ha encontrado");
		return todo; 
	}
	
	@GET // Para el navegador
	@Produces(MediaType.TEXT_XML)
	public Todo getTodoHTML() {
		Todo todo = TodoDao.INSTANCE.getModelo().get(id);
		
		if(todo==null)
			throw new RuntimeException("Get: Todo con " + id + " no se ha encontrado");
		return todo; 	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putTodo(JAXBElement<Todo> todo) {
		Todo c = todo.getValue();
		return putAndGetResponse(c); 
	}
	
	@DELETE
	public void deleteTodo() {
		Todo c = TodoDao.INSTANCE.getModelo().remove(id);
		
		if(c==null)
			throw new RuntimeException("Delete: Todo con " + id + " no se ha encontrado"); 
	}
	
	private Response putAndGetResponse(Todo todo) {
		Response res;
		
		if(TodoDao.INSTANCE.getModelo().containsKey(todo.getId())) {
			res = Response.noContent().build();
		} else {
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		
		TodoDao.INSTANCE.getModelo().put(todo.getId(), todo);
		return res;
	}

}

