package Lab18;
import java.util.*;
public final class Ejercito {
    public static final int MAX_CANTIDAD = 10;//Constante de Clase
    private static int cantidadEjercitos = 0;
    private String nombre;
    private ArrayList <Soldado> soldados = new ArrayList<>();
    private ArrayList <Soldado> caballeros = new ArrayList<>();
    private ArrayList <Soldado> espadachines = new ArrayList<>();
    private ArrayList <Soldado> arqueros = new ArrayList<>();
    private int cantidadSoldados;
    private int nivelVidaTotal;
    
    public Ejercito(int num) {
        int cantidadCaballeros = 0,cantidadEspadachin = 0,cantidadArquero = 0;
        Caballero nuevoCaballero;
        cantidadSoldados = (int)(Math.random()*10+1); //Define la cantidad de soldados aleatorios
        while(getCantidadSoldados()<= cantidadSoldados){
            int existenciaC = existencia(); //Creacion Caballero
            if (existenciaC == 1){
                nuevoCaballero = new Caballero();
                
            }
            if (cantidadCreados == cantidadSoldados)
                break;
            cantidadEspadachin += (int)(Math.random());
            cantidadCreados++;
            if (cantidadCreados == cantidadSoldados)
                break;
            cantidadArquero += (int)(Math.random());
            cantidadCreados++;
            if (cantidadCreados == cantidadSoldados)
                break;
        }
            Soldado nuevoSoldado = new Soldado("Caballero"); //Constructor incializa el atributo vid actual [0,5]
            agregarSoldado(nuevoSoldado);
            nivelVidaTotal += nuevoSoldado.getVidaActual();
        
        nombre = (Integer.toString(num));
        cantidadEjercitos++;
    }
    public static int getCantidadEjercitos() {
        return cantidadEjercitos;
    } 
    public int existencia(){
        return (int)(Math.random()*2);
    }
    public void agregarSoldado(Soldado unSoldado) {
        soldados.add(unSoldado);
    }       
    public String getNombre(){
        return nombre;
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