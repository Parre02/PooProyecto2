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



  public static ArrayList<String> imprimirCartelera(Cartelera Cart){
    ArrayList<String> pelis= new ArrayList<>();
    ArrayList<Pelicula> peliculas = new ArrayList<>();
    peliculas = Cart.getPelis();
    for(int i=0; i< peliculas.size();i++){
        Pelicula p = peliculas.get(i);
        
        String a="Nombre: "+ p.getNombre()
   +"\nDirector: "+ p.getDirector()
     +"\nAno: "+p.getAno()
                        +"\nDuracion: "+p.getDuracion()
                          +"\nGenero: "+p.getGenero()
                            +"\nPais: "+p.getPais()
                             +"\n------------------------" + 
                               "\n";
        pelis.add(a);            
    }
    for (int index = 0; index <pelis.size(); index++) {
      System.out.println(pelis.get(index));
    }
    return pelis;}

  public boolean confirmarPelicula(Cartelera cart, String busqueda){
    boolean varConfirmarPelicula = false;
    ArrayList<Pelicula> varPeliculas = new ArrayList<>();
    varPeliculas = cart.getPelis();
    busqueda= busqueda.toLowerCase();


      
    for (int i = 0; i < varPeliculas.size(); i++) {
      String varNombre = varPeliculas.get(i).getNombre().toLowerCase();
    
      if (varNombre == busqueda) {
        varConfirmarPelicula = true;
        break;
      } else {
       varConfirmarPelicula = false;
        
        
      }
      
    }
    return varConfirmarPelicula;
  }
    
  
  
        
    
    
}