/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cinen;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Cliente extends Persona{
      
    private int cedula;
    private String nombre;

    
    public Cliente(int cedula,int celular,String nombre, String sexo, int edad)
    {   super(cedula, celular, nombre, sexo, edad);
        this.cedula = cedula;
        this.nombre = nombre;
    }
    
    public boolean confirmarCliente( Cliente confirmar )
    {
        if( cedula == confirmar.getCedula( ) )
            return true;
        else
            return false;
    }
    

    
    
    
    




	public int getCedula( )
    {
        return cedula;
    }
	
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}


    public String getNombre( )
    {
        return nombre;
    }


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





    @Override
    public String toString(){
        String varImpr = "Se ha agregado satisfactoriamente el cliente" ;
        return varImpr;

    }

    public boolean loging(Cliente Cliente, ArrayList<Cliente> clientes)
    {
        boolean varConfirmar = false;
        for (Cliente cli : clientes) {
            if (cli.confirmarCliente(Cliente.getCedula())) {
                varConfirmar = true;
                break;
            } 
        }
        return varConfirmar;          
    }


   

    public boolean confirmarCliente (int confirmar){
        if (confirmar == this.cedula) {
            return true;
            
        }
        return false;
    }
   
   
    
    //si el cliente pregunta por las funciones del dia
    public ArrayList<String> bucarFuncion(){
        return Cartelera.cartelera();
    }
    
    
    
    //si el cliente quiere pedir una devolucion 
    public String devolucionCliente(Cliente cliente,Sala sala){
              
        Silla silla = null;
        Silla a=sala.buscarCliente(cliente);
        a.desasignarSilla();
        return "Devolucion exitosa";        
    }
    

    //el cliente compra una entrada con descuento y se hace la reserva 
    public String comprarEntrada(Cliente cliente,Sala sala, int tipo, int ubicacion){
        
       
        
        if (1== tipo){ //--------> si el cliente ha elegido la opcion de vip  
             
           Sala.admin.reservar(tipo, cliente.getCedula(), cliente, sala);//----le guradamos la reserva
        
           
        }else if(2== tipo){//lo mismo pero con el cliente economico 
           
             Sala.admin.reservar(2, cliente.getCedula(), cliente, sala);
        }
                        
         
       return "compra exitosa";
        
    }
    
    /*public Cliente buscarCliente(int cedula)
    {
        boolean encontrado = false;
        Silla f=null;
        for(int i =0; i < Sala.reservas.size(); i++ )
        {
            f = Sala.reservas.get(i);
            if(f.getCliente().getCedula()==cedula )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return f.getCliente();
        else
            return null;
    }*/ // Hacer un rediseÃ±o de este metodo debido que en la linea 108 Sala.reservas.get se esta ingresando a la clase no la instancia o objeto.
    
   
    
    
}
               