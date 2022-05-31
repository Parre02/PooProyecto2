
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
        ArrayList<Cliente> clientes= new ArrayList<Cliente>();
        ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
        ArrayList<Sala> salas = new ArrayList<Sala>();
        Cartelera cartelera = new Cartelera(null);
        Funcionalidades funcionalidades =new Funcionalidades();
        

        try (Scanner entrada = new Scanner(System.in)) {
            int opcion = 0;
            int varloging;

            System.out.println("Bienvenido al cine JKS, ingrese la contrasena para ingresar al menu: ");
            varloging = entrada.nextInt();
            if (varloging == 0000) {
                opcion = 0;
                    while (opcion != 8) {
                        System.out.print("\n\t.:Menu:.\t\n");
                        System.out.print("1.Comprar boleteria \n");
                        System.out.print("2.Editar la cartelera, o imprimir cartelera\n");
                        System.out.print("3.Buscar o eliminar registro en Cliente,Pelicula,Trabajador \n"); //Discutir
                        System.out.print("4.Buscar una reserva \n");
                        System.out.println("5.Inicializar Cine (Reservada para un unico uso)");
                        System.out.println("6.Verificar integridad de las salas");
                        System.out.println("7.Enviar a servicios a barrer una sala");
                        System.out.print("8.Salir\n\n");
                        System.out.print("Opcion: ");


                        opcion = entrada.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("Ingrese la cedula del cliente \nCedula no mas de 9 digitos");
                                int cedula = entrada.nextInt();

                                System.out.println("Ingrese el nombre del cliente \nNombre seguido de espacio y un apellido");
                                String nombre = entrada.nextLine();
                                entrada.nextLine();

                                Cliente cliente = new Cliente(cedula,000,nombre,"Na",0,0);

                                if (!cliente.loging(cliente, clientes)) {
                                    System.out.println("El cliente no esta registrado, se debe registrar para comprar boleteria");

                                    System.out.println("Ingrese el celular, \nCelular no mas de 9 digitos, Para agregar el cliente, ingrese el celular");
                                    int celular = entrada.nextInt();

                                    System.out.println("Sexo M o F");
                                    String sexo = entrada.next();

                                    System.out.println("Ingrese la edad, para agregar el cliente,edad minimo 16 para registro");
                                    int edad = entrada.nextInt();

                                    Cliente cliente1 = new Cliente(cedula,celular,nombre,sexo,edad,0);
                                    clientes.add(cliente1);

                                    System.out.println("Se ha registrado satisfactoriamente al cliente \n Desea imprimir la cartelera? 1 si, 2 no");
                                    int varOpcionPrint = entrada.nextInt();
                                    if(varOpcionPrint == 1){

                                    }
                                    else{
                                        System.out.println("Que pelicula desea ver");
                                    }
                                    
                                    
                                } 
                                else {
                                    System.out.println("El cliente esta registrado");
                                    System.out.println("Desea imprimir la cartelera? 1 si, 2 no");
                                    int varOpcionPrint = entrada.nextInt();
                                    if(varOpcionPrint == 1){

                                    }
                                    else{
                                        System.out.println("Que pelicula desea ver");
                                    }                                                                  
                                }
                                break;

                            case 2:
                                System.out.println("Desea editar o imprimir cartelera? \n 1 para editar, 2 para imprimir la cartelera");
                                int varOpcion = entrada.nextInt();
                                if (varOpcion == 1) {
                                    System.out.println("Que pelicula desea editar? \nPara editar ingrese el nombre de la pelicula");
                                String varEntrada = entrada.next();
                                    
                                } else {
                                    
                                }
                                


                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                salas = funcionalidades.inicializarSalas();
                                System.out.println("Se ha iniciado existosamente las salas");
                                cartelera = funcionalidades.inicializarCartelera();
                                trabajadores = funcionalidades.inicializarTrabajdores(salas);
                                System.out.println("Se ha inicializado correctamente el cine");
                                break;

                            case 6:
                                break;
                            
                            case 7:
                                break;

                            case 8:
                                break;
                            default:
                                System.out.println("Opción errada\n");
                        }
                    }
            }
            else {
                System.out.println("Clave incorrecta hasta luego");
            }
        }
    }
}

