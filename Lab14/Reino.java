package Lab14;
import java.util.*;
public class Reino {
    private static final int CANTIDAD_REINOS = 2;
    private String nombre;
    private ArrayList<Ejercito> ejercitos;
    
    public Reino(){ //Constructor
        
    }
    public Reino (String n){ //Constructor overloaded
        nombre = n;
        ejercitos = new ArrayList<>();  
    }
    public String getNombre(){
        return nombre;
    }
    public void agregarEjercito(Ejercito ejercito){
        ejercitos.add(ejercito);
    }
    public ArrayList<Ejercito> getEjercitos() { //Metodo que accede al grupo de ejercitos
        return ejercitos;
    }
}
