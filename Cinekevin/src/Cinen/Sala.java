package Cinen;
import java.util.ArrayList;

public class Sala {
    
    public final static int SILLAS_VIP = 8;
    
    public final static int SILLAS_ECONOMICAS = 42;
    
    private Silla[] sillas_vip;
    
    private Silla[] sillasEconomicas;

    
    public Sala( )
    {
        int ubicacion;

        
        sillas_vip = new Silla[SILLAS_VIP];

        
        sillasEconomicas = new Silla[SILLAS_ECONOMICAS];

        sillas_vip[ 0 ] = new Silla( 1, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 1 ] = new Silla( 2, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 2 ] = new Silla( 3, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 3 ] = new Silla( 4, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 4 ] = new Silla( 5, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 5 ] = new Silla( 6, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 6 ] = new Silla( 7, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 7 ] = new Silla( 8, Silla.SILLAS_VIP, Silla.CENTRAL );

        for( int numSilla = 1 + SILLAS_VIP, j = 1; j <= SILLAS_ECONOMICAS; numSilla++, j++ )
        {
            
            if( j % 6 == 1 || j % 6 == 0 )
                ubicacion = Silla.LATERAL_DERECHO;
            
            else if( j % 6 == 2 || j % 6 == 5 )
                ubicacion = Silla.CENTRAL;
            
            else
                ubicacion = Silla.LATERAL_IZQUIERDO;

            sillasEconomicas[ j - 1 ] = new Silla( numSilla, Silla.SILLAS_ECONOMICAS, ubicacion );
        }
    }
    
    public Silla asignarSilla( int tipo, int ubicacion, Cliente cliente)
    {
        
        Silla silla = null;
        if( tipo == Silla.SILLAS_VIP )
        {
            silla = buscarSillaVipLibre( ubicacion );
        }
        else if( tipo == Silla.SILLAS_ECONOMICAS )
        {
            silla = buscarSillaEconomicaLibre( ubicacion );
        }
        if( silla != null )
        {
            silla.asignarAcliente( cliente );
        }
        return silla;
    }

    
    public Silla buscarSillaVipLibre( int ubicacion )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_VIP && !encontrado; i++ )
        {
            silla = sillas_vip[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.getUbicacion( ) == ubicacion )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    
    public Silla buscarSillaEconomicaLibre( int ubicacion )
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.getUbicacion( ) == ubicacion )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    
    public Silla buscarPasajero(Cliente c)
    {
        
        Silla silla = buscarClienteVip( c);
        
        if( null == silla )
            
            silla = buscarClienteEconomico( c);
        return silla;

    }

    
    public Silla buscarClienteVip(Cliente cliente)
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_VIP && !encontrado; i++ )
        {
            silla = sillas_vip[ i ];
            if( silla.sillaAsignada( ) && silla.getPasajero( ).confirmarCliente(cliente ) )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    
    public Silla buscarClienteEconomico(Cliente cliente)
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( silla.sillaAsignada( ) && silla.getPasajero( ).equals(cliente) )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    
    public boolean desasignarSilla( Cliente cliente )
    {
        
        Silla silla = buscarPasajero(cliente);
        
        if( silla != null )
        {
            silla.desasignarSilla( );
            return true;
        }
        else
            return false;
    }

    
    public int contarSillasVipOcupadas( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_VIP; i++ )
        {
            if( sillas_vip[ i ].sillaAsignada( ) )
            {
                contador++;
            }
        }
        return contador;
    }
    
    public int contarSillasDañadas( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_ECONOMICAS; i++ )
        {
            if( sillasEconomicas[ i ].isDañada()==false)
            {
                contador++;
            }
        }
        for( int i = 0; i < SILLAS_VIP; i++ )
        {
            if( sillas_vip[ i ].isDañada()==false)
            {
                contador++;
            }
        }
        return contador;
    }
     

    
    public int contarSillasEconomicasOcupadas( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_ECONOMICAS; i++ )
        {
            if( sillasEconomicas[ i ].sillaAsignada( ) )
            {
                contador++;
            }
        }
        return contador;
    }

  
    public double calcularPorcentajeOcupacion( )
    {
        double porcentaje;
        int totalSillas = SILLAS_ECONOMICAS + SILLAS_VIP;
        int sillasOcupadas = contarSillasEconomicasOcupadas( ) + contarSillasVipOcupadas( );
        porcentaje = ( double )sillasOcupadas / totalSillas * 100;
        return porcentaje;
    }

  
    public Silla[] obtenerSillasVip( )
    {
        return sillas_vip;
    }

    
    public Silla[] obtenerSillasEconomicas( )
    {
        return sillasEconomicas;
    }

        
     public ArrayList<Silla> darSillasVacias()
    {
       Silla silla = null;
       ArrayList<Silla> s=new ArrayList<>();
       for( int i = 0; i < SILLAS_ECONOMICAS; i++ ){
           silla = sillasEconomicas[ i ];
           if( ! ( silla.sillaAsignada( ) ))
           {
               s.add(silla);
           }
       }
       for( int i = 0; i < SILLAS_VIP ; i++ ){
           silla = sillas_vip[ i ];
           if( ( silla.sillaAsignada( ) ))
           {
               s.add(silla);
           }
       }
        
        
               
        return s;
    }
     
    
}
