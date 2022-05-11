package Cinen;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Pelicula {
    private String nombre;
	private String director;
	private int año;
	private int duracion;
	private String genero;
	private String pais;
	private String calificacion;
        protected static ArrayList<Pelicula> peliculas= new ArrayList<>();

    public Pelicula(String nombre, String director, int año, int duracion, String genero, String pais, String calificacion) {
        this.nombre = nombre;
        this.director = director;
        this.año = año;
        this.duracion = duracion;
        this.genero = genero;
        this.pais = pais;
        this.calificacion = calificacion;
        Pelicula.peliculas.add(this);
    }
        
        

	
    public String getNombre() {
		return nombre;
	}
    public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	
	
	

}
