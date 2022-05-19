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
    
    
   
    protected static ArrayList<Cliente> clientes= new ArrayList<>();

    
    public Cliente(int cedula,String nombre)
    {
        this.cedula = cedula;
        this.nombre = nombre;
        Cliente.clientes.add(this);
        
        
               
    }

    
    public int getCedula( )
    {
        return cedula;
    }


    public String getNombre( )
    {
        return nombre;
    }

   
    public boolean confirmarCliente( Cliente confirmar )
    {
        if( cedula == confirmar.getCedula( ) )
            return true;
        else
            return false;
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
    
   
    
    
}
               
                        
              