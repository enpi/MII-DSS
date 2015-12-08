package dss.practica3.recurso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
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

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import dss.practica3.modelo.Todo;
import dss.practica3.modelo.TodoDao;


// Will map the resource to the URL todos
@Path("/todos")
public class TodosResource {

  // Allows to insert contextual objects into the class,
  // e.g. ServletContext, Request, Response, UriInfo
  @Context
  UriInfo uriInfo;
  @Context
  Request request;
	
	  // Return the list of todos to the user in the browser
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public List<Todo> getTodosBrowser() {
	    List<Todo> todos = new ArrayList<Todo>();
	    todos.addAll(TodoDao.INSTANCE.getModelo().values());
	    return todos;
	  }

	  // Return the list of todos for applications
	  @GET
	  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public List<Todo> getTodos() {
	    List<Todo> todos = new ArrayList<Todo>();
	    todos.addAll(TodoDao.INSTANCE.getModelo().values());
	    return todos;
	  }

	  // retuns the number of todos
	  // Use http://localhost:8080/com.vogella.jersey.todo/rest/todos/count
	  // to get the total number of records
	  @GET
	  @Path("count")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getCount() {
	    int count = TodoDao.INSTANCE.getModelo().size();
	    return String.valueOf(count);
	  }
	
	
	@POST
	  @Produces(MediaType.TEXT_HTML)
	  //@Consumes(MediaType.MULTIPART_FORM_DATA)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public void newTodo(@FormParam("id") String id,
	      @FormParam("titulo") String titulo,
	      @FormParam("anio") String anio,
	      @FormParam("genero") String genero,
	      @FormParam("director") String director,
	      @FormParam("actores") String actores,
	      @FormParam("sinopsis") String sinopsis,

	      //@FormDataParam("imagen") InputStream uploadedInputStream,
		  //@FormDataParam("imagen") FormDataContentDisposition fileDetail,
		  
	      @Context HttpServletResponse servletResponse) throws IOException{
	    Todo todo = new Todo(id, titulo);
	    if (anio != null && genero != null && director != null && actores != null && sinopsis != null ) {
	    	todo.setAnio(anio);
	    	todo.setGenero(genero);
	    	todo.setDirector(director);
	    	todo.setActores(actores);
	    	todo.setSinopsis(sinopsis);
	    	
	    }
	    
	    /*
	    if(fileDetail !=null){
	    	todo.setImagen(ImageIO.read(uploadedInputStream));
	    
	    	System.out.println("Imagen añadida.");
	    	String uploadedFileLocation = "/home/iv-aerospace/Escritorio/" + fileDetail.getFileName();

			// save it
			writeToFile(uploadedInputStream, uploadedFileLocation);

			todo.setImg(uploadedFileLocation);
	    	
	    }
		*/
	     
	    TodoDao.INSTANCE.getModelo().put(id, todo);

	    servletResponse.sendRedirect("../todo/res");
	  }

	  // Defines that the next path parameter after todos is
	  // treated as a parameter and passed to the TodoResources
	  // Allows to type http://localhost:8080/com.vogella.jersey.todo/rest/todos/1
	  // 1 will be treaded as parameter todo and passed to TodoResource
	  @Path("{todo}")
	  public TodoResource getTodo(@PathParam("todo") String id) {
	    return new TodoResource(uriInfo, request, id);
	  }
	  
	// save uploaded file to new location
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
