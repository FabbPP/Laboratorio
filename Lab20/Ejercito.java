package Lab20;
import java.util.*;
public final class Ejercito {
    public static final int MAX_CANTIDAD = 10;//Constante de Clase
    private static int cantidadEjercitos = 0;
    private String nombre;
    private String color;
    private ArrayList <Soldado> soldados = new ArrayList<>();
    private int cantidadSoldadosCrear;
    private double nivelVidaTotal = 0;
    private double promedioNivelVidaTotal;
    
    public Ejercito(int num) {
        cantidadSoldadosCrear = (int)(Math.random()*10+1); //Define la cantidad de soldados aleatorios
        nombre = (Integer.toString(num));
        cantidadEjercitos++;
    }   
    public void agregarSoldado(Soldado unSoldado) {
        soldados.add(unSoldado);
        nivelVidaTotal += unSoldado.getVidaActual();
    }    
    public void eliminarSoldado(Soldado unSoldado){
        soldados.remove(unSoldado);
    }
    public void agregarCaballero(Caballero unCaballero){
        soldados.add(unCaballero);
    }
    public void agregarEspadachin(Espadachin unEspadachin){
        soldados.add(unEspadachin);
    }
    public void agregarArquero(Arquero unArquero){
        soldados.add(unArquero);
    }
    public void agregarLancero(Lancero unLancero){
        soldados.add(unLancero);
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
    public double getNivelVidaTotal(){
        return nivelVidaTotal;
    }
    public double getPromedioNivelVidaTotal(){
        return nivelVidaTotal/soldados.size();
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