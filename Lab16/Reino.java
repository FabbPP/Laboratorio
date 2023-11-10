package Lab16;
import java.util.*;
public class Reino {
    private static final int CANTIDAD_REINOS = 2;
    public static final String[] NOMBRES_DE_REINOS = {"Inglaterra", "Francia", "Sacro Imperio", "Castilla Aragon", "Moros"};
    private String nombre;
    private ArrayList <Ejercito> ejercitos = new ArrayList<>();
    private ArrayList <Soldado> soldados = new ArrayList<>();
    private String color;
    
    public Reino (String n){ 
        nombre = n;
        ejercitos = new ArrayList<>();  
    }
    public void setColor (String c){
        color = c;
    }
    public String getNombre(){
        return nombre;
    }
    public String getColor(){
        return color;
    }
    public ArrayList<Ejercito> getEjercitos() { //Metodo que accede al grupo de ejercitos
        return ejercitos;
    }

    public int getCantidadEjercitos(){
        return ejercitos.size();
    }
    public void agregarEjercito(Ejercito ejercito){
        ejercitos.add(ejercito);
    }
    public boolean contieneEjercito(Ejercito e){
        return ejercitos.contains(e); //ejercitos es el arraylist que contiene todo 
    }
    public boolean esReinoVacio (){
        return (ejercitos.isEmpty());
    }
}
