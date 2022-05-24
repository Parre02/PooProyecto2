package Cinen;

import java.util.ArrayList;
import java.util.Scanner;



public class Sala {
    
    public final static int SILLAS_VIP = 8;

    public final static int SILLAS_ECONOMICAS = 42;
    
    private Silla[] sillas_vip;
    
    private Silla[] sillasEconomicas;
    
    public static Administrador admin=new Administrador("", 1,2);
    
    
    
    
    public ArrayList<Silla> reservas=new ArrayList<>();
    
    

    
    public Sala( )
    {
        int ubicacion;

        //cantidad de sillas vip que vamos a tener en la sala
        sillas_vip = new Silla[SILLAS_VIP];

        //cantidad de sillas economicas que vamos a tener en la sala
        sillasEconomicas = new Silla[SILLAS_ECONOMICAS];
        
        
        //asiganamos cuales van el numero que van ser las sillas  vip, sus atributos
        sillas_vip[ 0 ] = new Silla( 1, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 1 ] = new Silla( 2, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 2 ] = new Silla( 3, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 3 ] = new Silla( 4, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 4 ] = new Silla( 5, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 5 ] = new Silla( 6, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 6 ] = new Silla( 7, Silla.SILLAS_VIP, Silla.CENTRAL );
        sillas_vip[ 7 ] = new Silla( 8, Silla.SILLAS_VIP, Silla.CENTRAL );

        
        //luego vamos a distribuir la ubicacion de las sillas
        for( int numSilla = 1 + SILLAS_VIP, j = 1; j <= SILLAS_ECONOMICAS; numSilla++, j++ )
        {
            //la ubicacion del lateral derecho, esto es un ejemplo podemos cambiarlo
            if( j % 6 == 1 || j % 6 == 0 ){
                ubicacion = Silla.LATERAL_DERECHO;
                
            
            }else if( j % 6 == 2 || j % 6 == 5 ){
                ubicacion = Silla.CENTRAL;
                               
          
                
            
            }else{
                ubicacion = Silla.LATERAL_IZQUIERDO;
                
            }

            sillasEconomicas[ j - 1 ] = new Silla( numSilla, Silla.SILLAS_ECONOMICAS, ubicacion );
        }
    }
    
    
    //asiganmos la silla el tipo, la ubicacion y el cliente
    public Silla asignarSilla( int tipo, int ubicacion, Cliente cliente)
    {
        
        Silla silla = null;
        if( tipo == Silla.SILLAS_VIP )
        {
            Scanner lugares = new Scanner(System.in);
            int numeroSilla = 0;
            System.out.print(this.obtenerSillasVip()+"\n\"Escoge una silla: ");
            numeroSilla = lugares.nextInt();
            silla = buscarSillaVipLibre(numeroSilla);
            reservas.add(silla);
            this.descuento(cliente, this, 1);
        }
        else if(tipo == Silla.SILLAS_ECONOMICAS)
        {   
            Scanner lugares = new Scanner(System.in);
            int numeroSilla = 0;
            
            if (ubicacion==1) {
                System.out.print(this.lateral_D()+"\n\"Escoge una silla: ");
                numeroSilla = lugares.nextInt();
                silla = this.buscarSillaEconomicaLibre(1,numeroSilla);
                reservas.add(silla);
                this.descuento(cliente, this, 2);
                }
            else if(ubicacion==2) {
                System.out.print(this.Central()+"\n\"Escoge una silla: ");
                numeroSilla = lugares.nextInt();
                silla = this.buscarSillaEconomicaLibre(2,numeroSilla);
                reservas.add(silla);
                this.descuento(cliente, this, 2);
                }
            else {
                System.out.print(this.lateral_I()+"\n\"Escoge una silla: ");
                numeroSilla = lugares.nextInt();
                silla = this.buscarSillaEconomicaLibre(3,numeroSilla);
                reservas.add(silla);
                this.descuento(cliente, this, 2);
                }
            }
            
            
          
        if( silla != null )
        {
            silla.asignarAcliente(cliente );
        }
        return silla;
    }
    
    
    //buscamos los clientes antiguos que seran almacenados en la reserva
    public Cliente buscarClienteEnLAreserva( Cliente cliente)
    {
        
        Silla silla = null;
        for(int i =0; i < reservas.size(); i++){
                 Silla f = reservas.get(i);
                 
                 if(f.getCliente()!=cliente){
                     silla= null;                   
                  }else{
                     silla=f;
                 }             
           }
            if( silla != null )
        {
            return silla.getCliente();
            
        }
            else{
                return null;
            }
    }
            
        
        
 
    
    
    
