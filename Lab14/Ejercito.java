package Lab14;
import java.util.*;
public class Ejercito {
    private ArrayList<Soldado> soldados;
    private String nombre;
    
    public Ejercito (String n){
        nombre = n;
        soldados = new ArrayList<>();
    }
    public void agregarSoldado(Soldado miSoldado){
        if (soldados.size() < Soldado.MAX_CANTIDAD) {
            soldados.add(miSoldado);
        } 
        else {
            System.out.println("No es posible agregar más soldados, el ejército ha alcanzado su límite.");
        }
    }
}
