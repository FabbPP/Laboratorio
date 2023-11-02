package Lab14;
import java.util.*;
public class Reino {
    private String nombre;
    private ArrayList<Ejercito> ejercitos;
    
    public Reino (String n){ //Constructor
        nombre = n;
    }
    public String getNombre(){
        return nombre;
    }
    public void agregarEjercito(Ejercito ejercito){
        ejercitos.add(ejercito);
    }

}