    //buscamos un silla libre vip que esta libre
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
    
    
    
    
    
    
    //aqui buscamos la silla pero cteniendo en cuenta el numero de la silla que es lugar
    public Silla buscarSillaVipLibre(int lugar)
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_VIP && !encontrado; i++ )
        {
            silla = sillas_vip[ i ];
            if( ( silla.sillaAsignada( )==false ) && silla.getUbicacion( ) == 2){
                if(silla.getNumero()==lugar)
            
                    
            {
                encontrado = true;
            }
            }
        }
        if( encontrado )
            return silla;
        else
            return null;
    }

    
    
    //buscamos sillas economicas con el tipo si es central, lado izquierdo o derecho 
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
    
    
    
    
     //buscamos sillas economicas con el tipo si es central, lado izquierdo o derecho  teniendo en cuenta el numero de la silla
     public Silla buscarSillaEconomicaLibre( int ubicacion, int lugar)
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ )
        {
            silla = sillasEconomicas[ i ];
            if( ( silla.sillaAsignada( )==false ) && silla.getUbicacion( ) == ubicacion )
                
            {
                encontrado = true;
            }
        }
    
        if( encontrado )
            return silla;
        else
            return null;
    }
    
    
     
     //buscamos la silla dañada, aqui tambien podemos ver el dueño de la silla
      public Silla buscarSillaDanada()
    {
        boolean encontrado = false;
        Silla silla = null;
        for( int i = 0; i < SILLAS_ECONOMICAS && !encontrado; i++ ){
           silla = sillasEconomicas[ i ];
           if((silla.isDanada()==true))
           {
               encontrado=true;
           }
       }
       for( int i = 0; i < SILLAS_VIP ; i++ ){
           silla = sillas_vip[ i ];
           if(( silla.isDanada( )==true))
           {
               
               encontrado=true;
       }
          
       }
       
        if( encontrado )
            return silla;
        else
            return null;
    }
    
     
    
     //aqui buscaremos el cliente y nos retornara la silla donde esta ubicada, este lo utilizamos en otros metodos cuando 
     //no conocemos si es vip o economico
     
    public Silla buscarCliente(Cliente c)
    {
        
        Silla silla = buscarClienteVip( c);
        
        if( null == silla )
            
            silla = buscarClienteEconomico(c);
        return silla;

    }



//buscamos el cliente vip y que nos retorne la silla donde esta ubicado    
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

    
    
    //buscamos el clleinte que economico y nos dara la silla en donde esta asiganddo
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

    
    
    //le quitamos la asigancion a un cliente y nos retornara true si esta desigando
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

    
    
    //metodo por codicia jajajaj puesto por si alguna vez lo utlizamos 
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
    
    
    
    //igual por codicia pero pues de pronto lo utlicemos mas que el antaerior 
    public int contarSillasDanadas( )
    {
        int contador = 0;
        for( int i = 0; i < SILLAS_ECONOMICAS;  i++ )
        {
            if( sillasEconomicas[ i ].isDanada()==true)
            {
                contador++;
            }
        }
        for( int i = 0; i < SILLAS_VIP; i++ )
        {
            if( sillas_vip[ i ].isDanada()==true)
            {
                contador++;
            }
        }
        return contador;
    }
   
    
    //arreglamos las sillas dñadas
    public String arreglarSillasDanadas( )
    {
        Silla silla=this.buscarSillaDanada();
        if (silla==null){
            silla.setDanada(false);
            return "Se arreglo la silla";
        }else{
            return "No hay sillas dañadas ";
        }
                      
    }
       

    //mas codicia 
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
    
    
    

  //pense que podria sevir para algo pero no es muy importante
    public double calcularPorcentajeOcupacion( )
    {
        double porcentaje;
        int totalSillas = SILLAS_ECONOMICAS + SILLAS_VIP;
        int sillasOcupadas = contarSillasEconomicasOcupadas( ) + contarSillasVipOcupadas( );
        porcentaje = ( double )sillasOcupadas / totalSillas * 100;
        return porcentaje;
    }

    
    
    
  //importante nos da las sillas ocupadas en un array que estan libres
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

