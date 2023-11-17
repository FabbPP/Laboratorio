package Lab19;
import java.util.*;
public final class Ejercito {
    public static final int MAX_CANTIDAD = 10;//Constante de Clase
    private static int cantidadEjercitos = 0;
    private String nombre;
    private String color;
    private ArrayList <Soldado> soldados = new ArrayList<>();
    private ArrayList <Soldado> caballeros = new ArrayList<>();
    private ArrayList <Soldado> espadachines = new ArrayList<>();
    private ArrayList <Soldado> arqueros = new ArrayList<>();
    private int cantidadSoldados;
    private int nivelVidaTotal;
    
    public Ejercito(int num) {
        cantidadSoldados = (int)(Math.random()*10+1); //Define la cantidad de soldados aleatorios
        nombre = (Integer.toString(num));
        cantidadEjercitos++;
    }
    public static int getCantidadEjercitos() {
        return cantidadEjercitos;
    } 
    public int existencia(){ //secundario en constructor
        return (int)(Math.random()*2);
    }
    public void agregarSoldado(Soldado unSoldado) {
        soldados.add(unSoldado);
    }    
    public void agregarCaballero(Caballero unCaballero){
        caballeros.add(unCaballero);
        soldados.add(unCaballero);
    }
    public void agregarEspadachin(Espadachin unEspadachin){
        caballeros.add(unEspadachin);
        soldados.add(unEspadachin);
    }
    public void agregarArquero(Arquero unArquero){
        caballeros.add(unArquero);
        soldados.add(unArquero);
    }
    public String getNombre(){
        return nombre;
    }
    public void setColor(String c){
        color = c;
    }
    public String getColor(){
        return color;
    }
    public ArrayList <Soldado> getSoldados(){
        return soldados;
    }
    public int getCantidadSoldados(){
        return soldados.size();
    }
    public int getNivelVidaTotal(){
        return nivelVidaTotal;
    }
    public void bonificacionXvencida(){
        for (Soldado soldado : soldados){
            soldado.setVidaActual(soldado.getVidaActual()+1);
        }
    }
}