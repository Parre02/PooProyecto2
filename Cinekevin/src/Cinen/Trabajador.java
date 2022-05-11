package Cinen;

public class Trabajador {
    private String nombre;
    private int id;
    private String cargo;
    private int edad;
    private boolean administrador;

    public Trabajador(String nombre, int id, String cargo, int edad, boolean administrador) {
        this.nombre = nombre;
        this.id = id;
        this.cargo = cargo;
        this.edad = edad;
        this.administrador = administrador;
    }
        
        
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	
	

}
