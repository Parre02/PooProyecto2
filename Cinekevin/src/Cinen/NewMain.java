
package Cinen;

import java.util.ArrayList;
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
        ArrayList<Cliente> clientes= new ArrayList<>();
        ArrayList<Trabajador> trabajadores = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        System.out.print("\n\t.:Menu:.\t\n");
        System.out.print("1.Comprar boleteria \n");
        System.out.print("2.Editar la cartelera\n");
        System.out.print("3. Buscar un registro en Cliente,Pelicula,Trabajador \n");
        System.out.print("4. Eliminar un registro en Cliente,Pelicula,Trabajador \n");
        System.out.print("5. Salir\n\n");
        System.out.print("Opcion: ");

        opcion = entrada.nextInt();

        while (opcion != 5) {
            System.out.print("\n\t.:Menu:.\t\n");
            System.out.print("1.Comprar boleteria \n");
            System.out.print("2.Editar la cartelera \n");
            System.out.print("3.Buscar un registro en Cliente,Pelicula,Trabajador \n");
            System.out.print("4.Eliminar un registro en Cliente,Pelicula,Trabajador \n");
            System.out.print("5. Salir\n\n");
            System.out.print("Opcion: ");
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cedula y el nombre del cliente \nCedula no mas de 10 digitos \nNombre seguido de espacio y un apellido");
                    int cedula = entrada.nextInt();
                    String nombre = entrada.next();
                    Cliente cliente = new Cliente(cedula,000,nombre,"Na",0);

                    if (!cliente.loging(cliente, clientes)) {
                        System.out.println("El cliente no esta registrado, se debe registrar para comprar boleteria");
                        System.out.println("Ingrese el celular, \nCelular no mas de 10 digitos \nSexo M o F, edad minimo 16 para registro");
                        int celular = entrada.nextInt();
                        String sexo = entrada.next();
                        int edad = entrada.nextInt();
                        Cliente cliente1 = new Cliente(cedula,celular,nombre,sexo,edad);
                        System.out.println("Se ha registrado satisfactoriamente al cliente \n Desea imprimir la cartelera? 1 si, 2 no,");
                        
                        
                    } 
                    else {
                        
                        
                    }




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
        
        Cliente cl=new Cliente(1, 2,"a", "b", 3 );
        Cliente c2=new Cliente(2, 8,"k", "c", 5 );
       
        
        
        
        
        
        System.out.println(Sala.admin.estadisticas(s1));
        System.out.println(cl.comprarEntrada(cl, s1, 1, 2));
        
        
        
        
        
    }



        
    
}

