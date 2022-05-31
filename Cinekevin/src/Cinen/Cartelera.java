package Cinen;
import java.util.ArrayList;


public class Cartelera {
  private ArrayList<Pelicula> pelis= new ArrayList<>();
  
  public Cartelera(ArrayList<Pelicula> pelis){
    this.pelis = pelis;
  }

  public ArrayList<Pelicula> getPelis() {
    return pelis;
  }

  public void cambiarPelicula(String nombre) {
    ArrayList<Pelicula> varCartelera;
    varCartelera = this.getPelis();}


  /*
  public static ArrayList<String> imprimirCartelera(Cartelera Cart){
    ArrayList<String> pelis= new ArrayList<>();
    ArrayList<Pelicula> peliculas = new ArrayList<>();
    peliculas = Cart.getPelis();
    for(int i=0; i< Pelicula.peliculas.size();i++
        Pelicula p = Pelicula.peliculas.get(i);
        
        String a="nombre: "+ p.getNombre()
   +"\ndirector: "+ p.getDirector()
     +"\nano: "+p.getAno()
                        +"\nduracion: "+p.getDuracion()
                          +"\ngenero: "+p.getGenero()
                            +"\npais: "+p.getPais()
                             +"\n------------------------" + 
                               "\n";
        pelis.add(a);
        
        
                               
        
    }
    return pelis;*/
    
  
  
        
    
    
}