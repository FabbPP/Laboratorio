package Lab22;
import java.util.*;
public final class Ejercito {
    public static final int MAX_CANTIDAD = 10;//Constante de Clase
    private static int cantidadEjercitos = 0;
    private String nombre;
    private String color;
    private ArrayList <Soldado> soldados = new ArrayList<>();
    private ArrayList <Soldado> arqueros = new ArrayList<>();
    private ArrayList <Soldado> caballeros = new ArrayList<>();
    private ArrayList <Soldado> lanceros = new ArrayList<>();
    private ArrayList <Soldado> espadachines = new ArrayList<>();
    private ArrayList <Soldado> unidadesEspeciales = new ArrayList<>();

    private int cantidadSoldadosCrear;
    private double nivelVidaTotal = 0;
    private Reino reino;
    
    public Ejercito(int num,Reino unReino, String unColor) {
        cantidadSoldadosCrear = (int)(Math.random()*10+1); //Define la cantidad de soldados aleatorios
        nombre = unReino.getNombre();
        cantidadEjercitos++;
        reino = unReino;
        color = unColor;
    }   
    public void agregarSoldado(Soldado unSoldado) {
        soldados.add(unSoldado);
        switch(unSoldado.tipoDeSoldado){
            case ("Arquero"):
                arqueros.add(unSoldado);
                break;
            case ("Caballero"):
                caballeros.add(unSoldado);
                break;
            case ("Lancero"):
                lanceros.add(unSoldado);
                break;
            case ("Espadachin"):
                espadachines.add(unSoldado);
                break;
            default :
                unidadesEspeciales.add(unSoldado);
        }
        nivelVidaTotal += unSoldado.getVidaActual();
    }    
    public void eliminarSoldado(Soldado unSoldado){
        soldados.remove(unSoldado);
        switch(unSoldado.tipoDeSoldado){
            case ("Arquero"):
                arqueros.remove(unSoldado);
                break;
            case ("Caballero"):
                caballeros.remove(unSoldado);
                break;
            case ("Lancero"):
                lanceros.remove(unSoldado);
                break;
            case ("Espadachin"):
                espadachines.remove(unSoldado);
                break;
        }
        nivelVidaTotal -= unSoldado.getVidaActual();
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
    public Reino getReino(){
        return reino;
    }
    public double getNivelVidaTotal(){
        return nivelVidaTotal;
    }
    public void mostrarColores(Ejercito otroEjercito){
        System.out.println("EJERCITOS: "+"Ejercito 1\t Ejercito 2");
        System.out.println("COLOR:  "+this.getColor()+"\t\t"+otroEjercito.getColor());
        System.out.println("NUM:    "+this.getCantidadSoldados()+"\t\t"+otroEjercito.getCantidadSoldados());
    }
    public boolean esEjercitoVacio(){
        return (soldados.isEmpty());
    }
    public void mostrarInformacion(int i){
        System.out.println("Ejercito "+i+": "+ nombre);
        System.out.println("Cantidad Total de soldados: "+ soldados.size());
        System.out.println("Espadachines: "+ espadachines.size());
        System.out.println("Arqueros: "+ arqueros.size());
        System.out.println("Caballeros: "+ caballeros.size());
        System.out.println("Lanceros: "+ lanceros.size());
        if (unidadesEspeciales.size() > 0)
            System.out.println(unidadesEspeciales.get(0).getTipoDeSoldado()+":"+ unidadesEspeciales.size());
        else
            System.out.println("Sin unidades especiales");
    }
    public void mostrarDatosSoldados(){ //Mostrara en el orden que fueron creados, el array esta en orden de creacion
        System.out.println("--> Lista de Soldados: ");
        for (Soldado unSoldado : soldados){
            unSoldado.mostrarDatos();
        }
    }
    public void mostrarDatosMayorVida(){ 
        System.out.println("--> Soldado CON MAYOR VIDA...");
        int indiceSoldadoMaxVida = 0;
        int maxVida = soldados.get(0).getVidaActual();
        for (int i = 0; i< soldados.size(); i++){
            Soldado soldado = soldados.get(i);
            if (maxVida < soldado.getVidaActual()){
                maxVida = soldado.getVidaActual();
                indiceSoldadoMaxVida = i;
            }
        }
        soldados.get(indiceSoldadoMaxVida).mostrarDatos();
    }
    public double getPromedioNivelVida(){
        return nivelVidaTotal/soldados.size();
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
        System.out.println("--> Ranking de poder:");
        for (int i = 0; i < soldados.size(); i++) {
            int index = indices.get(i);
            Soldado soldado = soldados.get(index);
            System.out.println((i + 1) + ".- " + soldado.getNombre() + "/ salud: " + soldado.getVidaActual());
        }
    }
}