package Lab18;
public class Soldado {
    public static final int MAX_CANTIDAD = 10;//Constante de Clase
    private static int cantidadTotal = 0; //Variable de Clase
    private String tipoDeSoldado;
    private int fila;
    private int columna;
    private String columnaStr;
    private Ejercito ejercito; 
    private String nombre;
    private double vidaActual;

    public Soldado(String tipoDeSoldado){  //Constructor
        int random = 0;
        this.tipoDeSoldado = tipoDeSoldado;
        switch (tipoDeSoldado){
            case "Caballero" :
                random = (int)((Math.random()*3)+3); // [3..5]
                break;
            case "Espadachin" :
                random = (int)((Math.random()*2)+3); //[3..4],
                break;
            case "Arquero" :
                random = (int)((Math.random()*3)+1); //[1..3] 
                break;
        }
        vidaActual = random;    
        cantidadTotal ++;
    }
    public static int getCantidadSoldados(){
        return cantidadTotal;
    }
    public void setNombre(String n){
        nombre = n; 
    }
    public String getNombre(){
        return nombre;
    }
    public Soldado setFila(int fil){ //Method-call chaining
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
    public Ejercito getEjercito(){
        return ejercito;
    }    
    public void setVidaActual(double va){
        vidaActual = va;
    }
    public double getVidaActual(){
        return vidaActual;
    }
    public void bonificacionXterritorio(){
        vidaActual ++;
    }
    public void mostrarDatos() {
        System.out.println("  Nombre: " + this.getNombre());
        System.out.println("  Ejercito: " + this.getEjercito());
        System.out.println("  Vida Actual: " + this.getVidaActual());
    }       
}