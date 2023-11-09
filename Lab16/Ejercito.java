package Lab16;
import java.util.*;
public final class Ejercito {
    public static final int MAX_CANTIDAD = 10;//Constante de Clase
    private static int cantidadEjercitos = 0;
    private int cantidadSoldados;
    private int nivelVidaTotal;
    private Reino reino;
    private ArrayList <Soldado> soldados = new ArrayList<>();

    public Ejercito() {
        cantidadSoldados = (int)(Math.random()*10+1);
        for (int i=0; i<cantidadSoldados; i++){
            Soldado nuevoSoldado = new Soldado(); //Constructor incializa el atributo vid actual [0,5]
            agregarSoldado(nuevoSoldado);
            nivelVidaTotal += nuevoSoldado.getVidaActual();
        }
        cantidadEjercitos++;
    }   
    public int getCantidadEjercitos() {
        return cantidadEjercitos;
    }
    public void setReino(Reino reino) {
        this.reino = reino;
    }    
    public Reino getReino(){
        return reino;
    }  
    public double getNivelVidaTotal(){
        return nivelVidaTotal;
    }
    public void agregarSoldado(Soldado unSoldado) {
          soldados.add(unSoldado);
    }
 
}
