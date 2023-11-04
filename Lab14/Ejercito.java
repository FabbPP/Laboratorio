package Lab14;
import java.util.*;
public class Ejercito {
    private static int cantidadEjercitos = 0;
    private String nombre;
    private Reino reino;
    private ArrayList<Soldado> soldados;

    public Ejercito(String n) {
        nombre = n;
        this.soldados = new ArrayList<>();
        cantidadEjercitos++;
    }
    public int getCantidadEjercitos() {
        return cantidadEjercitos;
    }
    public void agregarSoldado(ArrayList<ArrayList<Soldado>> arrL, ArrayList orden,String nombre, int nivelAtaque, int nivelDefensa, int velocidad, String actitud, boolean vive,int fil,int col) {
        if (soldados.size() < Soldado.MAX_CANTIDAD) {       
            Soldado nuevoSoldado = new Soldado(nombre, this, nivelAtaque, nivelDefensa, velocidad, actitud, vive,(fil+1));
            nuevoSoldado.setColumna(col+1);
            arrL.get(fil).set(col, nuevoSoldado);
            orden.add(nuevoSoldado);
            soldados.add(nuevoSoldado);
        } 
        else 
            System.out.println("No es posible agregar más soldados, el ejército ha alcanzado su límite."); 
    }
    public void eliminarSoldado(Soldado unSoldado) {
        if (soldados.contains(unSoldado)) 
            soldados.remove(unSoldado);
        else 
            System.out.println("El soldado no pertenece a este ejército.");
        
    }
    public int getCantidadSoldados() { //IMPORTANTE RECUPERA CANTIDAD DE SOLDADOS POR EJERCITO
        return soldados.size();
    }
    public boolean esEjercitoVacio(){
        return (soldados.isEmpty());
    }
    public void setReino(Reino reino) {
        this.reino = reino;
    }
    public Reino getReino(){
        return reino;
    }   
}
