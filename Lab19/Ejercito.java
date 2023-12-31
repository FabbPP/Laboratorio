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
    private int cantidadSoldadosCrear;
    private int nivelVidaTotal;
    
    public Ejercito(int num) {
        cantidadSoldadosCrear = (int)(Math.random()*10+1); //Define la cantidad de soldados aleatorios
        nombre = (Integer.toString(num));
        cantidadEjercitos++;
    }   
    public void agregarSoldado(Soldado unSoldado) {
        soldados.add(unSoldado);
    }    
    public void eliminarSoldado(Soldado unSoldado){
        soldados.remove(unSoldado);
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
    public int getCantidadSoldadosCrear(){
        return cantidadSoldadosCrear;
    }
    public int getCantidadSoldados(){
        return soldados.size();
    }
    public int getNivelVidaTotal(){
        return nivelVidaTotal;
    }
    public boolean esEjercitoVacio(){
        return (soldados.isEmpty());
    }
    public void mostrarColores(Ejercito otroEjercito){
        this.setColor("rojo");
        otroEjercito.setColor("azul");
        System.out.println("EJERCITOS: "+"Ejercito 1\t Ejercito 2");
        System.out.println("COLOR:  "+this.getColor()+"\t\t"+otroEjercito.getColor());
        System.out.println("NUM:    "+this.getCantidadSoldados()+"\t\t"+otroEjercito.getCantidadSoldados());
    }
    
}