//importante nos da el numero de sillas en un array disponobles    
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

        
    
    //nos da las sillas vacias importante
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
     
 //Lista de las sillas disponibles de la lateral derecho economicas      
    public ArrayList<String> lateral_D()
    {
       Silla silla = null;
       ArrayList<String> s=new ArrayList<>();
       for( int i = 0; i < SILLAS_ECONOMICAS; i++ ){
           silla = sillasEconomicas[ i ];
           if( ! ( silla.sillaAsignada( ) ) && silla.getUbicacion( ) == 1  )
            {
               int a=silla.getNumero();
               String b=a+"";
               s.add(b);
           }
       
       }              
        return s;
    }
    
//Lista de las sillas disponibles de la lateral izqueido economicas       
    public ArrayList<String> lateral_I()
    {
       Silla silla = null;
       ArrayList<String> s=new ArrayList<>();
       for( int i = 0; i < SILLAS_ECONOMICAS; i++ ){
           silla = sillasEconomicas[ i ];
           if( ! ( silla.sillaAsignada( ) ) && silla.getUbicacion( ) == 3  )
            {
               int a=silla.getNumero();
               String b=a+"";
               s.add(b);
           }
       
       }              
        return s;
    }
    
//Lista de las sillas disponibles de la central economicas    
    public ArrayList<String> Central()
    {
       Silla silla = null;
       ArrayList<String> s=new ArrayList<>();
       for( int i = 0; i < SILLAS_ECONOMICAS; i++ ){
           silla = sillasEconomicas[ i ];
           if( ! ( silla.sillaAsignada( ) ) && silla.getUbicacion( ) == 2  )
            {
               int a=silla.getNumero();
               String b=a+"";
               s.add(b);
           }
       
       }              
        return s;
    }
     
     
      
            
     
     
     //busca el cliente por cedula de los que han hechos reservas
     public Cliente buscarCliente(int cedula)
    {
        boolean encontrado = false;
        Silla f=null;
        for(int i =0; i < this.reservas.size(); i++ )
        {
            f = this.reservas.get(i);
            if(f.getCliente().getCedula()==cedula )
            {
                encontrado = true;
            }
        }
        if( encontrado )
            return f.getCliente();
        else
            return null;
    }
     
     public void descuento(Cliente cliente,Sala sala, int tipo){
        
        Silla silla=null;
        
        if (tipo==silla.SILLAS_ECONOMICAS){    //aqui asignamos que si la silla va ser vip o economica
            silla=sala.buscarSillaEconomicaLibre(tipo);
        }
        if (tipo==silla.SILLAS_VIP){
            silla=sala.buscarSillaVipLibre();
        }
        
        
        silla.asignarAcliente(cliente);//es importante 
        
        double preciovip=25.000;
        double precioEco=15.000;        
        String a="";
        boolean descuento=false; 
        
        
        if(sala.buscarClienteEnLAreserva(cliente)!=null){               //---->vemos si el cliente ha sido cliente antiguo y si es asi le aplica el descuento del 10%
            if (sala.buscarClienteEnLAreserva(cliente)==cliente){
                descuento=true;
            }
        }
        
        
        
        if ((descuento) && silla.getTipo()== silla.SILLAS_VIP){ //--------> si el cliente ha elegido la opcion de vip  
                                                                        
           preciovip=preciovip-(preciovip*0.10);//----->le aplica el descuento
           a=preciovip+"";
           
        
           
        }else if((descuento) && silla.getTipo()== silla.SILLAS_ECONOMICAS){//lo mismo pero con el cliente economico 
           
            precioEco=precioEco-(precioEco*0.05);//descuento de 5%
           a=precioEco+"";
           
        }
        
        //ahora vemos los que no han sido clientes
        
        if (!(descuento ) && silla.getTipo()== silla.SILLAS_VIP){
            
           
           a=preciovip+"";
           
          
        }else if(!(descuento) && silla.getTipo()== silla.SILLAS_ECONOMICAS){
           
            
           a=precioEco+"";
           
        }
            
                
         System.out.println("Valor de la silla: " +a);
        
    }
     
    
}

    

