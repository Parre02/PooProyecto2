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
   
    
    //aqui hacemos la rserva del cliente 
    public String reservar(int tipo, int ubicacion, int lugar, Cliente cliente, Sala reserva){
        
        String tip="";
        String tip2="";
        
        Silla silla=null;
        
        if (tipo==silla.SILLAS_ECONOMICAS){    //aqui asignamos que si la silla va ser vip o economica
            
            
            tip="Silla_Economica";
            
            silla=reserva.asignarSilla(2, ubicacion, cliente);
        }
        if (tipo==silla.SILLAS_VIP){
            silla=reserva.asignarSilla(1, 2, cliente);
            tip="Silla_Vip";
        }
        
        
        silla.asignarAcliente(cliente);//es importante 
                
        switch (silla.getUbicacion()) {
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
        return "Numero: "+silla.getNumero()
                +"\nTipo: "+ tip
                +"\nUbicacion: "+ tip2;
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
    public String comprarEntrada(Cliente cliente,Sala sala, int tipo, int ubicacion, int lugar){
        
        Silla silla=null;
        
        if (tipo==silla.SILLAS_ECONOMICAS){    //aqui asignamos que si la silla va ser vip o economica
            silla=sala.buscarSillaEconomicaLibre(ubicacion);
        }
        if (tipo==silla.SILLAS_VIP){
            silla=sala.buscarSillaVipLibre();
        }
        
        
        silla.asignarAcliente(cliente);//es importante 
        
        double preciovip=25.000;
        double precioEco=15.000;        
        String a="";
        boolean descuento=false; 
        
        
        if(sala.buscarCliente(cliente).getCliente()==cliente){//---->vemos si el cliente ha sido cliente antiguo y si es asi le aplica el descuento del 10%
            descuento=true;
        }
        
        
        
        if ((descuento) && silla.getTipo()== silla.SILLAS_VIP){ //--------> si el cliente ha elegido la opcion de vip  
                                                                        
           preciovip=preciovip-(preciovip*0.10);//----->le aplica el descuento
           a=preciovip+"";
           this.reservar(silla.SILLAS_VIP, cliente.getCedula(), lugar, cliente, sala);//----le guradamos la reserva
        
           
        }else if((descuento) && silla.getTipo()== silla.SILLAS_ECONOMICAS){//lo mismo pero con el cliente economico 
           
            precioEco=precioEco-(precioEco*0.05);//descuento de 5%
           a=precioEco+"";
           this.reservar(silla.SILLAS_VIP, cliente.getCedula(), lugar, cliente, sala);
        }
        
        //ahora vemos los que no han sido clientes
        
        if (!(descuento ) && silla.getTipo()== silla.SILLAS_VIP){
            
           
           a=preciovip+"";
           
           this.reservar(silla.SILLAS_ECONOMICAS, cliente.getCedula(), lugar, cliente, sala);
        }else if(!(descuento) && silla.getTipo()== silla.SILLAS_ECONOMICAS){
           
            
           a=precioEco+"";
           this.reservar(silla.SILLAS_ECONOMICAS, cliente.getCedula(), lugar, cliente, sala);
        }
            
                
         return a;
        
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
               