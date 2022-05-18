package Cinen;

import java.util.ArrayList;



public class Sala {
    
    public final static int SILLAS_VIP = 8;
    
    public final static int SILLAS_ECONOMICAS = 42;
    
    private Silla[] sillas_vip;
    
    private Silla[] sillasEconomicas;
    
    
    public ArrayList<String> lateral_I=new ArrayList<>();
    public ArrayList<String> Cental=new ArrayList<>();
    public ArrayList<String> lateral_D=new ArrayList<>();
    public static ArrayList<Silla> reservas=new ArrayList<>();
    
    

    
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
            
            if( j % 6 == 1 || j % 6 == 0 ){
                ubicacion = Silla.LATERAL_DERECHO;
                int a=j;
                String b=a+"";
          
                lateral_I.add(b);
            
            }else if( j % 6 == 2 || j % 6 == 5 ){
                ubicacion = Silla.CENTRAL;
                int a=j;
                String b=a+"";
          
                lateral_D.add(b);
            
            }else{
                ubicacion = Silla.LATERAL_IZQUIERDO;
                int a=j;
                String b=a+"";
          
                Cental.add(b);
            }

            sillasEconomicas[ j - 1 ] = new Silla( numSilla, Silla.SILLAS_ECONOMICAS, ubicacion );
        }
    }
    
    public Silla asignarSilla( int tipo, int ubicacion, Cliente cliente)
    {
        
        Silla silla = null;
        if( tipo == Silla.SILLAS_VIP )
        {
            silla = buscarSillaVipLibre();
            reservas.add(silla);
        }
        else if(tipo == Silla.SILLAS_ECONOMICAS )
        {
            silla = buscarSillaEconomicaLibre( ubicacion );
            reservas.add(silla);
        }
        if( silla != null )
        {
            silla.asignarAcliente( cliente );
        }
        return silla;
    }
    
    public Silla asignarSilla( int tipo, int ubicacion, Cliente cliente, int lugar)
    {
        
        Silla silla = null;
        if( tipo == Silla.SILLAS_VIP )
        {
            this.obtenerSillasVip();
            for(int i =0; i < reservas.size(); i++){
                 Silla f = reservas.get(i);
                 
                 if(f.getNumero()!=lugar){
                     silla= this.buscarSillaVipLibre(lugar);
                     reservas.add(silla);
                     
                 }
                 
            
        }
            
        }
        else if(tipo == Silla.SILLAS_ECONOMICAS )
        {
            this.obtenerSillasEconomicas();
            for(int i =0; i < reservas.size(); i++){
                 Silla f = reservas.get(i);
                 
                 if(f.getNumero()!=lugar && lugar<9){
                     silla= this.buscarSillaEconomicaLibre(lugar);
                     reservas.add(silla);
                 }
            
        }
        }
        
        if( silla != null )
        {
            silla.asignarAcliente(cliente);
        }
        return silla;
    }
 
    
    
    public Silla buscarSillaVipLibre()
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_VIP && !encontrado; i++ )
        {
            silla = sillas_vip[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.getUbicacion( ) == 2 )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }
    
    public Silla buscarSillaVipLibre(int lugar)
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_VIP && !encontrado; i++ )
        {
            silla = sillas_vip[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.getUbicacion( ) == 2 && silla.getNumero()==lugar)
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
            if( ! ( silla.sillaAsignada( ) ) && silla.getUbicacion( ) == ubicacion  )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }
    
     public Silla buscarSillaEconomicaLibre( int ubicacion, int lugar)
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( ! ( silla.sillaAsignada( ) ) && silla.getUbicacion( ) == ubicacion && silla.getNumero()==lugar )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }
    
    

    
    public Silla buscarCliente(Cliente c)
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
            if( silla.sillaAsignada() && silla.getCliente( ).confirmarCliente(cliente ) )
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
            if( silla.sillaAsignada( ) && silla.getCliente( ).equals(cliente) )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    
    public boolean desasignarSilla(Cliente cliente)
    {
        
        Silla silla = buscarCliente(cliente);
        
        if( silla != null )
        {
            silla.desasignarSilla();
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
            if( sillasEconomicas[ i ].isDanada()==false)
            {
                contador++;
            }
        }
        for( int i = 0; i < SILLAS_VIP; i++ )
        {
            if( sillas_vip[ i ].isDanada()==false)
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

  
    public ArrayList<String> obtenerSillasVip( )
    {
        
        Silla silla = null;
        ArrayList<String> s=new ArrayList<>();
        for( int i = 0; i < SILLAS_VIP; i++ )
        {
            if(!( sillas_vip[ i ].sillaAsignada( ) ))
            {
                              silla = sillas_vip[ i ];
                int a=silla.getNumero();
                String b=a+"";
                s.add(b);
            }
           
            
        }
        return s;
    }

    
    public ArrayList<String> obtenerSillasEconomicas( )
    {
        Silla silla = null;
        ArrayList<String> s=new ArrayList<>();
        for( int i = 0; i < SILLAS_ECONOMICAS; i++ )
        {
 
            if(!( sillasEconomicas[ i ].sillaAsignada( ) ))
            {
                silla = sillasEconomicas[ i ];
                
               
                              
                int a=silla.getNumero();
                String b=a+"";
                s.add(b);
            }
           
            
        }
        return s;
    
    }

        
     public ArrayList<String> darSillasVacias()
    {
       Silla silla = null;
       ArrayList<String> s=new ArrayList<>();
       for( int i = 0; i < SILLAS_ECONOMICAS; i++ ){
           silla = sillasEconomicas[ i ];
           if( ! ( silla.sillaAsignada( ) ))
           {
               int a=silla.getNumero();
               String b=a+"";
               s.add(b);
           }
       }
       for( int i = 0; i < SILLAS_VIP ; i++ ){
           silla = sillas_vip[ i ];
           if( ( silla.sillaAsignada( ) ))
           {
               
               int a=silla.getNumero();
               String b=a+"";
               s.add(b);
           }
       }
        
        
               
        return s;
    }
     
    
}

    

