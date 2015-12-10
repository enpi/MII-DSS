package dss.practica3.recurso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import dss.practica3.modelo.Todo;
import dss.practica3.modelo.TodoDao;


@Path("/todos")
public class TodosResource {


  @Context
  UriInfo uriInfo;
  @Context
  Request request;
	
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public List<Todo> getTodosBrowser() {
	    List<Todo> todos = new ArrayList<Todo>();
	    todos.addAll(TodoDao.INSTANCE.getModelo().values());
	    return todos;
	  }

	  @GET
	  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public List<Todo> getTodos() {
	    List<Todo> todos = new ArrayList<Todo>();
	    todos.addAll(TodoDao.INSTANCE.getModelo().values());
	    return todos;
	  }


	  @GET
	  @Path("count")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getCount() {
	    int count = TodoDao.INSTANCE.getModelo().size();
	    return String.valueOf(count);
	  }
	
	  
	@POST
	  @Produces(MediaType.TEXT_HTML)
	  @Path("insert")
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public void newTodo(@FormParam("id") String id,
	      @FormParam("titulo") String titulo,
	      @FormParam("anio") String anio,
	      @FormParam("genero") String genero,
	      @FormParam("director") String director,
	      @FormParam("actores") String actores,
	      @FormParam("sinopsis") String sinopsis,
	      @FormParam("imagen") String imagen,
		  
	      @Context HttpServletResponse servletResponse) throws IOException{
	    Todo todo = new Todo(id, titulo);
	    if (anio != null && genero != null && director != null && actores != null && sinopsis != null && imagen != null) {
	    	todo.setAnio(anio);
	    	todo.setGenero(genero);
	    	todo.setDirector(director);
	    	todo.setActores(actores);
	    	todo.setSinopsis(sinopsis);
	    	todo.setImg(imagen);
	    	
	    }
	    
	    TodoDao.INSTANCE.getModelo().put(id, todo);

	    servletResponse.sendRedirect("../../index.html");
	  }
	
	  
	  @POST
	  @Produces(MediaType.TEXT_HTML)
      @Path("update")
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public void updateTodo(@FormParam("id") String id,
	      @FormParam("titulo") String titulo,
	      @FormParam("anio") String anio,
	      @FormParam("genero") String genero,
	      @FormParam("director") String director,
	      @FormParam("actores") String actores,
	      @FormParam("sinopsis") String sinopsis,
	      @FormParam("imagen") String imagen,  
		  
	      @Context HttpServletResponse servletResponse) throws IOException{
	    Todo todo = getTodo(id).getTodo();
	    if (titulo !=null && anio != null && genero != null && director != null && actores != null && sinopsis != null && imagen != null) {
	    	todo.setTitulo(titulo);
	    	todo.setAnio(anio);
	    	todo.setGenero(genero);
	    	todo.setDirector(director);
	    	todo.setActores(actores);
	    	todo.setSinopsis(sinopsis);
	    	todo.setImg(imagen);

	    	
	    }
	    TodoDao.INSTANCE.getModelo().put(id, todo);

	    servletResponse.sendRedirect("../../index.html");
	  }
	
	
	@POST
    @Produces(MediaType.TEXT_HTML)
	@Path("delete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void removeTodo(@FormParam("id") String id,			  
		      @Context HttpServletResponse servletResponse) throws IOException{
		
				getTodo(id).deleteTodo();
				
			    servletResponse.sendRedirect("../../index.html");

	}
	
	@POST
    @Produces(MediaType.TEXT_HTML)
	@Path("showImage")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String showImage(@FormParam("id") String id,			  
		      @Context HttpServletResponse servletResponse) throws IOException{
		
				String img = getTodo(id).getTodo().getImg();
				
				
			    return "<img src=\""+img+"\" >";

	}

	  @Path("{todo}")
	  public TodoResource getTodo(@PathParam("todo") String id) {
	    return new TodoResource(uriInfo, request, id);
	  }
	  
	  
	  
	private void writeToFile(InputStream uploadedInputStream,
		String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(
					uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

} 
