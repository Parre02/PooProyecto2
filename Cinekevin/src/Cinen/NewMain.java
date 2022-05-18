
package Cinen;

/**
 *
 * @author usuario
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Sala s=new Sala();
        Sala s1=new Sala();
        Pelicula op=new Pelicula("nombre", "String director", 2023, 2, "String genero", "String pais", "String calificacion");
        Pelicula op2=new Pelicula("nombre", "String director", 2032, 2, "String genero", "String pais", "String calificacion");
        Cartelera cc=new Cartelera();
        
        Cliente cl=new Cliente(1, "n" );
        Cliente c2=new Cliente(2, "n" );
       
        //System.out.println(cl.reservar(1,2,cl,s));
        
        System.out.println(cl.reservar(2, 2, c2,s));
        
        s.asignarSilla(1, 1, cl,2);
        System.out.println(s.lateral_I);
        System.out.println(s.lateral_D);
        System.out.println(s.obtenerSillasVip());
        System.out.println(cl.buscarCliente(2));
        
        
        
        
        
    }
    
}
