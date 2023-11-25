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
    public void mostrarDatosSoldados(){ //Mostrara en el orden que fueron creados, el array esta en orden de creacion
        for (Soldado unSoldado : soldados){
            unSoldado.mostrarDatos();
        }
    }
    public void mostrarRankingDePoder(){ 
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < soldados.size(); i++) {
            indices.add(i);
        }
        int temp;
        for (int i = 0; i < soldados.size() - 1; i++) {
            for (int j = 0; j < soldados.size() - i - 1; j++) {
                if (soldados.get(j) != null) {
                    int ant = soldados.get(indices.get(j)).getVidaActual();
                    int pos = soldados.get(indices.get(j + 1)).getVidaActual();
                    if (ant < pos) {
                        temp = indices.get(j);
                        indices.set(j, indices.get(j + 1));
                        indices.set(j + 1, temp);
                    }
                }
            }
        }
        System.out.println("RANKING DE PODER POR ORDENAMIENTO BURBUJA...");
        
        for (int i = 0; i < soldados.size(); i++) {
            int index = indices.get(i);
            Soldado soldado = soldados.get(index);
            System.out.println((i + 1) + ".- " + soldado.getNombre() + "/ salud: " + soldado.getVidaActual());
        }
    }
}