package dss.practica3.modelo;

import java.awt.Image;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Todo{
	
	// Películas
	
	private String id;
	private String titulo;
	private String anio;
	private String genero;
	private String director;
	private String actores;
	private String sinopsis;
	private String img;
	
	public Todo(){
	}
	
	public Todo (String id, String titulo){
		this.id = id;
		this.titulo = titulo;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSinopsis() {
		return sinopsis;
	}


	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAnio() {
		return anio;
	}

	public String getGenero() {
		return genero;
	}

	public String getDirector() {
		return director;
	}

	public String getActores() {
		return actores;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
	
}