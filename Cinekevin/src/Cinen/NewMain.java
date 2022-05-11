package Cinen;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Sala s=new Sala();
        Pelicula op=new Pelicula("nombre", "String director", 2023, 2, "String genero", "String pais", "String calificacion");
        Pelicula op2=new Pelicula("nombre", "String director", 2032, 2, "String genero", "String pais", "String calificacion");
        Cartelera cc=new Cartelera();
        
        Cliente cl=new Cliente(1, "n" );
        Cliente c2=new Cliente(1, "n" );
       
        System.out.println( cl.reservar(1,2,cl));
        
        System.out.println( cl.bucarFuncion());
        
    }
    
}
