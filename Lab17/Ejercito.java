package Lab17;
import java.util.*;
public final class Ejercito {
    public static final int MAX_CANTIDAD = 10;//Constante de Clase
    private static int cantidadEjercitos = 0;
    private String nombre;
    private int fila;
    private int columna;
    private String columnaStr;
    private Reino reino;
    private ArrayList <Soldado> soldados = new ArrayList<>();
    private int cantidadSoldados;
    private int nivelVidaTotal;
    
    public Ejercito() {
        cantidadSoldados = (int)(Math.random()*10+1);
        for (int i=0; i<cantidadSoldados; i++){
            Soldado nuevoSoldado = new Soldado(); //Constructor incializa el atributo vid actual [0,5]
            agregarSoldado(nuevoSoldado);
            nivelVidaTotal += nuevoSoldado.getVidaActual();
        }
        nombre = ("Ejercito "+cantidadSoldados+"-"+nivelVidaTotal);
        cantidadEjercitos++;
    }
    public static int getCantidadEjercitos() {
        return cantidadEjercitos;
    } 
    public void agregarSoldado(Soldado unSoldado) {
        soldados.add(unSoldado);
    }       
    public String getNombre(){
        return nombre;
    }
    public Ejercito setFila(int fil){ //Method-call chaining
        fila = fil;
        return this;
    }
    public int getFila(){
        return fila;
    }
    public void setColumna(int col){
        columna = col;
        switch (columna){
            case 1: 
                columnaStr = "A";
                break;
            case 2: 
                columnaStr = "B";
                break;
            case 3:
                columnaStr = "C";
                break;
            case 4: 
                columnaStr = "D";
                break;
            case 5: 
                columnaStr = "E";
                break;
            case 6: 
                columnaStr = "F"; 
                break;
            case 7: 
                columnaStr = "G"; 
                break;
            case 8: 
                columnaStr = "H"; 
                break;
            case 9: 
                columnaStr = "I"; 
                break;
            case 10: 
                columnaStr = "J"; 
                break;
        }
    }
    public int getColumna(){
        return columna;
    }
    public String getColumnaStr(){
        return columnaStr;
    }
    public ArrayList <Soldado> getSoldados(){
        return soldados;
    }
    public int getCantidadSoldados(){
        return soldados.size();
    }
    public void setReino(Reino reino) {
        this.reino = reino;
    }    
    public Reino getReino(){
        return reino;
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
