package Cinen;
import java.util.ArrayList;


public class Cartelera {
	
    public static ArrayList<String> cartelera(){
        ArrayList<String> pelis= new ArrayList<>();
        for(int i=0; i< Pelicula.peliculas.size();i++){
            Pelicula p = Pelicula.peliculas.get(i);
            
            String a="nombre: "+ p.getNombre()
			 +"\ndirector: "+ p.getDirector()
			   +"\naño: "+p.getAño()
                            +"\nduracion: "+p.getDuracion()
                              +"\ngenero: "+p.getGenero()
                                +"\npais: "+p.getPais()
                                 +"\n------------------------" + 
                                   "\n";
            pelis.add(a);
            
            
                                   
            
        }
        return pelis;
            
        
        
    
    
}
}