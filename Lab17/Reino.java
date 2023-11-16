package Lab17;
import java.util.*;
public class Reino {
    private static final int CANTIDAD_REINOS = 2;
    public static final String[] NOMBRES_DE_REINOS = {"Inglaterra", "Francia", "Sacro_Imperio", "Castilla_Aragon", "Moros"};
    private static int totalVidaReino = 0;
    private String nombre;
    private ArrayList <Ejercito> ejercitos = new ArrayList<>();
    private ArrayList <Soldado> soldados = new ArrayList<>();
    private String color;
    
    public Reino (String n){ 
        nombre = n;
        ejercitos = new ArrayList<>();  
    }
    public int getTotalVidaReino(){
        return totalVidaReino;
    }
    public void agregarEjercito(Ejercito unEjercito){
        ejercitos.add(unEjercito);
        totalVidaReino += unEjercito.getNivelVidaTotal();
    }
    public void eliminarEjercito(Ejercito unEjercito){
        ejercitos.remove(unEjercito);
    }
    public ArrayList<Ejercito> getEjercitos() { //Metodo que accede al grupo de ejercitos
        return ejercitos;
    }
    public int getCantidadEjercitos(){
        return ejercitos.size();
    }
    public ArrayList<Soldado> getSoldados(){
        return soldados;
    }
    public int getCantidadSoldados(){
        return soldados.size();
    }
    public String getNombre(){
        return nombre;
    }   
    public void setColor (String c){
        color = c;
    }
    public String getColor(){
        return color;
    }
    public boolean esReinoVacio (){
        return (ejercitos.isEmpty());
    }
    public boolean contieneEjercito(Ejercito e){
        return ejercitos.contains(e); //ejercitos es el arraylist que contiene todo 
    }
    public void mostrarColores(Reino otroReino){
        System.out.println("REINOS: "+ nombre+"\t\t"+otroReino.getNombre());
        System.out.println("COLOR:  "+color+"\t\t"+otroReino.getColor());
        System.out.println("NUM:    "+this.getCantidadEjercitos()+"\t\t"+otroReino.getCantidadEjercitos());
    }
}