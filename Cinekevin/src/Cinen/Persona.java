package Cinen;


public class Persona {
    private long cedula;
    private long celular;
    private String nombre;
    private String sexo;
    private int edad;

    

    public Persona(long cedula,long celular, String nombre, String sexo, int edad) {
        this.cedula = cedula;
        this.celular = celular;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
