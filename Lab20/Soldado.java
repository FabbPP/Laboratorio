package Lab20;
public class Soldado {
    public static final int MAX_CANTIDAD = 10;//Constante de Clase
    private static int cantidadTotal = 0; //Variable de Clase
    private String tipoDeSoldado;
    private int fila;
    private int columna;
    private String columnaStr;
    private Ejercito ejercito; 
    private String nombre;
    private int vidaActual;
    protected String actitud; //Defensiva, fuga
    protected int nivelAtaque = 1;
    protected int nivelDefensa = 1; 

    public Soldado(String tipoDeSoldado,Ejercito suEjercito){  //Constructor define vidaActual del soldado
        this.tipoDeSoldado = tipoDeSoldado;
        ejercito = suEjercito;
        switch (tipoDeSoldado){
            case "Caballero" :
                vidaActual = (int)((Math.random()*3)+3); // [3..5]
                break;
            case "Espadachin" :
                vidaActual = (int)((Math.random()*2)+3); //[3..4],
                break;
            case "Arquero" :
                vidaActual = (int)((Math.random()*3)+1); //[1..3] 
                break;
            case "Lancero" :
                vidaActual = (int)((Math.random()*2)+1); //[1..2] 
                break;
        } 
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
    public String getTipoDeSoldado(){
        return tipoDeSoldado;
    }
    public String getTipoAbreviado() {
        return tipoDeSoldado.substring(0, 1); // Obtener la primera letra del tipo de Soldado
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
    public void setVidaActual(int va){
        vidaActual = va;
    }
    public int getVidaActual(){
        return vidaActual;
    }
    public void mostrarDatos() {
        System.out.println("  Nombre: " + this.getNombre());
        System.out.println("  Fila: " + this.getFila());
        System.out.println("  Columna: " + this.getColumnaStr());
        System.out.println("  Vida Actual: " + this.getVidaActual());
    }     
    public void bonificacionxVencida(){
        this.vidaActual ++;
    }
}