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
    private long cedula;
    private String nombre;
    private int puntos;
     
    

    
    public Cliente(long cedula,long celular,String nombre, String sexo, int edad,int puntos)
    {   super(cedula, celular, nombre, sexo, edad);
        this.cedula = cedula;
        this.nombre = nombre;
        this.puntos = puntos;
    }
    
    public boolean confirmarCliente( Cliente confirmar )
    {
        if( cedula == confirmar.getCedula( ) )
            return true;
        else
            return false;
    }
    

	public long getCedula( )
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


   

    public boolean confirmarCliente (long confirmar){
        if (confirmar == this.cedula) {
            return true;
            
        }
        return false;
    }



    }

   
   
    
    //si el cliente pregunta por las funciones del dia

    
    
    
    

  /*  //el cliente compra una entrada con descuento y se hace la reserva 
    public String comprarEntrada(Cliente cliente,Sala sala, int tipo, int ubicacion){
        
       
        
        if (1== tipo){ //--------> si el cliente ha elegido la opcion de vip  
             
           Sala.admin.reservar(tipo, cliente.getCedula(), cliente, sala);//----le guradamos la reserva
        
           
        }else if(2== tipo){//lo mismo pero con el cliente economico 
           
             Sala.admin.reservar(2, cliente.getCedula(), cliente, sala);
        }*/
                        
         
