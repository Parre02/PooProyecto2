package Cinen;

public class Silla {
    
    
    public final static int SILLAS_VIP = 1;
   
    public final static int SILLAS_ECONOMICAS= 2;
    
    public final static int LATERAL_DERECHO = 1;
    
    public final static int CENTRAL = 2;
    
    public final static int LATERAL_IZQUIERDO = 3;

    
    private int numero;
    
    private int tipo;
    
    private int ubicacion;
    
    private boolean danada;
    
    private Cliente clientes;

    
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

    
    public Cliente getPasajero( )
    {
        return clientes;
    }

    public boolean isDanada() {
        return danada;
    }

    public void setDanada(boolean danada) {
        this.danada = danada;
    }
    
    
}
    
