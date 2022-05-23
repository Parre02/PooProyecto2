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
public class Cliente{
      
    private int cedula;
    
    private String nombre;
    
    
   
    private ArrayList<Cliente> clientes= new ArrayList<>();

    
    public Cliente(int cedula,String nombre)
    {
        this.cedula = cedula;
        this.nombre = nombre;
        
        
               
    }
    

    
    public int getCedula( )
    {
        return cedula;
    }


    public String getNombre( )
    {
        return nombre;
    }

    public Cliente setclientes(Cliente cliente ){
        clientes.add(cliente);
        return cliente;


    }


    @Override
    public String toString(){
        String varImpr = "Se ha agregado satisfactoriamente el cliente" ;
        return varImpr;

    }



   
    public boolean confirmarCliente( Cliente confirmar )
    {  
        for (int i = 0; i < clientes.length; i++) {
            
        }
    }
    
    public String reservar(int tipo, int ubicacion, Cliente cliente, Sala reserva){
        
        String tip="";
        String tip2="";
        
        Silla silla = null;
        Silla a=reserva.asignarSilla(tipo, ubicacion, cliente);
        if(a.getTipo()==1){
            tip="Silla_Vip";
        }
        else{
            tip="Silla_Economica";
        }
        switch (a.getUbicacion()) {
            case 1:
                tip2="Lateral_Derecho";
                break;
            case 2:
                tip2="Central";
                break;
            default:
                tip2="Lateral_Izquierdo";
                break;
        }
        return "Numero: "+a.getNumero()
                +"\nTipo: "+ tip
                +"\nUbicacion: "+ tip2;
     }
    
    public ArrayList<String> bucarFuncion(){
        return Cartelera.cartelera();
    }
    
    
    public String devolucionCliente(Cliente cliente,Sala sala){
              
        Silla silla = null;
        Silla a=sala.buscarCliente(cliente);
        a.desasignarSilla();
        return "Devolucion exitosa";        
    }
    
    /*public String comprarEntrada(Cliente cliente,Sala sala){
        String a="";
        if(this.buscarCliente(cliente.getCedula())!=null){          
    }*/
    
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
    }*/ // Hacer un rediseño de este metodo debido que en la linea 108 Sala.reservas.get se esta ingresando a la clase no la instancia o objeto.
    
   
    
    
}
               
                        
              