package Cinen;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Pelicula {
    private String nombre;
	private String director;
	private int a�o;
	private int duracion;
	private String genero;
	private String pais;
	private String calificacion;
        protected static ArrayList<Pelicula> peliculas= new ArrayList<>();

    public Pelicula(String nombre, String director, int a�o, int duracion, String genero, String pais, String calificacion) {
        this.nombre = nombre;
        this.director = director;
        this.a�o = a�o;
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
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
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
