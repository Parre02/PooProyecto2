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
public class Silla {
    
    
    public final static int SILLAS_VIP = 1;
   
    public final static int SILLAS_ECONOMICAS= 2;
    
    public final static int LATERAL_DERECHO = 1;
    
    public final static int CENTRAL = 2;
    
    public final static int LATERAL_IZQUIERDO = 3;

    
    private int numero;
    
    private int tipo;
    
    private int ubicacion;
    
    private boolean dañada;
    
    private Cliente clientes;
    
    private ArrayList<Cliente> listaClientes= new ArrayList<>(); ;

    
    public Silla( int numero, int tipo, int ubicacion )
    {
        this.numero =numero;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        clientes = null;
    }

    
    public void asignarAcliente( Cliente p )
    {
        clientes = p;
    }

    
    public void desasignarSilla( )
    {
        clientes = null;
    }

    
    public boolean sillaAsignada( )
    {
        if( null == clientes )
            return false;
        else
            return true;
    }

    
    public boolean sillaAsignadaAcliente( Cliente p )
    {
        if( null == clientes )
            return false;
        else if( clientes.confirmarCliente(p ) )
            return true;
        else
            return false;
    }

    
    public int getNumero( )
    {
        return numero;
    }

    
    public int getTipo( )
    {
        return tipo;
    }

    
    public int getUbicacion( )
    {
        return ubicacion;
    }

    
    public Cliente getCliente( )
    {
        return clientes;
    }

    public boolean isDanada() {
        return dañada;
    }

    public void setDanada(boolean dañada) {
        this.dañada = dañada;
    }
    
    
}
    