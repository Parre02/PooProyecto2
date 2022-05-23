
package Cinen;

import java.util.Scanner;

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
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        System.out.print("\n\t.:Menu:.\t\n");
        System.out.print("1.Comprar boleteria \n");
        System.out.print("2.\n");
        System.out.print("3. Buscar un registro en Cliente,Pelicula,Trabajador \n");
        System.out.print("4. Eliminar un registro en Cliente,Pelicula,Trabajador \n");
        System.out.print("5. Salir\n\n");
        System.out.print("Opcion: ");

        opcion = entrada.nextInt();

        while (opcion != 5) {
            System.out.print("\n\t.:Menu:.\t\n");
            System.out.print("1.Comprar boleteria \n");
            System.out.print("2.Editar la cartelera \n");
            System.out.print("3. Buscar un registro en Cliente,Pelicula,Trabajador \n");
            System.out.print("4. Eliminar un registro en Cliente,Pelicula,Trabajador \n");
            System.out.print("5. Salir\n\n");
            System.out.print("Opcion: ");
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cedula y el nombre del cliente");
                    int cedula = entrada.nextInt();
                    String nombre = entrada.next();
                    Cliente cliente = new Cliente(cedula, nombre);
                    cliente.
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción errada\n");
            }
        }
    


        
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
